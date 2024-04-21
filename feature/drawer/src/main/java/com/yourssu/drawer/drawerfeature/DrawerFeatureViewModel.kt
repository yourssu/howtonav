package com.yourssu.drawer.drawerfeature

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

@HiltViewModel
class DrawerFeatureViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _stateFlow: MutableStateFlow<DrawerFeatureState> =
        MutableStateFlow(DrawerFeatureState())

    val stateFlow: StateFlow<DrawerFeatureState> = _stateFlow.asStateFlow()

}