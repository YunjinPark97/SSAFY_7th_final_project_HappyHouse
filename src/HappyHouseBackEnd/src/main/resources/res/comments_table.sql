CREATE TABLE IF NOT EXISTS `ssafyweb`.`qnacomment` (
  `commentno` INT NOT NULL AUTO_INCREMENT,
  `articleno` INT NULL DEFAULT NULL,
  `userid` VARCHAR(100) NULL DEFAULT NULL,
  `content` VARCHAR(2000) NULL DEFAULT NULL,
  `regtime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`commentno`),
    FOREIGN KEY (`articleno`)
    REFERENCES `ssafyweb`.`qna` (`articleno`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

desc qnacomment;
select * from qnacomment;

CREATE TABLE IF NOT EXISTS `ssafyweb`.`boardcomment` (
  `commentno` INT NOT NULL AUTO_INCREMENT,
  `articleno` INT NULL DEFAULT NULL,
  `userid` VARCHAR(100) NULL DEFAULT NULL,
  `content` VARCHAR(2000) NULL DEFAULT NULL,
  `regtime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`commentno`),
    FOREIGN KEY (`articleno`)
    REFERENCES `ssafyweb`.`board` (`articleno`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

desc boardcomment;
select * from boardcomment;

select *   
from boardcomment   
where articleno = 1 
order by commentno asc;

