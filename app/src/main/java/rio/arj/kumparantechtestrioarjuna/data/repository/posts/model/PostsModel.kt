package rio.arj.kumparantechtestrioarjuna.data.repository.posts.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PostsModel(
  var post: MutableList<PostDetail>
) : Parcelable

@Parcelize
data class PostDetail(
  var id: Int,
  var userId: Int,
  var title: String,
  var body: String,
  var name: String?,
  var companyName: String?
) : Parcelable