package rio.arj.kumparantechtestrioarjuna.data.repository.album

import rio.arj.kumparantechtestrioarjuna.data.repository.album.model.AlbumResponse

interface AlbumRepository {
  suspend fun getAlbums(userId: Int): AlbumResponse
}