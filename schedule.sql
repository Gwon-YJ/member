단일테이블
테이블 이름: schedules

| 컬럼이름       | 데이터타입           | 키                  | null 허용 | 설명   |
|------------|-----------------|--------------------|--------|------|
| id         | bigint          | PK(aute_increment) | N       | 식별자  |
| title      | varchar(20)     | -                  | N       | 할일제목 |
| contents   | varchar(200)    | -                  | N       | 할일내용 |
| password   | varchar(200)    | -                  | N       | 비밀번호 |
| updated_at | LocalDateTime() | -                  | N       | 수정일  |

테이블 다수(정규화 적용)
테이블 이름: schedules

| 컬럼이름       | 데이터타입           | 키                  | null 허용 | 설명   |
|------------|-----------------|--------------------|---------|------|
| id         | bigint          | PK(aute_increment) | N       | 식별자  |
| title      | varchar(20)     | -                  | N       | 할일제목 |
| contents   | varchar(200)    | -                  | N       | 할일내용 |
| password   | varchar(200)    | -                  | N       | 비밀번호 |
| created_at | LocalDateTime() | -                  | N       | 생성일  |
| updated_at | LocalDateTime() | -                  | N       | 수정일  |

테이블이름: members

| 컬럼이름       | 데이터타입           | 키                  | null 허용 | 설명   |
|------------|-----------------|--------------------|---------|------|
| id         | bigint          | PK(aute_increment) | N       | 식별자  |
| username   | varchar(20)     | -                  | N       | 작성자  |
| password   | varchar(200)    | -                  | N       | 비밀번호 |
| email      | varchar(200)    | -                  | N       | 이메일  |
| created_at | LocalDateTime() | -                  | N       | 생성일  |
| updated_at | LocalDateTime() | -                  | N       | 수정일  |
