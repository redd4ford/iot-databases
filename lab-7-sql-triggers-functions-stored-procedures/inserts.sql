use family_db;

insert into sex (name)
values
		('female'),
		('male'),
        ('attack helicopter');


insert into family_life_partners (surname, name, birth_date, birth_place, death_date, death_place,
						marriage_date, sex_id)
values
		('Hall', 'Monica', '1990-01-01', 'Silicon Valley', '2070-01-01', 'Silicon Valley', '2025-01-01', 1),
        ('Bertram', 'Gilfoyle', '1990-01-01', 'Silicon Valley', '2070-01-02', 'Silicon Valley', '2020-01-01', 2),
        ('Belson', 'Gavin', '1990-01-01', 'Silicon Valley', '2030-01-01', 'Silicon Valley', '2020-05-05', 2);


insert into family_tree (surname, name, credit_card_number, birth_date, birth_place, death_date,
						death_place, sex_id, family_life_partners_id, ancector_id)
values
		('Hendriks', 'Richard', '1111 2222 3333 4444', '1990-01-01', 'Silicon Valley', '2070-01-01', 'Silicon Valley', 2, 1, null),
		('Chugtai', 'Dinesh', '5555 6666 7777 8888', '1990-01-01', 'Silicon Valley', '2070-01-01', 'Silicon Valley', 2, 2, 1),
        ('Dunn', 'Jared', '9999 1010 1111 1212', '1990-01-01', 'Silicon Valley', '2070-01-01', 'Silicon Valley', 2, 3, null);


insert into family_values (name, estimated_price, max_price, min_price, catalog_code)
values
		('Nothing', 1000, 1200, 0, 3),
        ('Hello world in brainfuck', 1000, 1500, 750, 2),
        ('Kind of Blue by Miles Davis', 500, 950, 300, 5);


insert into member_has_value (family_tree_id, family_values_id)
values
		(1, 1),
        (2, 1),
        (2, 2),
        (1, 3),
        (3, 3);