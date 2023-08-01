package kg.varis.taskmanagerwithmvvm.home.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import kg.varis.taskmanagerwithmvvm.databinding.ItemTaskBinding
import kg.varis.taskmanagerwithmvvm.model.TaskModel

class TaskAdapter(val deleteClick: (TaskModel) -> Unit) : Adapter<TaskAdapter.TaskViewHolder>() {

    var list = mutableListOf<TaskModel>()

    fun addData(lists: List<TaskModel>) {
        list.clear()
        list.addAll(lists)
        notifyItemChanged(lists.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(
            ItemTaskBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    inner class TaskViewHolder(private val binding: ItemTaskBinding) : ViewHolder(binding.root) {
        fun onBind(taskModel: TaskModel) {
            binding.tvTask.text = taskModel.title
            binding.checkbox.isChecked = taskModel.isCompleted!!

            itemView.setOnLongClickListener {
                deleteClick(list[adapterPosition])
                false
            }
        }
    }
}