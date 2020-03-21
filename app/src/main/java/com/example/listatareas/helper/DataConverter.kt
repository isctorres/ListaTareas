package com.example.listatareas.helper

import androidx.room.TypeConverter
import java.sql.Timestamp
import java.util.*

class DataConverter{

    @TypeConverter
    fun toDate(timestamp: Long?) : Date?{
        return if(timestamp != null ) Date(timestamp) else null
    }

    @TypeConverter
    fun toTimeStamp(date:Date):Long? = date?.time
}