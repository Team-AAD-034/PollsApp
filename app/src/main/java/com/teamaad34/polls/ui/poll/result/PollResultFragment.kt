package com.teamaad34.polls.ui.poll.result

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.teamaad34.polls.databinding.PollResultFragmentBinding
import com.xently.xui.Fragment
import com.xently.xui.utils.ui.fragment.setupToolbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PollResultFragment : Fragment() {

    private val viewModel: PollResultViewModel by viewModels()
    private var _binding: PollResultFragmentBinding? = null
    private val binding: PollResultFragmentBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = PollResultFragmentBinding.inflate(inflater, container, false).apply {
            setupToolbar(toolbar)
        }
        return binding.root
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}