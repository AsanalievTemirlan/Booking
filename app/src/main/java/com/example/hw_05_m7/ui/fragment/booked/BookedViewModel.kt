package com.example.hw_05_m7.ui.fragment.booked

import androidx.lifecycle.ViewModel
import com.example.hw_05_m7.data.local.repository.BookingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BookedViewModel @Inject constructor(private val repository: BookingRepository) : ViewModel() {
}
