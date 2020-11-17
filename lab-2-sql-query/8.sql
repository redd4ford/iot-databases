# Знайдіть виробників, які б випускали ноутбуки з мінімальною швидкістю
# не менше 600 МГц. Вивести: maker, мінімальна швидкість.

USE labor_sql;

SELECT maker, MIN(laptop.speed)
FROM product
JOIN laptop USING(model)
WHERE laptop.speed >= 600
GROUP BY maker;