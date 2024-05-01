package org.example.variable

class VariableSample {
	companion object {
		@JvmStatic
		fun main(args: Array<String>) {
			val name: String = "DaheeO"
			val language = "Kotlin"
			var age = 26
			// 이건 에러 발생 val 타입이라 변경 불가
			// language = "JAVA"
			age = 27

			println("HI!! My name is $name")
			println("I'm currently studying \"$language\"")
			println("and, I'm $age year old!")
		}
	}
}
