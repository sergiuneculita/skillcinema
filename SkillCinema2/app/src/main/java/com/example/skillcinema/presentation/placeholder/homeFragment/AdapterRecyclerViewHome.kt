package com.example.skillcinema.presentation.placeholder.homeFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.skillcinema.databinding.ElementListFilmHorizontalBinding
import com.example.skillcinema.presentation.FilmsWithCategory
import com.example.skillcinema.presentation.placeholder.homeFragment.recyclerView.AdapterButtonAllFilms
import com.example.skillcinema.presentation.placeholder.homeFragment.recyclerView.AdapterFilmHorizontal

class AdapterRecyclerViewHome(
    private val onClickItem: (String) -> String,
    private val onClickAllFilms: (String) -> Unit,
    ) : ListAdapter<FilmsWithCategory, ViewHolderParent>(DiffUtilListForHomeFragment()) {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolderParent {
        return ViewHolderParent(
            ElementListFilmHorizontalBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }


    override fun onBindViewHolder(
        holder: ViewHolderParent,
        position: Int
    ) {
        val item = getItem(position)
        holder.all.setOnClickListener {
            onClickAllFilms(item.nameCategory)
        }
        holder.text.text = item.nameCategory
        val adapter = ConcatAdapter(
            AdapterFilmHorizontal(item.listFilms) { name ->
                onClickItem(
                    name
                )
            },
            AdapterButtonAllFilms { onClickAllFilms(item.nameCategory) })
        holder.recyclerView.adapter = adapter
        holder.recyclerView.layoutManager =
            LinearLayoutManager(holder.recyclerView.context, RecyclerView.HORIZONTAL, false)

    }
}

class ViewHolderParent(itemView: ElementListFilmHorizontalBinding) :
    RecyclerView.ViewHolder(itemView.root) {
    val text = itemView.texeLeft
    val recyclerView = itemView.containerFilmHorizontal
    val all = itemView.textRight
}
class DiffUtilListForHomeFragment(
) : DiffUtil.ItemCallback<FilmsWithCategory>() {
    override fun areItemsTheSame(oldItem: FilmsWithCategory, newItem: FilmsWithCategory): Boolean = oldItem.nameCategory == newItem.nameCategory

    override fun areContentsTheSame(
        oldItem: FilmsWithCategory,
        newItem: FilmsWithCategory
    ): Boolean = oldItem.nameCategory == newItem.nameCategory

}



