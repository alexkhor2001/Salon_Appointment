package com.example.salon_appointment.hairdresser

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.salon_appointment.R
import com.example.salon_appointment.hairdresserChooseAdapter
import com.example.salon_appointment.hairdresserModel
import com.example.salon_appointment.sharedViewModel

class booking_hairdresser : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var hairdresserArrayList: ArrayList<hairdresserModel>
    private lateinit var imageId : ArrayList<Int>
    private lateinit var heading : ArrayList<String>
    private val sharedViewModel: sharedViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        imageId = arrayListOf (
            R.drawable.img_2328596phmodi,
            R.drawable.img_20200719159511,
            R.drawable.img_15408877569017,
            R.drawable.img_hairdresser4,
            R.drawable.img_hairdresser5
        )

        heading = arrayListOf(
            "Sim Pei Wen",
            "Lily Tan Xian Yan",
            "Kim Hao Yu",
            "Lucas",
            "Davil"
        )
        val view = inflater.inflate(R.layout.fragment_booking_hairdresser,container,false)
        recyclerView = view.findViewById(R.id.bookingHairdresserRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(getContext())
        recyclerView.setHasFixedSize(true)
        hairdresserArrayList = arrayListOf<hairdresserModel>()
        getServicesData()
        return view
    }

    private fun getServicesData(){
        for(i in imageId.indices){
            val times = hairdresserModel(heading[i],imageId[i])
            hairdresserArrayList.add(times)
        }
        var adapter = hairdresserChooseAdapter(hairdresserArrayList)
        recyclerView.adapter = adapter
        adapter.setOnClickListener(object : hairdresserChooseAdapter.onItemClickListener{
            override fun onItemClick(view: View) {
                val name = view.findViewById<TextView>(R.id.txtHairdresserName)
                val image = view.findViewById<ImageView>(R.id.imgHairdresserProfile)
                Toast.makeText(context , "hairdresser choosed is ${name.text.toString()}", Toast.LENGTH_SHORT).show()
                sharedViewModel.setNameOfHairdresser(name.text.toString())
                sharedViewModel.setImgHairdresser(image.getDrawable())
                Navigation.findNavController(view).navigate(R.id.action_booking_hairdresser_to_booking_time)
            }

        })
    }
}