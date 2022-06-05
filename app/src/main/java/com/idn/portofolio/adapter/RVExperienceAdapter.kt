package com.idn.portofolio.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.idn.portofolio.R
import com.idn.portofolio.data.Portofolio
import com.idn.portofolio.databinding.ItemExperienceBinding

class RVExperienceAdapter : RecyclerView.Adapter<RVExperienceAdapter.ExperienceViewHolder>() {

    private val listData = ArrayList<Portofolio>()

    var onItemClicked : ((Portofolio) -> Unit)? = null

    fun setData(newList : List<Portofolio>?) {
        if(newList == null) return
        listData.clear()
        listData.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ExperienceViewHolder  =
        ExperienceViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_experience, parent, false)
        )

    override fun onBindViewHolder(holder: ExperienceViewHolder, pos: Int) {
        val listData = listData[pos]
        holder.bind(listData)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    inner class ExperienceViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemExperienceBinding.bind(itemView)

        fun bind(data : Portofolio) {
            binding.experience = data
            binding.executePendingBindings()
        }

        init {
            binding.root.setOnClickListener{
                onItemClicked?.invoke(listData[adapterPosition])
            }
        }
    }
}