package com.samanmadar.myapplication.feature_todolist.presentation.screen_add_task

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.samanmadar.myapplication.R
import com.samanmadar.myapplication.databinding.FragmentAddTaskBinding
import com.samanmadar.myapplication.databinding.FragmentShowTasksBinding


class AddTaskFragment : Fragment() {

    private lateinit var binding: FragmentAddTaskBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddTaskBinding.inflate(inflater)
        return binding.root
    }

}