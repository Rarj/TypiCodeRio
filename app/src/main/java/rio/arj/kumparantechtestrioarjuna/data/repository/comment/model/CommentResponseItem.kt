package rio.arj.kumparantechtestrioarjuna.data.repository.comment.model

data class CommentResponseItem(
  val body: String,
  val email: String,
  val id: Int,
  val name: String,
  val postId: Int
)