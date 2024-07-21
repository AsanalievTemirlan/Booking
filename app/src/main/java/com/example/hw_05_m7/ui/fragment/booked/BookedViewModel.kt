package com.example.hw_05_m7.ui.fragment.booked

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.hw_05_m7.data.local.entity.RoomEntity
import com.example.hw_05_m7.data.local.repository.BookingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BookedViewModel @Inject constructor(private val repository: BookingRepository) : ViewModel() {

    fun getByStatus(status: Boolean): LiveData<List<RoomEntity>> = repository.getByStatus(status)

}
