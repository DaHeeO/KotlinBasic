# Kotlin_Basic(Variable, DatType)

날짜: 2024년 4월 20일
태그: 자습

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
