DROP TABLE IF EXISTS `ssafyweb`.`qna` ;

CREATE TABLE IF NOT EXISTS `ssafyweb`.`qna` (
  `articleno` INT NOT NULL AUTO_INCREMENT,
  `userid` VARCHAR(16) NULL DEFAULT NULL,
  `subject` VARCHAR(100) NULL DEFAULT NULL,
  `content` VARCHAR(2000) NULL DEFAULT NULL,
  `hit` INT NULL DEFAULT 0,
  `regtime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `secret` boolean DEFAULT 0,
  PRIMARY KEY (`articleno`),
  INDEX `qna_to_member_fk` (`userid` ASC) VISIBLE,
  CONSTRAINT `qna_to_member_fk`
    FOREIGN KEY (`userid`)
    REFERENCES `ssafyweb`.`ssafy_member` (`userid`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;