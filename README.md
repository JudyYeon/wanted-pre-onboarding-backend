# 프리온보딩 백엔드 인턴십 선발과제

프리온보딩 백엔드 인턴십 선발을 위한 과제입니다.

---

## 서비스 개요

- 본 서비스는 기업의 채용을 위한 웹 서비스입니다.
- 회사는 채용공고를 생성하고, 이에 사용자는 지원합니다.

---

## ⚙ 기술 스택

- **언어**: Java 17
- **프레임워크**: Spring Boot
- **ORM**: Spring Data JPA (Hibernate)
- **DB**: MySQL
- **API 문서화**: Swagger (Spring-doc OpenAPI)
- **테스트**: JUnit5

---

## 📂 아키텍처 구성

- **Domain Layer**
    - `Company`, `Notice`, `Applicants`, `Apply`
    - 각 Entity 간 관계 매핑 (예: Company 1:N Notice, Notice 1:N Apply)

- **Repository Layer**
    - JPA 기반 CRUD 처리 (`NoticeRepository`, `ApplyRepository`)

- **Service Layer**
    - 비즈니스 로직 처리
    - 트랜잭션 관리 및 도메인 간 협력

- **Controller Layer**
    - API 엔드포인트 제공 (RESTful)
    - 요청 검증, 응답 포맷 (ApiResponse)

---

## 1️⃣ 채용공고 등록 / 수정

### 요구사항
- 회사는 채용공고를 등록 / 수정할 수 있습니다.

### 아키텍처별 구현 과정
- **Domain**
    - `Notice` Entity: 포지션, 보상금, 내용, 기술스택 필드 설계
- **Repository**
    - `NoticeRepository`: 기본 CRUD 지원
- **Service**
    - `RecruitService`: 등록 / 수정 로직, Company 연관 엔티티 처리
- **Controller**
    - `POST /recruit` 등록 API
    - `PUT /recruit/{id}` 수정 API

---

## 2️⃣ 채용공고 삭제

### 요구사항
- 회사는 채용공고를 삭제할 수 있습니다.

### 아키텍처별 구현 과정
- **Domain**
    - `Notice` Entity 활용
- **Repository**
    - `NoticeRepository`: `deleteById` 사용
- **Service**
    - 삭제 요청 시 존재 여부 확인 + 삭제 처리
- **Controller**
    - `DELETE /recruit/{id}` API

---

## 3️⃣ 채용공고 목록

### 요구사항
- 채용공고 리스트 제공
- 검색 (선택사항)

### 아키텍처별 구현 과정
- **Domain**
    - `Notice` + `Company` 조인 데이터 반환용 DTO 설계
- **Repository**
    - 채용공고 목록 + 검색 메서드 작성
- **Service**
    - 목록 / 검색 조건 처리
- **Controller**
    - `GET /recruit` API (검색 포함)

---

## 4️⃣ 채용 상세 페이지

### 요구사항
- 채용공고 상세정보 제공
- 해당 회사의 다른 채용공고 ID 리스트 포함 (가산점 요소)

### 아키텍처별 구현 과정
- **Domain**
    - `Notice`, `Company` 관계 활용
- **Repository**
    - 상세조회 + 같은 회사 다른 채용공고 조회 메서드 작성
- **Service**
    - 상세 데이터 + ID 리스트 조합
- **Controller**
    - `GET /recruit/{id}` API

---

## 5️⃣ 채용공고 지원

### 요구사항
- **가산점 요소**
- 사용자는 채용공고에 1회 지원 가능

### 아키텍처별 구현 과정
- **Domain**
    - `Apply`, `Applicants` Entity 설계 (Unique 제약으로 중복 지원 방지)
- **Repository**
    - `ApplyRepository`: 지원 내역 조회 + 등록
- **Service**
    - 중복 체크 -> 지원 등록
- **Controller**
    - `POST /apply` API

---

## ✅ ORM & RDBMS

- Spring Data JPA + Hibernate 기반 ORM
- MySQL RDBMS 사용
- ERD: <br>
Company(회사) ⬌ Notice(채용공고) ⬌ Apply(지원) ⬌ Applicants(지원자)

---

## ✅ Unit Test

- `RecruitServiceTest`에 서비스 레이어 단위 테스트 작성
- JPA 쿼리 검증용 테스트 포함

---

## ✅ Git Commit Convention
> feat: 기능 추가 <br>
> fix: 버그 수정 <br>
> docs: 문서 작성 <br>
> refactor: 코드 리팩토링 <br>
> test: 테스트 코드 작성
