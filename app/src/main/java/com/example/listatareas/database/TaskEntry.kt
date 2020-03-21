package com.example.listatareas.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName="task") // Anotacion para generar la tabla
class TaskEntry (
    @PrimaryKey(autoGenerate = true)
    var id:Long = 0,
    var description: String = "",
    var priority: Int = 1,
    @ColumnInfo(name="updated_at")
    var updateAt: Date
)