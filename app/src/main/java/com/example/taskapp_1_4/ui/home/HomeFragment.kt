package com.example.taskapp_1_4.ui.home

import TaskAdapter
import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.taskapp_1_4.App
import com.example.taskapp_1_4.R
import com.example.taskapp_1_4.databinding.FragmentHomeBinding
import com.example.taskapp_1_4.ext.showToast
import com.example.taskapp_1_4.model.Task
import com.example.taskapp_1_4.ui.task.TaskFragment.Companion.TASK_KEY
import com.example.taskapp_1_4.ui.task.TaskFragment.Companion.TASK_REQUEST

class HomeFragment : Fragment(),TaskAdapter.Listener {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val adapter = TaskAdapter(this)
    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        val data = App.db.taskDao().getAll()
        adapter.addTasks(data)
        binding.recyclerView.adapter = adapter
        binding.fab.setOnClickListener {

            findNavController().navigate(R.id.taskFragment)

        }
    }

    private fun showAlert(task: Task) {
        AlertDialog.Builder(context).setTitle("Are you want to delete ${task.title}?")
            .setMessage("Are you sure you want to delete it?")
            .setNegativeButton("NO") { dialog, which ->

            }.setPositiveButton("YES") { dialog, which ->
                App.db.taskDao().delete(task)
                adapter.onTaskDelete(task)
            }

            .show()
    }

    companion object {
        const val KEY_FOR_TASK = "task"
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null

    }

    override fun onTaskDeleteClickListener(task: Task, position: Int) {
        showAlert(task)

    }

    override fun onClick(task: Task) {

    }
}


