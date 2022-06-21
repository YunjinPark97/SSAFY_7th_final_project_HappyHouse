ALTER TABLE `ssafyweb`.`board` 
ADD COLUMN `love` INT NOT NULL DEFAULT '0' AFTER `regtime`,
ADD COLUMN `dislike` INT NOT NULL DEFAULT '0' AFTER `love`;