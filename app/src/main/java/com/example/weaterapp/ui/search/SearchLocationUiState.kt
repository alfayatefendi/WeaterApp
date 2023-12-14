package com.example.weaterapp.ui.search

import com.example.weaterapp.domain.model.location.LocationData
import com.example.weaterapp.domain.model.location.RecentLocation

data class SearchLocationUiState(

    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val locationDatas: List<LocationData> = emptyList()
)

data class RecentLocationUiState(
    val isError: Boolean = false,
    val recentLocation: List<RecentLocation> = emptyList()
)