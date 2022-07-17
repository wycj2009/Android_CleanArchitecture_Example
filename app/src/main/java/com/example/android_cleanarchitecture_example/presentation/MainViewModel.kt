package com.example.android_cleanarchitecture_example.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_cleanarchitecture_example.domain.model.User
import com.example.android_cleanarchitecture_example.domain.usecase.DeleteAllUsersUseCase
import com.example.android_cleanarchitecture_example.domain.usecase.GetAllUsersFlowUseCase
import com.example.android_cleanarchitecture_example.domain.usecase.InsertUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    getAllUsersFlowUseCase: GetAllUsersFlowUseCase,
    private val insertUserUseCase: InsertUserUseCase,
    private val deleteAllUsersUseCase: DeleteAllUsersUseCase
) : ViewModel() {

    val allUsersFlow: Flow<List<User>> = getAllUsersFlowUseCase()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    fun insertUser(name: String) {
        viewModelScope.launch {
            insertUserUseCase(
                User(name = name)
            )
        }
    }

    fun deleteAllUsers() {
        viewModelScope.launch {
            deleteAllUsersUseCase()
        }
    }
}
