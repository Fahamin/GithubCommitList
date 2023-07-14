package com.fahim.githubcommitlist.ui.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fahim.githubcommitlist.model.CommitModel
import retrofit2.Response

class NotificationsViewModel :
    ViewModel() {

    val errorMessage = MutableLiveData<String>()

    var convertValue = MutableLiveData<Response<CommitModel>>()


    private val _text = MutableLiveData<String>().apply {
        value = "This is notifications Fragment"
    }
    val text: LiveData<String> = _text


}