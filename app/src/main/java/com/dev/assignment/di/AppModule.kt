package com.dev.assignment


import com.dev.assignment.communication.IUserFlagEventHandler
import com.dev.assignment.communication.UserFlagEventHandler
import com.dev.assignment.data.TMOAppContentProvider
import com.dev.assignment.manager.DiagnosticConsentManager
import com.dev.assignment.manager.IDiagnosticConsentManager
import com.dev.assignment.module.DiagnosticConsentModule
import com.dev.assignment.module.IDiagnosticConsentModule
import dagger.Module
import dagger.Provides

@Module
object AppModule {


    @JvmStatic
    @Provides
    fun provideUserFlagEventHandler(): IUserFlagEventHandler = UserFlagEventHandler()

    @JvmStatic
    @Provides
    fun provideTMOAppContentProvider(userFlagEventHandler: IUserFlagEventHandler) = TMOAppContentProvider(userFlagEventHandler)

    @JvmStatic
    @Provides
    fun provideTMOAppDataReceiver(tmoAppContentProvider: TMOAppContentProvider) = tmoAppContentProvider.TMOAppDataReceiver()

    @JvmStatic
    @Provides
    fun provideDiagnosticConsentManager(tmoAppContentProvider: TMOAppContentProvider, tmoAppDataReceiver: TMOAppContentProvider.TMOAppDataReceiver): IDiagnosticConsentManager = DiagnosticConsentManager(tmoAppContentProvider,tmoAppDataReceiver)

    @JvmStatic
    @Provides
    fun provideDiagnosticConsentModule(diagnosticConsentManager: DiagnosticConsentManager): IDiagnosticConsentModule = DiagnosticConsentModule(diagnosticConsentManager)

}