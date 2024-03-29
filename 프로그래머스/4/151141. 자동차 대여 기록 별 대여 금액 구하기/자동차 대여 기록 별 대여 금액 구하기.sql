-- 코드를 입력하세요
WITH C AS (
    SELECT A.HISTORY_ID, B.CAR_TYPE, B.DAILY_FEE, DATEDIFF(END_DATE, START_DATE) + 1 AS PERIOD,
    CASE
        WHEN DATEDIFF(END_DATE, START_DATE) + 1 >= 90 THEN '90일 이상'
        WHEN DATEDIFF(END_DATE, START_DATE) + 1 >= 30 THEN '30일 이상'
        WHEN DATEDIFF(END_DATE, START_DATE) + 1 >= 7 THEN '7일 이상'
        ELSE 'NONE' END AS DURATION_TYPE
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY AS A 
    JOIN CAR_RENTAL_COMPANY_CAR  AS B
    ON A.CAR_ID = B.CAR_ID
    WHERE CAR_TYPE = '트럭')
    


SELECT HISTORY_ID,
    ROUND(C.DAILY_FEE * C.PERIOD * (100 - IFNULL(D.DISCOUNT_RATE, 0)) / 100) AS FEE
FROM C  LEFT JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN AS D
ON  C.DURATION_TYPE = D.DURATION_TYPE AND C.CAR_TYPE = D.CAR_TYPE 
ORDER BY FEE DESC, HISTORY_ID DESC;