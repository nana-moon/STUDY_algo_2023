-- 코드를 입력하세요
SELECT product_code, SUM(price*sales_amount) as sales
FROM PRODUCT as a
JOIN OFFLINE_SALE as b
on a.PRODUCT_ID = b.PRODUCT_ID
GROUP BY product_code
ORDER BY sales desc, product_code;