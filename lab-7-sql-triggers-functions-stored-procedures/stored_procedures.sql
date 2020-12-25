use family_db;

-- №1: параметризована вставка

drop procedure if exists insert_into_family_tree;

DELIMITER //
create procedure insert_into_family_tree (
	surname varchar(45),
    name varchar(45),
	credit_card_number varchar(45),
    birth_date date,
	birth_place varchar(45),
    death_date date,
    death_place varchar(45),
	sex_id int,
    family_life_partners_id int,
    ancestor_id int
)
begin
	insert into family_tree (
		surname, name, credit_card_number, birth_date, birth_place, death_date, death_place, sex_id, family_life_partners_id, ancector_id
    )
    values (
		surname, name, credit_card_number, birth_date, birth_place, death_date, death_place, sex_id, family_life_partners_id, ancestor_id
    );
end //
DELIMITER ;

-- №2: вивести дані зі стикувальної таблиці М:М, замінивши числові значення реальними назвами

drop procedure if exists print_many_to_many;

DELIMITER //
create procedure print_many_to_many()
begin
	select CONCAT(f.surname, ', ', f.name) as full_name, fi.name as value_name
	from member_has_value
	join family_tree f on f.id = family_tree_id
	join family_values fi on fi.id = family_values_id;
end //
DELIMITER ;

-- №3: динамічне створення 2х таблиць, ідентичних до FAMILY_TREE. випадковим чином пострічково
-- скопіювати стрічки таблиці FAMILY_TREE в одну з додаткових.

drop procedure if exists create_random_tables;

DELIMITER //
create procedure create_random_tables()
begin
	declare done bool default false;
    declare new_id, new_sex_id, new_family_life_partners_id, new_ancestor_id int;
    declare new_death_place, new_birth_place, new_surname, new_name, new_credit_card_number varchar(45);
    declare new_death_date, new_birth_date date;
    
	declare trees CURSOR
		for select * from family_tree;
	declare continue handler
		for not found set done = true;
	
    drop table if exists new_tree_1;
	drop table if exists new_tree_2;
    
    create table new_tree_1 like family_tree;
    create table new_tree_2 like family_tree;
    
    open trees;
    family_loop:
		LOOP
			fetch trees into new_id, new_surname, new_name, new_credit_card_number,
							 new_birth_date, new_birth_place, new_death_date,
							 new_death_place, new_sex_id, new_family_life_partners_id, new_ancestor_id;
			if done then
				leave family_loop;
			end if; 
        
			if rand() > 0.5 then
				insert into new_tree_1 (surname, name, credit_card_number, birth_date, birth_place, death_date,
									    death_place, sex_id, family_life_partners_id, ancector_id)
				values (
                         new_surname, new_name, new_credit_card_number, new_birth_date, new_birth_place, new_death_date,
						 new_death_place, new_sex_id, new_family_life_partners_id, new_ancestor_id
				);

			else
				insert into new_tree_2 (surname, name, credit_card_number, birth_date, birth_place, death_date,
									    death_place, sex_id, family_life_partners_id, ancector_id)
				values (
						 new_surname, new_name, new_credit_card_number, new_birth_date, new_birth_place, new_death_date,
						 new_death_place, new_sex_id, new_family_life_partners_id, new_ancestor_id
				);
			end if;
		END LOOP;
    close trees;
end //
DELIMITER ;