package utility

import hu.vanio.kotlin.hazifeladat.ms.utility.isSameDay
import java.util.*
import kotlin.test.Test


class DateExtensionsKtTest {

    companion object {
        private const val HOUR_IN_MILLIS = 60 * 60 * 1000
    }

    private val startOfThisDay: Date by lazy {
        val date = Date()
        val calendar = Calendar.getInstance()
        calendar.time = date
        calendar[Calendar.HOUR_OF_DAY] = 0
        calendar[Calendar.MINUTE] = 0
        calendar[Calendar.SECOND] = 0
        calendar[Calendar.MILLISECOND] = 0
        calendar.time
    }

    @Test
    fun sameDay() {
        val anHourLater = Date(startOfThisDay.time + HOUR_IN_MILLIS)
        assert(startOfThisDay.isSameDay(anHourLater))
    }

    @Test
    fun differentDay() {
        val anHourBefore = Date(startOfThisDay.time - HOUR_IN_MILLIS)
        assert(!startOfThisDay.isSameDay(anHourBefore))
    }

}