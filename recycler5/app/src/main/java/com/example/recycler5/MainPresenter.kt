package com.example.recycler5

import android.content.Context

class MainPresenter(var context: Context) {
    private var view: MainView? = null
    private var list = ArrayList<MyItem>()
    private lateinit var servicio: Servicio
    fun attach(view: MainView) {
        this.view = view
    }

    fun detach() {
        this.view = null
    }

    fun begin() {
        servicio = Servicio(context)
        servicio.getInfoServer(listenerOk, listenerError)
    }

    var listenerError = object : Servicio.ListenerError {
        override fun responseError(cod: Int) {

        }
    }
    var listenerOk = object : Servicio.ListenerOk {
        override fun responseOk(list: ArrayList<MyItem>) {
            view?.showList(list)
        }

    }
}

interface MainView {
    fun showError()
    fun showList(list: ArrayList<MyItem>)
}