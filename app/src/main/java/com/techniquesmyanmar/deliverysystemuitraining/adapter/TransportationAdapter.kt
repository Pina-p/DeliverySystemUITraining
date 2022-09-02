package com.techniquesmyanmar.deliverysystemuitraining.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.techniquesmyanmar.deliverysystemuitraining.databinding.TransportationItemBinding
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