package rio.arj.kumparantechtestrioarjuna.ui.detailuser

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import rio.arj.kumparantechtestrioarjuna.data.repository.album.AlbumRepositoryImpl
import rio.arj.kumparantechtestrioarjuna.data.repository.users.UsersRepositoryImpl

class DetailUserViewModel(
  private val usersRepository: UsersRepositoryImpl,
  private val albumRepository: AlbumRepositoryImpl
) : ViewModel() {

  fun getDetailUser(userId: Int) = flow {
    emit(usersRepository.getDetailUser(userId))
  }.flowOn(Dispatchers.IO)

  fun getAlbums(userId: Int) = flow {
    emit(albumRepository.getAlbums(userId))
  }.flowOn(Dispatchers.IO)

}