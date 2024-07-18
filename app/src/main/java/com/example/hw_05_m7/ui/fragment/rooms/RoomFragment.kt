package com.example.hw_05_m7.ui.fragment.rooms

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.hw_05_m7.R
import com.example.hw_05_m7.data.local.entity.RoomEntity
import com.example.hw_05_m7.databinding.FragmentRoomBinding
import com.example.hw_05_m7.ui.interfaces.OnClick
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class RoomFragment : Fragment(), OnClick {

    private lateinit var binding: FragmentRoomBinding
    private val roomAdapter = RoomAdapter(this)
    private val viewModel: RoomViewModel by viewModels()
    private var rooms = ArrayList<RoomEntity>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRoomBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addDataInAdapter()
    }

    private fun addDataInAdapter() {
        rooms.addAll()
        viewModel.insertRooms(rooms)
    }

    override fun onClick(roomEntity: RoomEntity) {
        val action = RoomFragmentDirections.actionRoomFragmentToDetailRoomsFragment(roomEntity.id)
        findNavController().navigate(action)
    }

}