package rio.arj.kumparantechtestrioarjuna.ui.detail

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import rio.arj.kumparantechtestrioarjuna.R
import rio.arj.kumparantechtestrioarjuna.data.repository.comment.model.CommentResponse
import rio.arj.kumparantechtestrioarjuna.data.repository.posts.model.PostDetail
import rio.arj.kumparantechtestrioarjuna.databinding.ActivityDetailBinding
import rio.arj.kumparantechtestrioarjuna.ui.detailuser.DetailUserActivity

class DetailActivity : AppCompatActivity() {

  private val postDetailIntent: PostDetail by lazy {
    intent.getParcelableExtra<PostDetail>("POST_DETAIL_KEY")
      ?: throw RuntimeException("${PostDetail::class.java.name} must be not null")
  }

  private val detailViewModel by viewModel<DetailViewModel>()
  private lateinit var binding: ActivityDetailBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
    binding.viewModel = detailViewModel
    binding.lifecycleOwner = this

    binding.title = postDetailIntent.title
    binding.body = postDetailIntent.body

    loadDetail()
    listener()
  }

  private fun loadDetail() {
    detailViewModel.viewModelScope.launch {
      detailViewModel.getDetailUser(postDetailIntent.userId)
        .collect { binding.textName.text = it.username }

      detailViewModel.getComments(postDetailIntent.id)
        .collect { setupCommentUi(it) }
    }
  }

  private fun setupCommentUi(it: CommentResponse) {
    val detailCommentAdapter = DetailCommentAdapter(it)
    binding.recyclerComments.apply {
      layoutManager = LinearLayoutManager(this@DetailActivity)
      adapter = detailCommentAdapter
    }
  }

  private fun listener() {
    binding.toolbar.setNavigationOnClickListener { finish() }

    binding.textName.setOnClickListener {
      val intent = Intent(this, DetailUserActivity::class.java)
      intent.putExtra("USER_ID_KEY", postDetailIntent.userId)
      startActivity(intent)
    }
  }
}