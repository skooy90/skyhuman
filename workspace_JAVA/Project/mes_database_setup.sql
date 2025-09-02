-- =====================================================
-- MES 시스템 데이터베이스 설정 파일
-- 오이비누 제조업 생산관리시스템 (오이 + 비누 제조)
-- Manufacturing Execution System for Cucumber Soap Industry
-- 작성일: 2024년
-- =====================================================

-- =====================================================
-- 1. 테이블 생성 (CREATE TABLE)
-- =====================================================

-- 제품 관리 테이블 (완제품, 반제품, 원자재 구분)
CREATE TABLE PRODUCT (
    PRODUCT_ID NUMBER PRIMARY KEY,                    -- 제품 고유 식별번호
    PRODUCT_NAME VARCHAR2(100) NOT NULL,              -- 제품명
    PRODUCT_TYPE VARCHAR2(20) CHECK (PRODUCT_TYPE IN ('FINISHED', 'SEMI_FINISHED', 'RAW')), -- 제품유형
    UNIT VARCHAR2(20),                                -- 단위 (개, kg, g, L, ml 등)
    CREATED_AT DATE DEFAULT SYSDATE                   -- 제품 등록일
);

-- LOT(생산 배치) 관리 테이블 (생산 이력 추적용)
CREATE TABLE LOT (
    LOT_ID NUMBER PRIMARY KEY,                        -- LOT 고유 식별번호
    PRODUCT_ID NUMBER REFERENCES PRODUCT(PRODUCT_ID), -- 제품 참조 번호
    QUANTITY NUMBER(10),                              -- 수량
    STATUS VARCHAR2(20) DEFAULT 'IVB',                -- 상태 (기본값: IVB)
    CREATED_AT DATE DEFAULT SYSDATE,                  -- LOT 생성일
    QC_STATUS VARCHAR2(20) DEFAULT 'PENDING',         -- 품질검사 상태
    INSPECTOR VARCHAR2(100)                           -- 검사자
);

-- 고객 정보 관리 테이블
CREATE TABLE CUSTOMER (
    CUSTOMER_ID NUMBER PRIMARY KEY,                   -- 고객 고유 식별번호
    NAME VARCHAR2(100) NOT NULL,                      -- 고객명
    CONTACT VARCHAR2(100),                            -- 연락처
    ADDRESS VARCHAR2(200)                             -- 주소
);

-- BOM(자재 명세서) 테이블 (제품 구성요소 관리)
CREATE TABLE BOM (
    BOM_ID NUMBER PRIMARY KEY,                        -- BOM 고유 식별번호
    PARENT_ID NUMBER(10) REFERENCES PRODUCT(PRODUCT_ID), -- 상위 제품 ID
    CHILD_ID NUMBER(10) REFERENCES PRODUCT(PRODUCT_ID),  -- 하위 제품 ID
    QUANTITY NUMBER(10,2) NOT NULL                    -- 필요 수량 (소수점 2자리까지 허용)
);

-- 생산 이력 관리 테이블 (공정별 진행상황 추적)
CREATE TABLE PRODUCTION_HISTORY (
    HISTORY_ID NUMBER(20) PRIMARY KEY,                -- 이력 고유 식별번호
    LOT_ID NUMBER(20) REFERENCES LOT(LOT_ID),         -- LOT 참조 번호
    STEP_NAME VARCHAR2(100),                          -- 공정 단계명
    START_TIME DATE,                                   -- 시작 시간
    END_TIME DATE,                                     -- 종료 시간
    OPERATOR VARCHAR2(100),                           -- 작업자
    STATUS VARCHAR2(20)                               -- 상태
);

-- 주문 관리 테이블
CREATE TABLE ORDERS (
    ORDER_ID NUMBER PRIMARY KEY,                      -- 주문 고유 식별번호
    CUSTOMER_ID NUMBER(10) REFERENCES CUSTOMER(CUSTOMER_ID), -- 고객 참조 번호
    PRODUCT_ID NUMBER(10) REFERENCES PRODUCT(PRODUCT_ID),    -- 제품 참조 번호
    QUANTITY NUMBER,                                  -- 주문 수량
    ORDER_DATE DATE DEFAULT SYSDATE,                  -- 주문일
    STATUS VARCHAR2(20) DEFAULT 'PENDING'             -- 주문 상태
);

-- KPI(핵심 성과 지표) 관리 테이블
CREATE TABLE KPI (
    KPI_ID NUMBER PRIMARY KEY,                        -- KPI 고유 식별번호
    KPI_NAME VARCHAR2(100) NOT NULL,                  -- KPI 지표명
    TARGET_VALUE NUMBER(10),                          -- 목표값
    ACTUAL_VALUE NUMBER(10),                          -- 실제값
    MEASURE_DATE DATE DEFAULT SYSDATE                 -- 측정일
);

-- BOM LOT 테이블 (BOM 구성요소별 LOT 관리)
CREATE TABLE BOM_LOT (
    BOM_LOT_ID NUMBER PRIMARY KEY,                    -- BOM LOT 고유 식별번호
    PARENT_ID NUMBER(10) REFERENCES PRODUCT(PRODUCT_ID), -- 상위 제품 ID
    CHILD_ID NUMBER(10) REFERENCES PRODUCT(PRODUCT_ID),  -- 하위 제품 ID
    QUANTITY NUMBER(10,2) NOT NULL,                   -- 필요 수량 (소수점 2자리까지 허용)
    CREATED_AT DATE DEFAULT SYSDATE                   -- 생성일
);

