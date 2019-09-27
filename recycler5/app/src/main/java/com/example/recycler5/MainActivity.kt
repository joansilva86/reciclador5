package com.example.recycler5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {
    override fun showError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showList(list: ArrayList<MyItem>) {
        (recycler.adapter as MyAdapter).list = list
    }

    private lateinit var presenter: MainPresenter
    override fun onResume() {
        super.onResume()
        presenter.attach(this)
        presenter.begin()
    }

    override fun onPause() {
        super.onPause()
        presenter.detach()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = MainPresenter(this)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = MyAdapter()
    }
}
