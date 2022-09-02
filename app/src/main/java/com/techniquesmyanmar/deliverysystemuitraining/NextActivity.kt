package com.techniquesmyanmar.deliverysystemuitraining

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.techniquesmyanmar.deliverysystemuitraining.databinding.ActivityNextBinding
import com.techniquesmyanmar.deliverysystemuitraining.model.DeliveryCompany
import com.techniquesmyanmar.deliverysystemuitraining.model.Time
import com.techniquesmyanmar.filter.DeliComAdapter
import java.time.LocalDate

class NextActivity : AppCompatActivity() {

    private lateinit var binding : ActivityNextBinding
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNextBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var today = LocalDate.now()

        var tmr = today.plusDays(1)
        var tdt = today.plusDays(2)

        Toast.makeText(this, "$today + ${today.month} $tmr + $tdt", Toast.LENGTH_SHORT).show()

        val data: ArrayList<DeliveryCompany> = arrayListOf(
            DeliveryCompany(R.drawable.delivery,"My Shop Delivery","09458484854"),
            DeliveryCompany(R.drawable.delivery,"Biker Delivery","0945655655"),
            DeliveryCompany(R.drawable.delivery,"Rocket Delivery","09976766667"),
            DeliveryCompany(R.drawable.image_bg,"Faster Delivery","095233443"),
            DeliveryCompany(R.drawable.image_bg,"Swoosh Deli","09343433334")
        )

        binding.rvDeliveryCom.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@NextActivity)
            adapter = DeliComAdapter(data)
        }

        binding.ivBack.setOnClickListener {
            finish()
        }

    }

}