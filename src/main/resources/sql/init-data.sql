drop table if exists db_sconnect.student;
drop table if exists db_sconnect.work;
drop table if exists db_sconnect.course;
drop table if exists db_sconnect.mark;
drop table if exists db_sconnect.teacher;


CREATE TABLE `student` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `birth_date` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

 course
CREATE TABLE `teacher` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `birth_date` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
 
CREATE TABLE `course` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data` longblob,
  `file_name` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `published_date` datetime DEFAULT NULL,
  `publisher_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhr2s5qqfd78rmcq5tto3mfhn7` (`publisher_id`),
  CONSTRAINT `FKhr2s5qqfd78rmcq5tto3mfhn7` FOREIGN KEY (`publisher_id`) REFERENCES `teacher` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;


CREATE TABLE `mark` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `marked_date` varchar(255) DEFAULT NULL,
  `evaluator_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbf7wu1n93t7rixf00k0ayjnpa` (`evaluator_id`),
  CONSTRAINT `FKbf7wu1n93t7rixf00k0ayjnpa` FOREIGN KEY (`evaluator_id`) REFERENCES `teacher` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;


 CREATE TABLE `work` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `extention` varchar(255) DEFAULT NULL,
  `file_content` varchar(255) DEFAULT NULL,
  `file_name` varchar(255) DEFAULT NULL,
  `uploaded_date` varchar(255) DEFAULT NULL,
  `course_id` bigint(20) DEFAULT NULL,
  `mark_id` bigint(20) DEFAULT NULL,
  `student_id` bigint(20) DEFAULT NULL,
  `data` longblob DEFAULT NULL,

  PRIMARY KEY (`id`),
  KEY `FK6biuwe7rusmo2gebc0x314ofr` (`course_id`),
  KEY `FKlm8w2je075fysx0c9jshcsiqp` (`mark_id`),
  KEY `FK3x7nfcg2v6itg7juqm487qi55` (`student_id`),
  CONSTRAINT `FK3x7nfcg2v6itg7juqm487qi55` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`),
  CONSTRAINT `FK6biuwe7rusmo2gebc0x314ofr` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`),
  CONSTRAINT `FKlm8w2je075fysx0c9jshcsiqp` FOREIGN KEY (`mark_id`) REFERENCES `mark` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

 

 
 
 