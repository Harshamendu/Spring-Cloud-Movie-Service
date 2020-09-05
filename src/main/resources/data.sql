DROP TABLE IF EXISTS Movie;
 
CREATE TABLE Movie (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  imdb_id INTEGER(250) NOT NULL,
  title VARCHAR(250) NOT NULL,
  story_line VARCHAR(2500) NOT NULL,
  release_date DATE NOT NULL,
  rated VARCHAR(250) DEFAULT NULL
);
 
INSERT INTO Movie (imdb_id,title, story_line,release_date,rated) VALUES
  (1,'Aladdin', 'Aladdin is a lovable street urchin who meets Princess Jasmine, the beautiful daughter of the sultan of Agrabah. While visiting her exotic palace, Aladdin stumbles upon a magic oil lamp that unleashes a powerful, wisecracking, larger-than-life genie. As Aladdin and the genie start to become friends, they must soon embark on a dangerous mission to stop the evil sorcerer, Jafar, from overthrowing young Jasmine kingdom.',
  '2019-05-24', 'PG');
--  (2,'Bill', 'Gates', 'Guest',45);
--  ('kill', 'Ramos', 4),
--  ('Folrunsho', 'Alakija', 5);