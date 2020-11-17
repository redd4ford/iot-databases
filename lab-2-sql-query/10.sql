# Знайдіть класи, у які входять лише один або два кораблі із цілої БД
# (врахувати також кораблі в таблиці Outcomes, яких немає в таблиці
# Ships). Вивести: class, кількість кораблів у класі.

USE labor_sql;

SELECT class, count(shp.name)
FROM (SELECT name, class
FROM ships
UNION
SELECT classes.class, outcomes.ship
FROM classes, outcomes
WHERE classes.class=outcomes.ship) shp
GROUP BY class
HAVING count(shp.name) = 1 OR count(shp.name) = 2;