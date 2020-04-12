package subtask3

class Abbreviation {

    // TODO: Complete the following function
    fun abbreviationFromA(a: String, b: String): String {
        var index = 0
        var indexA = 0;
        while (index < b.length && indexA < a.length) {
            val character = a[indexA]
            if (b[index] == character) {
                indexA++;
                index++;
                continue
            }
            if (character.toString().toUpperCase() == b[index].toString()) {
                indexA++;
                index++;
                continue;
            }
            if (character.toInt() < 'a'.toInt())
                return "NO"
            indexA++;
        }
        if (index < b.length)
            return "NO"
        if (indexA < a.length) {
            while (indexA < a.length) {
                if (a[indexA].toInt() < 'a'.toInt())
                    return "NO"
                indexA++
            }
        }
        return "YES"
    }
}
