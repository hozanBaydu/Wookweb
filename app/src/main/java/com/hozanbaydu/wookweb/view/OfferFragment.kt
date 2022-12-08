package com.hozanbaydu.wookweb.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.hozanbaydu.wookweb.R
import com.hozanbaydu.wookweb.databinding.FragmentMainBinding
import com.hozanbaydu.wookweb.databinding.FragmentOfferBinding
import com.hozanbaydu.wookweb.viewmodel.WookViewModel
import kotlinx.coroutines.launch

class OfferFragment: Fragment(R.layout.fragment_offer) {

    private var fragmentBinding : FragmentOfferBinding? = null
    lateinit var viewModel: WookViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity()).get(WookViewModel::class.java)

        val binding = FragmentOfferBinding.bind(view)
        fragmentBinding = binding


        lifecycleScope.launch {
            viewModel.textName.collect{

                binding.teklifImageview.text=it
            }
        }


        binding.gonderbutton.setOnClickListener {

            var message="Konu= " + binding.teklifImageview.text.toString()+ " - " + " Ad= "+binding.adTextview.text.toString()+
                    " - " + " Mail= " + binding.mailTextview.text.toString() + " - " + " Özet= " + binding.ozetTextview.text.toString()
            val intent = Intent(Intent.ACTION_VIEW)

            // Setting Intent type
            intent.type = "text/plain"

            // Setting whatsapp package name
            intent.setPackage("com.whatsapp")

            intent.setData(Uri.parse("http://api.whatsapp.com/send?phone=905456053279&text="+message))

            // Give your message here
            intent.putExtra(Intent.EXTRA_TEXT, message)

            // Starting Whatsapp
            startActivity(intent)
        }







    }
}