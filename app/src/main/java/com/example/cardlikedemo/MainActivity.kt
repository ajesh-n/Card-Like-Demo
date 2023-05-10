package com.example.cardlikedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.cardlikedemo.ui.theme.CardLikeDemoTheme

class MainActivity : ComponentActivity() {
    private val viewModel: PostListViewModel by viewModels { PostListViewModel.Factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CardLikeDemoTheme {
                val state by viewModel.posts.collectAsState()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Posts(
                        posts = state,
                        onCardLiked = {
                            viewModel.onCardLiked(it)
                        }
                    )
                }
            }
        }
    }

    companion object {
        const val TAG = "MainActivity"
    }
}

@Composable
fun Posts(posts: List<Post>, onCardLiked: (String) -> Unit) {
    LazyColumn(
        modifier = Modifier.padding(4.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        items(items = posts) {
            Post(it, onCardLiked)
        }
    }
}

@Composable
fun Post(
    post: Post,
    onCardLiked: (String) -> Unit
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(modifier = Modifier.padding(12.dp)) {
            AsyncImage(
                modifier = Modifier.weight(0.2f),
                model = post.imageUrl,
                contentDescription = null,
            )
            Column(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .weight(0.8f)
            ) {
                Text(text = post.title, maxLines = 1, overflow = TextOverflow.Ellipsis)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = post.content, maxLines = 2, overflow = TextOverflow.Ellipsis)
                IconButton(
                    modifier = Modifier.align(Alignment.End),
                    onClick = {
                        onCardLiked(post.id)
                    }
                ) {
                    if (post.isLiked) {
                        Icon(
                            imageVector = Icons.Default.Favorite,
                            tint = Color.Red,
                            contentDescription = "Like icon"
                        )
                    } else {
                        Icon(
                            imageVector = Icons.Default.FavoriteBorder,
                            contentDescription = "Like icon"
                        )
                    }
                }
            }
        }
    }
}