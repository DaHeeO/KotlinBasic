package org.example.workout

class Calculator constructor(private var a: Int, private var b: Int) {

	fun setter(a: Int, b:Int) {
		this.b = b;
		this.a = a;
	}

	fun addition(): String {
		return "${a}와 ${b}의 합은 ${a+b}입니다"
	}

	fun multiplication(): String {
		return "${a}와 ${b}의 곱은 ${a*b} 입니다"
	}

	fun division(): String {
		if(b == 0) {
			return "계산할 수 없습니다."
		}
		return "${a}를 ${b}로 나눈 몫은 ${a/b}입니다"
	}

	fun remainder(): String {
		return "${a}를 ${b}로 나눈 나머지는 ${a%b}입니다"
	}
}
