package utility

import hu.vanio.kotlin.hazifeladat.ms.model.TimeWithTemperature
import hu.vanio.kotlin.hazifeladat.ms.utility.Temperature
import java.util.*
import kotlin.test.Test

class TemperatureTest {

    private val now = Date()
    private val temperatureCold = 10.0
    private val temperatureHot = 40.0

    @Test
    fun sameTemperatureAllDay() {
        val list = listOf(
            TimeWithTemperature(now, temperatureCold),
            TimeWithTemperature(now, temperatureCold),
            TimeWithTemperature(now, temperatureCold)
        )
        assert(Temperature.dailyAverageTemperature(now, list) == temperatureCold)
    }

    @Test
    fun differentTemperature() {
        val list = listOf(
            TimeWithTemperature(now, temperatureCold), TimeWithTemperature(now, temperatureHot)
        )
        assert(Temperature.dailyAverageTemperature(now, list) == 25.0)
    }

    @Test
    fun noResult() {
        assert(Temperature.dailyAverageTemperature(now, emptyList()) == null)
    }
}