-- =====================================================
-- 2. 시퀀스 생성 (자동 증가 번호)
-- =====================================================

-- 제품 ID 자동 증가 시퀀스
CREATE SEQUENCE SEQ_PRODUCT_ID START WITH 1 INCREMENT BY 1;

-- LOT ID 자동 증가 시퀀스
CREATE SEQUENCE SEQ_LOT_ID START WITH 1 INCREMENT BY 1;

-- 고객 ID 자동 증가 시퀀스
CREATE SEQUENCE SEQ_CUSTOMER_ID START WITH 1 INCREMENT BY 1;

-- BOM ID 자동 증가 시퀀스
CREATE SEQUENCE SEQ_BOM_ID START WITH 1 INCREMENT BY 1;

-- 생산이력 ID 자동 증가 시퀀스
CREATE SEQUENCE SEQ_HISTORY_ID START WITH 1 INCREMENT BY 1;

-- 주문 ID 자동 증가 시퀀스
CREATE SEQUENCE SEQ_ORDER_ID START WITH 1 INCREMENT BY 1;

-- KPI ID 자동 증가 시퀀스
CREATE SEQUENCE SEQ_KPI_ID START WITH 1 INCREMENT BY 1;

-- BOM LOT ID 자동 증가 시퀀스
CREATE SEQUENCE SEQ_BOM_LOT_ID START WITH 1 INCREMENT BY 1;

-- =====================================================
-- 3. 샘플 데이터 삽입 (INSERT) - 오이비누 제조업 중심
-- =====================================================

-- 제품 데이터 삽입 (완제품, 반제품, 원자재)
INSERT INTO PRODUCT (PRODUCT_ID, PRODUCT_NAME, PRODUCT_TYPE, UNIT) 
VALUES (SEQ_PRODUCT_ID.NEXTVAL, '오이 천연비누', 'FINISHED', '개');

INSERT INTO PRODUCT (PRODUCT_ID, PRODUCT_NAME, PRODUCT_TYPE, UNIT) 
VALUES (SEQ_PRODUCT_ID.NEXTVAL, '오이 비누 베이스', 'SEMI_FINISHED', 'kg');

INSERT INTO PRODUCT (PRODUCT_ID, PRODUCT_NAME, PRODUCT_TYPE, UNIT) 
VALUES (SEQ_PRODUCT_ID.NEXTVAL, '신선 오이', 'RAW', 'kg');

INSERT INTO PRODUCT (PRODUCT_ID, PRODUCT_NAME, PRODUCT_TYPE, UNIT) 
VALUES (SEQ_PRODUCT_ID.NEXTVAL, '오이 추출물', 'SEMI_FINISHED', 'L');

INSERT INTO PRODUCT (PRODUCT_ID, PRODUCT_NAME, PRODUCT_TYPE, UNIT) 
VALUES (SEQ_PRODUCT_ID.NEXTVAL, '가성소다', 'RAW', 'g');

INSERT INTO PRODUCT (PRODUCT_ID, PRODUCT_NAME, PRODUCT_TYPE, UNIT) 
VALUES (SEQ_PRODUCT_ID.NEXTVAL, '팜 오일', 'RAW', 'g');

INSERT INTO PRODUCT (PRODUCT_ID, PRODUCT_NAME, PRODUCT_TYPE, UNIT) 
VALUES (SEQ_PRODUCT_ID.NEXTVAL, '올리브 오일', 'RAW', 'g');

INSERT INTO PRODUCT (PRODUCT_ID, PRODUCT_NAME, PRODUCT_TYPE, UNIT) 
VALUES (SEQ_PRODUCT_ID.NEXTVAL, '포도씨 오일', 'RAW', 'g');

INSERT INTO PRODUCT (PRODUCT_ID, PRODUCT_NAME, PRODUCT_TYPE, UNIT) 
VALUES (SEQ_PRODUCT_ID.NEXTVAL, '콩유', 'RAW', 'g');

INSERT INTO PRODUCT (PRODUCT_ID, PRODUCT_NAME, PRODUCT_TYPE, UNIT) 
VALUES (SEQ_PRODUCT_ID.NEXTVAL, '녹차씨 오일', 'RAW', 'g');

INSERT INTO PRODUCT (PRODUCT_ID, PRODUCT_NAME, PRODUCT_TYPE, UNIT) 
VALUES (SEQ_PRODUCT_ID.NEXTVAL, '오이 각질제거비누', 'FINISHED', '개');

INSERT INTO PRODUCT (PRODUCT_ID, PRODUCT_NAME, PRODUCT_TYPE, UNIT) 
VALUES (SEQ_PRODUCT_ID.NEXTVAL, '오이 수축비누', 'FINISHED', '개');

-- 고객 데이터 삽입 (화장품/비누 관련 고객)
INSERT INTO CUSTOMER (CUSTOMER_ID, NAME, CONTACT, ADDRESS) 
VALUES (SEQ_CUSTOMER_ID.NEXTVAL, '천연비누샵', '02-5555-1234', '서울시 영등포구');

INSERT INTO CUSTOMER (CUSTOMER_ID, NAME, CONTACT, ADDRESS) 
VALUES (SEQ_CUSTOMER_ID.NEXTVAL, '오가닉스토어', '02-7777-8888', '서울시 강남구');

INSERT INTO CUSTOMER (CUSTOMER_ID, NAME, CONTACT, ADDRESS) 
VALUES (SEQ_CUSTOMER_ID.NEXTVAL, '자연주의화장품', '02-3333-9999', '서울시 서초구');

