package com.example.salon_appointment

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class sharedViewModel : ViewModel() {
    private val date = Date(2022,1,1)//init

    private val _nameOfHairdresser = MutableLiveData("name")
    private val _serviceChoose = MutableLiveData("service")
    private val _timeSlotBooking = MutableLiveData("time")
    private val _dateChoose = MutableLiveData(date)
    private val _imgHairdresser = MutableLiveData<Drawable>(null)

    var nameOfHairdresser : LiveData<String> = _nameOfHairdresser
    var serviceChoose : LiveData<String> = _serviceChoose
    var timeSlotBooking : LiveData<String> = _timeSlotBooking
    var dateChoose : LiveData<Date> = _dateChoose
    var imgHairdresser : LiveData<Drawable> = _imgHairdresser

    fun setServiceChoose(newService : String){
        _serviceChoose.value = newService
    }

    fun setNameOfHairdresser(newHairdresser : String){
        _nameOfHairdresser.value = newHairdresser
    }

    fun setTimeSlotBooking(newTimeslot : String){
        _timeSlotBooking.value = newTimeslot
    }

    fun setDateChoose(newDate : Date){
        _dateChoose.value = newDate
    }

    fun setImgHairdresser(newImg : Drawable){
        _imgHairdresser.value = newImg
    }
}