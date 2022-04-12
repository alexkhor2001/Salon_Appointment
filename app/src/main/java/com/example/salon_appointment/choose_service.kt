package com.example.salon_appointment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class choose_service : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var serviceArrayList: ArrayList<serviceModel>
    private lateinit var imageId : ArrayList<Int>
    private lateinit var heading : ArrayList<String>

    private val sharedViewModel: sharedViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        imageId = arrayListOf (
            R.drawable.img_image3,
            R.drawable.img_image4,
            R.drawable.img_image5,
            R.drawable.img_image6,
            R.drawable.img_image7,
            R.drawable.img_image8
        )

        heading = arrayListOf(
            "Hair Dry",
            "Hair Stream",
            "Hair Cut",
            "Perm",
            "Hair Wash",
            "Hair Dye"
        )
        val view = inflater.inflate(R.layout.fragment_choose_service,container,false)
        recyclerView = view.findViewById(R.id.chooseServiceRecyclerview)
        recyclerView.layoutManager = GridLayoutManager(getContext(),2,GridLayoutManager.VERTICAL,false)
        recyclerView.setHasFixedSize(true)

        serviceArrayList = arrayListOf<serviceModel>()
        getServicesData()
        return view
    }

    private fun getServicesData(){
        for(i in imageId.indices){
            val times = serviceModel(imageId[i], heading[i])
            serviceArrayList.add(times)
        }
        var adapter = chooseServiceAdapter(serviceArrayList)
        recyclerView.adapter = adapter

        adapter.setOnClickListener(object : chooseServiceAdapter.onItemClickListener{
            override fun onItemClick(view: View) {
                val name = view.findViewById<TextView>(R.id.serviceTextView)
                Toast.makeText(context , "service choosed is ${name.text.toString()}", Toast.LENGTH_SHORT).show()
                sharedViewModel.setServiceChoose(name.text.toString())
                Navigation.findNavController(view).navigate(R.id.action_choose_service_to_booking_hairdresser)
            }

        })
    }
}