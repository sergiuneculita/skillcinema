package com.example.skillcinema.presentation.placeholder.homeFragment.recyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.skillcinema.databinding.LoadStateHorizontalBinding
import com.example.skillcinema.presentation.placeholder.homeFragment.ViewHolderButtonAllFilms

class AdapterButtonAllFilms(
    private val onClick: () -> Unit
) : RecyclerView.Adapter<ViewHolderButtonAllFilms>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderButtonAllFilms {
        return ViewHolderButtonAllFilms(
            LoadStateHorizontalBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun getItemCount(): Int = 1

    override fun onBindViewHolder(holder: ViewHolderButtonAllFilms, position: Int) {
        holder.button.setOnClickListener {
           onClick()

        }
    }
}