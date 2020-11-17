# Вивести значення таблиці Ships із коментарями, наприклад, 'name: California',
# 'class: Tennessee', 'launched: 1921'.

USE labor_sql;

SELECT CONCAT("name: ", name) AS "",
CONCAT("class: ", class) AS "",
CONCAT("launched: ", launched) AS ""
FROM ships;