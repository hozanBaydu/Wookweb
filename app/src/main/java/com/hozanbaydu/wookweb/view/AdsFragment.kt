package com.hozanbaydu.wookweb.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.hozanbaydu.wookweb.R
import com.hozanbaydu.wookweb.databinding.FragmentAdsBinding
import com.hozanbaydu.wookweb.databinding.FragmentIdentityBinding
import com.hozanbaydu.wookweb.viewmodel.WookViewModel

class AdsFragment:Fragment(R.layout.fragment_ads) {

    private var fragmentBinding : FragmentAdsBinding? = null
    lateinit var viewModel: WookViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity()).get(WookViewModel::class.java)

        val binding = FragmentAdsBinding.bind(view)
        fragmentBinding = binding

        binding.adsTeklifalButton.setOnClickListener {

            viewModel.textName.value="ADS"
            findNavController().navigate(AdsFragmentDirections.actionAdsFragmentToOfferFragment())
        }


    }
}