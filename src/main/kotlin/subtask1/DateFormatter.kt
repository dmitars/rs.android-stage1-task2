package subtask1

import java.text.SimpleDateFormat
import java.util.*

class DateFormatter {
    val DaysOfWeek = arrayOf("понедельник","вторник","среда","четверг","пятница","суббота",
        "воскресенье")
    val Months = arrayOf("января","февраля","марта","апреля","мая","июня","июля","августа",
        "сентября","октября","ноября","декабря")

    // TODO: Complete the following function
    fun toTextDay(day: String, month: String, year: String): String {
        val calendar: Calendar = Calendar.getInstance()
        val sdf = SimpleDateFormat("dd.MM.yyyy")
        var finalDate: String
        if(day.length == 1)
            finalDate = "0$day."
        else
            finalDate = "$day."
        if(month.length == 1)
            finalDate += ("0$month.")
        else
            finalDate += ("$month.")
        finalDate+=year
        val date = try {
            sdf.parse(finalDate)
        }catch (e: Exception){
            return "Такого дня не существует"
        }
        val value = date.month
        if(date.month!=month.toInt()-1)
            return "Такого дня не существует"
        calendar.time = date
        return day+" "+Months[date.month]+", "+
                DaysOfWeek[(date.day-1+7)%7]
        return ""
    }
}