INSERT INTO CUSTOMER (CUSTOMER_ID, NAME, CONTACT, ADDRESS) 
VALUES (SEQ_CUSTOMER_ID.NEXTVAL, '오이스킨케어', '02-1111-2222', '부산시 해운대구');

INSERT INTO CUSTOMER (CUSTOMER_ID, NAME, CONTACT, ADDRESS) 
VALUES (SEQ_CUSTOMER_ID.NEXTVAL, '그린뷰티', '02-4444-6666', '서울시 마포구');

-- LOT 데이터 삽입 (오이비누 생산 LOT)
-- 오이 천연비누 LOT
INSERT INTO LOT (LOT_ID, PRODUCT_ID, QUANTITY, STATUS, QC_STATUS) 
SELECT SEQ_LOT_ID.NEXTVAL, p.PRODUCT_ID, 1000, 'IN_PROGRESS', 'PENDING'
FROM PRODUCT p WHERE p.PRODUCT_NAME = '오이 천연비누';

-- 오이 비누 베이스 LOT
INSERT INTO LOT (LOT_ID, PRODUCT_ID, QUANTITY, STATUS, QC_STATUS) 
SELECT SEQ_LOT_ID.NEXTVAL, p.PRODUCT_ID, 500, 'COMPLETED', 'PASSED'
FROM PRODUCT p WHERE p.PRODUCT_NAME = '오이 비누 베이스';

-- 신선 오이 LOT
INSERT INTO LOT (LOT_ID, PRODUCT_ID, QUANTITY, STATUS, QC_STATUS) 
SELECT SEQ_LOT_ID.NEXTVAL, p.PRODUCT_ID, 2000, 'IN_STOCK', 'PASSED'
FROM PRODUCT p WHERE p.PRODUCT_NAME = '신선 오이';

-- 오이 각질제거비누 LOT
INSERT INTO LOT (LOT_ID, PRODUCT_ID, QUANTITY, STATUS, QC_STATUS) 
SELECT SEQ_LOT_ID.NEXTVAL, p.PRODUCT_ID, 600, 'IN_PROGRESS', 'PENDING'
FROM PRODUCT p WHERE p.PRODUCT_NAME = '오이 각질제거비누';

-- 오이 수축비누 LOT
INSERT INTO LOT (LOT_ID, PRODUCT_ID, QUANTITY, STATUS, QC_STATUS) 
SELECT SEQ_LOT_ID.NEXTVAL, p.PRODUCT_ID, 800, 'COMPLETED', 'PASSED'
FROM PRODUCT p WHERE p.PRODUCT_NAME = '오이 수축비누';

-- BOM 데이터 삽입 (오이비누 제품 구성요소 관계)
-- 오이 천연비누 1개 = 오이 비누 베이스 0.15kg
INSERT INTO BOM (BOM_ID, PARENT_ID, CHILD_ID, QUANTITY) 
SELECT SEQ_BOM_ID.NEXTVAL, p1.PRODUCT_ID, p2.PRODUCT_ID, 0.15
FROM PRODUCT p1, PRODUCT p2 
WHERE p1.PRODUCT_NAME = '오이 천연비누' AND p2.PRODUCT_NAME = '오이 비누 베이스';

-- 오이 비누 베이스 1kg = 신선 오이 0.3kg
INSERT INTO BOM (BOM_ID, PARENT_ID, CHILD_ID, QUANTITY) 
SELECT SEQ_BOM_ID.NEXTVAL, p1.PRODUCT_ID, p2.PRODUCT_ID, 0.3
FROM PRODUCT p1, PRODUCT p2 
WHERE p1.PRODUCT_NAME = '오이 비누 베이스' AND p2.PRODUCT_NAME = '신선 오이';

-- 오이 비누 베이스 1kg = 가성소다 119g
INSERT INTO BOM (BOM_ID, PARENT_ID, CHILD_ID, QUANTITY) 
SELECT SEQ_BOM_ID.NEXTVAL, p1.PRODUCT_ID, p2.PRODUCT_ID, 119
FROM PRODUCT p1, PRODUCT p2 
WHERE p1.PRODUCT_NAME = '오이 비누 베이스' AND p2.PRODUCT_NAME = '가성소다';

-- 오이 비누 베이스 1kg = 팜 오일 200g
INSERT INTO BOM (BOM_ID, PARENT_ID, CHILD_ID, QUANTITY) 
SELECT SEQ_BOM_ID.NEXTVAL, p1.PRODUCT_ID, p2.PRODUCT_ID, 200
FROM PRODUCT p1, PRODUCT p2 
WHERE p1.PRODUCT_NAME = '오이 비누 베이스' AND p2.PRODUCT_NAME = '팜 오일';

-- 오이 비누 베이스 1kg = 올리브 오일 130g
INSERT INTO BOM (BOM_ID, PARENT_ID, CHILD_ID, QUANTITY) 
SELECT SEQ_BOM_ID.NEXTVAL, p1.PRODUCT_ID, p2.PRODUCT_ID, 130
FROM PRODUCT p1, PRODUCT p2 
WHERE p1.PRODUCT_NAME = '오이 비누 베이스' AND p2.PRODUCT_NAME = '올리브 오일';

-- 오이 비누 베이스 1kg = 포도씨 오일 80g
INSERT INTO BOM (BOM_ID, PARENT_ID, CHILD_ID, QUANTITY) 
SELECT SEQ_BOM_ID.NEXTVAL, p1.PRODUCT_ID, p2.PRODUCT_ID, 80
FROM PRODUCT p1, PRODUCT p2 
WHERE p1.PRODUCT_NAME = '오이 비누 베이스' AND p2.PRODUCT_NAME = '포도씨 오일';

