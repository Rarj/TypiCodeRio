package rio.arj.kumparantechtestrioarjuna.ui.main

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import rio.arj.kumparantechtestrioarjuna.data.repository.posts.PostsRepositoryImpl
import rio.arj.kumparantechtestrioarjuna.data.repository.users.UsersRepositoryImpl

@FlowPreview
class MainViewModel(
  private val postsRepository: PostsRepositoryImpl,
  private val usersRepository: UsersRepositoryImpl,
) : ViewModel() {

  private var postId = 0

  val posts = flow {
    emit(postsRepository.getAllPosts())
  }.flowOn(Dispatchers.IO)

  val users = flow {
    emit(usersRepository.getAllUsers())
  }.flowOn(Dispatchers.IO)

}