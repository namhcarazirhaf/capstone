package com.belajar.capstoneapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.belajar.capstoneap.model.Food
import com.belajar.capstoneapp.data.DiaryRepository
import com.belajar.capstoneapp.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailViewModel(
    private val repository: DiaryRepository
) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<Food>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<Food>>
        get() = _uiState

    fun getFoodById(foodId: String) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            _uiState.value = UiState.Success(repository.getFoodById(foodId))
        }
    }

    fun updateFav(id: String) {
        viewModelScope.launch {
            repository.updateFav(id)
        }
    }
}