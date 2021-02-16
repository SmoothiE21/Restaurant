package com.example.restaurant_app

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.restaurant_app.model.Post
import kotlinx.coroutines.launch

class MainViewModel:ViewModel() {
    lateinit var currentRestaurant: Post


}