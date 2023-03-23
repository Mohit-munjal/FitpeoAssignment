package com.dev.assignment.di

import android.app.Application
import com.dev.assignment.BaseApplication
import com.dev.assignment.di.main.MainViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

  @Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ActivityBuildersModule::class,
    AppModule::class,
    ViewModelFactoryModule::class
]
)interface AppComponent:AndroidInjector<BaseApplication> {


    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }


}