package rio.arj.kumparantechtestrioarjuna.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import rio.arj.kumparantechtestrioarjuna.BR
import rio.arj.kumparantechtestrioarjuna.data.repository.posts.model.PostDetail
import rio.arj.kumparantechtestrioarjuna.data.repository.posts.model.PostsModel
import rio.arj.kumparantechtestrioarjuna.databinding.ItemPostBinding

class MainAdapter(
  private val listPost: PostsModel,
  private val listener: (postDetail: PostDetail) -> Unit
) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val inflater = LayoutInflater.from(parent.context)
    val viewDataBinding = ItemPostBinding.inflate(inflater, parent, false)
    return ViewHolder(viewDataBinding)
  }

  override fun getItemCount(): Int {
    return listPost.post.size
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.bind(listPost.post[position], listener)
  }

  class ViewHolder(private val binding: ItemPostBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(model: PostDetail, listener: (postDetail: PostDetail) -> Unit) {
      binding.setVariable(BR.model, model)
      binding.executePendingBindings()

      binding.root.setOnClickListener { listener.invoke(model) }
    }
  }

}