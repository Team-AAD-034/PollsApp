package com.teamaad34.polls.ui.poll.vote

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.teamaad34.polls.databinding.PollVoteFragmentBinding
import com.xently.xui.Fragment
import com.xently.xui.utils.ui.fragment.setupToolbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PollVoteFragment : Fragment() {

    private val viewModel: PollVoteViewModel by viewModels()
    private var _binding: PollVoteFragmentBinding? = null
    private val binding: PollVoteFragmentBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = PollVoteFragmentBinding.inflate(inflater, container, false).apply {
            setupToolbar(toolbar)
        }
        return binding.root
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}