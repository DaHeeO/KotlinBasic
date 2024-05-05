# 001 Variable and Data Type
## 변수의 선언


**코틀린에서 변수의 선언은 `val` 과 `var` 을 사용합니다.**

`val` 

- 변수를 선언할 때 지정한 값에서 더이상 변경하지 않아야 하는 경우 사용
- 즉 constant 상수를 표현할 때 사용하면 좋음
- ex) pi, e …

`var`

- 변수의 값을 바꿀 수 있어야 하는 경우 사용

변수를 선언하는 경우에는 다음과 같은 포맷으로 진행함

```kotlin
val variableName: String = "변수 선언 방법"

// DataType is Optional
val variable = "sth"

println("print value: $variable")
```

변수를 선언할 때 데이터 타입은 생략 가능하며, 값을 가지고 자료형을 자동으로 지정할 수 있습니다.
이를 **자료형 추론** 이라고 합니다.

## Data Type


코틀린은 **Reference Data Type**을 사용합니다.

Reference Data Type 은 객체(메모리)를 생성하고 **데이터를 할당**하는 방식을 의미합니다.

다만, 참조형으로 생성된 객체는 컴파일 과정에서 기본형으로 대체되어 문제 없이 사용할 수 있습니다. ( 즉 참조형 (Integer)로 생성된 객체는 compile 과정에서 (int = …) 으로 대체된다는 뜻)

데이터 타입의 최상위 클래스로는 `Any` 가 있습니다.

- **기본형 - Primitive**
    - ex) JAVA : int, double…
    - 실제값 저장 - 10, true, 1.1
- **참조형 - Reference**
    - ex) JAVA : Integer, Boolean…
    - 주소값 저장. 즉, 메모리를 생성하고 그 공간에 데이터를 저장한다. - 0 x 100 …

### 숫자형 데이터 타입 (Number)


1. **정수형 데이터 타입**
    - `Long` (64 bits), `int` (32 bits), `Short` (16 bits), `Byte` (8 bits)
    - 기본적으로 `int` 로 추론되며, 숫자 뒤에 L을 붙여주면 `Long` 타입으로 추론합니다.
    - 작은 숫자 또한 `int`로 추론되기 때문에 `Short`, `Byte`를 사용하기 위해서는 명시적으로 적어야 합니다.
2. **실수형 데이터 타입**
    - `Double` (64 bits), `Float` (32 bits)
    - 실수형은 기본적으로 `Double` 타입으로 추론됩니다.

숫자형 데이터 타입은 자리수를 구분하기 위해 언더바(_)를 사용할 수 있으며, 값에 영향을 주지 않습니다.

### 논리형 데이터 타입(Boolean)


1. **논리형 데이터 타입**
    - Boolean : `true` , `false`

### 문자, 문자열 데이터 타입(Char, String)


1. **문자 데이터 타입**
    - `Char` (16 bits)
    - 한 단어만 입력할 수 있으며, 선언할 때는 무조건 문자 값을 사용해야 합니다.
        - 16 bit → 숫자로 사용가능하다는 이야기(ASCII)

```kotlin
// 선언할 때 만큼은 문자로 하자
var a: Char = 'x' // (O)
var b: Char = 3 // (X)
```

1. **문자열 데이터 타입**
    - `String`
    - 문자열을 저장할 때 사용하는 타입입니다.

## companion object


이런 코드가 있다고 가정하자. 가장 기본적인 코드이다. 

```kotlin
class Basic {
	companion object {
		var num: Int = 0
	}
}
```

> **여기서 궁금한점 🤔 companion object란 뭐지???? 자바랑 다르다;;**
> 

**이코드를 JAVA로 변환해보자!!**

```java
public final class Basic {

   private static int num;
   // 기본 생성자 생략(자동적으로 만들어진다 ㅎㅎ)
   
   public static final class Companion {
		  // companion 내부 getter
      public final int getNum() {
         return Basic.num;
      }
      // companion 내부 setter
      public final void setNum(int var1) {
         Basic.num = var1;
      }
   }
}
```

