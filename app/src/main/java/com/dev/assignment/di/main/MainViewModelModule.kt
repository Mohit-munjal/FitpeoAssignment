package com.dev.assignment.di.main

import androidx.lifecycle.ViewModel
import com.dev.assignment.di.ViewModelKey
import com.dev.assignment.ui.main.view.PhotosViewModel

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainViewModelModule {


    @MainScope
    @Binds
    @IntoMap
    @ViewModelKey(PhotosViewModel::class)
    abstract fun bindPhotoViewModel(photosViewModel: PhotosViewModel):ViewModel
}