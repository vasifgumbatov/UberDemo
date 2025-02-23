package com.vasifgumbatov.uberdemo.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.vasifgumbatov.uberdemo.api.model.Address
import com.vasifgumbatov.uberdemo.databinding.ActivityMainBinding
import com.vasifgumbatov.uberdemo.viewmodel.AddressViewModel

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    private lateinit var viewModel: AddressViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        viewModel = ViewModelProvider(this).get(AddressViewModel::class.java)

        binding?.btnSubmit?.setOnClickListener {
            val address = Address(
                region = 1,
                address = binding?.editAddress?.text.toString(),
                lat = 35.7717503,
                lng = 51.3365315,
                coordinateMobile = binding?.editPhone?.text.toString(),
                coordinatePhoneNumber = binding?.editPhone?.text.toString(),
                firstName = binding?.editFirstName?.text.toString(),
                lastName = binding?.editLastName?.text.toString(),
                gender = "Male"
            )

            viewModel.addAddress(address)
        }

        // View Addresses
        binding?.btnViewAddresses?.setOnClickListener {
            viewModel.fetchAddresses()
        }
    }
}