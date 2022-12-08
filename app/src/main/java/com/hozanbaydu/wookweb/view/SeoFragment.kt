package com.hozanbaydu.wookweb.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.hozanbaydu.wookweb.R
import com.hozanbaydu.wookweb.databinding.FragmentMobileBinding
import com.hozanbaydu.wookweb.databinding.FragmentSeoBinding
import com.hozanbaydu.wookweb.viewmodel.WookViewModel

class SeoFragment:Fragment(R.layout.fragment_seo) {

    private var fragmentBinding : FragmentSeoBinding? = null
    lateinit var viewModel: WookViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(WookViewModel::class.java)
        val binding = FragmentSeoBinding.bind(view)
        fragmentBinding = binding


        binding.seoTeklifalButton.setOnClickListener {
            viewModel.textName.value="SEO"
            findNavController().navigate(SeoFragmentDirections.actionSeoFragmentToOfferFragment())
        }


    }
}