package org.example.classes

class Person {
	var name: String = "Jedi"
	var age: Int = 15
	var country: String = "South Korea"
	var height: Int = 150
	var weight: Int = 30

	fun sayHello() {
		println("HI")
	}

	fun introduce() {
		println("I'm $name and my age is $age")
	}
}
