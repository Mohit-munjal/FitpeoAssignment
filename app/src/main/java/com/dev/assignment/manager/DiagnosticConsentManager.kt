package com.dev.assignment.manager

import android.content.Context
import android.content.IntentFilter
import com.dev.assignment.data.LocalCache
import com.dev.assignment.data.TMOAppContentProvider
import com.dev.assignment.util.Constants
import javax.inject.Inject

class DiagnosticConsentManager
    @Inject constructor(
        private val source: TMOAppContentProvider,
        private val receiver: TMOAppContentProvider.TMOAppDataReceiver
    ) : IDiagnosticConsentManager
{



    private suspend fun fetchFlagsFromAppAndSaveInCache(): List<String> {
        //get data from tmo app
        val flags = source.getUserConsentFlags()
        //store data in local cache
        LocalCache.saveFlags(flags)
        return flags
    }

    override suspend fun getUserConsentFlags():List<String>{
        val flags = LocalCache.getCachedFlags()
        return if(flags.isNullOrEmpty().not()) {
            //get data from cache
            flags
        } else {
            //cache is empty so get data from tmo app
            fetchFlagsFromAppAndSaveInCache()
        }
    }


    override fun getUserConsentUpdates(context:Context): TMOAppContentProvider.TMOAppDataReceiver {
        //register broadcast receiver to get regular user consent flags updates from tmo app
        context.registerReceiver(receiver, IntentFilter(Constants.BR_ACTION))
        return receiver
    }

}