-- 오이 비누 베이스 1kg = 콩유 80g
INSERT INTO BOM (BOM_ID, PARENT_ID, CHILD_ID, QUANTITY) 
SELECT SEQ_BOM_ID.NEXTVAL, p1.PRODUCT_ID, p2.PRODUCT_ID, 80
FROM PRODUCT p1, PRODUCT p2 
WHERE p1.PRODUCT_NAME = '오이 비누 베이스' AND p2.PRODUCT_NAME = '콩유';

-- 오이 비누 베이스 1kg = 녹차씨 오일 80g
INSERT INTO BOM (BOM_ID, PARENT_ID, CHILD_ID, QUANTITY) 
SELECT SEQ_BOM_ID.NEXTVAL, p1.PRODUCT_ID, p2.PRODUCT_ID, 80
FROM PRODUCT p1, PRODUCT p2 
WHERE p1.PRODUCT_NAME = '오이 비누 베이스' AND p2.PRODUCT_NAME = '녹차씨 오일';

-- 오이 각질제거비누 1개 = 오이 비누 베이스 0.18kg
INSERT INTO BOM (BOM_ID, PARENT_ID, CHILD_ID, QUANTITY) 
SELECT SEQ_BOM_ID.NEXTVAL, p1.PRODUCT_ID, p2.PRODUCT_ID, 0.18
FROM PRODUCT p1, PRODUCT p2 
WHERE p1.PRODUCT_NAME = '오이 각질제거비누' AND p2.PRODUCT_NAME = '오이 비누 베이스';

-- 오이 수축비누 1개 = 오이 비누 베이스 0.16kg
INSERT INTO BOM (BOM_ID, PARENT_ID, CHILD_ID, QUANTITY) 
SELECT SEQ_BOM_ID.NEXTVAL, p1.PRODUCT_ID, p2.PRODUCT_ID, 0.16
FROM PRODUCT p1, PRODUCT p2 
WHERE p1.PRODUCT_NAME = '오이 수축비누' AND p2.PRODUCT_NAME = '오이 비누 베이스';

-- 주문 데이터 삽입 (오이비누 관련 주문)
-- 천연비누샵: 오이 천연비누 200개
INSERT INTO ORDERS (ORDER_ID, CUSTOMER_ID, PRODUCT_ID, QUANTITY, STATUS) 
SELECT SEQ_ORDER_ID.NEXTVAL, c.CUSTOMER_ID, p.PRODUCT_ID, 200, 'PENDING'
FROM CUSTOMER c, PRODUCT p 
WHERE c.NAME = '천연비누샵' AND p.PRODUCT_NAME = '오이 천연비누';

-- 오가닉스토어: 오이 각질제거비누 100개
INSERT INTO ORDERS (ORDER_ID, CUSTOMER_ID, PRODUCT_ID, QUANTITY, STATUS) 
SELECT SEQ_ORDER_ID.NEXTVAL, c.CUSTOMER_ID, p.PRODUCT_ID, 100, 'CONFIRMED'
FROM CUSTOMER c, PRODUCT p 
WHERE c.NAME = '오가닉스토어' AND p.PRODUCT_NAME = '오이 각질제거비누';

-- 자연주의화장품: 오이 수축비누 150개
INSERT INTO ORDERS (ORDER_ID, CUSTOMER_ID, PRODUCT_ID, QUANTITY, STATUS) 
SELECT SEQ_ORDER_ID.NEXTVAL, c.CUSTOMER_ID, p.PRODUCT_ID, 150, 'IN_PRODUCTION'
FROM CUSTOMER c, PRODUCT p 
WHERE c.NAME = '자연주의화장품' AND p.PRODUCT_NAME = '오이 수축비누';

-- 오이스킨케어: 오이 천연비누 300개
INSERT INTO ORDERS (ORDER_ID, CUSTOMER_ID, PRODUCT_ID, QUANTITY, STATUS) 
SELECT SEQ_ORDER_ID.NEXTVAL, c.CUSTOMER_ID, p.PRODUCT_ID, 300, 'PENDING'
FROM CUSTOMER c, PRODUCT p 
WHERE c.NAME = '오이스킨케어' AND p.PRODUCT_NAME = '오이 천연비누';

-- 그린뷰티: 오이 각질제거비누 80개
INSERT INTO ORDERS (ORDER_ID, CUSTOMER_ID, PRODUCT_ID, QUANTITY, STATUS) 
SELECT SEQ_ORDER_ID.NEXTVAL, c.CUSTOMER_ID, p.PRODUCT_ID, 80, 'CONFIRMED'
FROM CUSTOMER c, PRODUCT p 
WHERE c.NAME = '그린뷰티' AND p.PRODUCT_NAME = '오이 각질제거비누';

-- 생산 이력 데이터 삽입 (오이비누 생산 공정)
-- 오이 천연비누 LOT의 오이 추출물 제조
INSERT INTO PRODUCTION_HISTORY (HISTORY_ID, LOT_ID, STEP_NAME, START_TIME, END_TIME, OPERATOR, STATUS) 
SELECT SEQ_HISTORY_ID.NEXTVAL, l.LOT_ID, '오이 추출물 제조', SYSDATE-2, SYSDATE-1, '김화학', 'COMPLETED'
FROM LOT l, PRODUCT p 
WHERE l.PRODUCT_ID = p.PRODUCT_ID AND p.PRODUCT_NAME = '오이 천연비누';

