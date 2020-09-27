package com.arpit.imagepickfromgallery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       imageView.setOnClickListener {
           selectImageInAlbum()
       }

    }




    private fun selectImageInAlbum() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), REQUEST_SELECT_IMAGE_IN_ALBUM)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val imageUri=data?.data
        imageView.setImageURI(imageUri)
    }

    companion object {
        private const val REQUEST_SELECT_IMAGE_IN_ALBUM = 1
    }
}