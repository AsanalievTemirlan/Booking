package com.example.hw_05_m7.ui.fragment.detail_rooms

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import coil.load
import com.example.hw_05_m7.databinding.FragmentDetailRoomsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailRoomsFragment : Fragment() {

    private lateinit var binding: FragmentDetailRoomsBinding
    private val viewModel: DetailRoomViewModel by viewModels()
    private val args: DetailRoomsFragmentArgs by navArgs()
    private val roomId: Int by lazy { args.roomId }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailRoomsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpView()
        setUpListeners()
    }

    private fun setUpListeners() {
        if (binding.checkBooking.isChecked){
            viewModel.getRoomId(roomId).observe(viewLifecycleOwner) { room ->
                room?.let {
                    it.status = true
                    viewModel.updateRoom(it)
                    binding.btnBack.setOnClickListener {
                        findNavController().navigateUp()
                    }
                }
            }
        }
        else{
            viewModel.getRoomId(roomId).observe(viewLifecycleOwner) { room ->
                room?.let {
                    it.status = false
                    viewModel.updateRoom(it)
                    binding.btnBack.setOnClickListener {
                        findNavController().navigateUp()
                    }
                }
            }
        }


    }

    private fun setUpView() = with(binding) {
        if (roomId != -1) {
            viewModel.getRoomId(roomId).observe(viewLifecycleOwner, Observer { room ->
                room?.let {
                    tvRoomNumber.text = it.number
                    tvHotelName.text = it.hotelName
                    tvFloor.text = it.floor
                    tvDescription.text = it.description
                    imgRoomDetail.load(it.image)
                }
            })
        }
    }
}
