package kg.varis.taskmanagerwithmvvm.task

import kg.varis.taskmanagerwithmvvm.BaseFragment
import kg.varis.taskmanagerwithmvvm.R
import kg.varis.taskmanagerwithmvvm.databinding.FragmentTaskBinding
import kg.varis.taskmanagerwithmvvm.home.HomeFragment
import kg.varis.taskmanagerwithmvvm.model.TaskModel

class TaskFragment : BaseFragment<FragmentTaskBinding>(R.layout.fragment_task) {
    override fun inflateViewBinding(): FragmentTaskBinding {
        return FragmentTaskBinding.inflate(layoutInflater)
    }

    override fun initView() {
        binding.btnSave.setOnClickListener {
            val result = TaskModel(binding.etTitle.text.toString(), false)
            viewModel.addTask(result)
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.container, HomeFragment()).commit()
        }
    }

}