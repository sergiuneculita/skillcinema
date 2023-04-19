package com.example.skillcinema.presentation.placeholder.homeFragment.recyclerView

import androidx.recyclerview.widget.RecyclerView
import com.example.skillcinema.databinding.FilmPhotoNameForRecyclerBinding

class ViewHolderElementFilm (
    itemView: FilmPhotoNameForRecyclerBinding
) :
    RecyclerView.ViewHolder(itemView.root) {
    val imageView = itemView.myImageFilm
    val name = itemView.textViewBottom
    val genre = itemView.textViewDown
    val rating = itemView.rating
    val root = itemView.root


}