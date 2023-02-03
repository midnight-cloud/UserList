package com.example.userlist.presenter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.userlist.presenter.fragments.MainFragment
import com.example.userlist.R
import com.example.userlist.data.network.RetrofitServices
import com.example.userlist.databinding.ActivityMainBinding
import com.example.userlist.domain.usecases.GetUserListUsecase
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    @Inject
    lateinit var retrofitServices: RetrofitServices

    @Inject
    lateinit var getUserListUsecase: GetUserListUsecase

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as App).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        if(savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add(R.id.main_fragment, MainFragment())
            }
        } else {
            supportFragmentManager.commit {
                replace(R.id.main_fragment, MainFragment())
                setReorderingAllowed(true)
            }
        }


    }
}