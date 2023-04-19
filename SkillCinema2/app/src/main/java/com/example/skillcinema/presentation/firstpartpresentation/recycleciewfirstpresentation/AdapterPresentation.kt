package com.example.skillcinema.presentation.firstpartpresentation.recycleciewfirstpresentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.skillcinema.R
import com.example.skillcinema.databinding.ElementFirstPresentationBinding

class AdapterProbe: RecyclerView.Adapter<MyViewHolderProbe>() {
    val listView =
        listOf(R.drawable.image_for_first_page_presentation,
            R.drawable.wfh_8, R.drawable.wfh_2)
    val listText = listOf(
        R.drawable.___________________1,
        R.drawable.__________________22,
        R.drawable._________________3
    )


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderProbe {
        return MyViewHolderProbe(
            ElementFirstPresentationBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )

        )

    }override fun getItemCount(): Int = 3
    override fun onBindViewHolder(holder: MyViewHolderProbe, position: Int) {
        holder.binding.imageViewPresentation.setImageResource(listView[position])
        holder.binding.imageTextElement.setImageResource(listText[position])
    }
}

class MyViewHolderProbe(val binding: ElementFirstPresentationBinding) :
    RecyclerView.ViewHolder(binding.root)
