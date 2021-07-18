package rio.arj.kumparantechtestrioarjuna.data.repository.posts

import rio.arj.kumparantechtestrioarjuna.data.repository.posts.model.PostsResponse

interface PostsRepository {
  suspend fun getAllPosts(): PostsResponse
}