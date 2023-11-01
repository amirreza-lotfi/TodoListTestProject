package com.samanmadar.myapplication.feature_todolist.presentation.screen_show_tasks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.samanmadar.myapplication.R
import com.samanmadar.myapplication.databinding.FragmentShowTasksBinding


class ShowTasksFragment : Fragment() {
    private lateinit var binding:FragmentShowTasksBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShowTasksBinding.inflate(inflater)
        return binding.root
    }

}