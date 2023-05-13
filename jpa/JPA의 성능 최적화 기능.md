# 1차 캐시와 동일성(identity) 보장
- 같은 트랜잭션 안에서는 같은 엔티티를 반환 - 약간의 조회 성능 향상
- DB Isolation Level이 Read Commit이어도 애플리케이션에서 Repeatable Read보장
  - 1차 캐시에 저장된 내용을 리턴하기 때문에 같은 트랜잭션안에서는 Repeatable Read를 보장한다.

### 트랜잭션 격리 수준
- Read UnCommitted
  - 한 트랜잭션의 변경된 내용을 커밋이나 롤백과 상관없이 다른 트랜잭션에서 읽을 수 있는 격리 수준
- Read Committed
  - COMMIT이 완료된 데이터만 조회 가능한 격리 수준
- Repeatable Read
  - 트랜잭션이 시작되기 전에 커밋된 내용에 관해서만 조회할 수 있는 격리 수준
- Seriazable
  - 헌 트랜잭션을 다른 트랜잭션으로 부터 완전히 분리하는 격리 수준

# 트랜잭션을 지원하는 쓰기 지연 - INSERT
- 트랜잭션을 커밋할 때 까지 INSERT SQL을 모음
- JDBC BATCH SQL 기능을 사용해서 한번에 SQL 전송


```
transaction.begin() // 트랜잭션 시작

em.persist(memberA)
em.persist(memberB)
em.persist(memberC)
//여기까지 INSERT SQL을 데이터베이스에 보내지 않는다.

//커밋하는 순간 데이터베이스에 INSERT SQL을 모아서 보낸다.
transaction.commit(); // 트랜잭션 커밋
```

# 트랜잭션을 지원하는 쓰기 지연 - UPDATE
- UPDATE, DELETE로 인한 로우(ROW)락 시간 최소화
- 트랜잭션 커밋 시 UPDATE, DELETE SQL 실행하고, 바로 커밋

```
transaction.begin(); // 트랜잭션 시작

changeMember(memberA);
deleteMember(memberB); // 비즈니스 로직 수행 동안 DB 로우 락이 걸리지 않는다.
비즈니스_로직_수행();

//커밋하는 순간 데이터베이스에 UPDATE, DELETE SQL을 보낸다.
transaction.commit();
```

# 지연 로딩과 즉시 로딩
- 지연 로딩 : 객체가 실제 사용될 때 로딩
- 즉시 로딩 : JOIN SQL로 한번에 연관된 객체까지 미리 조회
