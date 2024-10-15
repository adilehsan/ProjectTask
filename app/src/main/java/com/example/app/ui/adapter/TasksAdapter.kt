package com.example.app.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.app.data.Task
import com.example.app.utils.Constant
import com.example.app.utils.Utility
import com.example.mynewprojecttest.databinding.ItemTasksBinding

class TasksAdapter(val context: Context, val itemClickListener: TaskAdapterItemClickListener) :
    RecyclerView.Adapter<TasksAdapter.TasksViewHolder>() {

    private var taskList: List<Task>? = null

    @SuppressLint("NotifyDataSetChanged")
    fun setData(list: List<Task>?) {
        taskList = list
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TasksViewHolder {
        val itemBinding =
            ItemTasksBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return TasksViewHolder(itemBinding)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: TasksViewHolder, position: Int) {
        taskList?.let { list ->
            val currentTask = list[position]
            currentTask.let {
                holder.setData(currentTask)
            }
            holder.itemView.rootView.setOnClickListener {
                itemClickListener.onItemClicked(position,currentTask)
            }
        }

    }

    override fun getItemCount(): Int {
        return taskList?.size ?: 0
    }

    class TasksViewHolder(private val itemViewBinding: ItemTasksBinding) :
        RecyclerView.ViewHolder(itemViewBinding.root) {

        @RequiresApi(Build.VERSION_CODES.O)
        fun setData(task: Task) {
            with(itemViewBinding) {
                tvTitle.text = task.Title
                task.DueDate?.let { dueDate ->
                    tvDateValue.text = Utility.getNewDate(dueDate, Constant.DATE_FORMATOR_1, Constant.DATE_FORMATOR_2)
                    tvDaysLeftValue.text = Utility.calculateDaysBetweenDates(task.TargetDate,dueDate,Constant.DATE_FORMATOR_1).toString()
                }


            }
        }
    }

}

interface TaskAdapterItemClickListener {
    fun onItemClicked(position: Int, task: Task)
}