package model


import com.fasterxml.jackson.annotation.JsonProperty

data class HourlyUnits(
    @JsonProperty("temperature_2m")
    val temperature2m: String,
    @JsonProperty("time")
    val time: String
)