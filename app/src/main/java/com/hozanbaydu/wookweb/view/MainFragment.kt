package com.hozanbaydu.wookweb.view

import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.hozanbaydu.wookweb.R
import com.hozanbaydu.wookweb.databinding.FragmentMainBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainFragment:Fragment(R.layout.fragment_main) {

    private var fragmentBinding : FragmentMainBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentMainBinding.bind(view)
        fragmentBinding = binding

        binding.mobileButton.setOnClickListener {
            findNavController().navigate(MainFragmentDirections.actionMainFragmentToMobileFragment())
        }
        binding.seoButton.setOnClickListener {
            findNavController().navigate(MainFragmentDirections.actionMainFragmentToSeoFragment())
        }
        binding.webButton.setOnClickListener {
            findNavController().navigate(MainFragmentDirections.actionMainFragmentToWebFragment())
        }
        binding.identityButton.setOnClickListener {
            findNavController().navigate(MainFragmentDirections.actionMainFragmentToIdentityFragment())
        }
        binding.designButton.setOnClickListener {
            findNavController().navigate(MainFragmentDirections.actionMainFragmentToDesignFragment())
        }
        binding.adsButton.setOnClickListener {
            findNavController().navigate(MainFragmentDirections.actionMainFragmentToAdsFragment())
        }




        lifecycleScope.launch {
            var i=0
            var check=true
            while (i<20) {
                if (check){
                    binding.animImageView.setImageResource(R.drawable.luxuriousimage)
                    binding.animImageViewTextview.setImageResource(R.drawable.luxurioustext)

                    val buttonAnimation = AnimationUtils.loadAnimation(requireContext(), R.anim.animation)
                    binding.animImageView.startAnimation(buttonAnimation)

                    check=false
                    i++
                    delay(3000)
                }else{
                    binding.animImageView.setImageResource(R.drawable.creativity)
                    binding.animImageViewTextview.setImageResource(R.drawable.creativityimagetext)

                    val buttonAnimation = AnimationUtils.loadAnimation(requireContext(), R.anim.animation)
                    binding.animImageView.startAnimation(buttonAnimation)
                    check=true
                    i++
                    delay(3000)
                }
            }
        }



    }
}