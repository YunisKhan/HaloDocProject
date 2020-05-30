package com.example.newsproject.view

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsproject.R
import com.example.newsproject.di.NewsComponent
import com.example.newsproject.di.NewsComponentProvider
import com.example.newsproject.recyclerview.RecyclerViewAdapter
import com.example.newsproject.viewmodel.NewsViewModel
import com.example.newsproject.viewmodel.NewsViewModelFactory

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    lateinit var mAdapter: RecyclerViewAdapter

    lateinit var mViewModelFactory: NewsViewModelFactory

    private val mViewModel: NewsViewModel by lazy {

        ViewModelProvider(this, mViewModelFactory).get(NewsViewModel::class.java)
    }

    private val mComponent: NewsComponent? by lazy {

        NewsComponentProvider.getComponent()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mComponent?.inject(this)

        mComponent?.viewModelFactory()?.let {

            mViewModelFactory = it
        }

        mAdapter = RecyclerViewAdapter()

        recycler_view.adapter       = mAdapter
        recycler_view.layoutManager = LinearLayoutManager(this)

        mViewModel.getNews("cricket").observe(
            this,
            Observer {

                if (it != null) {

                    mAdapter.submitList(ArrayList(it))
                }
            }
        )
    }
}
