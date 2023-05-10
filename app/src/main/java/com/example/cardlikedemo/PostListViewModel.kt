package com.example.cardlikedemo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PostListViewModel(
    private val postsRepository: PostsRepository
) : ViewModel() {
    private val _posts: MutableStateFlow<List<Post>> = MutableStateFlow(emptyList())
    val posts: StateFlow<List<Post>> = _posts

    init {
        load()
    }

    private fun load() {
        viewModelScope.launch {
            postsRepository.posts().collect {
                _posts.value = it
            }
        }
    }

    fun onCardLiked(id: String) {
        viewModelScope.launch {
            postsRepository.onPostLiked(id)
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>, extras: CreationExtras
            ): T {
                val application = checkNotNull(extras[APPLICATION_KEY])
                return PostListViewModel(
                    PostsRepository(application.applicationContext)
                ) as T
            }
        }
    }
}
