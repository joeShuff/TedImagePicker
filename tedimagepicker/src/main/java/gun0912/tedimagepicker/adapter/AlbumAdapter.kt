package gun0912.tedimagepicker.adapter

import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import com.bumptech.glide.Glide
import gun0912.tedimagepicker.R
import gun0912.tedimagepicker.base.BaseRecyclerViewAdapter
import gun0912.tedimagepicker.base.BaseViewHolder
import gun0912.tedimagepicker.builder.TedImagePickerBaseBuilder
import gun0912.tedimagepicker.databinding.ItemAlbumBinding
import gun0912.tedimagepicker.model.Album
import kotlinx.android.synthetic.main.item_album.view.*

internal class AlbumAdapter(var builder: TedImagePickerBaseBuilder<*>?) : BaseRecyclerViewAdapter<Album, AlbumAdapter.AlbumViewHolder>() {

    private var selectedPosition = 0

    override fun getViewHolder(parent: ViewGroup, viewType: ViewType) = AlbumViewHolder(parent)

    fun setSelectedAlbum(album: Album) {
        val index = items.indexOf(album)
        if (index >= 0 && selectedPosition != index) {
            val lastSelectedPosition = selectedPosition
            selectedPosition = index
            notifyItemChanged(lastSelectedPosition)
            notifyItemChanged(selectedPosition)
        }
    }

    inner class AlbumViewHolder(parent: ViewGroup) :
        BaseViewHolder<ItemAlbumBinding, Album>(parent, R.layout.item_album) {
        override fun bind(data: Album) {
            if (builder?.typeface != null) {
                builder?.typeface.let {
                    itemView.tv_name.typeface = ResourcesCompat.getFont(context, it!!)
                }
            }
            binding.album = data
            binding.isSelected = adapterPosition == selectedPosition
        }

        override fun recycled() {
            Glide.with(itemView).clear(binding.ivImage)
        }
    }
}