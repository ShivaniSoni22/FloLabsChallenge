package com.example.feature1

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.data.SignInService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FeatureViewModel @Inject constructor(
    private val stateHandle: SavedStateHandle,
    private val service: SignInService
) : ViewModel() {


}