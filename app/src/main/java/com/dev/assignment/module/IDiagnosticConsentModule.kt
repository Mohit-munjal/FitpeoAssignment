package com.dev.assignment.module

import android.content.Context
import com.dev.assignment.data.TMOAppContentProvider

interface IDiagnosticConsentModule {
    suspend fun getUserConsentFlags():List<String>
    fun getUserConsentUpdates(context: Context): TMOAppContentProvider.TMOAppDataReceiver
}