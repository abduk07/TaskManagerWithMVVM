package kg.varis.taskmanagerwithmvvm.model

data class TaskModel(
    val title: String? = null,
    var isCompleted: Boolean? = null
) : java.io.Serializable
