package com.example.weaterapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.decode.SvgDecoder
import coil.load
import com.example.weaterapp.databinding.ItemRowLocationBinding
import com.example.weaterapp.domain.model.location.LocationData
import com.example.weaterapp.utils.countryCodeToFlagUrl
import com.example.weaterapp.utils.descriptionLocation

class ListLocationAdapter (
    private val onClickItem: (LocationData) -> Unit
): ListAdapter<LocationData, ListLocationAdapter.ListLocationViewHolder>(DiffCallBack){

    inner class ListLocationViewHolder (
        private val binding: ItemRowLocationBinding
    ): RecyclerView.ViewHolder(binding.root) {

        fun bind(locationData: LocationData) {
            binding.apply {
                ivCountryFlag.load(
                    locationData.countryCode.countryCodeToFlagUrl()
                ) {
                    decoderFactory{ result, options, _ ->
                        SvgDecoder(result.source, options)
                    }
                }
                tvTitleLocation.text = locationData.name
                tvDescLocation.text = descriptionLocation(
                    listOf(locationData.name, locationData.country, locationData.admin)
                )
                root.setOnClickListener { onClickItem(locationData) }
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListLocationAdapter.ListLocationViewHolder {
        val binding = ItemRowLocationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListLocationViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ListLocationAdapter.ListLocationViewHolder,
        position: Int
    ) {
        val data = getItem(position)
        holder.bind(data)
    }

    private companion object DiffCallBack: DiffUtil.ItemCallback<LocationData>() {
        override fun areItemsTheSame(oldItem: LocationData, newItem: LocationData): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: LocationData, newItem: LocationData): Boolean {
            return oldItem.name == newItem.name
        }
    }
}