# Для кораблів таблиці Ships вивести їх водотоннажність.

USE labor_sql;

SELECT displacement
FROM classes
JOIN ships USING(class);