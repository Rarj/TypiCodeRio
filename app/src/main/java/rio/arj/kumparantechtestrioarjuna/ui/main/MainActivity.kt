package rio.arj.kumparantechtestrioarjuna.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flatMapMerge
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import rio.arj.kumparantechtestrioarjuna.data.repository.posts.model.PostDetail
import rio.arj.kumparantechtestrioarjuna.data.repository.posts.model.PostsModel
import rio.arj.kumparantechtestrioarjuna.data.repository.posts.model.PostsResponse
import rio.arj.kumparantechtestrioarjuna.data.repository.users.model.list.UsersResponse
import rio.arj.kumparantechtestrioarjuna.databinding.ActivityMainBinding
import rio.arj.kumparantechtestrioarjuna.ui.detail.DetailActivity

@FlowPreview
class MainActivity : AppCompatActivity() {

  private val viewModel by viewModel<MainViewModel>()
  private lateinit var binding: ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    viewModel.viewModelScope.launch {
      val postModel = PostsModel(mutableListOf())
      viewModel.posts
        .flatMapMerge { postResponse ->
          mappingPostResponse(postResponse, postModel)

          viewModel.users
        }.collect { userResponse ->
          mappingUserResponse(postModel, userResponse)
          setupUi(postModel)
        }
    }
  }

  private fun setupUi(postModel: PostsModel) {
    val mainAdapter = MainAdapter(postModel) {
      val intent = Intent(this, DetailActivity::class.java)
      intent.putExtra("POST_DETAIL_KEY", it)
      startActivity(intent)
    }
    binding.recyclerPost.apply {
      layoutManager = LinearLayoutManager(this@MainActivity)
      adapter = mainAdapter
    }
  }

  private fun mappingUserResponse(
    postModel: PostsModel,
    userResponse: UsersResponse
  ) {
    postModel.post.forEachIndexed { index, postDetail ->
      userResponse
        .filter { it.id == postDetail.userId }
        .forEach { userItem ->
          postModel.post[index] = postModel.post[index].copy(
            name = userItem.name,
            companyName = userItem.company?.name
          )
        }
    }
  }

  private fun mappingPostResponse(
    postResponse: PostsResponse,
    postModel: PostsModel
  ) {
    postResponse.forEach {
      postModel.post.add(PostDetail(it.id, it.userId, it.title, it.body, null, null))
    }
  }
}