package com.example.taskapp_1_4.ext

import android.widget.ImageView
import com.squareup.picasso.Picasso
import java.net.URL

fun ImageView.loadImage(url:String?){
    Picasso.get().load(url).into(this)
}