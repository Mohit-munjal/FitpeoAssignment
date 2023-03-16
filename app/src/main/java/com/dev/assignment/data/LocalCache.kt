package com.dev.assignment.data

object LocalCache {
//made this class singelton coz caching can happen throughout app life cycle
    fun saveFlags(flags: List<String>){

        //code to save data into cache
    }

    fun getCachedFlags():List<String>{
       //code to get data from cache
        return listOf("flag1", "flag2")
    }

    fun clearFlags() {
        //code to clear it
    }

}