package com.example.cleanarchitecturehomework.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProviders
import com.example.cleanarchitecturehomework.R
import com.example.cleanarchitecturehomework.viewmodel.UserCreateViewModel
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.sql.Date

class UserCreateFragment : BottomSheetDialogFragment() {

    private lateinit var etName: EditText
    private lateinit var etSurname: EditText
    private lateinit var button: Button

    private lateinit var usersViewModel: UserCreateViewModel
    private lateinit var date: Date

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (dialog as BottomSheetDialog).behavior.state = BottomSheetBehavior.STATE_EXPANDED
        val view = inflater.inflate(R.layout.fragment_user_create, container, false)

        etName = view.findViewById(R.id.et_user_name)
        etSurname = view.findViewById(R.id.et_user_surname)
        button = view.findViewById(R.id.bt_add_user)

        usersViewModel = ViewModelProviders.of(this).get(UserCreateViewModel::class.java)
        usersViewModel.insertUsersState.observe(this){
            etName.setText(it.name)
            etSurname.setText(it.surname)
        }

        button.setOnClickListener {
            usersViewModel.insert(etName.text.toString(), etSurname.text.toString())
        }

        return view
    }

}