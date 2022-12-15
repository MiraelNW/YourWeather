package com.example.yourweather.data.local

import androidx.room.TypeConverter
import java.util.*
import java.util.stream.Collectors


class Converters {


    @TypeConverter
    fun fromStringList(list: List<String?>): String? {
        return list.stream().collect(Collectors.joining(","))
    }

    @TypeConverter
    fun toStringList(value: String): List<String>? {
        return Arrays.asList(*value.split(",").toTypedArray())
    }

    @TypeConverter
    fun fromListIntToString(intList: List<Int>): String = intList.toString()

    @TypeConverter
    fun toListInt(stringList: String): List<Int> {
        val result = ArrayList<Int>()
        val split =stringList.replace("[","").replace("]","").replace(" ","").split(",")
        for (n in split) {
            try {
                result.add(n.toInt())
            } catch (e: Exception) {

            }
        }
        return result
    }

    @TypeConverter
    fun fromListDoubleToString(doubleList: List<Double>): String = doubleList.toString()

    @TypeConverter
    fun toListDouble(stringList: String): List<Double> {
        val result = ArrayList<Double>()
        val split =stringList.replace("[","").replace("]","").replace(" ","").split(",")
        for (n in split) {
            try {
                result.add(n.toDouble())
            } catch (e: Exception) {

            }
        }
        return result
    }


}