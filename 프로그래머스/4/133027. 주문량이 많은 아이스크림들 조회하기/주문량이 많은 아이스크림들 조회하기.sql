SELECT FLAVOR
FROM (SELECT * FROM FIRST_HALF
    UNION SELECT * FROM JULY) AS TOTAL_TABLE
GROUP BY FLAVOR
ORDER BY SUM(TOTAL_ORDER) DESC
LIMIT 3;