- 여기서는 Basic 클래스 내부에 Companion 그 내부에 Basic클래스를 호출해서 getter/settter 을 만드는 식이다
- getter로 접근하려면
    - Basic.getNum() — (X)
    - Basic.Companion.getNum()으로 접근해야한다.ㅠㅠ

**그럼 여기서 `@JVMStatic` 어노테이션을 단다면???**

## `@JVMStatic`


```kotlin
class Basic {
	companion object {
		@JVMStatic
		var num: Int = 0
	}
}
```

다시 JAVA로 변경해보자

```java
public final class Basic {

   private static int num;
   
   public static final int getNum() {
      return num;
   }

   public static final void setNum(int var0) {
      num = var0;
   }
   
   public static final class Companion {
		  // companion 내부 getter
      public final int getNum() {
         return Basic.num;
      }
      // companion 내부 setter
      public final void setNum(int var1) {
         Basic.num = var1;
      }
   }
}
```

- 위에 getter/setter 함수가 추가로 구현되면서 Class 내부에서 직접적으로 호출이 가능해진다 ㅎ



# 002 Operator
## 산술 연산자


**산술 연산자는 덧셈, 뺄셈, 곱셈, 나눗셈 등의 계산을 수행하는 연산자입니다.** 

`+` : 덧셈

`-` : 뺄셈

`*` : 곱셈

`/` : 나눗셈

`%` : 나머지 

## 대입/복합 대입 연산자


**대입 연산자**는 변수에 값을 할당하기 위해 사용하는 **연산자(=)** 입니다.

`=` : 오른쪽 값을 왼쪽 변수에 대입

**복합 대입 연산자**는 **대입 연산자에 산술연산자가 결합**된 형태입니다.
ex) `a += 1` >> `a = a + 1` 과 같습니다.

`+=` : 덧셈하여 왼쪽 변수에 대입

`-=` : 뺄셈하여 왼쪽 변수에 대입

`*=` : 곱셈하여 왼쪽 변수에 대입

`/=` : 나눗셈하여 왼쪽 변수에 대입

`%=` : 나머지를 계산하여 왼쪽 변수에 대입

## 증감 연산자


증감 연산자는 변수의 값을 증가시키거나 감소시키기 위해 사용하는 연산자 입니다.

`a++` : a의 값을 1 증가

`a--` : a의 값을 1 감소

`++a` : a의 값을 1 증가

`--a` : a의 값을 1 감소

`a++` VS `++a`

시점에 차이가 있다 a++은 계산 후 a 증가, ++a 는 증가 후 계산

```kotlin
var a = 1
var b = 1

print(a++) // a = 1
print(++a) // 2

a = 1
print(a) // 1
print(a++) // 1
print(++a) // 3
```

## 비교 연산자


비교 연산자는 2개의 항을 비교하기 위해 사용합니다. 결과값은 항상 `true` 또는 `false` 입니다.

`a > b` : a가 b보다 큰지 비교

`a >= b` : a가 b보다 크거나 같은지 비교

`a < b` : a가 b보다 작은지 비교

`a <= b` : a가 b보다 작거나 같은지 비교

`a == b` : a와 b의 값이 같은지 비교

`a != b` : a와 b의 값이 다른지 비교

`a === b` : a의 참조 주소와 b의 참조 주소가 같은지 비교

`a !== b` : a의 참조 주소와 b의 참조 주소가 다른지 비교 

## 논리 연산자


논리 연산자는 주어진 논리식(`true` 또는 `false` 로 결과가 도출되는 식)에 대한 연산을 수행합니다.

논리 연산자는 논리곱(`&&`), 논리합(`||`), 부정(`!`) 연산자가 있습니다.

`expr1 && expr2` : expr1 과 expr2가 모두 true일 경우 true

