package com.example.listatareas

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.listatareas.database.TaskEntry
import kotlinx.android.synthetic.main.task_layout.view.*
import java.text.SimpleDateFormat
import java.util.*

class TaskAdapter(private var mTaskEntries:List<TaskEntry>,private val mContext:Context, private val clickListener: (TaskEntry)->Unit):RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskAdapter.TaskViewHolder {

        val layoutInflater = LayoutInflater.from(mContext)
        return TaskViewHolder(layoutInflater.inflate(R.layout.task_layout,parent,false))
    }

    override fun getItemCount(): Int = mTaskEntries.size


    override fun onBindViewHolder(holder: TaskAdapter.TaskViewHolder, position: Int) {
        holder.bind(mTaskEntries[position], mContext, clickListener)
    }

    fun setTask(taskEntries:List<TaskEntry>){
        mTaskEntries = taskEntries
        notifyDataSetChanged()
    }

    fun getTask():List<TaskEntry> = mTaskEntries

    class TaskViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(task:TaskEntry, context: Context,clickListener: (TaskEntry) -> Unit){
            itemView.taskDescription.text = task.description
            itemView.taskUpdatedAt.text = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(task.updateAt).toString()
            itemView.priorityTextView.text = task.priority.toString()
            val priorityCircle = itemView.priorityTextView.background as GradientDrawable
            val priorityColor = getPriorityColor(task.priority,context)
            priorityCircle.setColor(priorityColor)
            itemView.setOnClickListener{
                clickListener(task)
            }

        }

        private fun getPriorityColor(priority: Int, context: Context): Int {
            var priorityColor = 0
            when( priority){
                1 -> ContextCompat.getColor(context, R.color.materialRed)
                2 -> ContextCompat.getColor(context, R.color.materialOrange)
                3 -> ContextCompat.getColor(context, R.color.materialYellow)
                else -> {

                }
            }
            return priorityColor;
        }
    }
}