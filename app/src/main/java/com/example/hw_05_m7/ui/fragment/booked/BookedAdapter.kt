package com.example.hw_05_m7.ui.fragment.booked

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.hw_05_m7.data.local.entity.RoomEntity
import com.example.hw_05_m7.databinding.ItemRoomBinding
import com.example.hw_05_m7.ui.interfaces.OnClick

class BookedAdapter(private val onClick: OnClick) :
    ListAdapter<RoomEntity, BookedAdapter.BookedViewHolder>(DiffCallback()) {

    inner class BookedViewHolder(private val binding: ItemRoomBinding) : ViewHolder(binding.root) {
        fun bind(room: RoomEntity) = with(binding) {
            tvRoomNumber.text = room.number
            tvHotelName.text = room.hotelName
            tvBookingStatus.text = if (room.status) "booked" else "freely"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookedViewHolder {
        val binding = ItemRoomBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BookedViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BookedViewHolder, position: Int) {
        holder.bind(getItem(position))
        holder.itemView.setOnClickListener { onClick.onClick(getItem(position)) }
    }


}

class DiffCallback : DiffUtil.ItemCallback<RoomEntity>() {
    override fun areItemsTheSame(oldItem: RoomEntity, newItem: RoomEntity): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: RoomEntity, newItem: RoomEntity): Boolean {
        return oldItem == newItem
    }
}

