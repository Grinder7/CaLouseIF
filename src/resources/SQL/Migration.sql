DROP DATABASE IF EXISTS `calouseif`;
CREATE DATABASE `calouseif`;
USE `calouseif`;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `User_id` varchar(255) NOT NULL,
  `Username` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `Phone_Number` varchar(255) NOT NULL,
  `Address` text NOT NULL,
  `Role` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`)
);

-- Default admin account
INSERT INTO `user` (`User_id`, `Username`, `Password`, `Phone_Number`, `Address`, `Role`) 
VALUES('68406ea2-f7ad-4808-bf68-6573629be257', 'admin', 'qLRywyE0xJuJn1MzXynPug==', '+62123456789', 'Binus', 'admin'),

DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `Item_id` varchar(255) NOT NULL,
  `Item_seller_id` varchar(255) NOT NULL,
  `Item_name` varchar(255) NOT NULL,
  `Item_size` varchar(255) NOT NULL,
  `Item_price` varchar(255) NOT NULL,
  `Item_category` varchar(255) NOT NULL,
  `Item_status` varchar(255) NOT NULL,
  `Item_wishlist` varchar(255) NOT NULL,
  `Item_offer_status` varchar(255) NOT NULL,
  PRIMARY KEY (`item_id`),
  KEY `FK_item_user_idx` (`Item_seller_id`),
  CONSTRAINT `FK_item_user`FOREIGN KEY (`Item_seller_id`) REFERENCES `user` (`User_id`)
);

DROP TABLE IF EXISTS `transaction`;
CREATE TABLE `transaction` (
  `User_id` varchar(255) NOT NULL,
  `Item_id` varchar(255) NOT NULL,
  `transaction_id` varchar(255) NOT NULL,
  PRIMARY KEY (`transaction_id`),
  KEY `FK_transaction_user_idx` (`user_id`),
  KEY `FK_transaction_item_idx` (`item_id`),
  CONSTRAINT `FK_transaction_item` FOREIGN KEY (`item_id`) REFERENCES `item` (`item_id`),
  CONSTRAINT `FK_transaction_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
);

DROP TABLE IF EXISTS `wishlist`;
CREATE TABLE `wishlist` (
  `Wishlist_id` varchar(255) NOT NULL,
  `Item_id` varchar(255) NOT NULL,
  `User_id` varchar(255) NOT NULL,
  PRIMARY KEY (`wishlist_id`),
  KEY `FK_wishlist_user_idx` (`user_id`),
  KEY `FK_wishlist_item_idx` (`item_id`),
  CONSTRAINT `FK_wishlist_item` FOREIGN KEY (`item_id`) REFERENCES `item` (`item_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_wishlist_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
);