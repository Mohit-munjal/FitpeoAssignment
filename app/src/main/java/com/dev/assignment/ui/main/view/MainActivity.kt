package com.dev.assignment.ui.main.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.dev.assignment.R
import com.dev.assignment.data.api.main.responseModel.Photo
import com.dev.assignment.databinding.ActivityMainBinding
import com.dev.assignment.ui.main.adapter.PhotosAdpater
import com.dev.assignment.ui.main.viewmodel.ViewModelFactory
import com.dev.assignment.utils.Constants
import com.dev.assignment.utils.ItemOffsetDecoration
import com.dev.assignment.utils.Status
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject


class MainActivity : DaggerAppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var photosAdpater: PhotosAdpater

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    val viewModel: PhotosViewModel by viewModels {
        viewModelFactory
    }

companion object {
    const val TAG = "mohit"
    const val SPAN_COUNT = 2
}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this, R.layout.activity_main)
        setupUI()
        setupObservers()
    }


    private fun setupUI() {
        setUpAdapter()
    }

    private fun setUpAdapter() {
        photosAdpater = PhotosAdpater(this, arrayListOf())
        binding.rvPhotos.apply {
            layoutManager= GridLayoutManager(this@MainActivity, SPAN_COUNT)
            addItemDecoration(ItemOffsetDecoration(this@MainActivity,R.dimen.item_offset))
            adapter=photosAdpater
        }
    }

    private fun setupObservers() {
        viewModel.getPhotos().observe(this){ resource->
            when (resource.status) {
                Status.SUCCESS -> {
                    binding.rvPhotos.visibility = View.VISIBLE
                    binding.progressBar.visibility = View.GONE
                    Log.d(TAG, "setupObservers: data ${resource.data.toString()}")
                    resource.data?.let { photos ->
                        photosAdpater.updatePhotos(photos)
                    }
                }
                Status.ERROR -> {
                    binding.rvPhotos.visibility = View.GONE
                    binding.progressBar.visibility = View.GONE

                    Toast.makeText(this, resource.message, Toast.LENGTH_LONG).show()
                }
                Status.LOADING -> {
                    binding.rvPhotos.visibility = View.GONE
                    binding.progressBar.visibility = View.VISIBLE
                }
            }


        }

    }


    fun onPhotoClicked(photo: Photo){
        val intent = Intent(this@MainActivity, PhotoDetailActivity::class.java)
        val bundle = Bundle()
        bundle.putSerializable(Constants.PHOTO, photo)
        intent.putExtras(bundle)
        startActivity(intent)
    }




}