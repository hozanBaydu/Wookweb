package com.hozanbaydu.wookweb.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.hozanbaydu.wookweb.R
import com.hozanbaydu.wookweb.databinding.FragmentDesignBinding
import com.hozanbaydu.wookweb.databinding.FragmentIdentityBinding
import com.hozanbaydu.wookweb.databinding.FragmentSeoBinding
import com.hozanbaydu.wookweb.viewmodel.WookViewModel

class DesignFragment :Fragment(R.layout.fragment_design){

    private var fragmentBinding : FragmentDesignBinding? = null
    lateinit var viewModel: WookViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(WookViewModel::class.java)
        val binding = FragmentDesignBinding.bind(view)
        fragmentBinding = binding

        binding.designTeklifalButton.setOnClickListener {
            viewModel.textName.value="DESİGN"
            findNavController().navigate(DesignFragmentDirections.actionDesignFragmentToOfferFragment())
        }

    }
}