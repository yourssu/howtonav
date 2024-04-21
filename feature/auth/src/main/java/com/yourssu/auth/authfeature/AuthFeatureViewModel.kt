package com.yourssu.auth.authfeature

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

@HiltViewModel
class AuthFeatureViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _stateFlow: MutableStateFlow<AuthFeatureState> =
        MutableStateFlow(AuthFeatureState())

    val stateFlow: StateFlow<AuthFeatureState> = _stateFlow.asStateFlow()

}