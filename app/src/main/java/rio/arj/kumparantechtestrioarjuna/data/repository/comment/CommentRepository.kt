package rio.arj.kumparantechtestrioarjuna.data.repository.comment

import rio.arj.kumparantechtestrioarjuna.data.repository.comment.model.CommentResponse

interface CommentRepository {
  suspend fun getComments(postId: Int): CommentResponse
}