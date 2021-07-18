package rio.arj.kumparantechtestrioarjuna.data.repository.album

import rio.arj.kumparantechtestrioarjuna.data.repository.album.model.AlbumResponse
import rio.arj.kumparantechtestrioarjuna.network.ApiService

class AlbumRepositoryImpl(private val apiService: ApiService) : AlbumRepository {
  override suspend fun getAlbums(userId: Int): AlbumResponse {
    return apiService.getAlbums(userId)
  }
}