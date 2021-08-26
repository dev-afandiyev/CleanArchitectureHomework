package com.example.cleanarchitecturehomework.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarchitecturehomework.R
import com.example.cleanarchitecturehomework.viewmodel.MainViewModel

class MainFragment : Fragment() {

    private lateinit var button: Button
    private lateinit var userCreateFragment: UserCreateFragment
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: UsersAdapter
    private lateinit var usersViewModel: MainViewModel

    @SuppressLint("FragmentLiveDataObserve")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        recyclerView = view.findViewById(R.id.rv_users)
        adapter = UsersAdapter()
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

        usersViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        usersViewModel.getAllUsers().observe(this) {
                adapter.setList(it)
        }

        button = view.findViewById(R.id.bt_open_book_dialog)
        button.setOnClickListener {
            userCreateFragment = UserCreateFragment()
            userCreateFragment?.show(requireFragmentManager(), null)
        }

        return view
    }

}