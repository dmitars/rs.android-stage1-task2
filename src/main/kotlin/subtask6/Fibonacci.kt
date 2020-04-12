package subtask6

class Fibonacci {

    // TODO: Complete the following function
    fun productFibonacciSequenceFor(n: Int): IntArray {
        var first:Int = 0
        var second = 1
        var third:Int = 1
        var firstTemp:Int
        var result = intArrayOf(0,0,0)
        while(second*first<n)
        {
            third = first+second
            first = second
            second = third
        }
        if(second*first == n)
            result[2] = 1
        result[0] = first
        result[1] = second
        return result
    }
}
