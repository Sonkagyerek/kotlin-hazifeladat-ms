package hu.vanio.kotlin.hazifeladat.ms

import hu.vanio.kotlin.hazifeladat.ms.service.WeatherService
import hu.vanio.kotlin.hazifeladat.ms.utility.Temperature
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.util.*

@SpringBootApplication
class WeatherApp

fun main() {
    runApplication<WeatherApp>()
    val forecast = WeatherService().getWeatherForecast()?.timesWithTemperatures()
    if (forecast != null) {
        println("Today's average daily temperature: ${Temperature.dailyAverageTemperature(Date(), forecast)} celsius degree")
    } else {
        println("No data provided")
    }
}

