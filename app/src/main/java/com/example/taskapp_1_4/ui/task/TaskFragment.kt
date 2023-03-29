package com.example.taskapp_1_4.ui.task

import android.os.Bundle
import android.provider.SyncStateContract.Helpers.update
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.example.taskapp_1_4.App
import com.example.taskapp_1_4.R
import com.example.taskapp_1_4.databinding.FragmentTaskBinding
import com.example.taskapp_1_4.model.Task

class TaskFragment : Fragment() {
    private lateinit var binding: FragmentTaskBinding
    private var task: Task? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSave.setOnClickListener {
            if (binding.etTitle.text.isNotEmpty()) {
                save()
            } else binding.etTitle.error = "Это поле обязательно для заполнения "

        }
        }
//        if (task == null) {
//            binding.btnSave.text = getString(R.string.save)
//        } else {
//            binding.etTitle.setText(task?.title.toString())
//            binding.etDesc.setText(task?.desc.toString())
//            binding.btnSave.text = "UPDATE"
//        }
//        binding.btnSave.setOnClickListener {
//            if (task == null) {
//                save()
//
//            } else {
//                update()
//
//            }
//        }
//    }

    private fun save() {
        val data =
            Task(title = binding.etTitle.text.toString(), desc = binding.etDesc.text.toString())
        //     setFragmentResult(TASK_REQUEST, bundleOf(TASK_KEY to data))
        App.db.taskDao().insert(data)
        findNavController().navigateUp()
    }
//    private fun update() {
//        task?.title = binding.etTitle.text.toString()
//        task?.desc = binding.etDesc.text.toString()
//        task?.let { App.db.taskDao().update(it) }
//        findNavController().navigateUp()
//    }



    companion object {
        const val TASK_REQUEST = "task"
        const val TASK_KEY = "task_key"
    }
}
