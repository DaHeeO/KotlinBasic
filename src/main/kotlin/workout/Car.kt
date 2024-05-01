package org.example.workout

class Car constructor(private val carName: String, private val mileage: Double, private val price: Int){

	fun getName(): String{
		return this.carName;
	}

	fun getMileage(): Double{
		return this.mileage;
	}

	fun getPrice(): Int{
		return this.price;
	}

	fun mileage(charge: Int): Double {
		return charge * mileage
	}

	fun comparator(A: Car) {
		if(this.mileage > A.mileage) {
			println("${this.carName}의 연비가 ${A.carName}의 연비보다 ${this.mileage-A.mileage}km/L 더 좋습니다.")
		}
		else {
			println("${A.carName}의 연비가 ${this.carName}의 연비보다 ${A.mileage-this.mileage}km/L 더 좋습니다.")
		}
	}

	fun numberOfCarByPrice(totalPrice: Int): Int{
		return totalPrice/this.price
	}
}
