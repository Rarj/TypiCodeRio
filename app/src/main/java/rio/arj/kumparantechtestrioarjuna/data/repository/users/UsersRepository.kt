package rio.arj.kumparantechtestrioarjuna.data.repository.users

import rio.arj.kumparantechtestrioarjuna.data.repository.users.model.detail.UserDetailResponse
import rio.arj.kumparantechtestrioarjuna.data.repository.users.model.list.UsersResponse

interface UsersRepository {
  suspend fun getAllUsers(): UsersResponse
  suspend fun getDetailUser(userId: Int): UserDetailResponse
}