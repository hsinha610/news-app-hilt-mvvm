package com.example.newsapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.databinding.FragmentNewsListBinding

class NewsListFragment : Fragment() {
    private val viewModel: NewsViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBundle()
    }

    private fun initBundle() {
        arguments?.let {

        }
    }

    private lateinit var binding: FragmentNewsListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewsListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        initRV()
        initViewModelObservers()
        initData()

    }

    private fun initData() {
        viewModel.getData()
    }

    private lateinit var newsAdapter: NewsAdapter
    private fun initRV() {
        if (!::newsAdapter.isInitialized) {
            newsAdapter = NewsAdapter(viewModel)
        }
        binding.rv.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = newsAdapter
        }

    }

    private fun initViewModelObservers() {
        viewModel.newsLD.observe(viewLifecycleOwner) {
            it?.let {
                when (it) {
                    NewsViewModel.UiState.Loading -> showLoader()
                    is NewsViewModel.UiState.Success -> {
                        hideLoader()
                        newsAdapter.submitList(it.dataList)
                    }

                    NewsViewModel.UiState.Error -> {}
                }
            }
        }
    }

    private fun showLoader() {
        binding.loader.showView()
        binding.rv.hideView()
        binding.networkErrorTv.hideView()
    }

    private fun hideLoader() {
        binding.loader.hideView()
        binding.rv.showView()
        binding.networkErrorTv.hideView()
    }

    private fun View.hideView() {
        visibility = View.GONE
    }

    private fun View.showView() {
        visibility = View.VISIBLE
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            NewsListFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}