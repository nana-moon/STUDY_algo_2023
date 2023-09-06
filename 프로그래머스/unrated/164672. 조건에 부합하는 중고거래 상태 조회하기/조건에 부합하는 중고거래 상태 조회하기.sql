-- 코드를 입력하세요
-- 2022년 10월 5일에 등록된 중고거래 게시물의 게시글 ID, 작성자 ID, 게시글 제목, 가격, 거래상태
SELECT BOARD_ID,
       WRITER_ID, 
       TITLE, 
       PRICE, 
       CASE WHEN status = 'SALE' then '판매중'
       WHEN status = 'RESERVED' then '예약중'
       ELSE '거래완료'
       END as STATUS
FROM USED_GOODS_BOARD 
WHERE CREATED_DATE = '2022-10-05'
ORDER BY BOARD_ID DESC;