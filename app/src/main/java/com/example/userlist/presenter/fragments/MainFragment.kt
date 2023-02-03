package com.example.userlist.presenter.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.userlist.data.Mapper
import com.example.userlist.databinding.FragmentMainBinding
import com.example.userlist.domain.models.Results
import com.example.userlist.domain.trueModels.UserModel
import com.example.userlist.domain.usecases.GetUserListUsecase
import com.example.userlist.presenter.App
import com.example.userlist.presenter.adapters.MainFragmentAdapter
import kotlinx.coroutines.*
import javax.inject.Inject

//private const val ARG_PARAM1 = "param1"
//private const val ARG_PARAM2 = "param2"

class MainFragment : Fragment() {

    //    private var param1: String? = null
//    private var param2: String? = null
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private val itemAdapter = MainFragmentAdapter()

    @Inject
    lateinit var getUserListUsecase: GetUserListUsecase

    @Inject
    lateinit var mapper: Mapper


    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as App).appComponent.inject(this@MainFragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
//        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //main code
//        getData()
        init()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun init() {
        binding.rvUsers.layoutManager = LinearLayoutManager(requireContext())
        binding.rvUsers.adapter = itemAdapter
        viewLifecycleOwner.lifecycleScope.launch {
            val items = getData().await()
            val listUsers = mutableListOf<UserModel>()
            for (i in items) {
                listUsers.add(mapper.mapDataResultToDomainUser(i))
            }
            itemAdapter.submitList(listUsers)
        }
        itemAdapter.onItemClickListener = {
            //onclick
        }
    }

    private fun getData() =
        viewLifecycleOwner.lifecycleScope.async {
            val res = getUserListUsecase.execute(10)
            Log.d("MAIN_TAG", res.toString())
            return@async res
        }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MainFragment().apply {
                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
                }
            }
    }
}