package com.techniquesmyanmar.deliverysystemuitraining.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.techniquesmyanmar.deliverysystemuitraining.databinding.DateItemBinding
import com.techniquesmyanmar.deliverysystemuitraining.model.DateDay

class DateDayAdapter (
    private val list : List<DateDay>
) : RecyclerView.Adapter<DateDayAdapter.DateDayHolder>(){
    private var selected = -1
    inner class DateDayHolder(private val binding: DateItemBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(day: DateDay){
           binding.tvDate.text = day.date
            binding.tvDay.text = day.day.uppercase()
            binding.cardView.setOnClickListener {
//                binding.tvDate.setTextColor(Color.parseColor("#ffffff"))
//                binding.tvDay.setTextColor(Color.parseColor("#ffffff"))
//                binding.cardView.setCardBackgroundColor(Color.parseColor("#e6cc00"))

                selected = adapterPosition
                notifyDataSetChanged()

            }
            if(selected == adapterPosition){
                binding.tvDate.setTextColor(Color.parseColor("#ffffff"))
                binding.tvDate.setTextColor(Color.parseColor("#ffffff"))
            }else{
                binding.tvDate.setTextColor(Color.parseColor("#4d4d4d"))
                binding.tvDay.setTextColor(Color.parseColor("#4d4d4d"))
            }
            binding.cardView.isSelected= selected == adapterPosition
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DateDayHolder {
        return DateDayHolder(
            DateItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        )
    }

    override fun onBindViewHolder(holder: DateDayHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

}