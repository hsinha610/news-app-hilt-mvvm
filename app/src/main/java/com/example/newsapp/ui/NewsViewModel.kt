package com.example.newsapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.data.Article
import com.example.newsapp.data.NewsRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(private val repo: NewsRepo) : ViewModel() , ClickInterface{

    private val _newsMLD = MutableLiveData<UiState>()
    val newsLD: LiveData<UiState>
        get() = _newsMLD

    fun getData() {
        viewModelScope.launch {
            _newsMLD.value = UiState.Loading
            try {
                val news = repo.getNewsHeadlines()
                _newsMLD.value = UiState.Success(news.listOfArticles.toMutableList())
            } catch (e: Exception) {
                _newsMLD.value = UiState.Error
            }

        }
    }

    sealed class UiState {
        object Loading : UiState()
        data class Success(val dataList: MutableList<Any>) : UiState()
        object Error : UiState()
    }

    private val _newsClickedMLD = MutableLiveData<Article?>()
    val newsClickedLD: LiveData<Article?>
        get() = _newsClickedMLD
    override fun newsClicked(news: Article) {
        _newsClickedMLD.value = news
    }
}