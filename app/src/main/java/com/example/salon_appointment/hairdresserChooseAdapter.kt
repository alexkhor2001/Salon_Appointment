package com.example.salon_appointment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class hairdresserChooseAdapter(private val hairdresserList : ArrayList<hairdresserModel>) :
    RecyclerView.Adapter<hairdresserChooseAdapter.hairdresserViewHolder>() {

    private lateinit var mListener : onItemClickListener

    interface onItemClickListener{
        fun onItemClick(view : View)
    }

    fun setOnClickListener(listener: onItemClickListener){
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): hairdresserViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.hairdresser_box_layout,parent,false)
        return hairdresserViewHolder(itemView,mListener)
    }

    override fun onBindViewHolder(holder: hairdresserViewHolder, position: Int) {
        val currentItem = hairdresserList[position]
        holder.profile.setImageResource(currentItem.profile)
        holder.name.text = currentItem.name
    }

    override fun getItemCount(): Int {
        return hairdresserList.size
    }

    class hairdresserViewHolder(itemView : View,listener: onItemClickListener) : RecyclerView.ViewHolder(itemView){
        val profile : ImageView = itemView.findViewById(R.id.imgHairdresserProfile)
        val name : TextView = itemView.findViewById(R.id.txtHairdresserName)

        init {
            itemView.setOnClickListener{
                listener.onItemClick(itemView)
            }
        }
    }
}