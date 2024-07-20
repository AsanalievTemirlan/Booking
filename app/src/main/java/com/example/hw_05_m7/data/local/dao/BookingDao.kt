package com.example.hw_05_m7.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.hw_05_m7.data.local.entity.RoomEntity

@Dao
interface BookingDao {

    @Insert
    suspend fun insertRoom(room: RoomEntity)

    @Delete
    suspend fun deleteRoom(room: RoomEntity)

    @Update
    suspend fun updateRoom(room: RoomEntity)

    @Query("SELECT * FROM room WHERE id = :id")
    fun getRoomById(id: Int): LiveData<RoomEntity>

    @Query("SELECT * FROM room")
    fun getAllRooms(): LiveData<List<RoomEntity>>
}
