package edu.msudenver.cs3013.project3

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class SharedViewModel(application: Application) : AndroidViewModel(application) {
    private val _searchQuery = MutableLiveData<String>()
    val searchQuery: LiveData<String> get() = _searchQuery

    private val _searchResultsCount = MutableLiveData<Int>(0)
    val searchResultsCount: LiveData<Int> get() = _searchResultsCount

    private val sharedPreferences = application.getSharedPreferences("app_prefs", Application.MODE_PRIVATE)

    private val _geocodingResults = MutableLiveData<List<GeocodingResult>>()
    val geocodingResults: LiveData<List<GeocodingResult>> get() = _geocodingResults

    init {
        // Load the saved search query
        _searchQuery.value = sharedPreferences.getString("search_query", "") ?: ""
    }

    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
        // Save the search query
        sharedPreferences.edit().putString("search_query", query).apply()
    }

    init {
        // Load the saved search query
        _searchQuery.value = sharedPreferences.getString("search_query", "") ?: ""
    }
}
