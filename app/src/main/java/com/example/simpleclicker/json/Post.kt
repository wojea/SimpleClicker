package com.example.simpleclicker.json

import com.google.gson.annotations.SerializedName

class Post
{

    lateinit var userId : Integer

    @SerializedName("id")
    lateinit var postId : Integer

    lateinit var title : String

    @SerializedName("body")
    lateinit var textbody : String

}