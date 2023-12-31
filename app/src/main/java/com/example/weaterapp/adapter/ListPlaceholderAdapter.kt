package com.example.weaterapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weaterapp.databinding.ItemRowWeatherShimmerBinding

class ListPlaceholderAdapter (
    private val sizePlaceHolder: Int = 12
): RecyclerView.Adapter<ListPlaceholderAdapter.ListPlaceholderViewHolder>() {

    class ListPlaceholderViewHolder(binding: ItemRowWeatherShimmerBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListPlaceholderViewHolder {
        val binding = ItemRowWeatherShimmerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListPlaceholderViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListPlaceholderViewHolder, position: Int) {
        holder.itemView
    }

    override fun getItemCount(): Int {
        return sizePlaceHolder
    }
}