`expr1 || expr2` : expr1 과 expr2 중 하나라도 true일 경우 true

`!expr1` : expr1 이 true일 경우 false


# 003 Conditions & Loops
## if statement


`if 문`은 **조건을 판단**하여 코드의 흐름을 제어하는 코드입니다.
**여러 조건**을 사용해야 할 경우 `else if`, `else` 키워드를 사용할 수 있습니다. 
아래와 같은 순서도와 같이 동작한다고 이해하면 좋습니다.

![Untitled](https://github.com/DaHeeO/KotlinBasic/assets/134845297/ff72e049-ad32-4e22-bcb0-39a5823b3c69)


### if statement 문법


`if 문` 은 아래와 같은 문법을 가집니다.

<aside>
💡 Kotlin에는 삼항연산자가 없으니 (표현식)expression을 사용하면 됩니다.

</aside>

```kotlin
val a = Random.nextInt(10)
val b = Random.nextInt(10)

var max = a
if(a < b) max = b

// With else
if(a > b) {
	// this is meaningless 
	max = a
} else {
	max = b
}

// As expression
max = if(a > b) a else b

// You can also use `else if` in expressions:
val maxLimit = 1
// 이건 문제가 많은 코드인듯 하다 한 예로
// a = 0 b = 5 이라면 여기서는 max 값인 b를 출력해야하는데 
// if 문에서 걸려버리니깐 1이 출력된다. 
val maxOrLimit = if(maxLimit > a) maxLimit else if (a > b) a else b

// My way
val maxOrLimit2 = if(a < maxLimit && b < maxLimit) maxLimit else if (a > b) a else b
// 이렇게 하면 둘다 1보다 작은경우에만 1을 출력하고 나머지 둘은 무조건 1 이상인 값을 한개는 가지기 때문에 큰걸 출력하면 max 값이 출력된다.
```

## when statement


`when 문`은 여러 케이스에 대해 구분하기 위해 사용되며, `if 문`을 사용하기엔 **비교적 케이스가 많을 경우** 사용합니다.

<aside>
💡 java의 switch 문과 같은 역할을 합니다.

</aside>

```kotlin
when(x) {
	1 -> print("x == 1")
	2 -> print("x == 2")
	else -> {print("x is neither 1 nor 2")}
}
```

### Enum Class


`enum class` 활용 ( else 문이 필요 없는 경우 )

```kotlin
import java.util.Random

enum class Bit {
    ZERO, ONE
}

fun getRandomBit(): Bit {
    val rand = Random().nextInt() // generate random int

    return if (rand % 2 == 0) Bit.ZERO else Bit.ONE
}

fun main() {
    val numericValue = when (getRandomBit()) {
        Bit.ZERO -> 0
        Bit.ONE -> 1
        // 'else' is not required because all cases are covered
    }
    println(numericValue)
}
```

### In 연산자


`in` 연산자 ( 조건에 범위를 설정해야 할 경우)

```kotlin
val x = readLine()?.toInt()

val validNumbers = arrayListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

when (x) {
	// in 연산자는 1 <= x <= 10 둘다 포함이다
	in 1..10 -> print("x is in the range")
	in validNumbers -> print("x is valid")
	!in 10..20 -> print("x is outside the range")
	else -> print("none of the above")
}
```

## for statement


특정 코드 범위를 반복해서 수행해야 할 경우 `for문`을 사용합니다.
간단하게 사용한다면 아래와 같은 문법을 사용할 수 있습니다.

```kotlin
for(item in collection) println(item)
```

여러 코드 줄을 반복해야 한다면 {} 를 사용하여 지정할 수 있습니다. 
그리고 범위를 지정하는 다양한 응용 방법이 존재합니다.

```kotlin
// 여기서 item: Int 는 dataType 명시이다 햇갈리지 말자 
// ints 는 collection이라고 하네요
for(item: Int in ints) {
	//..
}
```

## while statement


`while 문`은 `for 문`과 동일하게 코드를 반복하기 위해 사용됩니다.
반복하는 방식에 따라 편한 키워드가 있으며, 이를 고려하여 선택하여 사용하면 됩니다.
**반복문을 수행 후 코드를 실행할 지,** **코드를 실행하고 반복문을 수행할지**에 따라 `do-while`을 선택할 수 있습니다.

즉 무조건 한번은 실행해야 한다면 `do-while` 이 적합하다는것!!!

> `while` and `do-while` loops execute their body continuously while their condition is satisfied. The difference between them is the condition checking time:
> 
- `while` checks the condition and, if it's satisfied, executes the body and then returns to the condition check.
- `do-while` executes the body and then checks the condition. If it's satisfied, the loop repeats. So, the body of `do-while` executes at least once regardless of the condition.

```kotlin
// while
while (x > 0) {
    x--
}

// do-while
do {
    val y = retrieveData()
} while (y != null) // y is visible here!
```


# 004 Function
## 함수(Function)


함수는 `input` 값을 받아 **일련의 기능을 수행**하는 코드 구성을 의미합니다.
함수는 결과물을 돌려주거나 돌려주지 않을 수 있습니다.

### 함수의 선언


함수의 선언은 아래와 같은 형식으로 작성할 수 있습니다.

- 함수 선언 형식
    
    ```kotlin
    fun 함수명(인자: 타입, 인자: 타입): return 타입 {
    	return 리턴값
    }
    ```
    
- 기본형
    - return 타입 명시하는경우 `function` 에도 `colone` 을 붙여야 한다
    
    ```kotlin
    fun sum(a: Int, b: Int): Int {
    	return a + b
    }
    
    // return 을 생략한 표현식도 가능
    fun sum2(a: Int b: Int) = a+b
    ```
    
- 리턴값이 없을때 ( `void` )
    
    ```kotlin
    fun noReturnFunction(a: String) {
    	println("called")
    }
    ```
    
- 전달 받는 **파라미터는 기본 값**을 사용할 수 있습니다 (`default value`)
    
    ```kotlin
    fun defaultParameter(a: String = "default value") {
    	println(a)
    }
    ```
    
- 넘겨야 하는 값이 많을 경우 **매개변수의 이름을 직접 명시**하여 가독성을 높일 수 있습니다.
    
    ```kotlin
    fun main() {
    	namedArgument(a = "around", c = "studio", b = "hub")
    }
    
    fun namedArgument(a: String, b: String, c: String) {
    	println("$a $b $c")
    }
    ```
    

JAVA와 다르게 Kotlin은 꼭 매개변수의 순서 보장을 할 필요가 없고, 파라미터의 기본값을 설정 할 수 있습니다.


# 005 Class

## 클래스 (Class)


코틀린의 클래스는 아래와 같은 키워드를 사용하여 선언됩니다.

```kotlin
class Person {/*..*/}
```

클래스의 선언은 클래스 이름을 포함하여 매개변수, 생성자, 그리고 중괄호로 묶인 본론으로 구성됩니다.

```kotlin
class Person {
	var name: String = "Dahee"
	var age:Int = 26
	var country: String = "Korea"
	var height: Int = 164
	var weight: Int = 60
	
	fun sayHello() {
		println("Hi")
	}
	
	fun introduce() {
		println("I'm $name and my age is $age.")
	}
}
```

## 생성자 (Constructor)


코틀린의 생성자는 아래와 같은 형식으로 구성할 수 있습니다.

```kotlin
class PersonWithConstructor constructor(private val name: String, private val age: Int) { // main constructor
	
	constructor(name: String): this(name, 15) // sub constructor
	
	constructor(name: String, age: Int, etc: String): this(name, age) { // additional constructor
		println("additional constructor is called: $etc")
	}
	
	fun sayHello() {
		println("HI")
	}
	
	fun introduce() {
		println("I'm $name and my age is $age.")
	}
}
```

# 006 Inheritance

## 상속(Inheritance)


상속은 **상위 클래스에 중복되는 로직을 구현하고 이를 재사용하는 것**을 의미합니다.

상속의 관계를 흔히 `부모 - 자식` 클래스라고도 부르며 `Is - a` 관계라고도 부릅니다.

ex). Person(parent) - Student(child)

