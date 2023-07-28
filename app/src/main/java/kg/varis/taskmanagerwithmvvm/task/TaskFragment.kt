package kg.varis.taskmanagerwithmvvm.task

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import kg.varis.taskmanagerwithmvvm.databinding.FragmentTaskBinding
import kg.varis.taskmanagerwithmvvm.home.HomeViewModel
import kg.varis.taskmanagerwithmvvm.model.TaskModel

class TaskFragment : Fragment() {

    private lateinit var binding: FragmentTaskBinding
    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        binding.btnSave.setOnClickListener {
            var task = TaskModel(binding.etTitle.text.toString())
            viewModel.addData(task)
            findNavController().navigateUp()
        }
    }


}