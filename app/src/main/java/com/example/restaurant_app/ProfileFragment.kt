
package com.example.restaurant_app

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import com.example.restaurant_app.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {

private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?



    ): View? {
        // Inflate the layout for this fragment
        //bindig init

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false)
        //bindig értékadása
       // val name=  binding.editTextTextPersonName.text.toString()
       // Log.d("Helo",  name)

       
        return binding.root
    }

}