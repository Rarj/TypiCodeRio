package rio.arj.kumparantechtestrioarjuna.data.repository.users

import rio.arj.kumparantechtestrioarjuna.data.repository.users.model.detail.UserDetailResponse
import rio.arj.kumparantechtestrioarjuna.data.repository.users.model.list.UsersResponse
import rio.arj.kumparantechtestrioarjuna.network.ApiService

class UsersRepositoryImpl(private val apiService: ApiService) : UsersRepository {
  override suspend fun getAllUsers(): UsersResponse {
    return apiService.getAllUsers()
  }

  override suspend fun getDetailUser(userId: Int): UserDetailResponse {
    return apiService.getDetailUser(userId)
  }
}