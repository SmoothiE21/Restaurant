package com.example.restaurant_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.restaurant_app.adapter.MyAdapter
import com.example.restaurant_app.repository.Repository
import kotlinx.android.synthetic.main.fragment_main.view.*

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

        //RecyclerView
        val adapter = MyAdapter()
        val recycleView = view.recycleView
        recycleView.adapter = adapter
        recycleView.layoutManager = LinearLayoutManager(requireContext())
        viewModel.myResponse.observe(viewLifecycleOwner, Observer { response ->
            adapter.setData(response)
        })




        return view
    }


}
