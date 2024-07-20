package com.example.hw_05_m7.ui.fragment.rooms

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hw_05_m7.data.local.entity.RoomEntity
import com.example.hw_05_m7.data.local.repository.BookingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RoomViewModel @Inject constructor(private val repository: BookingRepository) : ViewModel() {

    fun getAll(): LiveData<List<RoomEntity>> = repository.getAll()
    fun insertRooms(roomEntity: RoomEntity) = viewModelScope.launch{ repository.insert(roomEntity)}

}