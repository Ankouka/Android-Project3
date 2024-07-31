package edu.msudenver.cs3013.project3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import edu.msudenver.cs3013.project3.databinding.FragmentDisplayBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DisplayFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DisplayFragment : Fragment()  {
    private val sharedViewModel: SharedViewModel by activityViewModels()
    private val locationViewModel: LocationViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDisplayBinding.inflate(inflater, container, false)

        sharedViewModel.searchQuery.observe(viewLifecycleOwner) { query ->
            binding.textViewLocationName.text = query
        }

        locationViewModel.parkingLocation2.observe(viewLifecycleOwner) { locationName ->
            view?.findViewById<TextView>(R.id.textViewLocationName)?.text = locationName
        }

        return binding.root
    }




}
