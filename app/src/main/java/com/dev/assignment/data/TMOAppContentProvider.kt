package com.dev.assignment.data

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.dev.assignment.communication.IUserFlagEventHandler
import com.dev.assignment.util.Constants
import com.dev.assignment.util.getListOfObjectFromJsonString
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class TMOAppContentProvider @Inject constructor(
    val userFlagEventHandler: IUserFlagEventHandler
) {

    suspend fun getUserConsentFlags():List<String> {
        delay(3000)
        return listOf("flag1", "flag2")
    }

    inner class TMOAppDataReceiver:
        BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            if(intent?.getAction().equals(Constants.BR_ACTION)){
                val userFlags = intent?.getStringExtra(Constants.USER_FLAGS)
                userFlags?.let {
                    val listOfFlags = getListOfObjectFromJsonString(it)
                    CoroutineScope(Dispatchers.IO).launch {
                        userFlagEventHandler.postUserFlags(listOfFlags)
                    }
                    LocalCache.apply {
                        clearFlags()
                        saveFlags(listOfFlags)
                    }

                }
            }



        }

    }
}