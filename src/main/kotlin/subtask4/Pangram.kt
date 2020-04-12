package subtask4

import java.lang.StringBuilder


class Pair(wordTemp:String,isPangram:Boolean):Comparable<Pair>{
       public var countOfImportantLetters:Int
       public var word:String
       init {
           if(isPangram)
                countOfImportantLetters = Counter.getNumbOfVowels(wordTemp)
           else
               countOfImportantLetters = Counter.getNumbOfConsonants(wordTemp)
           word = countOfImportantLetters.toString() + wordTemp
           word = upgradeLine(word,isPangram)
       }

    override fun compareTo(other: Pair): Int {
        return countOfImportantLetters.compareTo(other.countOfImportantLetters)
    }

    fun upgradeLine(word:String,isPangram:Boolean): String{
        var temp:String = word
        if(isPangram)
        {
            for(i in 0..Counter.baseLowVowels.length-1)
                temp = temp.replace(Counter.baseLowVowels[i],Counter.baseUpVowels[i])
        }
        else
        {
            for(i in 0..Counter.base.length-1)
                temp = temp.replace(Counter.base[i],Counter.baseUp[i])
        }
        return temp
    }
}


class Counter{
    companion object{
        public const val base:String = "qwrtpsdfghjklzxcvbnm"
        public const val baseUp:String = "QWRTPSDFGHJKLZXCVBNM"
        public const val baseLowVowels:String = "eaouiy"
        public const val baseUpVowels:String = "EAOUIY"
        public const val lowAlphabet = "abcdefghijklmnopqrstuvwxyz"
        public const val upAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

        fun getNumbOfVowels(str: String): Int {
            var numb = 0
            for(letter in str){
                if(baseUpVowels.contains(letter)|| baseLowVowels.contains(letter))
                    numb++;
            }
            return numb
        }

        fun getNumbOfConsonants(str: String): Int {
            var numb = 0
            for(letter in str){
                if(base.contains(letter)||baseUp.contains(letter))
                    numb++;
            }
            return numb
        }
    }
}

class Pangram {

    // TODO: Complete the following function
    fun getResult(inputString: String): String {
       var flags = BooleanArray(26){false}
        for(character in inputString){
            if(character == ' ')
                continue;
            if(Counter.lowAlphabet.contains(character))
                flags[character.toInt()-'a'.toInt()] = true
            if(Counter.upAlphabet.contains(character))
                flags[character.toInt()-'A'.toInt()] = true
        }
        var isPangram = true

        for(flag in flags){
            if(!flag)
            {
                isPangram = false
                break
            }
        }

        val arrayOfWords = inputString.split(" ")

        var listOfPairs:ArrayList<Pair> = ArrayList()
        for(word in arrayOfWords)
            if(word!="" && word!="\n")
                listOfPairs.add(Pair(word,isPangram))
        listOfPairs.sort()
        var builder = StringBuilder()
        for(pair in listOfPairs)
            builder.append(" "+pair.word)
        var result = builder.toString()
        if(result.length>1)
            result = result.substring(1,result.length)
        else
            result = ""
        return result
    }
}
