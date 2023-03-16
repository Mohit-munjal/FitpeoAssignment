package com.dev.assignment.communication

import androidx.lifecycle.LifecycleOwner

interface IUserFlagEventHandler {
    suspend fun postUserFlags(userFlags: List<String>)
    fun subscribeUserConsentFlags(lifecycleOwner: LifecycleOwner, onEvent:(List<String>)->Unit)
}