package kg.varis.taskmanagerwithmvvm.home

import android.app.AlertDialog
import kg.varis.taskmanagerwithmvvm.BaseFragment
import kg.varis.taskmanagerwithmvvm.R
import kg.varis.taskmanagerwithmvvm.databinding.FragmentHomeBinding
import kg.varis.taskmanagerwithmvvm.home.adapter.TaskAdapter
import kg.varis.taskmanagerwithmvvm.model.TaskModel
import kg.varis.taskmanagerwithmvvm.task.TaskFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private val adapter by lazy { TaskAdapter(this::deleteClick) }

    override fun inflateViewBinding(): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(layoutInflater)
    }

    private fun deleteClick(task: TaskModel) {
        AlertDialog.Builder(requireContext())
            .setTitle("Delete Item")
            .setMessage("Are you sure you want to delete this item?")
            .setPositiveButton("Delete") { _, _ ->
                viewModel.deleteTask(task)
            }
            .setNegativeButton("Cancel", null)
            .show()
    }


    override fun initView() {
        binding.recyclerView.adapter = adapter
        binding.btnAddTasks.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.container, TaskFragment()).commit()
        }
        viewModel.list.observe(requireActivity()) {
            adapter.addData(it)
            binding.recyclerView.adapter = adapter
        }

    }
}