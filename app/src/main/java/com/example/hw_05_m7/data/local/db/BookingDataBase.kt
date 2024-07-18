package com.example.hw_05_m7.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hw_05_m7.data.local.dao.BookingDao
import com.example.hw_05_m7.data.local.entity.RoomEntity

@Database(entities = [RoomEntity::class], version = 1)
abstract class BookingDataBase: RoomDatabase() {
    abstract fun bookingDao(): BookingDao
}