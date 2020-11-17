# Знайти моделі та ціни ноутбуків, вартість яких є вищою
# за вартість будь-якого ПК. Вивести model, price.

USE labor_sql;

SELECT price, model
FROM labor_sql.laptop
WHERE labor_sql.laptop.price > (SELECT MAX(price) FROM pc);