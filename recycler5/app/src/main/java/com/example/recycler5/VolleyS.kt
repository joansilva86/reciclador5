package com.example.recycler5

import android.content.Context
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

class VolleyS private constructor(context: Context) {
    lateinit var queue: RequestQueue

    companion object {
        private var instance: VolleyS? = null
        fun getInstance(context: Context): VolleyS {
            if (instance == null)
                instance = VolleyS(context)
            instance!!.queue = Volley.newRequestQueue(context)
            return instance as VolleyS
        }
    }
}