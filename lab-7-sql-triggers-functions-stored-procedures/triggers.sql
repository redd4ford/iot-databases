use family_db;

-- №2: для credit_card_number забезпечити формат: хххх хххх хххх хххх

drop trigger if exists card_format;

DELIMITER //
create trigger card_format
    before insert
    on family_tree
    for each row
begin
    if (new.credit_card_number not rlike '^(([0-9]{4} ){3}[0-9]{4})$') then
		signal sqlstate '45000'
        set message_text = 'credit card does not match provided pattern!';
    end if;
end
//
DELIMITER ;

-- №3: значення max_price не може бути меншим за min_price; estimated_price має знаходитись
--     між min_price та max_price відповідно

drop trigger if exists items_price;

DELIMITER //
create trigger items_price
    before insert
    on family_values
    for each row
begin
    if (new.max_price < new.min_price) then
        signal sqlstate '45000'
        set message_text = 'min_price value cannot be greater than max_price';
	end if;
    if (new.estimated_price > new.max_price) then
		signal sqlstate '45000'
        set message_text = 'estimated_price value cannot be greater than max_price';
	end if;
    if (new.estimated_price < new.min_price) then
		signal sqlstate '45000'
        set message_text = 'estimated price value cannot be less than min_price';
	end if;
end
//
DELIMITER ;


-- №4: при вставці значень доповнювати surname значенням автоінкрементованого стовпця

-- create trigger update_surname
--   before insert
--     on family_tree
--     for each row
-- begin
--   set new.surname := CONCAT(new.surname, (
--   select `auto_increment` 
--   from INFORMATION_SCHEMA.TABLES    
--   where table_name = 'family_tree')
-- );
-- end
-- //
-- DELIMITER ;

-- DELIMITER //
-- create trigger update_surname
--   before insert
--     on family_tree
--     for each row
-- begin
-- 	if (select MAX(id) from family_tree) is not NULL then
-- 		set @ids = (select MAX(id) from family_tree) + 1;
-- 	else begin
-- 		set @ids = 1;
-- 		end;
-- 	end if;

-- 	set new.surname := CONCAT(new.surname, @ids);
-- end
-- //
-- DELIMITER ;

drop trigger if exists update_surname;

set @ids = (select `auto_increment` 
      from INFORMATION_SCHEMA.TABLES    
      where table_name = 'family_tree');

DELIMITER //
create trigger update_surname
  before insert
    on family_tree
    for each row
begin
  set new.surname := CONCAT(new.surname, @ids);
  set @ids = @ids + 1;
end
//
DELIMITER ;

-- №1: забезпечити цілісність даних

drop trigger if exists partnerIns;

DELIMITER //
create trigger partnerIns
	before insert
    on family_life_partners
    for each row
begin
	    if (new.sex_id not in (select id from sex)) then
		signal sqlstate '45000'
        set message_text = 'FK error. no such sex found';
	end if;
end
// DELIMITER ;


drop trigger if exists partnerUpd;

DELIMITER //
create trigger partnerUpd
	before update
    on family_life_partners
    for each row
begin
	    if (new.id != old.id and old in (select id from family_life_partners)) then
		signal sqlstate '45000'
        set message_text = 'FK error. no such partner found';
	end if;
end
// DELIMITER ;

drop trigger if exists partnerDel;

DELIMITER //
create trigger partnerDel
	before delete
    on family_life_partners
    for each row
begin
	    if (old.id in (select family_life_partners_id from family_tree)) then
		signal sqlstate '45000'
        set message_text = 'you cannot die without a partner';
	end if;
end
// DELIMITER ;



/* TREE INTEGRITY */

drop trigger if exists treeIns;

DELIMITER //
create trigger treeIns
	before insert
    on family_tree
    for each row
begin
	    if (new.sex_id not in (select id from sex)) then
			signal sqlstate '45000'
			set message_text = 'FK error. no such sex found';
        end if;
        if (new.family_life_partners_id not in (select id from family_life_partners)) then
			signal sqlstate '45000'
			set message_text = 'FK error. no such partner found';
        end if;
        if (new.ancector_id not in (select id from family_tree))
			then
            set new.ancector_id = NULL;
        end if;
end
// DELIMITER ;


drop trigger if exists treeUpd;

DELIMITER //
create trigger treeUpd
	before update
    on family_tree
    for each row
begin
    if (new.id != old.id and old in (select id from family_tree)) then
		signal sqlstate '45000'
        set message_text = 'no such tree found';
	end if;
end
// DELIMITER ;

drop trigger if exists treeDel;

DELIMITER //
create trigger treeDel
	before delete
    on family_tree
    for each row
begin
	    if (old.id in (select family_tree_id from member_has_value)) then
		signal sqlstate '45000'
        set message_text = 'this family has values, you cannot delete them';
	end if;
end
// DELIMITER ;


/* SEX INTEGRITY */

drop trigger if exists sexUpd;

DELIMITER //
create trigger sexUpd
	before update
    on sex
    for each row
begin
    if (new.id != old.id and old in (select id from sex)) then
		signal sqlstate '45000'
        set message_text = 'no such sex found';
	end if;
end
// DELIMITER ;

drop trigger if exists sexDel;

DELIMITER //
create trigger sexDel
	before delete
    on sex
    for each row
begin
	if (old.id in (select sex_id from family_life_partners)) then
		signal sqlstate '45000'
        set message_text = 'there is at least one person with such sex, you cannot delete it';
	end if;
end
// DELIMITER ;


/* VALUES INTEGRITY */

drop trigger if exists valueUpd;

DELIMITER //
create trigger valueUpd
	before update
    on family_values
    for each row
begin
    if (new.id != old.id and old in (select id from family_values)) then
		signal sqlstate '45000'
        set message_text = 'no such value found';
	end if;
end
// DELIMITER ;

drop trigger if exists valueDel;

DELIMITER //
create trigger valueDel
	before delete
    on family_values
    for each row
begin
	if (old.id in (select family_values_id from member_has_value)) then
		signal sqlstate '45000'
        set message_text = 'this value belongs to somebody, you cannot delete it';
	end if;
end
// DELIMITER ;

/* MEMBER_HAS_VALUE INTEGRITY */

drop trigger if exists memIns;

DELIMITER //
create trigger memIns
	before insert
    on member_has_value
    for each row
begin
	if (new.family_tree_id not in (select id from family_tree)) then
		signal sqlstate '45000'
        set message_text = 'FK error. no such family_tree found';
	end if;
    if (new.family_values_id not in (select id from family_values)) then
		signal sqlstate '45000'
        set message_text = 'FK error. no such family_value found';
	end if;
end
// DELIMITER ;


drop trigger if exists memUpd;

DELIMITER //
create trigger memUpd
	before update
    on member_has_value
    for each row
begin
	if (new.id != old.id and old.id in (select id from member_has_value)) then
		signal sqlstate '45000'
        set message_text = 'no such link in the linking table';
	end if;
end
// DELIMITER ;
