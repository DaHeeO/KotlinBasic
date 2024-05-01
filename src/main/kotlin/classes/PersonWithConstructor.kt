package org.example.classes

class PersonWithConstructor constructor(private val name: String, private val age: Int) { // main constructor

	private var etc: String = "no value"

	// 생성자 호출시 초기화 함수 무조건 실행됨
	init {
		println("initialize block : $etc")
	}

	// overloading -> 같은 이름의 함수를 매개변수만 다르게 해서 사용하는 것
	// : this(...)는 오버로딩이라고 보면 된다.
	// 다시 말하면 위에 있는 main constructor를 호출하는 함수
	constructor(name: String) : this(name, 15) // sub constructor

	// 역시 마찬가지로 :this(...)로 main constructor을 호출 하고,
	// var(changeable) etc를 수정해서 print 해주는 class 이다.
	constructor(name: String, age: Int, etc: String) : this(name, age) { // additional constructor
		this.etc = etc
		println("additional constructor is called: ${this.etc}")
	}

	fun sayHello() {
		println("HI")
	}

	fun introduce() {
		println("I'm $name and my age is $age")
	}
}
