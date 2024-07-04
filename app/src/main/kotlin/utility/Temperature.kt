package hu.vanio.kotlin.hazifeladat.ms.utility

import hu.vanio.kotlin.hazifeladat.ms.model.TimeWithTemperature
import java.util.*

object Temperature {

    fun dailyAverageTemperature(selectedDate: Date, dataList: List<TimeWithTemperature>): Double? {
        if (dataList.isEmpty()) {
            return null
        }
        val list = dataList.filter { it.time.isSameDay(selectedDate) }.map { it.temperature }
        return (list.min() + list.max()) / 2
    }
}