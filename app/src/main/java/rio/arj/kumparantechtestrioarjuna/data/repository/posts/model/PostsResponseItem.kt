package rio.arj.kumparantechtestrioarjuna.data.repository.posts.model

data class PostsResponseItem(
  val body: String,
  val id: Int,
  val title: String,
  val userId: Int
)