-- 오이 천연비누 LOT의 비누 베이스 혼합
INSERT INTO PRODUCTION_HISTORY (HISTORY_ID, LOT_ID, STEP_NAME, START_TIME, END_TIME, OPERATOR, STATUS) 
SELECT SEQ_HISTORY_ID.NEXTVAL, l.LOT_ID, '비누 베이스 혼합', SYSDATE-1, NULL, '이혼합', 'IN_PROGRESS'
FROM LOT l, PRODUCT p 
WHERE l.PRODUCT_ID = p.PRODUCT_ID AND p.PRODUCT_NAME = '오이 천연비누';

-- 오이 각질제거비누 LOT의 오이 추출물 추출
INSERT INTO PRODUCTION_HISTORY (HISTORY_ID, LOT_ID, STEP_NAME, START_TIME, END_TIME, OPERATOR, STATUS) 
SELECT SEQ_HISTORY_ID.NEXTVAL, l.LOT_ID, '오이 추출물 추출', SYSDATE-3, SYSDATE-2, '박추출', 'COMPLETED'
FROM LOT l, PRODUCT p 
WHERE l.PRODUCT_ID = p.PRODUCT_ID AND p.PRODUCT_NAME = '오이 각질제거비누';

-- 오이 각질제거비누 LOT의 각질제거비누 제형 제조
INSERT INTO PRODUCTION_HISTORY (HISTORY_ID, LOT_ID, STEP_NAME, START_TIME, END_TIME, OPERATOR, STATUS) 
SELECT SEQ_HISTORY_ID.NEXTVAL, l.LOT_ID, '각질제거비누 제형 제조', SYSDATE-2, NULL, '최제형', 'IN_PROGRESS'
FROM LOT l, PRODUCT p 
WHERE l.PRODUCT_ID = p.PRODUCT_ID AND p.PRODUCT_NAME = '오이 각질제거비누';

-- 오이 수축비누 LOT의 수축비누 성형
INSERT INTO PRODUCTION_HISTORY (HISTORY_ID, LOT_ID, STEP_NAME, START_TIME, END_TIME, OPERATOR, STATUS) 
SELECT SEQ_HISTORY_ID.NEXTVAL, l.LOT_ID, '수축비누 성형', SYSDATE-1, SYSDATE, '정성형', 'COMPLETED'
FROM LOT l, PRODUCT p 
WHERE l.PRODUCT_ID = p.PRODUCT_ID AND p.PRODUCT_NAME = '오이 수축비누';

-- 오이 수축비누 LOT의 품질검사
INSERT INTO PRODUCTION_HISTORY (HISTORY_ID, LOT_ID, STEP_NAME, START_TIME, END_TIME, OPERATOR, STATUS) 
SELECT SEQ_HISTORY_ID.NEXTVAL, l.LOT_ID, '품질검사', SYSDATE, NULL, '한검사', 'IN_PROGRESS'
FROM LOT l, PRODUCT p 
WHERE l.PRODUCT_ID = p.PRODUCT_ID AND p.PRODUCT_NAME = '오이 수축비누';

-- KPI 데이터 삽입 (오이비누 업종 KPI)
INSERT INTO KPI (KPI_ID, KPI_NAME, TARGET_VALUE, ACTUAL_VALUE) 
VALUES (SEQ_KPI_ID.NEXTVAL, '일일 오이비누 생산량', 1000, 950);

INSERT INTO KPI (KPI_ID, KPI_NAME, TARGET_VALUE, ACTUAL_VALUE) 
VALUES (SEQ_KPI_ID.NEXTVAL, '오이 각질제거비누 생산량', 600, 580);

INSERT INTO KPI (KPI_ID, KPI_NAME, TARGET_VALUE, ACTUAL_VALUE) 
VALUES (SEQ_KPI_ID.NEXTVAL, '오이 수축비누 생산량', 800, 780);

INSERT INTO KPI (KPI_ID, KPI_NAME, TARGET_VALUE, ACTUAL_VALUE) 
VALUES (SEQ_KPI_ID.NEXTVAL, '품질 합격률', 95, 98);

INSERT INTO KPI (KPI_ID, KPI_NAME, TARGET_VALUE, ACTUAL_VALUE) 
VALUES (SEQ_KPI_ID.NEXTVAL, '납기 준수율', 90, 92);

INSERT INTO KPI (KPI_ID, KPI_NAME, TARGET_VALUE, ACTUAL_VALUE) 
VALUES (SEQ_KPI_ID.NEXTVAL, '원자재 재고 회전율', 15, 12);

INSERT INTO KPI (KPI_ID, KPI_NAME, TARGET_VALUE, ACTUAL_VALUE) 
VALUES (SEQ_KPI_ID.NEXTVAL, '오이 추출 효율성', 85, 88);

-- BOM LOT 데이터 삽입 (오이비누 BOM 구성요소별 LOT)
-- 오이 천연비누 LOT: 오이 비누 베이스 0.15kg
INSERT INTO BOM_LOT (BOM_LOT_ID, PARENT_ID, CHILD_ID, QUANTITY) 
SELECT SEQ_BOM_LOT_ID.NEXTVAL, p1.PRODUCT_ID, p2.PRODUCT_ID, 0.15
FROM PRODUCT p1, PRODUCT p2 
WHERE p1.PRODUCT_NAME = '오이 천연비누' AND p2.PRODUCT_NAME = '오이 비누 베이스';

