package org.example.classes

fun main() {
    val aMan = Person()
    aMan.sayHello()
    aMan.introduce()

    aMan.age = 55
    println("sorry, my real age is ${aMan.age}")

    println("------------------------")

    val main = PersonWithConstructor("main", 150)
    val sub = PersonWithConstructor("sub")
    val additional = PersonWithConstructor(name = "additional", age = 25, etc ="additional value")

    main.sayHello()
    main.introduce()
    sub.sayHello()
    sub.introduce()
    additional.sayHello()
    additional.introduce()
}