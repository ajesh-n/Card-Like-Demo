package com.example.cardlikedemo

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringSetPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.cardlikedemo.FakeDataSource.Companion.POSTS
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class PostsRepository(private val context: Context) {
    fun posts(): Flow<List<Post>> {
        return context.dataStore.data
            .map { preferences ->
                preferences[FAVORITE_POSTS] ?: setOf()
            }.map { favoriteCardIds ->
                POSTS.map {
                    if (favoriteCardIds.contains(it.id)) {
                        it.copy(isLiked = true)
                    } else {
                        it
                    }
                }
            }
    }

    suspend fun onPostLiked(id: String) {
        context.dataStore.edit { preferences ->
            val favoriteCardIds = preferences[FAVORITE_POSTS] ?: setOf()
            val updatedFavoriteCardIds = mutableSetOf<String>().apply {
                addAll(favoriteCardIds)
                if (favoriteCardIds.contains(id)) {
                    remove(id)
                } else {
                    add(id)
                }
            }
            preferences[FAVORITE_POSTS] = updatedFavoriteCardIds
        }
    }

    companion object {
        val FAVORITE_POSTS = stringSetPreferencesKey("favorite_posts")
    }
}
