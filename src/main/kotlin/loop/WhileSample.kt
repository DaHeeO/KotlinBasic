package org.example.loop

import kotlin.random.Random

class WhileSample {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            var a = Random.nextInt(10)

            while(a > 0) {
                if(a%2 == 0) {
                    println("$a is even")
                    a--
                    continue
                } else {
                    println(a)
                    a--
                }
            }

            println(a)

            // 3의 배수에서 break -> while 문 중단
            var b = Random.nextInt(10)
            do {
                println(b)
                if(b % 3 == 0) {
                    println("break Point")
                    break
                }
                b--
            } while(b > 0)
        }
    }
}