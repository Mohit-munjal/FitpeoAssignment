package com.dev.assignment.ui

import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.dev.assignment.*
import com.dev.assignment.communication.IUserFlagEventHandler
import com.dev.assignment.data.TMOAppContentProvider
import com.dev.assignment.module.IDiagnosticConsentModule
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {
    @Inject
    lateinit var diagnosticConsentModule: IDiagnosticConsentModule

    @Inject
    lateinit var userFlagEventHandler: IUserFlagEventHandler

    var receiver: TMOAppContentProvider.TMOAppDataReceiver? = null

    var flags = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }



     fun getUserConsentFlags(){
         lifecycleScope.launch {
             withContext(Dispatchers.IO) {
                 flags.addAll(diagnosticConsentModule.getUserConsentFlags())
                 //do something with flags

             }
         }
     }

     fun getUserConsentUpdates(){
         //this will listen to updates as long as app is alive
        receiver = diagnosticConsentModule.getUserConsentUpdates(this)
        subscribeToUserFlagEvents()
    }

    private fun subscribeToUserFlagEvents(){
        userFlagEventHandler.subscribeUserConsentFlags(this){ flags ->
            this.flags.apply {
                clear()
                addAll(flags)
            }
            //do something with flags

        }
    }


    override fun onDestroy() {
        super.onDestroy()
        receiver?.let {
            unregisterReceiver(it)
        }
    }




}