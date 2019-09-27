package com.example.recycler5

import org.json.JSONObject

data class MyItem (var author: String = "") {
    fun fillWith(json: JSONObject){
        if (json.has("author")) this.author = json.getString("author")
    }
}