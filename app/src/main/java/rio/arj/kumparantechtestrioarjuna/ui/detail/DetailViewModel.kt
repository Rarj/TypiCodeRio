package rio.arj.kumparantechtestrioarjuna.ui.detail

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import rio.arj.kumparantechtestrioarjuna.data.repository.comment.CommentRepositoryImpl
import rio.arj.kumparantechtestrioarjuna.data.repository.users.UsersRepositoryImpl

class DetailViewModel(
  private val commentRepository: CommentRepositoryImpl,
  private val usersRepository: UsersRepositoryImpl,
) : ViewModel() {

  fun getDetailUser(userId: Int) = flow {
    emit(usersRepository.getDetailUser(userId))
  }.flowOn(Dispatchers.IO)

  fun getComments(postId: Int) = flow {
    emit(commentRepository.getComments(postId))
  }.flowOn(Dispatchers.IO)

}