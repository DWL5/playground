# [Stream] groupingBy
- 특정 속성값으로 그룹핑을 짓는다.
- 항상 Map<K, V> 형태를 리턴한다.

### groupingBy 메서드가 받는 3가지 파라미터
- classifier(Function<? super T, ? extends K>) : 분류 기준을 나타낸다.
- mapFactory(Supplier) : 결과 Map 구성 방식을 변경할 수 있다.
- downStream (Collector<? super T,A,D>) : 집계 방식을 변경할 수 있다. 


### 그룹화 Collectors.groupingBy
- 고기를 포함하는 그룹, 생선을 포함하는 그룹, 나머지 그룹으로 메뉴를 그룹화 하기

```
Map<Dish.Type, List<Dish>> dishesByType = 
    menu.stream().collect(groupingBy(Dish::getType));
```

- 그룹화 연산의 결과로 그룹화 함수가 반환하는 키 그리고 각 키에 대응하는 스트림의 모든 항목 리스트를 값으로 갖는 맵이 반환

- 람다 표현식으로 필요한 로직을 구현하여 그룹화 할 수 있다.
```
Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream().collect(
    groupingBy(dish -> {
        if (dish.getCalories() <= 400) return CaloricLevel.DIET;
        else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
        else return CaloricLevel.FAT;
    })
)
```

### 그룹화된 요소 조작
- 요소를 그룹화 한 다음에는 각 결과 그룹의 요소를 조작하는 연산이 필요하다. 예를 들어 500칼로리가 넘는 요리만 필터한다고 가정하자. 다음 코드처럼 그룹화를 하기 전에 프레디케이트로 필터를 적용해 문제를 해결할 수 있다고 생각할 것이다.

```
Map<Dish.Type, List<Dish>> caloricDishesByType = menu.stream().filter(dish -> dish.getCalories() > 500)
.collect(groupingBy(Dish::getType));
```

- 위의 프레디케이트를 만족하지 않는 키 값이 사라질 수 있다는 문제가 있다. Dish.Type Fish를 가진 데이터 중 하나도 calroties 500을 넘지 못한다면, Dish.Type Fish는 결과 값에서 사라질 것 이다.

- 해당 문제는 아래와 같이 해결 할 수 있다.
```
Map<Dish.Type, List<Dish>> caloricDishesByType = menu.stream().collect(groupingBy(Dish::getType, filtering(dish -> dish.getCalories() > 500, toList())));
```