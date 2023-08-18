package com.dianaldiansyah.beenews.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.dianaldiansyah.beenews.R
import com.dianaldiansyah.beenews.databinding.FragmentHomeBinding
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStreamReader

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var cardAdapter: CardAdapter

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val jsonString = readJsonFile(R.raw.sample_data)
        val cardDataList = Gson().fromJson(jsonString, Array<CardData>::class.java).toList()

        cardAdapter = CardAdapter(cardDataList)
        recyclerView.adapter = cardAdapter

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun readJsonFile(resourceId: Int): String {
        val inputStream = resources.openRawResource(resourceId)
        val reader = BufferedReader(InputStreamReader(inputStream))
        val stringBuilder = StringBuilder()
        var line: String? = reader.readLine()
        while (line != null) {
            stringBuilder.append(line)
            line = reader.readLine()
        }
        reader.close()
        return stringBuilder.toString()
    }
}
