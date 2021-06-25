package com.example.fetchtest

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fetchtest.databinding.HiringItemBinding
import com.example.fetchtest.models.HiringItem

class HiringItemsAdapter(
    private val itemsList: List<HiringItem>
) : RecyclerView.Adapter<HiringItemsAdapter.HiringItemViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HiringItemViewHolder {
        val binding = HiringItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return HiringItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HiringItemViewHolder, position: Int) {
        holder.bind(itemsList[position])
    }

    override fun getItemCount() = itemsList.size

    inner class HiringItemViewHolder constructor(private val binding: HiringItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: HiringItem) {
            binding.hiringItemId.text = "Id: ${item.id}"
            binding.hiringItemName.text = "Name: ${item.name}"
            binding.hiringItemListId.text = "ListID: ${item.listId}"
        }
    }
}