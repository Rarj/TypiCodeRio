package rio.arj.kumparantechtestrioarjuna.ui.photo

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import rio.arj.kumparantechtestrioarjuna.data.repository.photo.PhotoRepositoryImpl

class PhotoViewModel(private val photoRepository: PhotoRepositoryImpl) : ViewModel() {

  fun getPhotos(albumId: Int) = flow {
    emit(photoRepository.getPhotos(albumId))
  }.flowOn(Dispatchers.IO)

}