package kg.varis.taskmanagerwithmvvm.home.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import kg.varis.taskmanagerwithmvvm.databinding.ItemTaskBinding
import kg.varis.taskmanagerwithmvvm.model.TaskModel

class TaskAdapter(val deleteClick: (TaskModel) -> Unit) : Adapter<TaskAdapter.TaskViewHolder>() {

    private val arrayList = arrayListOf<TaskModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskAdapter.TaskViewHolder {
        return TaskViewHolder(
            ItemTaskBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    fun setData(tasks: TaskModel) {
        arrayList.add(tasks)
        notifyDataSetChanged()
    }


    override fun onBindViewHolder(holder: TaskAdapter.TaskViewHolder, position: Int) {
        holder.onBind(arrayList[position])
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    inner class TaskViewHolder(private val binding: ItemTaskBinding) : ViewHolder(binding.root) {
        fun onBind(model: TaskModel) {

            with(binding) {
                tvTask.text = model.title
                (model.isCompleted ?: false).also { checkbox.isChecked = it }

                checkbox.setOnClickListener {
                    val position = adapterPosition
                    if (position != RecyclerView.NO_POSITION) {
                        val task = arrayList[position]
                        deleteClick(task)
                    }
                    itemView.setOnLongClickListener {
                        deleteClick(arrayList[adapterPosition])
                        false
                    }


                }
            }
        }}}