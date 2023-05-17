package com.example.newsapp

import android.net.Uri
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.browser.customtabs.CustomTabsIntent
import com.example.newsapp.ui.NewsListFragment
import com.example.newsapp.ui.NewsViewModel
import com.example.newsapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: NewsViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction().apply {
            replace(binding.fragmentContainer.id, NewsListFragment.newInstance())
            addToBackStack("AS")
            commit()
        }
        initViewModelObserver()
    }

    private fun initViewModelObserver() {
        viewModel.newsClickedLD.observe(this) {

            it?.let {
                CustomTabsIntent.Builder().build().launchUrl(this, Uri.parse(it.url))
            }
        }
    }


}