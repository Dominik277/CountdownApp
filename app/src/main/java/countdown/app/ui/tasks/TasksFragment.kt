package countdown.app.ui.tasks

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import countdown.app.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TasksFragment : Fragment(R.layout.fragment_tasks) {

    private val viewModel : TasksViewModel by viewModels()

}