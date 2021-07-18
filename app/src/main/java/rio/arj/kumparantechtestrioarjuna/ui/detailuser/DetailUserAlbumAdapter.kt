package rio.arj.kumparantechtestrioarjuna.ui.detailuser

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import rio.arj.kumparantechtestrioarjuna.BR
import rio.arj.kumparantechtestrioarjuna.data.repository.album.model.AlbumResponse
import rio.arj.kumparantechtestrioarjuna.data.repository.album.model.AlbumResponseItem
import rio.arj.kumparantechtestrioarjuna.databinding.ItemAlbumBinding

class DetailUserAlbumAdapter(
  private val listAlbum: AlbumResponse,
  private val listener: (albumId: Int, title: String) -> Unit
) : RecyclerView.Adapter<DetailUserAlbumAdapter.ViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val inflater = LayoutInflater.from(parent.context)
    val viewDataBinding = ItemAlbumBinding.inflate(inflater, parent, false)
    return ViewHolder(viewDataBinding)
  }

  override fun getItemCount(): Int {
    return listAlbum.size
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.bind(listAlbum[position], listener)
  }

  class ViewHolder(private val binding: ItemAlbumBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(model: AlbumResponseItem, listener: (albumId: Int, title: String) -> Unit) {
      binding.setVariable(BR.albumModel, model)
      binding.executePendingBindings()

      binding.buttonMore.setOnClickListener { listener.invoke(model.id, model.title) }
    }
  }

}