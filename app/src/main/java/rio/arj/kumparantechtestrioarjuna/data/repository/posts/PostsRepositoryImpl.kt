package rio.arj.kumparantechtestrioarjuna.data.repository.posts

import rio.arj.kumparantechtestrioarjuna.data.repository.posts.model.PostsResponse
import rio.arj.kumparantechtestrioarjuna.network.ApiService

class PostsRepositoryImpl(private val apiService: ApiService) : PostsRepository {
  override suspend fun getAllPosts(): PostsResponse {
    return apiService.getPosts()
  }
}