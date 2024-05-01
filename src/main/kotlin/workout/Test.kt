package org.example.workout

fun main() {
	// hw 1. 계산기
	val calculator = Calculator(10, 4)

	println(calculator.addition())
	println(calculator.multiplication())
	println(calculator.division())
	println(calculator.remainder())
	calculator.setter(2, 0)
	println(calculator.division())

	println("---------------------------------")

	val carA = Car(carName = "소나타", mileage = 19.5, price = 3000)
	val carB = Car(carName = "제네시스", mileage = 9.5, price = 5000)
	val carC = Car(carName = "벤츠", mileage = 15.4, price = 11500)

	carC.comparator(carA);
	val gasoline = 50;
	println("${carC.getName()}에 ${gasoline}L를 넣으면 ${carC.mileage(gasoline)}km를 주행할 수 있습니다.")

	val totalPrice = 100000;
	var carList: List<Car> = listOf(carA, carB, carC)

	println("---------------------------------")
	for(car:Car in carList) {
		println("소지금 ${totalPrice}만원으로 ${car.getName()}을/를 ${car.numberOfCarByPrice(totalPrice)}대 살 수 있습니다.")
	}

}
