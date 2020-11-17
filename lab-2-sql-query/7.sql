# Визначіть дні, коли було виконано максимальну кількість рейсів
# з міста 'Rostov'. Вивести: date, число рейсів.

USE labor_sql;

SELECT pass_in_trip.date, Count(trip.plane)
FROM pass_in_trip
JOIN trip USING(trip_no)
GROUP BY pass_in_trip.date, trip.town_from
HAVING trip.town_from = 'Rostov'
ORDER BY Count(trip.plane) DESC
LIMIT 1;
