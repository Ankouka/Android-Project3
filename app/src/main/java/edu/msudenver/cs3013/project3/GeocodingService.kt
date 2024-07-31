package edu.msudenver.cs3013.project3

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GeocodingService {
    @GET("maps/api/geocode/json")
    fun getGeocodingResults(
        @Query("address") address: String,
        @Query("key") apiKey: String
    ): Call<GeocodingResponse>

}
