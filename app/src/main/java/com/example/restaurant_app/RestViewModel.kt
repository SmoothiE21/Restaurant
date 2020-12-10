package com.example.restaurant_app



import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.restaurant_app.model.Post
import com.example.restaurant_app.repository.Repository
import kotlinx.coroutines.launch

class RestViewModel(private val repository: Repository) :ViewModel() {

    val myResponse: MutableLiveData<List<Post>> = MutableLiveData()


    fun getRestaurants() {
        viewModelScope.launch {

            val response = repository.getPost().restaurants
            //myResponse.value = response
            myResponse.postValue(response)
            Log.d("dsdsdsds", response.map { it.name }.toString())
        }
    }
}