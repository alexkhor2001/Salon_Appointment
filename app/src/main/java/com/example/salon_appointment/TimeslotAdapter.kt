package com.example.salon_appointment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TimeslotAdapter(private val timeList: ArrayList<timeModel>) :
    RecyclerView.Adapter<TimeslotAdapter.timeslotViewHolder>() {

    private lateinit var mListener : chooseServiceAdapter.onItemClickListener

    interface onItemClickListener{
        fun onItemClick(view : View)
    }

    fun setOnClickListener(listener: chooseServiceAdapter.onItemClickListener){
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): timeslotViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.timeslot_layout,parent,false)
        return timeslotViewHolder(itemView,mListener)
    }

    override fun onBindViewHolder(holder: timeslotViewHolder, position: Int) {
        val currentItem = timeList[position]
        holder.time.text = currentItem.time
    }

    override fun getItemCount(): Int {
        return timeList.size
    }

    class timeslotViewHolder(itemView: View, listener: chooseServiceAdapter.onItemClickListener) : RecyclerView.ViewHolder(itemView){
        val time : TextView = itemView.findViewById(R.id.txtTime)

        init {
            itemView.setOnClickListener{
                listener.onItemClick(itemView)
            }
        }
    }
}