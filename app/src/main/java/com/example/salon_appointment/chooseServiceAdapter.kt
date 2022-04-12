package com.example.salon_appointment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class chooseServiceAdapter(private val serviceList: ArrayList<serviceModel>) :
    RecyclerView.Adapter<chooseServiceAdapter.serviceViewHolder>() {

    private lateinit var mListener : onItemClickListener

    interface onItemClickListener{
        fun onItemClick(view : View)
    }

    fun setOnClickListener(listener: onItemClickListener){
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): chooseServiceAdapter.serviceViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.service_box_layout,parent,false)
        return serviceViewHolder(itemView,mListener)
    }

    override fun onBindViewHolder(holder: serviceViewHolder, position: Int) {
        val currentItem = serviceList[position]
        holder.profile.setImageResource(currentItem.servicePicture)
        holder.name.text = currentItem.serviceName
    }

    override fun getItemCount(): Int {
        return serviceList.size
    }

    class serviceViewHolder(itemView : View,listener: onItemClickListener) : RecyclerView.ViewHolder(itemView){
        val profile : ImageView = itemView.findViewById(R.id.serviceImageView)
        val name : TextView = itemView.findViewById(R.id.serviceTextView)

        init {
            itemView.setOnClickListener{
                listener.onItemClick(itemView)
            }
        }
        }
    }
