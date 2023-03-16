package com.dev.assignment

import android.app.Application
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
]
)interface AppComponent:AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent//this is mandatory step, returning instance of appcomponent

    }


}