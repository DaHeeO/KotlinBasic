package org.example.inheritance

// 부모 class 에는 open 키워드를 써준다.
open class Car(private val name: String, private val price: Double, private val brand: String) {

	fun introduce() {
		println("This car is $name. This is made by $brand.")
	}

	fun howMuch() {
		println("This car is $price dollars")
	}

	// override 할 function도 부모 클래스에서 open 키워드를 써준다
	open fun myPurchaseDate() {
		println("You don't buy yet")
	}

	open fun compare(otherCar: Car) {
		println("### Comparison between ${this.name} and ${otherCar.name} ###")

		// Price Comparison
		println("### Price ###")

		if(this.price > otherCar.price) {
			println("${this.name} is more expensive than ${otherCar.name}")
		} else {
			println("${otherCar.name} is more expensive then ${this.name}")
		}

		println(">>> ${this.name} is ${this.price} dollars")
		println(">>> ${otherCar.name} is ${otherCar.price} dollars")

		// Brand Comparison
		println("### Brand ###")
		if(this.brand == otherCar.brand) {
			println("Both of ${this.name} and ${otherCar.name} are same brand '${this.brand}'")
		} else {
			println(">>> ${this.name} is made by ${this.brand}")
			println(">>> ${otherCar.name} is made by ${this.brand}")
		}

	}

}
