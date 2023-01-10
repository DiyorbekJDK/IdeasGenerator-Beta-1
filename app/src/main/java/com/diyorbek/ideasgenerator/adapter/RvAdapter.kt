package com.diyorbek.ideasgenerator.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.diyorbek.ideasgenerator.R
import com.diyorbek.ideasgenerator.databinding.MenuItemLayoutBinding
import com.diyorbek.ideasgenerator.model.MenuItem

class RvAdapter : ListAdapter<MenuItem, RvAdapter.MenuItemHolder>(DiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuItemHolder {
        return MenuItemHolder(
            MenuItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MenuItemHolder, position: Int) {
        holder.bind(getItem(position))
    }

    private class DiffCallBack : DiffUtil.ItemCallback<MenuItem>() {
        override fun areItemsTheSame(oldItem: MenuItem, newItem: MenuItem): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: MenuItem, newItem: MenuItem): Boolean {
            return oldItem == newItem
        }
    }

    inner class MenuItemHolder(private val binding: MenuItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(menuItem: MenuItem) {
            binding.blockName.text = menuItem.name
            binding.blockDescription.text = menuItem.desc
            if (menuItem.isFav) {
                binding.isFav.setImageResource(R.drawable.ic_baseline_favorite_24)
            }
        }
    }
}