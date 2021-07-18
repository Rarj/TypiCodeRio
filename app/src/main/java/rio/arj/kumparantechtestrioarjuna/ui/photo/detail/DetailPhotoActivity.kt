package rio.arj.kumparantechtestrioarjuna.ui.photo.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import rio.arj.kumparantechtestrioarjuna.R
import rio.arj.kumparantechtestrioarjuna.data.repository.photo.model.PhotoResponseItem
import rio.arj.kumparantechtestrioarjuna.databinding.ActivityDetailPhotoBinding
import rio.arj.kumparantechtestrioarjuna.helper.loadPhoto

class DetailPhotoActivity : AppCompatActivity() {

  private val detailPhotoIntent: PhotoResponseItem by lazy {
    intent.getParcelableExtra<PhotoResponseItem>("DETAIL_PHOTO_KEY")
      ?: throw RuntimeException("${DetailPhotoActivity::class.java.name} must be not null")
  }

  private lateinit var binding: ActivityDetailPhotoBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_photo)

    setupUi()
    listener()
  }

  private fun setupUi() {
    binding.toolbar.title = detailPhotoIntent.title
    binding.photoView.loadPhoto(detailPhotoIntent.url)
  }

  private fun listener() {
    binding.toolbar.setNavigationOnClickListener { finish() }
  }
}