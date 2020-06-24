package com.teamaad34.polls.ui.auth

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.teamaad34.polls.data.repository.voters.IVoterRepository

class SignInViewModel @ViewModelInject constructor(private val repository: IVoterRepository) :
    ViewModel() {
    // TODO: Implement the ViewModel
}