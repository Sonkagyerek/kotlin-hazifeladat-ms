package model


import com.fasterxml.jackson.annotation.JsonProperty
import hu.vanio.kotlin.hazifeladat.ms.model.TimeWithTemperature

data class ForecastResponse(
    @JsonProperty("elevation") val elevation: Double,
    @JsonProperty("generationtime_ms") val generationtimeMs: Double,
    @JsonProperty("hourly") val hourly: Hourly,
    @JsonProperty("hourly_units") val hourlyUnits: HourlyUnits,
    @JsonProperty("latitude") val latitude: Double,
    @JsonProperty("longitude") val longitude: Double,
    @JsonProperty("timezone") val timezone: String,
    @JsonProperty("timezone_abbreviation") val timezoneAbbreviation: String,
    @JsonProperty("utc_offset_seconds") val utcOffsetSeconds: Int
) {
    fun timesWithTemperatures(): List<TimeWithTemperature> = hourly.time.mapIndexed { index, date ->
        TimeWithTemperature(date, hourly.temperature2m[index])
    }
}