-- 오이 천연비누 LOT: 가성소다 17.85g (119g * 0.15)
INSERT INTO BOM_LOT (BOM_LOT_ID, PARENT_ID, CHILD_ID, QUANTITY) 
SELECT SEQ_BOM_LOT_ID.NEXTVAL, p1.PRODUCT_ID, p2.PRODUCT_ID, 17.85
FROM PRODUCT p1, PRODUCT p2 
WHERE p1.PRODUCT_NAME = '오이 천연비누' AND p2.PRODUCT_NAME = '가성소다';

-- 오이 각질제거비누 LOT: 오이 비누 베이스 0.18kg
INSERT INTO BOM_LOT (BOM_LOT_ID, PARENT_ID, CHILD_ID, QUANTITY) 
SELECT SEQ_BOM_LOT_ID.NEXTVAL, p1.PRODUCT_ID, p2.PRODUCT_ID, 0.18
FROM PRODUCT p1, PRODUCT p2 
WHERE p1.PRODUCT_NAME = '오이 각질제거비누' AND p2.PRODUCT_NAME = '오이 비누 베이스';

-- 오이 수축비누 LOT: 오이 비누 베이스 0.16kg
INSERT INTO BOM_LOT (BOM_LOT_ID, PARENT_ID, CHILD_ID, QUANTITY) 
SELECT SEQ_BOM_LOT_ID.NEXTVAL, p1.PRODUCT_ID, p2.PRODUCT_ID, 0.16
FROM PRODUCT p1, PRODUCT p2 
WHERE p1.PRODUCT_NAME = '오이 수축비누' AND p2.PRODUCT_NAME = '오이 비누 베이스';

-- =====================================================
-- 4. 조회 쿼리 (SELECT) - 오이비누 업종별 조회
-- =====================================================

-- 제품별 LOT 현황 조회
SELECT 
    p.PRODUCT_NAME AS "제품명",
    p.PRODUCT_TYPE AS "제품유형",
    l.LOT_ID AS "LOT번호",
    l.QUANTITY AS "수량",
    l.STATUS AS "상태",
    l.QC_STATUS AS "품질검사상태"
FROM PRODUCT p
JOIN LOT l ON p.PRODUCT_ID = l.PRODUCT_ID
ORDER BY p.PRODUCT_TYPE, p.PRODUCT_NAME;

-- BOM 트리 구조 조회 (오이비누 제품 구성요소 관계)
SELECT 
    parent.PRODUCT_NAME AS "상위제품",
    child.PRODUCT_NAME AS "하위제품",
    b.QUANTITY AS "필요수량",
    child.UNIT AS "단위"
FROM BOM b
JOIN PRODUCT parent ON b.PARENT_ID = parent.PRODUCT_ID
JOIN PRODUCT child ON b.CHILD_ID = child.PRODUCT_ID
ORDER BY parent.PRODUCT_NAME;

-- 고객별 주문 현황 조회
SELECT 
    c.NAME AS "고객명",
    p.PRODUCT_NAME AS "제품명",
    o.QUANTITY AS "주문수량",
    o.ORDER_DATE AS "주문일",
    o.STATUS AS "주문상태"
FROM ORDERS o
JOIN CUSTOMER c ON o.CUSTOMER_ID = c.CUSTOMER_ID
JOIN PRODUCT p ON o.PRODUCT_ID = p.PRODUCT_ID
ORDER BY o.ORDER_DATE DESC;

-- LOT별 생산 이력 조회
SELECT 
    l.LOT_ID AS "LOT번호",
    p.PRODUCT_NAME AS "제품명",
    ph.STEP_NAME AS "공정단계",
    ph.START_TIME AS "시작시간",
    ph.END_TIME AS "종료시간",
    ph.OPERATOR AS "작업자",
    ph.STATUS AS "상태"
FROM LOT l
JOIN PRODUCT p ON l.PRODUCT_ID = p.PRODUCT_ID
LEFT JOIN PRODUCTION_HISTORY ph ON l.LOT_ID = ph.LOT_ID
ORDER BY l.LOT_ID, ph.START_TIME;

-- 제품별 원자재 소요량 계산 (BOM 기반)
SELECT 
    p.PRODUCT_NAME AS "제품명",
    raw.PRODUCT_NAME AS "원자재명",
    SUM(b.QUANTITY) AS "총소요량",
    raw.UNIT AS "단위"
FROM PRODUCT p
JOIN BOM b ON p.PRODUCT_ID = b.PARENT_ID
JOIN PRODUCT raw ON b.CHILD_ID = raw.PRODUCT_ID
WHERE raw.PRODUCT_TYPE = 'RAW'
GROUP BY p.PRODUCT_NAME, raw.PRODUCT_NAME, raw.UNIT
ORDER BY p.PRODUCT_NAME;

-- 오이비누 업종별 생산 현황 조회
SELECT 
    CASE 
        WHEN p.PRODUCT_NAME LIKE '%천연비누%' THEN '기본 비누'
        WHEN p.PRODUCT_NAME LIKE '%각질제거비누%' THEN '각질 제거 비누'
        WHEN p.PRODUCT_NAME LIKE '%수축비누%' THEN '수축 비누'
        ELSE '기타'
    END AS "비누유형",
    p.PRODUCT_NAME AS "제품명",
    l.QUANTITY AS "생산수량",
    l.STATUS AS "생산상태"
FROM PRODUCT p
JOIN LOT l ON p.PRODUCT_ID = l.PRODUCT_ID
ORDER BY "비누유형", p.PRODUCT_NAME;

