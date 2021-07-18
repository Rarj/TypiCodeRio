package rio.arj.kumparantechtestrioarjuna.ui.photo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import rio.arj.kumparantechtestrioarjuna.data.repository.photo.model.PhotoResponse
import rio.arj.kumparantechtestrioarjuna.data.repository.photo.model.PhotoResponseItem
import rio.arj.kumparantechtestrioarjuna.databinding.ItemPhotoBinding
import rio.arj.kumparantechtestrioarjuna.helper.loadPhoto


class PhotoAdapter(
  private val listPhoto: PhotoResponse,
  private val listener: (photoItem: PhotoResponseItem) -> Unit
) : RecyclerView.Adapter<PhotoAdapter.ViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val inflater = LayoutInflater.from(parent.context)
    val viewDataBinding = ItemPhotoBinding.inflate(inflater, parent, false)
    return ViewHolder(viewDataBinding)
  }

  override fun getItemCount(): Int {
    return listPhoto.size
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.bind(listPhoto[position], listener)
  }

  class ViewHolder(private val binding: ItemPhotoBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(model: PhotoResponseItem, listener: (photoItem: PhotoResponseItem) -> Unit) {
      binding.textTitle.text = model.title

      binding.imagePhoto.loadPhoto(model.url)

      binding.root.setOnClickListener { listener.invoke(model) }
    }
  }

}