package kg.varis.taskmanagerwithmvvm.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import kg.varis.taskmanagerwithmvvm.R
import kg.varis.taskmanagerwithmvvm.databinding.FragmentHomeBinding
import kg.varis.taskmanagerwithmvvm.home.adapter.TaskAdapter
import kg.varis.taskmanagerwithmvvm.model.TaskModel

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: TaskAdapter
    private lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = TaskAdapter(this::deleteClick)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity())[HomeViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.list.observe(viewLifecycleOwner) {
            adapter.setData(it as TaskModel)
            addAdapter()
        }
        binding.btnAddTasks.setOnClickListener {
            findNavController().navigate(R.id.navigate_to_task_fragment)
        }
    }


    private fun addAdapter() {
        binding.recyclerView.adapter = adapter
    }

    private fun deleteClick(taskModel: TaskModel) {

    }


}