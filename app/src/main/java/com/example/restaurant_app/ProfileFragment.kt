
package com.example.restaurant_app

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.core.app.ActivityCompat
import androidx.databinding.DataBindingUtil
import com.example.restaurant_app.databinding.FragmentProfileBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_profile.*
import java.io.ByteArrayOutputStream


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
                binding.etvAge.text.toString().isNotEmpty() &&
                binding.etvAddr.text.toString().isNotEmpty() &&
                binding.etvEmail.text.toString().isNotEmpty()
            )
            {
                var user = User(binding.etvName.text.toString(), binding.etvAge.text.toString().toInt(),binding.etvAddr.text.toString(),binding.etvEmail.text.toString())

                db?.insertData(user)
            }
        }

        binding.animation.setOnClickListener {
            animation.animate().apply {
                duration = 4000
                rotationXBy(360f)


            }.withEndAction {
                animation.animate().apply {
                    duration = 4000
                    rotationYBy(360f)
                }
            }.withEndAction {
                animation.animate().apply {
                    duration = 4000
                    rotationXBy(360f)
                }
            }.withEndAction {

                animation.animate().apply {
                    duration = 4000
                    rotationYBy(360f)
                }.start()
            }
        }
        binding.buttoninsert.setOnClickListener{
            insert()
        }

        binding.buttonread.setOnClickListener{
            var data = db?.readData()
            binding.tvResult.text =""
            for (i in 0..data?.size!! -1){
                binding.tvResult.append("\n USER: "+"\n\n Name: " + data.get(i).name + "\n\n Tel: 0" + data.get(i).age + "\n" + "\n Address: " + data.get(i).addr + "\n" + "\n Email: " + data.get(i).email)
            }
        }

        binding.buttondelete.setOnClickListener{
            db?.deleteData()
            binding.buttonread.performClick()

        }


        binding.chooseButton.setOnClickListener{
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                if(ActivityCompat.checkSelfPermission(this.requireContext(), Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED)
                {
//                    permission denied
                    val permissions = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)
//                    show popup to request runtime permission
                    requestPermissions(permissions, PERMISSION_CODE)
                }
                else
                {
//                    permission already granted
                    pickImageFromGallery()
                }
            }
            else
            {
//                system OS is < Marshmalow
                pickImageFromGallery()
            }
        }


        return binding.root

    }
    companion object{
        private val IMAGE_PICK_CODE = 1000
        private val PERMISSION_CODE = 1001
    }

//    private fun imageViewToByte(image: ImageView): ByteArray {
//        val bitmap = (image.drawable as BitmapDrawable).bitmap
//        val stream = ByteArrayOutputStream()
//        bitmap.compress(Bitmap.CompressFormat.PNG, 90, stream)
//
//        return stream.toByteArray()
//    }

    private fun pickImageFromGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_PICK_CODE)
    }
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when (requestCode){
            PERMISSION_CODE -> {
                if(grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    //permission from popup granted
                    pickImageFromGallery()
                }
                else
                {
                    //permission from popup denied
                    Snackbar.make(this.requireView(), "Permission denied!", Snackbar.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val image = view?.findViewById<ImageView>(R.id.selectImage)
        if(resultCode == Activity.RESULT_OK && requestCode == IMAGE_PICK_CODE){
            image?.setImageURI(data?.data)
        }
    }

}