package com.example.app.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

data class MainApiResponse(
    val tasks: List<Task>
)
@Parcelize
data class Task(
    val id: String,
    val TargetDate: String,
    val DueDate: String? = null,
    val Title: String,
    val Description: String,
    val Priority: Long
) : Parcelable