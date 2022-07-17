package com.example.android_cleanarchitecture_example.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.android_cleanarchitecture_example.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    viewModel.allUsersFlow.collect {
                        binding.userList.text = buildString {
                            it.forEach {
                                append(it)
                                append("\n")
                            }
                        }
                    }
                }
            }
        }
    }

    private fun initView() {
        binding.run {
            insertUser.setOnClickListener {
                viewModel.insertUser(userNameToInsert.text.toString())
            }
            deleteAllUsers.setOnClickListener {
                viewModel.deleteAllUsers()
            }
        }
    }

}
