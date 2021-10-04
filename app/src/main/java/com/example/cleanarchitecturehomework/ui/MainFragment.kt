package com.example.cleanarchitecturehomework.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cleanarchitecturehomework.R
import com.example.cleanarchitecturehomework.databinding.FragmentMainBinding
import com.example.cleanarchitecturehomework.viewmodel.MainViewModel
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    private lateinit var userCreateFragment: UserCreateFragment
    private lateinit var adapter: UsersAdapter
    private val usersViewModel: MainViewModel by viewModels()

    @SuppressLint("FragmentLiveDataObserve")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentMainBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_main, container, false
        )
        val view: View = binding.root

        adapter = UsersAdapter()
        binding.rvUsers.layoutManager = LinearLayoutManager(context)
        binding.rvUsers.adapter = adapter

        usersViewModel.getAllUsers()?.observe(this) {
            adapter.setList(it)
        }

        binding.btOpenBookDialog.setOnClickListener {
            userCreateFragment = UserCreateFragment()
            userCreateFragment?.show(requireFragmentManager(), null)
        }

        return view

    }

}