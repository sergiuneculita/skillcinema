package com.example.skillcinema.presentation.placeholder.homeFragment.recyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.skillcinema.data.films.ItemDto
import com.example.skillcinema.databinding.FilmPhotoNameForRecyclerBinding

class AdapterFilmHorizontal(
    val itemList: List<ItemDto>,
    private val onClickItem: (String) -> String,
) :
    RecyclerView.Adapter<ViewHolderElementFilm>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderElementFilm {
        return ViewHolderElementFilm(
            FilmPhotoNameForRecyclerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: ViewHolderElementFilm, position: Int) {
        val itemDto = itemList[position]
        holder.root.setOnClickListener {
            onClickItem(
                if (itemDto.kinopoiskId == null) {
                    itemDto.imdbId.toString()
                } else {
                    itemDto.kinopoiskId.toString()
                }
            )
        }

        val name = itemDto.nameEn ?: itemDto.nameRu
        holder.name.text = name
        holder.genre.text = itemDto.genres[0].genre
        val rating = itemDto.ratingImdb ?: itemDto.ratingKinopoisk
        holder.rating.text = rating.toString()
        with(holder) {
            itemDto.let {
                Glide.with(imageView.context)
                    .load(it.posterUrl)
                    .into(imageView)

            }
        }

        holder.name.setOnClickListener {
            holder.name.maxLines = if (holder.name.maxLines == 1) {
                2

            } else {
                1
            }


        }


    }
}