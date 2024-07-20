package com.example.hw_05_m7.di

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.hw_05_m7.data.local.dao.BookingDao
import com.example.hw_05_m7.data.local.db.BookingDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideRoomDatabase(@ApplicationContext context: Context): BookingDataBase =
        Room.databaseBuilder(context, BookingDataBase::class.java, "DataBase" )
            .fallbackToDestructiveMigration().allowMainThreadQueries().build()

    @Provides
    fun provideDao(db: BookingDataBase): BookingDao {
        return db.bookingDao()
    }
}