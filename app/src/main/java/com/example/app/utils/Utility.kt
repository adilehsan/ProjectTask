package com.example.app.utils

import android.os.Build
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatter.*
import java.time.temporal.ChronoUnit
import java.util.Locale

object Utility {
    fun getNewDate (oldDateString: String, oldFormat: String, newFormat: String): String{
        return try {
            // Create the old and new date formats
            val oldFormatter = SimpleDateFormat(oldFormat, Locale.getDefault())
            val newFormatter = SimpleDateFormat(newFormat, Locale.getDefault())

            // Parse the old date string into a Date object
            val date = oldFormatter.parse(oldDateString)

            // Format the Date object into the new format
            newFormatter.format(date)
        } catch (e: Exception) {
            e.printStackTrace()
            ""
        }
    }


    @RequiresApi(Build.VERSION_CODES.O)
    fun calculateDaysBetweenDates(startDate: String, endDate: String, dateFormat: String): Long {
        // Create a DateTimeFormatter with the given date format
        val formatter = ofPattern(dateFormat)

        // Parse the start and end dates to LocalDate
        val start = LocalDate.parse(startDate, formatter)
        val end = LocalDate.parse(endDate, formatter)

        // Calculate the number of days between the two dates
        return ChronoUnit.DAYS.between(start, end)
    }
}
