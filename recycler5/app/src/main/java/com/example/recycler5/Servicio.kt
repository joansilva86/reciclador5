package com.example.recycler5

import android.content.Context
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest

class Servicio(var context: Context) {
    private val url = "http://de-coding-test.s3.amazonaws.com/books.json"
    var list = ArrayList<MyItem>()
    fun getInfoServer(listenerOk: ListenerOk, listenerError: ListenerError) {

        var vo = VolleyS.getInstance(context)
        var request = JsonArrayRequest(url, Response.Listener { response ->
            for (i in 0 until response.length()) {
                var jsonObject = response.getJSONObject(i)
                var myItem = MyItem()
                myItem.fillWith(jsonObject)
                list.add(myItem)

            }
            listenerOk.responseOk(list)
        }, Response.ErrorListener { error ->
            listenerError.responseError(12)
        })
        vo.queue.add(request)
    }

    interface ListenerOk {
        fun responseOk(list: ArrayList<MyItem>)
    }

    interface ListenerError {
        fun responseError(cod: Int)
    }
}
