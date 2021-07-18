package rio.arj.kumparantechtestrioarjuna.ui.detailuser

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import rio.arj.kumparantechtestrioarjuna.R
import rio.arj.kumparantechtestrioarjuna.databinding.ActivityDetailUserBinding
import rio.arj.kumparantechtestrioarjuna.ui.photo.PhotoActivity

class DetailUserActivity : AppCompatActivity() {

  private val userIdIntent: Int by lazy {
    intent.getIntExtra("USER_ID_KEY", -1)
  }

  private val detailUserViewModel by viewModel<DetailUserViewModel>()
  private lateinit var binding: ActivityDetailUserBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_user)
    binding.viewModel = detailUserViewModel
    binding.lifecycleOwner = this

    detailUserViewModel.viewModelScope.launch {
      detailUserViewModel.getDetailUser(userIdIntent)
        .collect { binding.userDetail = it }

      detailUserViewModel.getAlbums(userIdIntent)
        .collect {
          val albumAdapter = DetailUserAlbumAdapter(it) { albumId, title ->
            val intent = Intent(this@DetailUserActivity, PhotoActivity::class.java)
            intent.putExtra("ALBUM_ID_KEY", albumId)
            intent.putExtra("ALBUM_TITLE_KEY", title)
            startActivity(intent)
          }
          binding.recyclerAlbums.apply {
            layoutManager = GridLayoutManager(this@DetailUserActivity, 2)
            adapter = albumAdapter
          }
        }
    }

  }
}