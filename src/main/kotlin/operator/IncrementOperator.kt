package org.example.operator

class IncrementOperator {
	companion object {
		@JvmStatic
		fun main(args: Array<String>) {
			var a = 5
			val b = a++
			val c = a
			val d = ++a

			println(a) // 7
			// since a is used in a, b, c, d so the latest result will be seen in a. then a is 7
			println(b) // 5
			println(c) // 6
			println(d) // 7

			var e = 5
			// if i declare e as val(value) then it would be not changeable
			// at first Kotlin recommend "Variable never modified and can be declared immutable using val"
			// it doesn't mean that Variable is not modified it means in your code variable is never modified
			// that means variable never changed in your code so i suggest that you can be use val for your code
			println(e) // 5
			println(e++) // 5
			println(++e) // 7
			println(e) // 7
			println(e--) // 7
			println(--e) // 5
		}
	}
}
