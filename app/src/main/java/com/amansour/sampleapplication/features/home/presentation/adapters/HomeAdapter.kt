package com.amansour.sampleapplication.features.home.presentation.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amansour.sampleapplication.databinding.ItemHomeBinding
import com.amansour.sampleapplication.features.home.domain.models.HomeUiItem

class HomeAdapter : RecyclerView.Adapter<HomeViewHolder>() {
    var items: List<HomeUiItem> = listOf()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        HomeViewHolder(
            ItemHomeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )


    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) =
        holder.bind(items[position])

    override fun getItemCount() = items.size
}

class HomeViewHolder(private val binding: ItemHomeBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: HomeUiItem) {
        binding.data = item
    }
}