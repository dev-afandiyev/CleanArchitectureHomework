package com.example.cleanarchitecturehomework.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProviders
import com.example.cleanarchitecturehomework.R
import com.example.cleanarchitecturehomework.databinding.FragmentUserCreateBinding
import com.example.cleanarchitecturehomework.viewmodel.UserCreateViewModel
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserCreateFragment : BottomSheetDialogFragment(){

    private val usersViewModel: UserCreateViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (dialog as BottomSheetDialog).behavior.state = BottomSheetBehavior.STATE_EXPANDED
        val binding: FragmentUserCreateBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_user_create, container, false
        )
        val view: View = binding.root

        usersViewModel.insertUsersState.observe(this){
            binding.etUserName.setText(it.name)
            binding.etUserSurname.setText(it.surname)
        }

        binding.btAddUser.setOnClickListener {
            usersViewModel.insert(binding.etUserName.text.toString(),
                                  binding.etUserSurname.text.toString())
        }

        return view

    }

}