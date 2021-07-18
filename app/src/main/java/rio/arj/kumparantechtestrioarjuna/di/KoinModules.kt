package rio.arj.kumparantechtestrioarjuna.di

import kotlinx.coroutines.FlowPreview
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import rio.arj.kumparantechtestrioarjuna.data.repository.album.AlbumRepositoryImpl
import rio.arj.kumparantechtestrioarjuna.data.repository.comment.CommentRepositoryImpl
import rio.arj.kumparantechtestrioarjuna.data.repository.photo.PhotoRepositoryImpl
import rio.arj.kumparantechtestrioarjuna.data.repository.posts.PostsRepositoryImpl
import rio.arj.kumparantechtestrioarjuna.data.repository.users.UsersRepositoryImpl
import rio.arj.kumparantechtestrioarjuna.network.NetworkBuilder
import rio.arj.kumparantechtestrioarjuna.ui.detail.DetailViewModel
import rio.arj.kumparantechtestrioarjuna.ui.detailuser.DetailUserViewModel
import rio.arj.kumparantechtestrioarjuna.ui.main.MainViewModel
import rio.arj.kumparantechtestrioarjuna.ui.photo.PhotoViewModel

val appModules = module {
  single { NetworkBuilder().provideRetrofit() }
  single { NetworkBuilder().provideService(get()) }
}

@FlowPreview
val viewModelModules = module {
  viewModel { MainViewModel(get(), get()) }
  viewModel { DetailViewModel(get(), get()) }
  viewModel { DetailUserViewModel(get(), get()) }
  viewModel { PhotoViewModel(get()) }
}

val repositoryModules = module {
  single { PostsRepositoryImpl(get()) }
  single { UsersRepositoryImpl(get()) }
  single { CommentRepositoryImpl(get()) }
  single { AlbumRepositoryImpl(get()) }
  single { PhotoRepositoryImpl(get()) }
}