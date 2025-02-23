package com.vasifgumbatov.uberdemo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vasifgumbatov.uberdemo.api.model.Address
import com.vasifgumbatov.uberdemo.api.model.AddressResponse
import com.vasifgumbatov.uberdemo.api.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddressViewModel: ViewModel() {

    private val _addresses = MutableLiveData<List<Address>>()
    val addresses: LiveData<List<Address>> get() = _addresses

    fun fetchAddresses() {
        RetrofitClient.instance.getAddresses().enqueue(object : Callback<List<Address>> {
            override fun onResponse(call: Call<List<Address>>, response: Response<List<Address>>) {
                if (response.isSuccessful) {
                    _addresses.value = response.body()
                }
            }

            override fun onFailure(call: Call<List<Address>>, t: Throwable) {

            }
        })
    }

    fun addAddress(address: Address) {
        RetrofitClient.instance.addAddress(address).enqueue(object : Callback<AddressResponse> {
            override fun onResponse(
                call: Call<AddressResponse>,
                response: Response<AddressResponse>
            ) {
                if (response.isSuccessful) {
                    fetchAddresses()
                }
            }

            override fun onFailure(call: Call<AddressResponse>, t: Throwable) {

            }
        })
    }
}