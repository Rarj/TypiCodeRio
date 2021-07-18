package rio.arj.kumparantechtestrioarjuna.network

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import rio.arj.kumparantechtestrioarjuna.data.repository.album.model.AlbumResponse
import rio.arj.kumparantechtestrioarjuna.data.repository.comment.model.CommentResponse
import rio.arj.kumparantechtestrioarjuna.data.repository.photo.model.PhotoResponse
import rio.arj.kumparantechtestrioarjuna.data.repository.posts.model.PostsResponse
import rio.arj.kumparantechtestrioarjuna.data.repository.users.model.detail.UserDetailResponse
import rio.arj.kumparantechtestrioarjuna.data.repository.users.model.list.UsersResponse

interface ApiService {
  @GET("posts")
  suspend fun getPosts(): PostsResponse

  @GET("posts/{post_id}/comments")
  suspend fun getComments(@Path("post_id") postId: Int): CommentResponse

  @GET("users")
  suspend fun getAllUsers(): UsersResponse

  @GET("users/{user_id}")
  suspend fun getDetailUser(@Path("user_id") userId: Int): UserDetailResponse

  @GET("albums")
  suspend fun getAlbums(@Query("userId") userId: Int): AlbumResponse

  @GET("photos")
  suspend fun getPhotos(@Query("albumId") albumId: Int): PhotoResponse
}