package subtask5

import java.lang.StringBuilder
import java.time.LocalDate
import kotlin.reflect.KClass

class Blocks {

    // TODO: Complete the following function
    fun getData(blockA: Array<Any>, blockB: KClass<*>): Any {
        if (blockB == String::class) {
            var builder: StringBuilder = StringBuilder()
            for (temp in blockA) {
                if (temp is String)
                    builder.append(temp)
            }
            return builder.toString()
        }
        if (blockB == Int::class) {
            var result: Int = 0
            for (temp in blockA) {
                if (temp is Int)
                    result += temp
            }
            return result
        }
        var result =  LocalDate.MIN
        for (temp in blockA) {
            if (temp is LocalDate) {
                if (temp > result)
                    result = temp
            }
        }
        return result.dayOfMonth.toString()+"."+result.monthValue.toString()+"."+
                result.year.toString()
    }
}