## 코틀린의 상속


코틀린에서는 모든 클래스가 `Any` 를 상속 받고 있는 구조입니다.

`Any` 에서는 `equals()` , `hashCode()` , `toString()` 이 구현되어 있습니다.

`Any` Interface 예시 

```kotlin
public open class Any {

	public open operator fun equals(other: Any?): Boolean
	
	public open fun hashCode(): Int
	
	public open fun toString(): String
}
```

### 부모 class


부모 클래스는 `open` 키워드를 사용하여 상속을 허용할 수 있습니다.

```kotlin
open class Car(val name: String, val price: Double, val brand: String) {

	fun introduce() {
		println("this car is $name. this is made by $brand.")
	}
	
	fun howMuch() {
		println("this car is $price dollars")
	}
	
}
```

메소드 또한 **override** 할 수 있게 `open` 키워드를 사용할 수 있습니다.

```kotlin
open class Car(val name: String, val price: Double, val brand: String) {

	open fun myPurchaseDate() {
		println("you don't buy yet")
	}
	
}
```

### 자식 class


상속을 받는 자식 클래스는 아래와 같은 형식으로 상속을 받습니다.

```kotlin
class MyCar(name: String, price: Double, brand: String, val purchaseDate: LocalDate): Car(name, price, brand) {

}
```

