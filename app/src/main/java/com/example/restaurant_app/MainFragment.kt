package com.example.restaurant_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.restaurant_app.repository.Repository

class MainFragment : Fragment() {
    private lateinit var  viewModel: RestViewModel

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        arguments?.let {
//
//        }
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

      //  return inflater.inflate(R.layout.fragment_main, container, false)
        val view: View = inflater.inflate(R.layout.fragment_main,container,false)

        val repository = Repository()
        val viewModelFactory = RestViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(RestViewModel::class.java)
        viewModel.getRestaurants()
        viewModel.myResponse.observe(viewLifecycleOwner,{ restaurants->})

        return view
    }


}
