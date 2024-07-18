package com.example.hw_05_m7.ui.fragment.detail_rooms

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hw_05_m7.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailRoomsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_rooms, container, false)
    }

}