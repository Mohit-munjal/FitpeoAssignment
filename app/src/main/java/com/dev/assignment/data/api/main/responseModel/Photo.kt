package com.dev.assignment.data.api.main.responseModel

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Photo(
    @SerializedName("id")
    @Expose
    val id: String,

    @SerializedName("albumId")
    @Expose
    val albumId: String,

    @SerializedName("title")
    @Expose
    val title: String,


    @SerializedName("url")
    @Expose
    val url: String,

    @SerializedName("thumbnailUrl")
    @Expose
    val thumbnailUrl: String,


    ):Serializable {

    override fun toString(): String {
        return "Photo(title='$title', thumbnailUrl='$thumbnailUrl', url=$url)"
    }
}

