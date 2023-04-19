package com.example.skillcinema.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.skillcinema.data.films.ItemDto
import com.example.skillcinema.databinding.FilmPhotoNameForRecyclerBinding

class AllFilmsTopRecyclerViewAdapter  (private val onClickItem: (String) -> Unit
):
    PagingDataAdapter<ItemDto, MyViewHolderFilmAll>(DiffUtilItemCallAllFilmAll()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderFilmAll {
        return MyViewHolderFilmAll(
            FilmPhotoNameForRecyclerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
    override fun onBindViewHolder(holder: MyViewHolderFilmAll, position: Int) {
        val item = getItem(position)
        with(holder.binding) {
            if (item != null) {
                root.setOnClickListener {
                        onClickItem((item.kinopoiskId ?: item.imdbId).toString())
                    }
                textViewBottom.text = item.nameEn ?: item.nameRu
                textViewDown.text = item.genres[0].genre?: ""
               rating.text = (item.ratingKinopoisk?: item.ratingImdb).toString()
                item.let {
                    Glide
                        .with(myImageFilm.context)
                        .load(it.posterUrl)
                        .into(myImageFilm)
                }
            }

        }
        holder.binding.textViewBottom.setOnClickListener {
            holder.binding.textViewBottom.maxLines = if ( holder.binding.textViewBottom.maxLines == 1) {
                2

            } else {
                1
            }


        }

    }


}

class MyViewHolderFilmAll(val binding: FilmPhotoNameForRecyclerBinding) : RecyclerView.ViewHolder(binding.root)

class DiffUtilItemCallAllFilmAll : DiffUtil.ItemCallback<ItemDto>() {
    override fun areItemsTheSame(oldItem: ItemDto, newItem: ItemDto): Boolean {
        val    itemIdOld = (oldItem.ratingKinopoisk?: oldItem.ratingImdb)
        val   itemIdNew = (newItem.ratingKinopoisk?: newItem.ratingImdb)
      return (itemIdNew == itemIdOld)

    }



    override fun areContentsTheSame(oldItem: ItemDto, newItem: ItemDto): Boolean = oldItem == newItem


}
