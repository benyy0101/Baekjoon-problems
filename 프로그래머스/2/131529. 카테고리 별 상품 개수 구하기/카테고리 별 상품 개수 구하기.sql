-- 코드를 입력하세요
SELECT distinct left(PRODUCT_CODE,2) as CATEGORY, count(*) as PRODUCTS from product group by left(PRODUCT_CODE,2)