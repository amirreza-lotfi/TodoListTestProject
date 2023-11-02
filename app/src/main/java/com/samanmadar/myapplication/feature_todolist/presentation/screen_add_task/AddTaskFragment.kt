package com.samanmadar.myapplication.feature_todolist.presentation.screen_add_task

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.samanmadar.myapplication.R
import com.samanmadar.myapplication.databinding.FragmentAddTaskBinding
import com.samanmadar.myapplication.databinding.FragmentShowTasksBinding
import org.koin.android.ext.android.inject


class AddTaskFragment : Fragment() {

    private lateinit var binding: FragmentAddTaskBinding
    private val addTaskViewModel:AddTaskViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddTaskBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.taskDetailEt.addTextChangedListener { addTaskViewModel.setTaskDetail(it.toString()) }
        binding.taskTitleEt.addTextChangedListener { addTaskViewModel.setTaskTitle(it.toString()) }

        binding.saveButton.setOnClickListener {
            addTaskViewModel.addTask {
                findNavController().popBackStack()
            }
        }
    }


}