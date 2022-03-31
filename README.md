# spring mvc 사용하여 아이템관리 만들기

## VERSION 1 (DB없이 진행)
+ 백엔드 로직에 집중하기 위해 화면은 부트스트랩으로 대체

### 프로젝트 환경설정
+ thymeleaf 뷰템플릿 사용

### 프로젝트 기능
+ 아이템 조회
+ 아이템 추가
+ 아이템 수정
+ 아이템 삭제

### 발생했던 이슈
+ 타임리프 환경설정
+ [타임리프 환경설정 에러 및 해결방법](https://unique-wandflower-4cc.notion.site/spring-boot-Thymeleaf-1e682c67a4e74cf9b0b0cc8cb26712e8)

### 코드 리펙토링
- 아이템관리 create시 시퀀스 생성 코드 리펙토링
- 기존 : item 저장전 시퀀스 값 증가후 item 저장
- 수정후 : service에서 item 추가전 먼저 시퀀스를 생성하여 item을 Map에 저장

```java
public Long save(Item item) {
        Long sequence = createSequence();
        item.setItem_id(sequence);
        return itemRepository.save(item);
    };

```

```java
    public Long createSequence() {
        return itemRepository.createSequence();
    }
```

```java
    @Override
    public Long createSequence() {
        return sequence += 1;
    }

```

