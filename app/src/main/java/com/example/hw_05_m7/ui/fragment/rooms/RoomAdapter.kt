package com.example.hw_05_m7.ui.fragment.rooms

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.hw_05_m7.data.local.entity.RoomEntity
import com.example.hw_05_m7.databinding.ItemRoomBinding
import com.example.hw_05_m7.ui.interfaces.OnClick

class RoomAdapter(private val onClick: OnClick) :
    ListAdapter<RoomEntity, RoomAdapter.RoomViewHolder>(RoomDiffCallback()) {

    inner class RoomViewHolder(private val binding: ItemRoomBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(room: RoomEntity) = with(binding) {
            tvRoomNumber.text = room.number
            tvHotelName.text = room.hotelName
            tvBookingStatus.text = if (room.status) "booked" else "freely"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomViewHolder {
        val binding = ItemRoomBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RoomViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RoomViewHolder, position: Int) {
        val room = getItem(position)
        holder.bind(room)
        holder.itemView.setOnClickListener { onClick.onClick(room) }
    }

    class RoomDiffCallback : DiffUtil.ItemCallback<RoomEntity>() {
        override fun areItemsTheSame(oldItem: RoomEntity, newItem: RoomEntity): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: RoomEntity, newItem: RoomEntity): Boolean {
            return oldItem == newItem
        }
    }
}
