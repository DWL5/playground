# Predicate

java.util.function.Predicte<T> 인터페이스는 test라는 추상 메서드를 정의하며 test는 제네릭 형식의 T 객체를 인수로 받아 boolean을 반환한다.

```
@FunctionalInterface
pubic interface Predicate<T> {
    boolean test(T t);
}
```

다음 예제처럼 String 객체를 인수로 받는 람다를 정의할 수 있다.
```
Predicate<String> nonEmptyStringPredicate = (String s) s -> !s.isEmpty();
```

# Consumer
java.util.function.Consumer<T> 인터페이스는 제네릭 형식 T 객체를 받아서 void를 반환한다. T형식의 객체를 인수로 받아서 어떤 동작을 수행하고 싶을 때 Consumer 인터페이스를 사용할 수 있다.

```
@FunctionalInterface
public interface Consumer<T> {
    void accept(T t);
}
```


# Function
java.util.function.Function<T, R> 인터페이스는 제네릭 형식 T를 인수로 받아서 제네릭 형식 R 객체를 반환하는 추상 메서드 apply를 정의한다.

```
@FunctionalInterface
public interface Function<T, R> {
    R apply(T t);
}
```

다음은 String 리스트를 인수로 받아 각 String의 길이를 포함하는 Integer리스트로 변환하는 map 메서드를 정의하는 예제다.

```
public <T, R> List<R> map(List<T> list, Function<T, R> f) {
    List<R> result = new ArrayList<>();
    for(T t : list) {
        result.add(f.apply(t));
    }
    return result;
}

List<Integer> l = map(
    Arrays.asList("lambdas", "in", "action"),
    (String s) -> s.length() // Function의 apply 메서드를 구현하는 람다
);
```

# 람다와 함수형 인터페이스 예제

- 불리언 표현
  - `Predicate<List<String>>`
  - 람다 예제
    - `(List<String> list) -> list.isEmpty())`
- 객체 생성
  - `Supplier<Apple>`
  - 람다 예제
    - () -> new Apple(10)
- 객체에서 소비
  - `Consumer<Apple>`
  - 람다 예제
    - `(Apple a) -> System.out.println(a.getWeight())`
- 객체에서 선택/추출
  - `Function<String, Integer>`
  - `ToIntFunction<String>`
  - 람다 예제
  - `(String s) -> s.length()`
- 두 값 조합
  - IntBinaryOperator
  - 람다 예제
    - `(int a, int b) -> a * b`
- 두 객체 비교
  - `Comparator<Apple>`
  - `Bifunction<Apple, Apple, Integer>`
    - `BiFunction<T, U, R> (T, U) -> R`
  - `ToIntBiFunction<Apple, Apple>`
  - 람다 예제
    - `(Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight())`
  