package com.example.restaurant_app.repository

import com.example.restaurant_app.api.RetrofitInstance
import com.example.restaurant_app.model.Resdata

class Repository {

    suspend fun getPost(): Resdata {
        return RetrofitInstance.api.getPost()
    }
}