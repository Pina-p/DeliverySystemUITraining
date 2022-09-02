package com.techniquesmyanmar.filter

import android.annotation.SuppressLint
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
import com.techniquesmyanmar.deliverysystemuitraining.databinding.TransportationItemBinding
import com.techniquesmyanmar.deliverysystemuitraining.model.Time
import com.techniquesmyanmar.deliverysystemuitraining.model.Transportation

class TransportationAdapter (
    private val tlist : List<Transportation>
) : RecyclerView.Adapter<TransportationAdapter.TransportationHolder>(){
    private var selectItem = -1
    inner class TransportationHolder(private val binding: TransportationItemBinding):RecyclerView.ViewHolder(binding.root){
        @SuppressLint("NotifyDataSetChanged")
        fun bind(t: Transportation){

            binding.rbRadio.text = t.way
            binding.tvDuration.text = t.duration

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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransportationHolder {
        return TransportationHolder(
            TransportationItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        )
    }

    override fun onBindViewHolder(holder: TransportationHolder, position: Int) {
        holder.bind(tlist[position])

    }

    override fun getItemCount(): Int {
        return tlist.size
    }

}