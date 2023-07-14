package com.fahim.githubcommitlist.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fahim.githubcommitlist.Model.CommitModel
import com.velmurugan.paging3android.Repository.CommitRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private var commitRepository: CommitRepository) :
    ViewModel() {

    val errorMessage = MutableLiveData<String>()

    var convertValue = MutableLiveData<Response<CommitModel>>()

    suspend fun getCommitList(branchName: String, repoName: String, page: Int, perPage: Int) {
        viewModelScope.launch {
            commitRepository.getCommitList(branchName, repoName, page, perPage).collect() {
                convertValue.postValue(it)
            }

        }
    }

}