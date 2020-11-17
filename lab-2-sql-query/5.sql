# Знайдіть виробників, які б випускали ноутбуки зі швидкістю
# 500 МГц та нижче. Виведіть: maker.

USE labor_sql;

SELECT DISTINCT product.maker
FROM product
JOIN laptop USING(model)
WHERE laptop.speed <= 500;