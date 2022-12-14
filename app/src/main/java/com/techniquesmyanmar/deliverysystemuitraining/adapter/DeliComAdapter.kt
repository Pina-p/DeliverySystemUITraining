package com.techniquesmyanmar.deliverysystemuitraining.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.techniquesmyanmar.deliverysystemuitraining.databinding.DeliveryCompanyItemBinding
import com.techniquesmyanmar.deliverysystemuitraining.model.DeliveryCompany

class DeliComAdapter (
    private val dList : List<DeliveryCompany>
) : RecyclerView.Adapter<DeliComAdapter.DeliComHolder>(){
    private var selectItem = -1
    inner class DeliComHolder(private val binding: DeliveryCompanyItemBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(dc: DeliveryCompany){
            binding.tvCompany1.text = dc.company
            binding.tvPhoneNum1.text = dc.phone_num

            binding.ivDeliveryCompany.load(dc.image)

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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeliComHolder {
        return DeliComHolder(
            DeliveryCompanyItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        )
    }

    override fun onBindViewHolder(holder: DeliComHolder, position: Int) {
        holder.bind(dList[position])

    }

    override fun getItemCount(): Int {
        return dList.size
    }

}