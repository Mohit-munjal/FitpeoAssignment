package com.dev.assignment.di.main

import com.dev.assignment.data.api.main.PhotoApiService
import com.dev.assignment.repository.main.PhotosRepository
import com.dev.assignment.repository.main.PhotosRepositoryImp
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
object MainModule {

    @MainScope
    @JvmStatic
    @Provides
    fun providePhotoApiService(retrofit: Retrofit): PhotoApiService {
        return retrofit.create(PhotoApiService::class.java)
    }

    @MainScope
    @JvmStatic
    @Provides
    fun providePhotosRepository(photoApiService: PhotoApiService): PhotosRepository {
        return PhotosRepositoryImp(photoApiService)
    }


}