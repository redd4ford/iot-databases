# Визначити назви всіх кораблів із таблиці Ships, які задовольняють, у крайньому випадку,
# комбінації будь-яких чотирьох критеріїв із наступного списку: numGuns=8, bore=15,
# displacement=32000, type='bb', country='USA', launched=1915, class='Kongo'.
# Вивести: name, launched, class, numGuns, bore, displacement, type, country.

USE labor_sql;

SELECT shp.name, shp.launched, shp.class, clss.numGuns, clss.bore, clss.displacement, clss.type, clss.country
FROM ships AS shp
JOIN classes AS clss USING(class)
WHERE
(CASE WHEN clss.numGuns = 8 THEN 1 ELSE 0 END +
CASE WHEN clss.bore = 15 THEN 1 ELSE 0 END +
CASE WHEN clss.displacement = 32000 THEN 1 ELSE 0 END +
CASE WHEN clss.type = 'bb' THEN 1 ELSE 0 END +
CASE WHEN clss.country = 'USA' THEN 1 ELSE 0 END +
CASE WHEN shp.launched = 1915 THEN 1 ELSE 0 END +
CASE WHEN clss.class = 'Kongo' THEN 1 ELSE 0 END) >= 4;