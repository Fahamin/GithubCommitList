package com.velmurugan.paging3android.Repository


import android.util.Log
import com.velmurugan.paging3android.Retrofit.CommitApiService
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CommitRepository @Inject constructor(private val commitApiService: CommitApiService) {

    suspend fun getCommitList(branchName: String, repoName: String, page: Int,perPage: Int) = flow {
        var response = commitApiService.getCommitFromRepo(branchName, repoName, page, perPage)
        emit(response)
        Log.e("rate", "" + response)

    }.catch { e ->
        Log.e("rate", "" + e.message)

    }
}