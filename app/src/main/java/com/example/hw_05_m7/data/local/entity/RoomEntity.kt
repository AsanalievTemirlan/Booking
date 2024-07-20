package com.example.hw_05_m7.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "room")
data class RoomEntity(
    @PrimaryKey (autoGenerate = true)
    val id: Int = 0,
    val number: String,
    val description: String,
    val image: String,
    var status: Boolean = false,
    val hotelName: String,
    val floor: String
)
