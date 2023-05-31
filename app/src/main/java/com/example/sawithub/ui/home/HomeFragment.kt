package com.example.sawithub.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.sawithub.R
import com.example.sawithub.databinding.FragmentHomeBinding
import com.smarteist.autoimageslider.SliderView

class HomeFragment : Fragment() {

    lateinit var imageUrlSource: ArrayList<Int>
    lateinit var sliderBannerView: SliderView
    lateinit var bannerSliderAdapter: BannerSliderAdapter
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) { textView.text = it }
        bannerSlider()
        return root
    }

    private fun bannerSlider() {
        sliderBannerView = binding.bannerSlider
        imageUrlSource = ArrayList<Int>()
        imageUrlSource.add(R.drawable.banner_1)
        imageUrlSource.add(R.drawable.banner_2)
        imageUrlSource.add(R.drawable.banner_3)
        bannerSliderAdapter = BannerSliderAdapter(imageUrlSource)
        sliderBannerView.autoCycleDirection = SliderView.LAYOUT_DIRECTION_RTL
        sliderBannerView.setSliderAdapter(bannerSliderAdapter)
        sliderBannerView.scrollTimeInSec = 3
        sliderBannerView.isAutoCycle = true
        sliderBannerView.startAutoCycle()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}