package com.fahim.githubcommitlist.worker

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.fahim.githubcommitlist.CommitApplication
import com.fahim.githubcommitlist.api.CommitApiService
import com.fahim.githubcommitlist.repository.CommitRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class CommitWorker @Inject constructor(
    private var context: Context,
    param: WorkerParameters,
    private var commitRepository: CommitRepository
) : Worker(context, param) {

    override fun doWork(): Result {

        Log.e("Fahamin", "WORKMAGANER WORK")

        CoroutineScope(Dispatchers.Main).launch {
            commitRepository.getCommitListBackground()
        }

        return Result.success()
    }

}