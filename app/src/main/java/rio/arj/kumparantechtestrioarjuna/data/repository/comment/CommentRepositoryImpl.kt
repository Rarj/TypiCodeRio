package rio.arj.kumparantechtestrioarjuna.data.repository.comment

import rio.arj.kumparantechtestrioarjuna.data.repository.comment.model.CommentResponse
import rio.arj.kumparantechtestrioarjuna.network.ApiService

class CommentRepositoryImpl(private val apiService: ApiService) : CommentRepository {
  override suspend fun getComments(postId: Int): CommentResponse {
    return apiService.getComments(postId)
  }
}