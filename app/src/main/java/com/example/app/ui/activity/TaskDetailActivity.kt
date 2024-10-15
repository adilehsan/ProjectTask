package com.example.app.ui.activity

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.app.data.Task
import com.example.app.utils.Constant
import com.example.app.utils.Utility
import com.example.mynewprojecttest.databinding.TaskDetailActivityBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TaskDetailActivity : AppCompatActivity() {

    private lateinit var binding: TaskDetailActivityBinding
    private var currentTask: Task? = null

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TaskDetailActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        currentTask = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(KEY_TASK, Task::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(KEY_TASK)
        }
        setTaskData()
        clickListeners()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun setTaskData() {
        currentTask?.let { task ->
            with(binding) {
                tvTitle.text = task.Title
                task.DueDate?.let { dueDate ->
                    tvDateValue.text = Utility.getNewDate(dueDate, Constant.DATE_FORMATOR_1, Constant.DATE_FORMATOR_2)
                    tvDaysLeftValue.text =
                        Utility.calculateDaysBetweenDates(task.TargetDate, dueDate, Constant.DATE_FORMATOR_1)
                            .toString()
                }
                tvDescription.text = task.Description

            }
        }
    }

    private fun clickListeners() {
        binding.ivBack.setOnClickListener {
            finish()
        }
    }
}