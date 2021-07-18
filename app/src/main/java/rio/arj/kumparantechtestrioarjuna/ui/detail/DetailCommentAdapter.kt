package rio.arj.kumparantechtestrioarjuna.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import rio.arj.kumparantechtestrioarjuna.BR
import rio.arj.kumparantechtestrioarjuna.R
import rio.arj.kumparantechtestrioarjuna.data.repository.comment.model.CommentResponse
import rio.arj.kumparantechtestrioarjuna.data.repository.comment.model.CommentResponseItem
import rio.arj.kumparantechtestrioarjuna.databinding.ItemCommentBinding

class DetailCommentAdapter(
  private val commentList: CommentResponse
) : RecyclerView.Adapter<DetailCommentAdapter.ViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val inflater = LayoutInflater.from(parent.context)
    val viewDataBinding = ItemCommentBinding.inflate(inflater, parent, false)
    return ViewHolder(viewDataBinding)
  }

  override fun getItemCount(): Int {
    return commentList.size
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.bind(commentList[position])
  }

  class ViewHolder(private val binding: ItemCommentBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(model: CommentResponseItem) {
      binding.setVariable(BR.commentModel, model)
      binding.executePendingBindings()

      if (adapterPosition % 2 == 0) {
        setBackgroundColor(R.color.gray_EDEDED)
      } else {
        setBackgroundColor(R.color.white)
      }
    }

    private fun setBackgroundColor(@ColorRes color: Int) =
      binding.containerComment.setBackgroundColor(
        ContextCompat.getColor(binding.root.context, color)
      )
  }

}