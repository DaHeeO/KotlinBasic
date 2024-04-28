package org.example.loop

class ForSample {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            for(i in 1..5) println(i)
            println()
            // in a..b 는 b 가 a 보다 큼을 보장해야함
            // 즉 i-- 를 쓰고 싶을 때에는 downTo를 써주자
            for(i in 5 downTo 1) println(i)
            println()
            for(i in 1..5 step 2) println(i)
        }
    }
}