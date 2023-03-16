package com.dev.assignment.communication

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import com.dev.assignment.communication.EventBus
import com.dev.assignment.communication.IUserFlagEventHandler
import kotlinx.coroutines.launch


class UserFlagEventHandler: IUserFlagEventHandler {
    override suspend fun postUserFlags(userFlags: List<String>) {
        EventBus.publish(userFlags)
    }

    override fun subscribeUserConsentFlags(lifecycleOwner: LifecycleOwner,onEvent:(List<String>)->Unit) {
        lifecycleOwner.lifecycleScope.launch {
            EventBus.subscribe<List<String>> { flags ->
                onEvent(flags)
            }
        }
    }
}