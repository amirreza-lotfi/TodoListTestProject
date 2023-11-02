package com.samanmadar.myapplication.feature_todolist.presentation.screen_show_tasks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.samanmadar.myapplication.R
import com.samanmadar.myapplication.databinding.FragmentShowTasksBinding
import org.koin.android.ext.android.inject


class ShowTasksFragment : Fragment() {
    private lateinit var binding:FragmentShowTasksBinding
    private  val showTasksViewModel:ShowTasksViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShowTasksBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.showTaskRecyclerView.layoutManager = LinearLayoutManager(requireContext(),RecyclerView.VERTICAL,false)

        showTasksViewModel.tasks.observe(viewLifecycleOwner){
            binding.showTaskRecyclerView.adapter = TaskAdapter(it)
        }

        binding.addNewTask.setOnClickListener {
            findNavController().navigate(R.id.action_showTasksFragment_to_addTaskFragment)
        }


    }

    override fun onStart() {
        super.onStart()
        showTasksViewModel.getTasks()
    }

}