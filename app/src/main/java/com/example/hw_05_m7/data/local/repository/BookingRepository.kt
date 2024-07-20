package com.example.hw_05_m7.data.local.repository

import androidx.lifecycle.LiveData
import com.example.hw_05_m7.data.local.dao.BookingDao
import com.example.hw_05_m7.data.local.entity.RoomEntity
import javax.inject.Inject

class BookingRepository @Inject constructor(
    private val bookingDao: BookingDao
) {
    fun getAll(): LiveData<List<RoomEntity>> = bookingDao.getAllRooms()

    fun getById(id: Int): LiveData<RoomEntity> = bookingDao.getRoomById(id)

    suspend fun insert(roomEntity: RoomEntity) = bookingDao.insertRoom(roomEntity)

    suspend fun update(roomEntity: RoomEntity) = bookingDao.updateRoom(roomEntity)

    suspend fun delete(roomEntity: RoomEntity) = bookingDao.deleteRoom(roomEntity)
}