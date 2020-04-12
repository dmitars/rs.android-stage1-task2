package subtask6

class Fibonacci {

    // TODO: Complete the following function
    fun productFibonacciSequenceFor(n: Int): IntArray {
        var first:Int = 0
        var second = 1
        var third:Int = 0
        var firstTemp:Int
        var result = intArrayOf(0,0,0)
        while(second*third<n)
        {
            firstTemp = third
            third = first+second
            first = second
            second = firstTemp
        }
        if(second*third == n)
            result[2] = 1
        result[0] = second
        result[1] = third
        return result
    }
}
