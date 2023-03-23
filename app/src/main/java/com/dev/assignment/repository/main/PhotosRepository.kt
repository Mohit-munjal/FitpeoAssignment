package com.dev.assignment.repository.main

import com.dev.assignment.data.api.main.responseModel.Photo

interface PhotosRepository {
    suspend fun getPhotos():List<Photo>
}