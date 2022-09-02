package com.techniquesmyanmar.filter

import android.util.Log
import android.view.LayoutInflater
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.techniquesmyanmar.deliverysystemuitraining.R
import com.techniquesmyanmar.deliverysystemuitraining.databinding.ActivityMainBinding.inflate
import com.techniquesmyanmar.deliverysystemuitraining.databinding.TimeItemBinding
import com.techniquesmyanmar.deliverysystemuitraining.model.Time

class TimeAdapter (
    private val timeList : List<Time>
) : RecyclerView.Adapter<TimeAdapter.TimeHolder>(){
    private var selectItem = -1
    inner class TimeHolder(private val binding: TimeItemBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(time: Time){
            binding.rbRadio.text = time.time
            binding.tvPrice.text = time.price

            binding.root.setOnClickListener{
                if(!binding.rbRadio.isChecked){
                    selectItem = adapterPosition
                    notifyDataSetChanged()
                }
            }
            binding.rbRadio.setOnClickListener {
                if(binding.rbRadio.isChecked){
                    selectItem = adapterPosition
                    notifyDataSetChanged()
                }
            }
            binding.rbRadio.isChecked = selectItem == adapterPosition
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimeHolder {
        return TimeHolder(
            TimeItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        )
    }

    override fun onBindViewHolder(holder: TimeHolder, position: Int) {
        holder.bind(timeList[position])

    }

    override fun getItemCount(): Int {
        return timeList.size
    }

}