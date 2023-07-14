package com.fahim.githubcommitlist.repository


import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.fahim.githubcommitlist.utils.Constance.ITEMS_PER_PAGE
import com.fahim.githubcommitlist.api.CommitApiService
import com.fahim.githubcommitlist.model.Item
import com.fahim.githubcommitlist.paging.CommitPagingSource
import javax.inject.Inject

class CommitRepository @Inject constructor(private val commitApiService: CommitApiService) {

    fun getCommitList(): LiveData<PagingData<Item>> {
        return Pager(
            config = PagingConfig(
                pageSize = ITEMS_PER_PAGE,
                enablePlaceholders = false,
                initialLoadSize = 2
            ),
            pagingSourceFactory = {
                CommitPagingSource(commitApiService)
            }, initialKey = 1
        ).liveData
    }
}