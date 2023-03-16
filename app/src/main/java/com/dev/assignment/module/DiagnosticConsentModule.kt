package com.dev.assignment.module

import android.content.Context
import com.dev.assignment.data.TMOAppContentProvider
import com.dev.assignment.manager.DiagnosticConsentManager
import javax.inject.Inject


class DiagnosticConsentModule
    @Inject constructor(private val diagnosticConsentManager: DiagnosticConsentManager):
    IDiagnosticConsentModule {

    override suspend fun getUserConsentFlags():List<String>{

        return diagnosticConsentManager.getUserConsentFlags()
    }

    override fun getUserConsentUpdates(context:Context): TMOAppContentProvider.TMOAppDataReceiver {
      return diagnosticConsentManager.getUserConsentUpdates(context)
    }

}