package com.dev.assignment.di

import com.dev.assignment.di.main.MainModule
import com.dev.assignment.di.main.MainScope
import com.dev.assignment.di.main.MainViewModelModule
import com.dev.assignment.ui.main.view.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {
    @ContributesAndroidInjector
    (modules = [MainViewModelModule::class, MainModule::class])
    @MainScope
    abstract fun contributeMainActivity():MainActivity

}