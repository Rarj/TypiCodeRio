package rio.arj.kumparantechtestrioarjuna.ui.photo

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
import rio.arj.kumparantechtestrioarjuna.databinding.ActivityPhotoBinding
import rio.arj.kumparantechtestrioarjuna.ui.photo.detail.DetailPhotoActivity

class PhotoActivity : AppCompatActivity() {

  private val albumIdIntent by lazy {
    intent.getIntExtra("ALBUM_ID_KEY", -1)
  }

  private val albumTitleIntent by lazy {
    intent.getStringExtra("ALBUM_TITLE_KEY")
  }

  private val photoViewModel by viewModel<PhotoViewModel>()
  private lateinit var binding: ActivityPhotoBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    binding = DataBindingUtil.setContentView(this, R.layout.activity_photo)
    binding.viewModel = photoViewModel
    binding.lifecycleOwner = this

    binding.title = albumTitleIntent

    photoViewModel.viewModelScope.launch {
      photoViewModel.getPhotos(albumIdIntent)
        .collect {
          val photoAdapter = PhotoAdapter(it) { photoItem ->
            val intent = Intent(this@PhotoActivity, DetailPhotoActivity::class.java)
            intent.putExtra("DETAIL_PHOTO_KEY", photoItem)
            startActivity(intent)
          }
          binding.recyclerPhotos.apply {
            layoutManager = GridLayoutManager(this@PhotoActivity, 2)
            adapter = photoAdapter
          }
        }
    }
  }
}