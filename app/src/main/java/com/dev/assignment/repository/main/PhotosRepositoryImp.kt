package com.dev.assignment.repository.main

import com.dev.assignment.data.api.main.PhotoApiService
import com.dev.assignment.data.api.main.responseModel.Photo
import javax.inject.Inject

class PhotosRepositoryImp @Inject constructor(
    private val photoApiService: PhotoApiService
    ):PhotosRepository {

    override suspend fun getPhotos():List<Photo> = photoApiService.getPhotos()

}
