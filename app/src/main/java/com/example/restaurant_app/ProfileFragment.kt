
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

        var db = context?.let { DataBaseHandler(context = it) }

        //insert data
        fun insert() {
            if (binding.etvName.text.toString().isNotEmpty() &&
                binding.etvAge.text.toString().isNotEmpty()
            )
            {
                var user = User(binding.etvName.text.toString(), binding.etvAge.text.toString().toInt())

                db?.insertData(user)
            }
        }


        binding.buttoninsert.setOnClickListener{
            insert()
        }

        binding.buttonread.setOnClickListener{
            var data = db?.readData()
            binding.tvResult.text =""
            for (i in 0..data?.size!! -1){
                binding.tvResult.append("\nName: " + data.get(i).name + "\n\n Age: " + data.get(i).age + "\n")
            }
        }
        binding.buttondelete.setOnClickListener{
            db?.deleteData()
            binding.buttonread.performClick()

        }

        return binding.root
    }

}