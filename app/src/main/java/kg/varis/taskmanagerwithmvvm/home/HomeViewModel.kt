package kg.varis.taskmanagerwithmvvm.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kg.varis.taskmanagerwithmvvm.model.TaskModel

class ViewModels: ViewModel() {

    private val _list = MutableLiveData<MutableList<TaskModel>>()
    val list: LiveData<MutableList<TaskModel>>
        get() = _list
    val listTask = mutableListOf<TaskModel>()

    fun addTask(lists: TaskModel) {
        listTask.add(lists)
        _list.value = listTask
    }

    fun deleteTask(task: TaskModel) {
        listTask.remove(task)
        _list.value = listTask
    }
}