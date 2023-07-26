package com.fahim.githubcommitlist

import android.app.Application
import androidx.constraintlayout.widget.ConstraintSet.Constraint
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import com.fahim.githubcommitlist.worker.CommitWorker
import dagger.hilt.android.HiltAndroidApp
import java.util.concurrent.TimeUnit

@HiltAndroidApp
class CommitApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        setWorker()
    }

    private fun setWorker() {
        val constrain = Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()
        val workRequest = PeriodicWorkRequest.Builder(CommitWorker::class.java,15,TimeUnit.MINUTES)
            .setConstraints(constrain)
            .build()
        WorkManager.getInstance(this).enqueue(workRequest)

    }
}