# Вивести всі моделі ПК, у номерах яких є хоча б 2 одинички.

USE labor_sql;

SELECT model
FROM labor_sql.pc
WHERE model LIKE '%11%';