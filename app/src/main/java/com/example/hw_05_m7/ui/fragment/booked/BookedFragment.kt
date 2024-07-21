package com.example.hw_05_m7.ui.fragment.booked

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.hw_05_m7.R
import com.example.hw_05_m7.data.local.entity.RoomEntity
import com.example.hw_05_m7.databinding.FragmentBookedBinding
import com.example.hw_05_m7.ui.fragment.rooms.RoomFragmentDirections
import com.example.hw_05_m7.ui.interfaces.OnClick
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BookedFragment : Fragment(), OnClick {

    private lateinit var binding: FragmentBookedBinding
    private val viewModel: BookedViewModel by viewModels()
    private val rooms = ArrayList<RoomEntity>()
    private lateinit var adapter: BookedAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBookedBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        observeRooms()
    }

    private fun observeRooms() {
        viewModel.getByStatus(true).observe(viewLifecycleOwner) { rooms ->
            adapter.submitList(rooms)
        }
    }

    private fun setupRecyclerView() {
        adapter = BookedAdapter(this)
        binding.rvBooked.adapter = adapter
    }

    override fun onClick(roomEntity: RoomEntity) {
        val action = BookedFragmentDirections.actionBookedFragmentToDetailRoomsFragment(roomEntity.id)
        findNavController().navigate(action.actionId)
    }


}