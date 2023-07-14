package com.velmurugan.paging3android.Retrofit

import com.fahim.githubcommitlist.Model.CommitModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CommitApiService {

    @GET("commits")
    suspend fun getCommitFromRepo(
        @Query("sha") branchName: String,
        @Query("q") repoName: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): Response<CommitModel>


}