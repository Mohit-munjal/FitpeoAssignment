package com.dev.assignment.manager

import android.content.Context
import com.dev.assignment.data.TMOAppContentProvider

interface IDiagnosticConsentManager {
      suspend fun getUserConsentFlags():List<String>
     fun getUserConsentUpdates(context: Context): TMOAppContentProvider.TMOAppDataReceiver
}