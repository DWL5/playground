# @MappedSuperclass
- 공통 매핑 정보가 필요할 때 사용
  - 테이블과 관계 없고, 단순히 엔티티가 공통으로 사용하는 매핑 정보를 모으는 역할
  - 주로 등록일, 수정일, 등록자, 수정자 같은 전체 엔티티에서 공통으로 적용하는 정보를 모을 때 사용
  - @Entity 클래스는 엔티티나 @MappedSuperclass로 지정한 클래스만 상속 가능
- 상속관계 매핑 X
- 엔티티 X, 테이블과 매핑 X
- 부모 클래스를 상속 받는 자식 클래스에 매핑 정보만 제공
- 조회, 검색 불가(em.find(BaseEntity) 불가)
- 직접 생성해서 사용할 일이 없으므로 추상 클래스 권장

```
@MappedSuperclass
public class BaseEntity {

    private String createdBy;
    private LocalDateTime createdDate;
    private String lastModifiedBy;
    private LocalDateTime lastModifiedDate;
}
```

테이블을 생성해보면 BaseEntity의 속성이 그대로 반영되어 테이블이 생성된 것을 확인 할 수 있다.

```
Hibernate: 
    
    create table Item (
       DTYPE varchar(31) not null,
        ITEM_ID bigint not null,
        createdBy varchar(255),
        createdDate timestamp,
        lastModifiedBy varchar(255),
        lastModifiedDate timestamp,
        name varchar(255),
        price integer not null,
        stockQuantity integer not null,
        artist varchar(255),
        etc varchar(255),
        author varchar(255),
        isbn varchar(255),
        actor varchar(255),
        director varchar(255),
        primary key (ITEM_ID)
    )
Hibernate: 
    
    create table Member (
       MEMBER_ID bigint not null,
        createdBy varchar(255),
        createdDate timestamp,
        lastModifiedBy varchar(255),
        lastModifiedDate timestamp,
        city varchar(255),
        name varchar(255),
        street varchar(255),
        zipCode varchar(255),
        primary key (MEMBER_ID)
    )
```