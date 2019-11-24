package es.iesnervion.avazquez.fragmentslivedatakotlin.viewmodel

import android.content.ClipData.Item
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    val data = MutableLiveData<Item>()

    fun data(item: Item) {
        data.value = item
    }
}