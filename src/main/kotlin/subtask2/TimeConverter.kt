package subtask2

class TimeConverter {
    private val base:Map<Int,String> = mapOf(1 to "one",2 to "two",3 to "three",4 to "four",5 to "five",6 to "six",7 to "seven",
        8 to "eight",9 to "nine", 10 to "ten",11 to "eleven", 12 to "twelve",13 to "thirteen", 14 to "fourteen",
        15 to "fifteen", 16 to "sixteen", 17 to "seventeen",18 to "eighteen",19 to "nineteen",20 to "twenty", 30 to "thirty")

    // TODO: Complete the following function
    fun toTextFormat(hour: String, minute: String): String {
        var intHour = hour.toInt()
        var intMinute = minute.toInt()
        if(intMinute>59||intMinute<0)
            return ""
        if(intHour<0 || intHour>23)
            return ""
        val period:String
        var minutes:String
        if(intMinute == 0)
            return getStringName(intHour)+" o' clock"
        if(intMinute>30)
            period = " to "
        else
            period = " past "
        if (period == " to ") {
            intHour++;
        }
        if(intMinute == 15 || intMinute == 45)
            minutes = "quarter"
        else
        {
            if(intMinute == 30)
                minutes = "half"
            else {
                if (period == " to ") {
                    intMinute = 60 - intMinute;
                }
                minutes = getStringName(intMinute) + " minutes";
            }
        }
        return minutes+period+getStringName(intHour)
    }

    fun getStringName(value:Int): String{
        if(value<=20) {
            if (base.containsKey(value)) {
                return base.get(value).toString()
            }
        }
        return base.get((value/10)*10)+" "+base.get(value%10)
    }
}
