package service

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import hu.vanio.kotlin.hazifeladat.ms.rawForecastResponse
import hu.vanio.kotlin.hazifeladat.ms.service.IWeatherService
import hu.vanio.kotlin.hazifeladat.ms.utility.Temperature
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import model.ForecastResponse
import org.junit.jupiter.api.Assertions.assertEquals
import java.util.*
import kotlin.test.Test

class WeatherServiceTest {

    private val mapper = jacksonObjectMapper()

    @Test
    fun noResponse() {
        val weatherService = mockk<IWeatherService>()
        every { weatherService.getWeatherForecast() } returns null
        val result = weatherService.getWeatherForecast()
        verify { weatherService.getWeatherForecast() }
        assertEquals(null, result)
    }

    @Test
    fun successResponse() {
        val forecastResponse: ForecastResponse = mapper.readValue(rawForecastResponse)
        val weatherService = mockk<IWeatherService>()
        every { weatherService.getWeatherForecast() } returns forecastResponse
        // when
        val result = weatherService.getWeatherForecast()
        // then
        verify { weatherService.getWeatherForecast() }
        assert(result != null)
        assert(Temperature.dailyAverageTemperature(Date(), result!!.timesWithTemperatures()) != null)
    }
}

