package org.example.operator

import kotlin.random.Random

class ComparisonOperator {
	companion object {
		@JvmStatic
		fun main(args: Array<String>) {
			val a = Random.nextInt(10) // range 0 ~ 9 any number may assigned in a
			val b = Random.nextInt(10)
			println("a : $a")
			println("b : $b")

			println(a > b)
			println(a >= b)
			println(a < b)
			println(a <= b)
			println(a == b)
			println(a != b)
		}
	}
}
