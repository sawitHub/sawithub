package com.example.sawithub.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sawithub.R
import com.example.sawithub.databinding.FragmentHomeBinding
import com.example.sawithub.entity.Artikel
import com.smarteist.autoimageslider.SliderView

class HomeFragment : Fragment() {

    lateinit var imageUrlSource: ArrayList<Int>
    lateinit var sliderBannerView: SliderView
    lateinit var bannerSliderAdapter: BannerSliderAdapter
    private lateinit var rvTipsTrikAdapter: RecyclerView
    private lateinit var rvArtikelBacaanAdapter: RecyclerView
    private var _binding: FragmentHomeBinding? = null
    private val list = ArrayList<Artikel>()
    private val listArtikel = ArrayList<Artikel>()
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        rvTipsTrikAdapter = binding.itemBacaanData
        rvTipsTrikAdapter.setHasFixedSize(true)

        rvArtikelBacaanAdapter = binding.itemArtikelData
        rvArtikelBacaanAdapter.setHasFixedSize(true)

        list.addAll(getListTipsTrik())
        showRecyclerListTipsTrik()

        listArtikel.addAll(getListArtikel())
        showRecyclerListArtikel()

        bannerSlider()
        return root
    }

    private fun getListTipsTrik(): ArrayList<Artikel>  {
        val dataName = resources.getStringArray(R.array.name_artikel)
        val dataImgUrl = resources.getStringArray(R.array.img_artikel)
        val dataLinkUrl = resources.getStringArray(R.array.url_artikel)
        val listArtikel = ArrayList<Artikel>()
        for (i in dataName.indices) {
            val hero = Artikel(dataName[i], dataImgUrl[i], dataLinkUrl[i])
            listArtikel.add(hero)
        }
        return listArtikel
    }

    private fun getListArtikel(): java.util.ArrayList<Artikel> {
        val dataName = resources.getStringArray(R.array.name_artikel)
        val dataImgUrl = resources.getStringArray(R.array.img_artikel)
        val dataLinkUrl = resources.getStringArray(R.array.url_artikel)
        val listArtikel = ArrayList<Artikel>()
        for (i in dataName.indices) {
            val hero = Artikel(dataName[i], dataImgUrl[i], dataLinkUrl[i])
            listArtikel.add(hero)
        }
        return listArtikel
    }

    private fun showRecyclerListTipsTrik() {
        rvTipsTrikAdapter.layoutManager = LinearLayoutManager(context,  LinearLayoutManager.HORIZONTAL, false)
        val listTipsTrikAdapter = TipsTrikAdapter(list)
        rvTipsTrikAdapter.adapter = listTipsTrikAdapter
    }

    private fun showRecyclerListArtikel() {
        rvTipsTrikAdapter.layoutManager = LinearLayoutManager(context,  LinearLayoutManager.HORIZONTAL, false)
        val listArtikelAdapter = ArtikelBacaanAdapter(listArtikel)
        rvTipsTrikAdapter.adapter = listArtikelAdapter
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