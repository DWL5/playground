# 기본 Q-Type 활용
- static import를 사용하는 것이 깔끔하다.
  
### Q클래스 인스턴스를 사용하는 2가지 방법
```
QMember qMember = new QMember("m");
QMember qMember = QMember.member;
```

### 기본 인스턴스를 static import와 함께 사용
```
import static study.querydsl.entity.QMember.*;
@Test
public void startQuerydsl3() {
    //member1을 찾아라.
    Member findMember = queryFactory
        .select(member)
        .from(member)
        .where(member.username.eq("member1"))
        .fetchOne();
    assertThat(findMember.getUsername()).isEqualTo("member1");
}
```