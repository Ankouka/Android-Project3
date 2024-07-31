package edu.msudenver.cs3013.project3

import com.squareup.moshi.Json

data class GeocodingResponse(
    @Json(name = "results") val results: List<GeocodingResult>
)

data class GeocodingResult(
    @Json(name = "formatted_address") val formattedAddress: String,
    @Json(name = "geometry") val geometry: Geometry
)

data class Geometry(
    @Json(name = "location") val location: Location
)

data class Location(
    @Json(name = "lat") val lat: Double,
    @Json(name = "lng") val lng: Double
)



