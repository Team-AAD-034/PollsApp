package com.teamaad34.polls.ui.poll.create

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.teamaad34.polls.databinding.PollCreateFragmentBinding
import com.xently.xui.Fragment
import com.xently.xui.utils.ui.fragment.setupToolbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PollCreateFragment : Fragment() {

    private val viewModel: PollCreateViewModel by viewModels()
    private var _binding: PollCreateFragmentBinding? = null
    private val binding: PollCreateFragmentBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = PollCreateFragmentBinding.inflate(inflater, container, false).apply {
            setupToolbar(toolbar)
        }
        return binding.root
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}