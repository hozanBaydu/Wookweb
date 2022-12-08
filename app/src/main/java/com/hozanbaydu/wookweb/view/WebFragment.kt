package com.hozanbaydu.wookweb.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.hozanbaydu.wookweb.R
import com.hozanbaydu.wookweb.databinding.FragmentSeoBinding
import com.hozanbaydu.wookweb.databinding.FragmentWebBinding
import com.hozanbaydu.wookweb.viewmodel.WookViewModel

class WebFragment :Fragment(R.layout.fragment_web){

    private var fragmentBinding : FragmentWebBinding? = null
    lateinit var viewModel: WookViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(WookViewModel::class.java)
        val binding = FragmentWebBinding.bind(view)
        fragmentBinding = binding

        binding.webTeklifalButton.setOnClickListener {
            viewModel.textName.value="WEB"
            findNavController().navigate(WebFragmentDirections.actionWebFragmentToOfferFragment())
        }

    }
}