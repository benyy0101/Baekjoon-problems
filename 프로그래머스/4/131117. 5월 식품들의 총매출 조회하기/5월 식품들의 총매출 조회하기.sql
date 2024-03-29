-- 코드를 입력하세요
SELECT PRODUCT_ID,PRODUCT_NAME,sum(amount) * price as TOTAL_SALES from FOOD_PRODUCT t1 left join FOOD_ORDER t2 using(product_id)
where date_format(t2.produce_date, "%Y-%m") = '2022-05'
group by product_id
order by TOTAL_SALES desc, product_id