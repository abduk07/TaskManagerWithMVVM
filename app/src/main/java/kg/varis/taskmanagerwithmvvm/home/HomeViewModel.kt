package kg.varis.taskmanagerwithmvvm.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kg.varis.taskmanagerwithmvvm.model.TaskModel

class HomeViewModel : ViewModel() {

    var list = MutableLiveData<ArrayList<TaskModel>>()
    private var taskList = arrayListOf<TaskModel>()

    fun addData(task: TaskModel) {
        taskList.add(task)
        list.postValue(taskList)
    }
}