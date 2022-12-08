package com.hozanbaydu.wookweb.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.hozanbaydu.wookweb.R
import com.hozanbaydu.wookweb.databinding.FragmentIdentityBinding
import com.hozanbaydu.wookweb.databinding.FragmentSeoBinding
import com.hozanbaydu.wookweb.viewmodel.WookViewModel

class IdentityFragment:Fragment(R.layout.fragment_identity) {

    private var fragmentBinding : FragmentIdentityBinding? = null
    lateinit var viewModel: WookViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(WookViewModel::class.java)
        val binding = FragmentIdentityBinding.bind(view)
        fragmentBinding = binding

        binding.identityTeklifalButton.setOnClickListener {
            viewModel.textName.value="IDENTITY"
            findNavController().navigate(IdentityFragmentDirections.actionIdentityFragmentToOfferFragment())
        }


    }
}