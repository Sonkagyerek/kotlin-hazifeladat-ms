package hu.vanio.kotlin.hazifeladat.ms.service

import hu.vanio.kotlin.hazifeladat.ms.Constant
import model.ForecastResponse
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.stereotype.Service
import org.springframework.web.client.RestClient
import org.springframework.web.client.body


interface IWeatherService {
    fun getWeatherForecast(): ForecastResponse?
}

@Service
class WeatherService(private val restClient: RestClient = RestClient.create()) : IWeatherService {

    companion object {
        private const val FORECAST_PATH =
            "/v1/forecast?latitude=47.4984&longitude=19.0404&hourly=temperature_2m&timezone=auto"
    }

    override fun getWeatherForecast(): ForecastResponse? {
        return restClient.get()
            .uri(Constant.BASE_URL + FORECAST_PATH)
            .accept(APPLICATION_JSON)
            .retrieve()
            .body<ForecastResponse>()
    }
}