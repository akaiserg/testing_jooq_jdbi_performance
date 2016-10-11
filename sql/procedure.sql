CREATE DEFINER=`root`@`localhost` PROCEDURE `test`.`test`(IN NumRows INT)
    READS SQL DATA
BEGIN
  DECLARE i INT;
  SET i = 1;
  START TRANSACTION;
  WHILE i <= NumRows DO
    INSERT INTO info (name) VALUES ((sha2(rand(), 256)));
    SET i = i + 1;
  END WHILE;
  commit;
END