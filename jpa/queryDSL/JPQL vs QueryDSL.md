# JPQL vs QueryDSL
### JPQL
```
String qlString = "select m from Member m where m.username = :username";

Member findMember = em.createQuery(qlString, Member.class)
        .setParameter("username", "member1")
        .getSingleResult();

assertThat(findMember.getUsername()).isEqualTo("member1");
```

### QueryDSL
```
JPAQueryFactory queryFactory = new JPAQueryFactory(em);
QMember m = new QMember("m");

Member findMember = queryFactory
        .select(m)
        .from(m)
        .where(m.username.eq("member1"))
        .fetchOne();

assertThat(findMember.getUsername()).isEqualTo("member1");
```