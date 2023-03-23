package com.dev.assignment.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.dev.assignment.R
import com.dev.assignment.data.api.main.responseModel.Photo
import com.dev.assignment.databinding.ActivityPhotoDetailBinding
import com.dev.assignment.utils.Constants

class PhotoDetailActivity : AppCompatActivity() {
    lateinit var activityPhotoDetailBinding: ActivityPhotoDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityPhotoDetailBinding=DataBindingUtil.setContentView(this,R.layout.activity_photo_detail)
        activityPhotoDetailBinding.photo = intent.getSerializableExtra(Constants.PHOTO) as Photo
    }
}