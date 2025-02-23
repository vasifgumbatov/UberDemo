package com.vasifgumbatov.uberdemo.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.vasifgumbatov.uberdemo.R
import com.vasifgumbatov.uberdemo.adapters.AddressAdapter
import com.vasifgumbatov.uberdemo.viewmodel.AddressViewModel

class AddressListActivity : AppCompatActivity() {
    private lateinit var viewModel: AddressViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_address_list)

        viewModel = ViewModelProvider(this)[AddressViewModel::class.java]
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        viewModel.addresses.observe(this) { addresses ->
            recyclerView.adapter = AddressAdapter(addresses)
        }

        viewModel.fetchAddresses()
    }
}