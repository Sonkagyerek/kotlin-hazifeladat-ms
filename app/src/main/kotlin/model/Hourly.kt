package model


import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

data class Hourly(
    @JsonProperty("temperature_2m") val temperature2m: List<Double>,
    @JsonProperty("time") @field:JsonFormat(pattern = "yyyy-MM-dd'T'hh:mm") val time: List<Date>
)