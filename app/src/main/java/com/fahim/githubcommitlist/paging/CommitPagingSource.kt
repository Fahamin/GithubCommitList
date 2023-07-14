package com.fahim.githubcommitlist.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.fahim.githubcommitlist.utils.Constance.ITEMS_PER_PAGE
import com.fahim.githubcommitlist.api.CommitApiService
import com.fahim.githubcommitlist.model.Item

class CommitPagingSource constructor(private var commitApiService: CommitApiService) :
    PagingSource<Int, Item>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Item> {
        return try {
            val position = params.key ?: 1
            val response = commitApiService.getCommitFromRepo(
                "main",
                "flutter/flutter",
                position,
                ITEMS_PER_PAGE
            )
            LoadResult.Page(
                data = response.body()!!.items,
                prevKey = if (position == 1) null else position - 1,
                nextKey = position + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }


    override fun getRefreshKey(state: PagingState<Int, Item>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}