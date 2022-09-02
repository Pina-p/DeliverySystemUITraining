package com.techniquesmyanmar.deliverysystemuitraining

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.AdapterView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.techniquesmyanmar.deliverysystemuitraining.databinding.ActivityMainBinding
import com.techniquesmyanmar.deliverysystemuitraining.model.DateDay
import com.techniquesmyanmar.deliverysystemuitraining.model.Time
import com.techniquesmyanmar.deliverysystemuitraining.model.Transportation
import com.techniquesmyanmar.deliverysystemuitraining.adapter.DateDayAdapter
import com.techniquesmyanmar.deliverysystemuitraining.adapter.TimeAdapter
import com.techniquesmyanmar.deliverysystemuitraining.adapter.TransportationAdapter
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var itemClickListener: AdapterView.OnItemClickListener
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        var today = LocalDate.now()
        var tmr = today.plusDays(1)
        var tdt = today.plusDays(2)

        formatDate(today)
        formatDate(tmr)
        formatDate(tdt)


        val dateData : ArrayList<DateDay> = arrayListOf(
            DateDay(formatDate(today),formatWeekDay(today)),
            DateDay(formatDate(tmr),formatWeekDay(tmr)),
            DateDay(formatDate(tdt),formatWeekDay(tdt))
        )


        val data: ArrayList<Time> = arrayListOf(
            Time("09:00 AM - 10:00 AM","2,500 Ks"),
            Time("11:00 AM - 12:00 PM","1,000 Ks"),
            Time("03:00 PM - 06:00 PM","3,000 Ks")
        )

        val transportData: ArrayList<Transportation> = arrayListOf(
            Transportation("ကားဂိတ်ဖြင့် ပို့မည်","(2 - 4 Day) 2,500 Ks"),
            Transportation("စာတိုက်ဖြင့် ပို့မည်","(5 - 7 Day) 1,500 Ks")

        )

        binding.rvDate.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity,LinearLayoutManager.HORIZONTAL,false)
            adapter = DateDayAdapter(dateData)
        }

        binding.rvTime.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = TimeAdapter(data)
        }

        binding.rvDeliver.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = TransportationAdapter(transportData)
        }

        binding.btnButton.setOnClickListener {
            Intent(this,NextActivity::class.java).also {
                startActivity(it)
            }
        }


    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun formatDate(date:LocalDate):String{
        var formatDate = DateTimeFormatter.ofPattern("d MMM")
        return date.format(formatDate)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun formatWeekDay(day:LocalDate):String{
        var formatWeekDay = DateTimeFormatter.ofPattern("EEE")
        return day.format(formatWeekDay)
    }


}