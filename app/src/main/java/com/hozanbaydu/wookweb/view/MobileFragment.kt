package com.hozanbaydu.wookweb.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.hozanbaydu.wookweb.R
import com.hozanbaydu.wookweb.databinding.FragmentMainBinding
import com.hozanbaydu.wookweb.databinding.FragmentMobileBinding
import com.hozanbaydu.wookweb.viewmodel.WookViewModel

class MobileFragment:Fragment(R.layout.fragment_mobile) {

    private var fragmentBinding : FragmentMobileBinding? = null
    lateinit var viewModel: WookViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(WookViewModel::class.java)
        val binding = FragmentMobileBinding.bind(view)
        fragmentBinding = binding

        binding.mobileTeklifalButton.setOnClickListener {
            viewModel.textName.value="MOBİLE"
            findNavController().navigate(MobileFragmentDirections.actionMobileFragmentToOfferFragment())
        }


    }
}