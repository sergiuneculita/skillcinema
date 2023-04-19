package com.example.skillcinema.presentation.placeholder.homeFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import com.example.skillcinema.databinding.LoadStateHorizontalBinding

class LoadStateAdapter:androidx.paging.LoadStateAdapter<LoadStateAdapter.LoadStateViewHolder>() {

    override fun onBindViewHolder(holder: LoadStateViewHolder, loadState: LoadState)= Unit

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoadStateViewHolder {

        val binding = LoadStateHorizontalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LoadStateViewHolder(binding)
    }

    class LoadStateViewHolder(binding: LoadStateHorizontalBinding): RecyclerView.ViewHolder(binding.root)


}

