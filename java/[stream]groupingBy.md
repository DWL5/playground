# [Stream] groupingBy
- 특정 속성값으로 그룹핑을 짓는다.
- 항상 Map<K, V> 형태를 리턴한다.

### groupingBy 메서드가 받는 3가지 파라미터
- classifier(Function<? super T, ? extends K>) : 분류 기준을 나타낸다.
- mapFactory(Supplier) : 결과 Map 구성 방식을 변경할 수 있다.
- downStream (Collector<? super T,A,D>) : 집계 방식을 변경할 수 있다. 