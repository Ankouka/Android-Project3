package edu.msudenver.cs3013.project3

import android.app.Application
import android.location.Address
import android.location.Geocoder
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.util.Locale

class LocationViewModel(application: Application) : AndroidViewModel(application) {
    private val _parkingLocation = MutableLiveData<String>()
    val parkingLocation: LiveData<String> get() = _parkingLocation

    private val _parkingLocation2 = MutableLiveData<String>()
    val parkingLocation2: LiveData<String> get() = _parkingLocation2

    fun updateParkingLocation2(locationName: String) {
        _parkingLocation2.value = locationName
    }

    fun updateParkingLocation(latLng: String) {
        val parts = latLng.removePrefix("lat/lng: (").removeSuffix(")").split(",")
        val latitude = parts[0].toDouble()
        val longitude = parts[1].toDouble()

        val geocoder = Geocoder(getApplication(), Locale.getDefault())
        val addresses: List<Address>? = geocoder.getFromLocation(latitude, longitude, 1)
        val address = addresses?.firstOrNull()?.getAddressLine(0) ?: "Address not found"
        _parkingLocation.value = address
    }


}