메소드 오버라이드는 아래와 같이 구현합니다.

```kotlin
class MyCar(name: String, price: Double, brand: String, val purchaseDate: LocalDate): Car(name, price, brand) {

	override fun myPurchaseDate() {
		println("you made a purchase on $purchaseDate")
	}
	
}
```

# 007 Data Class

## 데이터 클래스 (Data Class)


일반적으로 레이어간 데이터 전달을 위해 `DTO` : **Data Transfer Object** 라는 객체를 생성하여 사용합니다.

코틀린에서는 이러한 역할을 수행할 수 있는 `데이터 클래스` 를 제공합니다.

데이터 클래스를 사용하면 아래와 같은 메소드를 자동으로 생성해 줍니다.

- `equals()`
- `getter / setter`
- `hashCode()`
- `toString()`
- `copy()`
- `componentN()`

### Data Class 생성


코틀린에서 데이터 클래스는 아래와 같은 형식으로 정의할 수 있습니다.

```kotlin
data class DataClassSample(val name: String, val age: Int)
```

> 클래스 앞에 `data` 키워드를 붙여 정의합니다.
> 


# 008 Enum Class

## 열거형 클래스 (Enumeration Class = Enum Class)


우리는 Enum 클래스를 사용하여 일정 범주 안에 들어갈 수 있는 상수들을 묶어 관리할 수 있습니다.

**Enum 클래스를 사용하는 이유**

- 코드가 단순해지고, 가독성이 좋아짐
- 인스턴스의 생성과 상속 등을 방지하고 타입 안정성을 보장함

### Enum Class 생성


Enum 클래스는 아래와 같이 구현할 수 있습니다.

```kotlin
enum class Color(val label: String, val code: String) {
	Red("red", "#FE2E2E"),
	YELLOW("yellow", "#F7FE2E"),
	GREEN("green", "#40FF00"),
	BLUE("blue", "#0000FF");
}	
```

이렇게 선언된 클래스는 아래와 같이 활용 할 수 있습니다.

```kotlin
val red = Color.RED
println(red)
println(red.label)
println(red.code)
```

이 외에도 각 타입마다 함수를 구현하여 기능을 동작하게 할 수 있습니다.
