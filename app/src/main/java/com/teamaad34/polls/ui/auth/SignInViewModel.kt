package com.teamaad34.polls.ui.auth

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.teamaad34.polls.data.repository.user.IUserRepository

class SignInViewModel @ViewModelInject constructor(private val repository: IUserRepository) :
    ViewModel() {
    // TODO: Implement the ViewModel
}