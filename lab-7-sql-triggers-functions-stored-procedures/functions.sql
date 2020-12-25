use family_db;

SET GLOBAL log_bin_trust_function_creators = 1;

-- №1: для FAMILY_VALUES шукати MAX стовпця max_price.

drop function if exists get_max_max_price;

DELIMITER //
create function get_max_max_price()
returns varchar(30)
begin
return (
	select MAX(max_price)
    from family_values
);
end //
DELIMITER ;

-- №2: функція, яка стягує за ключем між SEX та FAMILY_TREE значення поля SEX.

drop function if exists get_sex_name;

DELIMITER //
create function get_sex_name(
family_id int
)
returns varchar(30)
begin
return (
	select s1.name 
	from family_tree f
	left join sex s1 on f.sex_id = s1.id
    where f.id = family_id
);
end //
DELIMITER ;

-- вибірка даних

select get_max_max_price();
select *, get_sex_name(f.id) as sex_name from family_tree f;