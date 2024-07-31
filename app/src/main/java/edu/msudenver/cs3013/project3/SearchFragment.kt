package edu.msudenver.cs3013.project3

import android.content.Context
import android.location.Geocoder
import android.location.Location
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import edu.msudenver.cs3013.project3.databinding.FragmentSearchBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject
import java.io.IOException

class SearchFragment : Fragment() {
    private val sharedViewModel: SharedViewModel by activityViewModels()
    private lateinit var binding2: FragmentSearchBinding
    private lateinit var mMap: GoogleMap
    private val fusedLocationProviderClient by lazy {
        LocationServices.getFusedLocationProviderClient(requireContext())
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding2 = FragmentSearchBinding.inflate(inflater, container, false)

        return binding2.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedViewModel.searchQuery.observe(viewLifecycleOwner) { query ->
            binding2.searchLocation.setText(query)
        }

        // Set up the search button to trigger a search when the user types a location and clicks the button
        view.findViewById<Button>(R.id.button2).setOnClickListener {
            val query = view.findViewById<EditText>(R.id.search_location).text.toString()
            val mapsFragment =
                parentFragmentManager.findFragmentById(R.id.activity_fragment_split_maps) as MapsFragment
            mapsFragment.triggerSearchNearby(query)
            sharedViewModel.updateSearchQuery(query)
        }
    }

    companion object {
        private const val TAG = "MapsFragment"
    }
}
