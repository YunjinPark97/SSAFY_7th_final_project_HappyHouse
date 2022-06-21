CREATE TABLE IF NOT EXISTS `ssafyweb`.`boardlike` (
  `likeno` INT NOT NULL AUTO_INCREMENT,
  `userid` VARCHAR(100) NULL DEFAULT NULL,
  `articleno` INT NULL DEFAULT NULL,
  PRIMARY KEY (`likeno`),
    FOREIGN KEY (`userid`)
    REFERENCES `ssafyweb`.`ssafy_member` (`userid`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

desc boardlike;
select * from boardlike;

CREATE TABLE IF NOT EXISTS `ssafyweb`.`boarddislike` (
  `dislikeno` INT NOT NULL AUTO_INCREMENT,
  `userid` VARCHAR(100) NULL DEFAULT NULL,
  `articleno` INT NULL DEFAULT NULL,
  PRIMARY KEY (`dislikeno`),
    FOREIGN KEY (`userid`)
    REFERENCES `ssafyweb`.`ssafy_member` (`userid`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;