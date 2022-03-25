package com.example.moviesdb01.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviesdb01.databinding.ActivityMainBinding
import com.example.moviesdb01.domain.model.MoviesResult
import com.example.moviesdb01.presentation.viewModel.MoviesViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MoviesViewModel by viewModel()
    private val adapter by lazy {
        MoviesAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configRv()
        resultsObserver()
    }

    private fun resultsObserver() {
        viewModel.movies.observe(this, Observer {
            adapter.updateList(it.results as MutableList<MoviesResult>)
        })
    }

    private fun configRv(){
        binding.recyclerViewXml.adapter = adapter
        binding.recyclerViewXml.layoutManager =
            GridLayoutManager(this, 2)
    //LinearLayoutManager(this, GridLayoutManager.VERTICAL, false)
    }
}