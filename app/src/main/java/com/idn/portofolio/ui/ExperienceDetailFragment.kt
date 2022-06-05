package com.idn.portofolio.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import coil.load
import com.idn.portofolio.databinding.FragmentExperienceDetailBinding

class ExperienceDetailFragment : Fragment() {
    private var _binding: FragmentExperienceDetailBinding? = null
    private val binding get() = _binding!!
    private val experienceArgs by navArgs<ExperienceDetailFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentExperienceDetailBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val expData = experienceArgs.experience
        with(binding) {
            txtTitle.text = expData.title
            txtSubtitle.text = expData.detail
            imgDetailProfile.load(expData.image) {
                crossfade(2000)
            }
        }

    }
}