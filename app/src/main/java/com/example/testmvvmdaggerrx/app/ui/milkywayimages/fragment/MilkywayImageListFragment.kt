package com.example.testmvvmdaggerrx.app.ui.milkywayimages.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.testmvvmdaggerrx.R
import com.example.testmvvmdaggerrx.app.DataLoadingState
import com.example.testmvvmdaggerrx.app.DataLoadingState.*
import com.example.testmvvmdaggerrx.app.injection.component.DaggerNetworkComponent
import com.example.testmvvmdaggerrx.app.injection.module.NetworkModule
import com.example.testmvvmdaggerrx.app.ui.milkywayimages.adapter.MilkywayImageAdapter
import com.example.testmvvmdaggerrx.app.viewmodel.MilkywayImageListViewModel
import com.example.testmvvmdaggerrx.app.viewmodel.factory.MilkywayImagesListViewModelFactory
import com.example.testmvvmdaggerrx.core.model.MilkywayImage
import com.example.testmvvmdaggerrx.data.repository.NasaImagesRepository
import kotlinx.android.synthetic.main.image_list_view.*
import javax.inject.Inject

class MilkywayImageListFragment: Fragment(), MilkywayImageAdapter.Listener, SwipeRefreshLayout.OnRefreshListener {

    interface Listener {
        fun onItemClicked(milkywayImage: MilkywayImage)
    }

    companion object{
        const val KEYW_WORDS = "milky way"
        const val YEAR_START = 2017
        const val YEAR_END = 2017
    }

    private val injector = DaggerNetworkComponent
        .builder()
        .networkModule(NetworkModule)
        .build()

    private var delegate: Listener? = null
    private lateinit var milkywayImageAdapter: MilkywayImageAdapter
    private lateinit var swipeRefresher : SwipeRefreshLayout

    @Inject
    lateinit var nasaRepository: NasaImagesRepository

    private val listViewModel by lazy {
        ViewModelProviders.of(this,
            MilkywayImagesListViewModelFactory(nasaRepository))
            .get(MilkywayImageListViewModel::class.java)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            delegate = context as Listener?
        } catch (e: ClassCastException) {
            throw ClassCastException("$context must implement MilkywayImageListFragment.Listener")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.image_list_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        inject()
        milkywayImageAdapter = MilkywayImageAdapter()
        milkywayImageAdapter.delegate = this
        swipeRefresher = swipeRefreshLayout
        swipeRefresher.setOnRefreshListener(this)

        listViewModel.loadMilkywayImages(KEYW_WORDS, YEAR_START, YEAR_END)
        observeViewModel(listViewModel)

        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = RecyclerView.VERTICAL
        imageRecyclerView.adapter = milkywayImageAdapter
        imageRecyclerView.layoutManager = layoutManager
    }

    private fun observeViewModel(milkywayListViewModel: MilkywayImageListViewModel){

        milkywayListViewModel.milkywayImageList.observe(this, Observer {
            milkywayImageAdapter.setItems(it)
        })

        milkywayListViewModel.dataState.observe(this, Observer {
            onDataLoadingStateChanged(it)
        })

        milkywayListViewModel.message.observe(this, Observer {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        })

    }

    private fun onDataLoadingStateChanged(dataLoadingState: DataLoadingState){
        when(dataLoadingState){
            LOADING -> swipeRefresher.isRefreshing = true
            LOADED -> swipeRefresher.isRefreshing = false
            FAILED -> swipeRefresher.isRefreshing = false
            DEFAULT -> swipeRefresher.isRefreshing = false
        }
    }

    override fun onRefresh() {
        listViewModel.loadMilkywayImages(KEYW_WORDS, YEAR_START, YEAR_END)
    }

    override fun onClickItemInList(milkywayImage: MilkywayImage) {
        delegate?.onItemClicked(milkywayImage)
    }

    private fun inject(){
        injector.inject(this)
    }
}