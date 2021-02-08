package countdown.app.ui.tasks

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import countdown.app.data.TaskDao

class TasksViewModel @ViewModelInject constructor(
        private val taskDao: TaskDao
) : ViewModel() {



}