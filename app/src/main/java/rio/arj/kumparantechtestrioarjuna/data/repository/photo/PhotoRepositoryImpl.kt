package rio.arj.kumparantechtestrioarjuna.data.repository.photo

import rio.arj.kumparantechtestrioarjuna.data.repository.photo.model.PhotoResponse
import rio.arj.kumparantechtestrioarjuna.network.ApiService

class PhotoRepositoryImpl(private val apiService: ApiService) : PhotoRepository {
  override suspend fun getPhotos(albumId: Int): PhotoResponse {
    return apiService.getPhotos(albumId)
  }
}