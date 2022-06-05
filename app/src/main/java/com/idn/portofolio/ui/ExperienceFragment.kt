package com.idn.portofolio.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.idn.portofolio.adapter.RVExperienceAdapter
import com.idn.portofolio.data.PortofolioData
import com.idn.portofolio.databinding.FragmentExperienceBinding

class ExperienceFragment : Fragment() {
    private var _binding: FragmentExperienceBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentExperienceBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val expAdapter = RVExperienceAdapter()

        expAdapter.onItemClicked = {
            findNavController().navigate(
                ExperienceFragmentDirections.actionExperienceFragmentToExperienceDetailFragment(
                    it
                )
            )
        }

        expAdapter.setData(PortofolioData.listDataExperience)

        with(binding.rvExperience) {
            layoutManager = StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL)
            setHasFixedSize(true)
            adapter = expAdapter
        }

    }
}