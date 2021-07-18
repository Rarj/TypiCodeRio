package rio.arj.kumparantechtestrioarjuna.data.repository.photo

import rio.arj.kumparantechtestrioarjuna.data.repository.photo.model.PhotoResponse

interface PhotoRepository {
  suspend fun getPhotos(albumId: Int): PhotoResponse
}