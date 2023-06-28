package com.elhacene.pixwall.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.elhacene.pixwall.R
import com.elhacene.pixwall.ui.adapters.PhotoAdapter


class NewFragment : Fragment() {

    companion object {
        fun newInstance() = NewFragment()
    }

    private lateinit var viewModel: NewViewModel
    private val photos: ArrayList<String> = ArrayList<String>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView =  inflater.inflate(R.layout.fragment_new, container, false)

        // getting the recyclerview by its id
        for (i in 0..25) {
            println(i);
            Log.e("error","https://picsum.photos/5000/3333")
            photos.add("https://picsum.photos/5000/3333")
        }
        Log.e("Error","onCreateView")

        val recyclerview = rootView.findViewById<RecyclerView>(R.id.recyclerView)

        val gridLayoutManager = GridLayoutManager(activity, 2)
        recyclerview.layoutManager = gridLayoutManager
        val adapter = PhotoAdapter(photos)
        recyclerview.adapter = adapter

        return rootView;
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(NewViewModel::class.java)
        // TODO: Use the ViewModel
    }

}