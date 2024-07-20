package com.example.hw_05_m7.ui.fragment.detail_rooms

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hw_05_m7.data.local.entity.RoomEntity
import com.example.hw_05_m7.data.local.repository.BookingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailRoomViewModel @Inject constructor(private val repository: BookingRepository): ViewModel() {

    fun getRoomId(id: Int): LiveData<RoomEntity> = repository.getById(id)

    fun updateRoom(roomEntity: RoomEntity) = viewModelScope.launch { repository.update(roomEntity) }

}