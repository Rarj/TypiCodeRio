package rio.arj.kumparantechtestrioarjuna.data.repository.photo.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PhotoResponseItem(
  val albumId: Int,
  val id: Int,
  val thumbnailUrl: String,
  val title: String,
  val url: String
) : Parcelable