-- BOM LOT 구성요소 조회
SELECT 
    parent.PRODUCT_NAME AS "상위제품",
    child.PRODUCT_NAME AS "하위제품",
    bl.QUANTITY AS "필요수량",
    bl.CREATED_AT AS "LOT생성일"
FROM BOM_LOT bl
JOIN PRODUCT parent ON bl.PARENT_ID = parent.PRODUCT_ID
JOIN PRODUCT child ON bl.CHILD_ID = child.PRODUCT_ID
ORDER BY parent.PRODUCT_NAME, child.PRODUCT_NAME;

-- =====================================================
-- 5. 수정 쿼리 (UPDATE) - 데이터 업데이트 예시
-- =====================================================

-- LOT 상태 업데이트 (생산 완료 시)
UPDATE LOT 
SET STATUS = 'COMPLETED', 
    QC_STATUS = 'PASSED'
WHERE LOT_ID = 1;

-- 주문 상태 업데이트 (출하 시)
UPDATE ORDERS 
SET STATUS = 'SHIPPED'
WHERE ORDER_ID = 1;

-- 생산 이력 완료 시간 업데이트
UPDATE PRODUCTION_HISTORY 
SET END_TIME = SYSDATE,
    STATUS = 'COMPLETED'
WHERE HISTORY_ID = 1;

-- =====================================================
-- 6. 삭제 쿼리 (DELETE) - 데이터 삭제 예시
-- =====================================================

-- 특정 LOT 삭제 (주의: 외래키 제약조건 확인 필요)
-- DELETE FROM LOT WHERE LOT_ID = 1;

-- 특정 제품 삭제 (주의: 외래키 제약조건 확인 필요)
-- DELETE FROM PRODUCT WHERE PRODUCT_ID = 1;

-- =====================================================
-- 7. 인덱스 생성 (성능 향상을 위한 인덱스)
-- =====================================================

-- PRODUCT 테이블 인덱스
CREATE INDEX IDX_PRODUCT_TYPE ON PRODUCT(PRODUCT_TYPE);    -- 제품유형별 검색 성능 향상
CREATE INDEX IDX_PRODUCT_NAME ON PRODUCT(PRODUCT_NAME);    -- 제품명 검색 성능 향상

-- LOT 테이블 인덱스
CREATE INDEX IDX_LOT_PRODUCT ON LOT(PRODUCT_ID);           -- 제품별 LOT 검색 성능 향상
CREATE INDEX IDX_LOT_STATUS ON LOT(STATUS);                -- 상태별 LOT 검색 성능 향상
CREATE INDEX IDX_LOT_QC_STATUS ON LOT(QC_STATUS);          -- 품질검사상태별 검색 성능 향상

-- ORDER 테이블 인덱스
CREATE INDEX IDX_ORDER_CUSTOMER ON ORDERS(CUSTOMER_ID);    -- 고객별 주문 검색 성능 향상
CREATE INDEX IDX_ORDER_DATE ON ORDERS(ORDER_DATE);         -- 주문일별 검색 성능 향상
CREATE INDEX IDX_ORDER_STATUS ON ORDERS(STATUS);           -- 주문상태별 검색 성능 향상

-- BOM 테이블 인덱스
CREATE INDEX IDX_BOM_PARENT ON BOM(PARENT_ID);             -- 상위제품별 BOM 검색 성능 향상
CREATE INDEX IDX_BOM_CHILD ON BOM(CHILD_ID);               -- 하위제품별 BOM 검색 성능 향상

-- PRODUCTION_HISTORY 테이블 인덱스
CREATE INDEX IDX_HISTORY_LOT ON PRODUCTION_HISTORY(LOT_ID); -- LOT별 이력 검색 성능 향상
CREATE INDEX IDX_HISTORY_DATE ON PRODUCTION_HISTORY(START_TIME); -- 날짜별 이력 검색 성능 향상

-- BOM_LOT 테이블 인덱스
CREATE INDEX IDX_BOM_LOT_PARENT ON BOM_LOT(PARENT_ID);     -- 상위제품별 BOM LOT 검색 성능 향상
CREATE INDEX IDX_BOM_LOT_CHILD ON BOM_LOT(CHILD_ID);       -- 하위제품별 BOM LOT 검색 성능 향상

-- =====================================================
-- 8. 뷰 생성 (자주 사용하는 복잡한 쿼리를 뷰로 생성)
-- =====================================================

-- 제품별 재고 현황 뷰
CREATE VIEW V_PRODUCT_INVENTORY AS
SELECT 
    p.PRODUCT_ID,
    p.PRODUCT_NAME,
    p.PRODUCT_TYPE,
    p.UNIT,
    NVL(SUM(l.QUANTITY), 0) AS TOTAL_QUANTITY,
    COUNT(l.LOT_ID) AS LOT_COUNT
FROM PRODUCT p
LEFT JOIN LOT l ON p.PRODUCT_ID = l.PRODUCT_ID
GROUP BY p.PRODUCT_ID, p.PRODUCT_NAME, p.PRODUCT_TYPE, p.UNIT;

-- 오이비누 업종별 재고 현황 뷰
CREATE VIEW V_INDUSTRY_INVENTORY AS
SELECT 
    CASE 
        WHEN p.PRODUCT_NAME LIKE '%천연비누%' THEN '기본 비누'
        WHEN p.PRODUCT_NAME LIKE '%각질제거비누%' THEN '각질 제거 비누'
        WHEN p.PRODUCT_NAME LIKE '%수축비누%' THEN '수축 비누'
        ELSE '기타'
    END AS SOAP_TYPE,
    p.PRODUCT_TYPE,
    SUM(NVL(l.QUANTITY, 0)) AS TOTAL_INVENTORY,
    COUNT(DISTINCT p.PRODUCT_ID) AS PRODUCT_COUNT
