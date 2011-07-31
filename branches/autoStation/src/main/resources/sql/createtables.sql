CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` text,
  `password` text,
  `isdispatcher` tinyint(1) DEFAULT '0',
  `busid` varchar(45) DEFAULT '0',
  `name` text,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
);

CREATE TABLE `busses` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `busload` varchar(45) DEFAULT '0',
  `maxspeed` varchar(45) DEFAULT '0',
  `workingorder` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
);

CREATE TABLE `bus_application` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `minspeed` varchar(45) DEFAULT '0',
  `minbusload` varchar(45) DEFAULT '0',
  `isdone` tinyint(1) DEFAULT '0',
  `userid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
);
