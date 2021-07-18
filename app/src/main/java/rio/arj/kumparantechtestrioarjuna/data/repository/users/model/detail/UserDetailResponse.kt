package rio.arj.kumparantechtestrioarjuna.data.repository.users.model.detail

data class UserDetailResponse(
  val id: Int,
  val name: String,
  val username: String,
  val email: String,
  val address: Address,
  val company: Company
)