FROM PRODUCT p
LEFT JOIN LOT l ON p.PRODUCT_ID = l.PRODUCT_ID
GROUP BY 
    CASE 
        WHEN p.PRODUCT_NAME LIKE '%천연비누%' THEN '기본 비누'
        WHEN p.PRODUCT_NAME LIKE '%각질제거비누%' THEN '각질 제거 비누'
        WHEN p.PRODUCT_NAME LIKE '%수축비누%' THEN '수축 비누'
        ELSE '기타'
    END,
    p.PRODUCT_TYPE;

-- 고객별 주문 요약 뷰
CREATE VIEW V_CUSTOMER_ORDER_SUMMARY AS
SELECT 
    c.CUSTOMER_ID,
    c.NAME AS CUSTOMER_NAME,
    COUNT(o.ORDER_ID) AS ORDER_COUNT,
    SUM(o.QUANTITY) AS TOTAL_QUANTITY,
    MAX(o.ORDER_DATE) AS LAST_ORDER_DATE
FROM CUSTOMER c
LEFT JOIN ORDERS o ON c.CUSTOMER_ID = o.CUSTOMER_ID
GROUP BY c.CUSTOMER_ID, c.NAME;

-- =====================================================
-- 9. 권한 설정 (사용자별 접근 권한 설정)
-- =====================================================

-- MES 시스템 사용자에게 테이블 접근 권한 부여
-- GRANT SELECT, INSERT, UPDATE, DELETE ON PRODUCT TO mes_user;
-- GRANT SELECT, INSERT, UPDATE, DELETE ON LOT TO mes_user;
-- GRANT SELECT, INSERT, UPDATE, DELETE ON CUSTOMER TO mes_user;
-- GRANT SELECT, INSERT, UPDATE, DELETE ON BOM TO mes_user;
-- GRANT SELECT, INSERT, UPDATE, DELETE ON PRODUCTION_HISTORY TO mes_user;
-- GRANT SELECT, INSERT, UPDATE, DELETE ON ORDERS TO mes_user;
-- GRANT SELECT, INSERT, UPDATE, DELETE ON KPI TO mes_user;

-- =====================================================
-- 10. 데이터베이스 설정 완료 확인
-- =====================================================

-- 생성된 테이블 목록 확인
SELECT TABLE_NAME FROM USER_TABLES WHERE TABLE_NAME LIKE '%MES%' OR TABLE_NAME IN ('PRODUCT', 'LOT', 'CUSTOMER', 'BOM', 'BOM_LOT', 'PRODUCTION_HISTORY', 'ORDERS', 'KPI');

-- 생성된 시퀀스 목록 확인
SELECT SEQUENCE_NAME FROM USER_SEQUENCES WHERE SEQUENCE_NAME LIKE 'SEQ_%';

-- 생성된 인덱스 목록 확인
SELECT INDEX_NAME, TABLE_NAME FROM USER_INDEXES WHERE TABLE_NAME IN ('PRODUCT', 'LOT', 'CUSTOMER', 'BOM', 'BOM_LOT', 'PRODUCTION_HISTORY', 'ORDERS', 'KPI');

-- =====================================================
-- MES 시스템 데이터베이스 설정 완료 (오이비누 제조업 특화)
-- =====================================================
-- 이 파일을 실행하면 오이비누 제조업 MES 시스템에 필요한 모든 테이블, 시퀀스, 
-- 샘플 데이터, 인덱스가 생성됩니다.
-- 
-- 주요 기능:
-- 1. 제품 관리 (완제품/반제품/원자재)
--    - 비누 제품 (오이 천연비누, 오이 각질제거비누, 오이 수축비누)
--    - 반제품 (오이 비누 베이스, 오이 추출물)
--    - 원자재 (신선 오이, 가성소다, 팜 오일, 올리브 오일, 포도씨 오일, 콩유, 녹차씨 오일)
-- 2. LOT 생산 이력 추적
--    - 비누 제조 이력 (오이 추출, 베이스 혼합, 성형, 건조)
--    - 각종 기능성 비누별 생산 이력 추적
-- 3. BOM(자재 명세서) 관리
--    - 오이 천연비누: 오이 비누 베이스 + 가성소다 119g + 팜 오일 200g + 올리브 오일 130g + 포도씨 오일 80g + 콩유 80g + 녹차씨 오일 80g
--    - 오이 각질제거비누: 오이 비누 베이스 (각질 제거 기능)
--    - 오이 수축비누: 오이 비누 베이스 (수축 기능)
-- 4. BOM LOT 관리
--    - BOM 구성요소별 LOT 추적
--    - 상위제품-하위제품 관계별 LOT 관리
-- 5. 고객/주문 관리
--    - 천연비누샵, 오가닉스토어, 자연주의화장품, 오이스킨케어, 그린뷰티
--    - 각종 오이비누 제품 주문
-- 6. 생산 이력 관리
--    - 비누별 공정 단계 추적 (추출, 혼합, 성형, 건조, 품질검사)
--    - 작업자별 생산 이력 관리
-- 7. KPI 성과 지표 관리
--    - 비누별 생산량, 품질, 납기 준수율
--    - 원자재 재고 회전율, 오이 추출 효율성
-- =====================================================
