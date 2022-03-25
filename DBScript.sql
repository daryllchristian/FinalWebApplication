-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema inxdb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema inxdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `inxdb` DEFAULT CHARACTER SET utf8mb4 ;
USE `inxdb` ;

-- -----------------------------------------------------
-- Table `inxdb`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `inxdb`.`user` (
  `user_id` INT(11) NOT NULL AUTO_INCREMENT,
  `firstname` VARCHAR(45) NOT NULL,
  `middlename` VARCHAR(45) NULL DEFAULT NULL,
  `lastname` VARCHAR(45) NOT NULL,
  `gender` CHAR(6) NOT NULL,
  `dob` DATE NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `mobile_number` VARCHAR(10) CHARACTER SET 'utf8' NOT NULL,
  `picture` BLOB NOT NULL,
  `security_ans` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `inxdb`.`address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `inxdb`.`address` (
  `add_id` INT(11) NOT NULL AUTO_INCREMENT,
  `user_id` INT(11) NOT NULL,
  `line1` VARCHAR(45) NOT NULL,
  `line2` VARCHAR(45) NOT NULL,
  `city` VARCHAR(45) NOT NULL,
  `state` VARCHAR(45) NOT NULL,
  `postalcode` INT(11) NOT NULL,
  PRIMARY KEY (`add_id`),
  INDEX `fk_user_id` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `inxdb`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `inxdb`.`designation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `inxdb`.`designation` (
  `id` INT(11) NOT NULL,
  `designation` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `inxdb`.`picture`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `inxdb`.`picture` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `imagename` VARCHAR(45) NOT NULL,
  `image` BLOB NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_id`
    FOREIGN KEY (`id`)
    REFERENCES `inxdb`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `inxdb`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `inxdb`.`roles` (
  `user_id` INT(11) NOT NULL AUTO_INCREMENT,
  `role` INT(11) NOT NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `inxdb`.`student`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `inxdb`.`student` (
  `tid` INT(4) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `sub1` INT(2) NULL DEFAULT NULL,
  `sub2` INT(2) NULL DEFAULT NULL,
  `sub3` INT(2) NULL DEFAULT NULL,
  `total` INT(3) NULL DEFAULT NULL,
  `per` INT(3) NULL DEFAULT NULL,
  PRIMARY KEY (`tid`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
