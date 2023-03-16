package com.dev.assignment.util

import com.google.gson.Gson



fun getListOfObjectFromJsonString(json:String) = Gson().fromJson(json, Array<String>::class.java).asList()



