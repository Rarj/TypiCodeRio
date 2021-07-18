package rio.arj.kumparantechtestrioarjuna.helper

import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders

fun AppCompatImageView.loadPhoto(imageUrl: String) {
  val url = GlideUrl(
    imageUrl,
    LazyHeaders.Builder().addHeader("User-Agent", "kumparan_tech_test").build()
  )
  Glide.with(this.context)
    .load(url)
    .into(this)
}