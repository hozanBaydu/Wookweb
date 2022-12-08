package com.hozanbaydu.wookweb.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class WookViewModel:ViewModel() {
    
    var textName= MutableStateFlow("textName")

}