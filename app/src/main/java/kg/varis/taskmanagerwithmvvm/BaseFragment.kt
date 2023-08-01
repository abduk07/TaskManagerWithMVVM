package kg.varis.taskmanagerwithmvvm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import kg.varis.taskmanagerwithmvvm.home.ViewModels

abstract class BaseFragment<VB : ViewBinding>(layout: Int) : Fragment(layout) {

    lateinit var binding: VB

    abstract fun inflateViewBinding(): VB

    lateinit var viewModel: ViewModels

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = inflateViewBinding()
        viewModel = ViewModelProvider(requireActivity())[ViewModels::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    abstract fun initView()
}