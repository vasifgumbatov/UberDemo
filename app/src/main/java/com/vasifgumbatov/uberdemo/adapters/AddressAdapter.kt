package com.vasifgumbatov.uberdemo.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vasifgumbatov.uberdemo.R
import com.vasifgumbatov.uberdemo.api.model.Address

class AddressAdapter(private val addresses: List<Address>) :
    RecyclerView.Adapter<AddressAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val addressText: TextView = itemView.findViewById(R.id.text_address)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_address, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.addressText.text = addresses[position].address
    }

    override fun getItemCount(): Int = addresses.size
}