# MES 프로젝트 지시사항 (Java 11 + Tomcat + JSP/Servlet + Oracle)

## 1. 프로젝트 개요
- **목표**: SOAP 기반 MES 시스템 구축 (2주 단기 프로젝트)
- **대상**: 학생 팀 프로젝트 (생산 관리, LOT 추적, BOM 관리, CRM, KPI)
- **제품 관리 범위**: 완제품, 반제품, 원자재까지 통합 관리

---

## 2. 기술 스택
- **백엔드**: Java 11, JSP/Servlet, JDBC
- **서버**: Apache Tomcat 9 이상
- **프론트엔드**: HTML, CSS, JavaScript (JSP 내 포함)
- **DBMS**: Oracle 19c
- **버전관리**: GitHub (팀 협업)
- **빌드/배포**: WAR 파일 형태로 Tomcat 배포

---

## 3. 시스템 아키텍처
- **JSP/Servlet MVC 구조**
  - JSP: View (화면)
  - Servlet: Controller (요청 처리)
  - DAO (Data Access Object): DB 연결, SQL 실행
- **DB 연결 방식**: JDBC (ojdbc8.jar)
- **SOAP 통신**: JAX-WS 사용 (단순 SOAP 기반 데이터 요청)

---

## 4. 데이터베이스 설계 (주요 테이블)

### 4.1 Product (제품 관리)
```sql
CREATE TABLE PRODUCT (
    PRODUCT_ID NUMBER PRIMARY KEY,
    PRODUCT_NAME VARCHAR2(100) NOT NULL,
    PRODUCT_TYPE VARCHAR2(20) CHECK (PRODUCT_TYPE IN ('FINISHED', 'SEMI_FINISHED', 'RAW')),
    UNIT VARCHAR2(20),
    CREATED_AT DATE DEFAULT SYSDATE
);
```
- PRODUCT_TYPE: `FINISHED(완제품)`, `SEMI_FINISHED(반제품)`, `RAW(원자재)`

### 4.2 BOM (자재 명세서)
```sql
CREATE TABLE BOM (
    BOM_ID NUMBER PRIMARY KEY,
    PARENT_PRODUCT_ID NUMBER REFERENCES PRODUCT(PRODUCT_ID),
    CHILD_PRODUCT_ID NUMBER REFERENCES PRODUCT(PRODUCT_ID),
    QUANTITY NUMBER NOT NULL
);
```

### 4.3 LOT (생산 이력 추적)
```sql
CREATE TABLE LOT (
    LOT_ID NUMBER PRIMARY KEY,
    PRODUCT_ID NUMBER REFERENCES PRODUCT(PRODUCT_ID),
    QUANTITY NUMBER,
    STATUS VARCHAR2(20),
    CREATED_AT DATE DEFAULT SYSDATE
);
```

### 4.4 CRM (고객/주문 관리)
```sql
CREATE TABLE CUSTOMER (
    CUSTOMER_ID NUMBER PRIMARY KEY,
    NAME VARCHAR2(100),
    CONTACT VARCHAR2(100)
);

CREATE TABLE ORDERS (
    ORDER_ID NUMBER PRIMARY KEY,
    CUSTOMER_ID NUMBER REFERENCES CUSTOMER(CUSTOMER_ID),
    PRODUCT_ID NUMBER REFERENCES PRODUCT(PRODUCT_ID),
    QUANTITY NUMBER,
    ORDER_DATE DATE DEFAULT SYSDATE
);
```

### 4.5 KPI (성과 지표)
```sql
CREATE TABLE KPI (
    KPI_ID NUMBER PRIMARY KEY,
    KPI_NAME VARCHAR2(100),
    VALUE NUMBER,
    MEASURE_DATE DATE DEFAULT SYSDATE
);
```

---

## 5. 기능 모듈

### 5.1 생산 관리
- 원자재 입고 등록
- 반제품 가공 기록
- 완제품 출하 등록

### 5.2 BOM 관리
- 제품별 자재 구성 등록/조회
- 반제품 ↔ 원자재 매핑

### 5.3 LOT 추적
- LOT별 생산/가공/출하 이력 추적
- 특정 LOT → 사용된 원자재 추적

### 5.4 CRM 관리
- 고객 정보 등록/수정
- 주문 생성, 주문 현황 조회

### 5.5 KPI 관리
- 생산량, 불량률, 납기 준수율 등록
- 대시보드 화면 제공

---

## 6. 화면 설계 (와이어프레임 개요)
1. **대시보드**: KPI 차트, 생산 현황 요약
2. **제품 관리 화면**: 완제품/반제품/원자재 구분 등록
3. **BOM 관리 화면**: 제품 구성 등록 및 BOM Tree 조회
4. **LOT 추적 화면**: LOT ID 기반 추적 기능
5. **CRM 화면**: 고객/주문 관리

---

## 7. 프로젝트 일정 (2주)
- **1일차 ~ 2일차**: 요구사항 정의, DB 설계
- **3일차 ~ 5일차**: JSP/Servlet 기본 구조 세팅, DB 연결
- **6일차 ~ 9일차**: 주요 기능 구현 (Product, BOM, LOT)
- **10일차 ~ 12일차**: CRM, KPI 기능 구현
- **13일차**: 테스트 및 통합
- **14일차**: 발표/보고서 준비

---

## 8. 개발 규칙
- Java 11 문법 준수
- DAO 패턴 사용 (DB 접근 일원화)
- JSP는 View 전용, Servlet은 Controller 역할만 수행
- SQL은 최대한 표준 SQL 사용 (Oracle 호환성 고려)

---

✅ 이 구조라면 **완제품/반제품/원자재를 명확히 구분**하여 관리할 수 있고, 2주 안에 핵심 기능(LOT 추적 + BOM + CRM + KPI)까지 구현이 가능합니다.

