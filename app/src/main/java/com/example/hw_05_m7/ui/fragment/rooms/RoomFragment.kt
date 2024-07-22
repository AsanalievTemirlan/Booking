package com.example.hw_05_m7.ui.fragment.rooms

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.hw_05_m7.data.local.entity.RoomEntity
import com.example.hw_05_m7.databinding.FragmentRoomBinding
import com.example.hw_05_m7.ui.interfaces.OnClick
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RoomFragment : Fragment(), OnClick {

    private lateinit var binding: FragmentRoomBinding
    private lateinit var roomAdapter: RoomAdapter
    private val viewModel: RoomViewModel by viewModels()
    private val rooms = ArrayList<RoomEntity>()

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
        observeRooms()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        roomAdapter = RoomAdapter(this)
        binding.recyclerViewRooms.adapter = roomAdapter
    }

    private fun observeRooms() {
        viewModel.getAll().observe(viewLifecycleOwner) { rooms ->
            Log.e("TAG", "Observing rooms $rooms")
            roomAdapter.submitList(rooms)
        }
    }

    private fun addDataInAdapter() {
        rooms.add(
            RoomEntity(
                number = 1.toString(),
                status = false,
                hotelName = "Hotel 1",
                floor = "1st",
                description = "Description 1",
                image = "https://cdn.prod.website-files.com/5c6d6c45eaa55f57c6367749/65045f093c166fdddb4a94a5_x-65045f0266217.webp"
            )
        )
        rooms.add(
            RoomEntity(
                number = 2.toString(),
                status = false,
                hotelName = "Hotel 2",
                floor = "2st",
                description = "Description 2",
                image = "https://cdn.prod.website-files.com/5c6d6c45eaa55f57c6367749/65045f093c166fdddb4a94a5_x-65045f0266217.webp"
            )
        )
        rooms.add(
            RoomEntity(
                number = 3.toString(),
                status = false,
                hotelName = "Hotel 3",
                floor = "3st",
                description = "Description 3",
                image = "https://cdn.prod.website-files.com/5c6d6c45eaa55f57c6367749/65045f093c166fdddb4a94a5_x-65045f0266217.webp"
            )
        )
        rooms.add(
            RoomEntity(
                number = 4.toString(),
                status = false,
                hotelName = "Hotel 4",
                floor = "4st",
                description = "Description 4",
                image = "https://cdn.prod.website-files.com/5c6d6c45eaa55f57c6367749/65045f093c166fdddb4a94a5_x-65045f0266217.webp"
            )
        )
        rooms.add(
            RoomEntity(
                number = 5.toString(),
                status = false,
                hotelName = "Hotel 5",
                floor = "5st",
                description = "Description 5",
                image = "https://cdn.prod.website-files.com/5c6d6c45eaa55f57c6367749/65045f093c166fdddb4a94a5_x-65045f0266217.webp"
            )
        )
        rooms.forEach { room ->
            viewModel.insertRooms(room)
        }

    }

    override fun onClick(roomEntity: RoomEntity) {
        val action = RoomFragmentDirections.actionRoomFragmentToDetailRoomsFragment(roomEntity.id)
        Log.e("TAG", "${action.actionId}")
        findNavController().navigate(action)
    }
}
