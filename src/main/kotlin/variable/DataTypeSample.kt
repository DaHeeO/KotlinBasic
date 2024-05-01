package org.example.variable

class DataTypeSample {
	companion object {
		@JvmStatic
		fun main(args: Array<String>) {
			// Number Data Type
			val number1 = 123 // int
			val number2 = 123L // long
			val number3 = -123 // int
			val number4: Long = 123 // long
			val number5: Any = 123 // any
			val number6 = 123.456 // double
			val number7: Double = 123.456 // double
			val number8: Float = 123.456F // float

			// The floating-point literal does not conform to the expected type Float
			// val number9: Float = 123.456
			// 즉, float은 항상 명시적으로 붙여줘야한다 data type

			// Logical Data Type
			val isTrue = true // boolean
			val isFalse: Boolean = false // boolean
			var isFalse2: Any = false // any

			// Character, String Data Type
			val character = 'a' // char
			println(character)

			// 'toInt(): Int' is deprecated. Conversion of Char to Number is deprecated. Use Char.code property instead.
			println(character.toInt())
			// 위처럼 강제적으로 형변환은 비추 .code를 이용하면 ASCII code를 쉽게 확인 가능
			println(character.code)
			println(character + 1) // ascii code a+1 == b

			// The integer literal does not conform to the expected type Char
			// 처음부터 명시적으로 Char을 선언해도 Integer을 Char로 바꾸기 어렵다 이럴땐 toChar()을 쓰면 된다
			// val char1: Char = 97
			// 강제적 형변환 Int -> Char
			val char = 97.toChar()
			println(char)

			val string1 = "text" // string
			val string2: Any = "text" // any

			// The Type of isFalse2 is any so isFalse2 can be string either
			isFalse2 = "oh"
		}
	}
}
