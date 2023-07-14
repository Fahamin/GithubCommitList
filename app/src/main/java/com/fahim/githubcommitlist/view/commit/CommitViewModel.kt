package com.fahim.githubcommitlist.view.commit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.fahim.githubcommitlist.model.Item
import com.fahim.githubcommitlist.repository.CommitRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CommitViewModel @Inject constructor(private var commitRepository: CommitRepository) :
    ViewModel() {

    val errorMessage = MutableLiveData<String>()


    suspend fun getCommitList(): LiveData<PagingData<Item>> {
        return commitRepository.getCommitList().cachedIn(viewModelScope)
    }

}