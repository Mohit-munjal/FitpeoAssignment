package com.dev.assignment.ui.main.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.dev.assignment.data.api.main.responseModel.Photo
import com.dev.assignment.repository.main.PhotosRepository
import com.dev.assignment.repository.main.PhotosRepositoryImp
import com.dev.assignment.utils.Resource
import kotlinx.coroutines.Dispatchers
import java.util.*
import javax.inject.Inject
import kotlin.Comparator
import kotlin.collections.ArrayList

class PhotosViewModel
    @Inject
    constructor(val photosRepository: PhotosRepository):ViewModel() {

    companion object {
        const val TAG = "mohit"
    }

    fun getPhotos() = liveData(Dispatchers.IO) {

        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = photosRepository.getPhotos()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }

}