package com.dev.assignment.data.api.main

import com.dev.assignment.data.api.main.responseModel.Photo
import retrofit2.http.*

interface PhotoApiService {

    @GET("photos")
    suspend fun getPhotos():List<Photo>

}
