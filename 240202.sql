-- Table creations
CREATE TABLE membership (
  idx BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  type VARCHAR(10) NOT NULL
);

CREATE TABLE customer (
  idx BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  email VARCHAR(10) NOT NULL,
  password VARCHAR(10) NOT NULL,
  membership_idx BIGINT NOT NULL
);

CREATE TABLE genre (
  idx BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  type VARCHAR(10) NOT NULL
);

CREATE TABLE actor (
  idx BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  name VARCHAR(10) NOT NULL,
  company VARCHAR(10) NOT NULL,
  related_video_idx BIGINT
);

CREATE TABLE nickname (
  idx BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  nick VARCHAR(10) NOT NULL,
  customer_idx BIGINT NOT NULL
);

CREATE TABLE video_actor_bridge (
  idx BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  actor_idx BIGINT NOT NULL,
  video_idx BIGINT NOT NULL
);

CREATE TABLE top10 (
  idx INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
  video_idx BIGINT NOT NULL
);

CREATE TABLE video (
  idx BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  title VARCHAR(255) NOT NULL,
  thumb_img VARCHAR(255) NOT NULL,
  sample_clip VARCHAR(255) NOT NULL,
  description TEXT NOT NULL,
  video_type_idx BIGINT NOT NULL,
  genre_idx BIGINT NOT NULL,
  feature_idx BIGINT,
  running_time BIGINT,
  open_date DATE,
  age BIGINT,
  series_idx BIGINT,
  movie_idx BIGINT
);

CREATE TABLE video_type (
  idx BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  type VARCHAR(10) NOT NULL
);

CREATE TABLE series (
  idx BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  title VARCHAR(255) NOT NULL,
  description VARCHAR(255) NOT NULL
);

CREATE TABLE watching_video (
  idx BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  nickname_idx BIGINT NOT NULL,
  video_idx BIGINT NOT NULL
);

CREATE TABLE like_video (
  idx BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  nickname_idx BIGINT NOT NULL,
  video_idx BIGINT NOT NULL
);

CREATE TABLE movie (
  idx BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  collection_video BIGINT,
  description VARCHAR(255) NOT NULL
);

CREATE TABLE video_director_bridge (
  idx BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  director_idx BIGINT NOT NULL,
  video_idx BIGINT NOT NULL
);

CREATE TABLE director (
  idx BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  name VARCHAR(10) NOT NULL,
  related_video_idx BIGINT
);

CREATE TABLE feature (
  idx BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  type VARCHAR(10) NOT NULL
);

CREATE TABLE screenwriter (
  idx BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  name VARCHAR(10) NOT NULL,
  related_video_idx BIGINT
);

CREATE TABLE video_sceenwriter_bridge (
  idx BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  screenwriter_idx BIGINT NOT NULL,
  video_idx BIGINT NOT NULL
);

CREATE TABLE notification (
  idx BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  nickname_idx BIGINT NOT NULL,
  video_idx BIGINT NOT NULL,
  notification_date DATE NOT NULL,
  notification_type VARCHAR(20)
);

CREATE TABLE recommend (
  idx BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  video_idx BIGINT,
  comming_this_week_idx BIGINT,
  comming_next_week_idx BIGINT
);

CREATE TABLE comming_this_week (
  idx BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  video_idx BIGINT NOT NULL
);

CREATE TABLE comming_next_week (
  idx BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  video_idx BIGINT NOT NULL
);


-- Adding foreign keys
ALTER TABLE customer
ADD FOREIGN KEY (membership_idx) REFERENCES membership(idx);

ALTER TABLE actor
ADD FOREIGN KEY (related_video_idx) REFERENCES video(idx);

ALTER TABLE nickname
ADD FOREIGN KEY (customer_idx) REFERENCES customer(idx);

ALTER TABLE video_actor_bridge
ADD FOREIGN KEY (actor_idx) REFERENCES actor(idx),
ADD FOREIGN KEY (video_idx) REFERENCES video(idx);

ALTER TABLE top10
ADD FOREIGN KEY (video_idx) REFERENCES video(idx);

ALTER TABLE video
ADD FOREIGN KEY (video_type_idx) REFERENCES video_type(idx),
ADD FOREIGN KEY (genre_idx) REFERENCES genre(idx),
ADD FOREIGN KEY (feature_idx) REFERENCES feature(idx),
ADD FOREIGN KEY (series_idx) REFERENCES series(idx),
ADD FOREIGN KEY (movie_idx) REFERENCES movie(idx);

ALTER TABLE watching_video
ADD FOREIGN KEY (nickname_idx) REFERENCES nickname(idx),
ADD FOREIGN KEY (video_idx) REFERENCES video(idx);

ALTER TABLE like_video
ADD FOREIGN KEY (nickname_idx) REFERENCES nickname(idx),
ADD FOREIGN KEY (video_idx) REFERENCES video(idx);

ALTER TABLE video_director_bridge
ADD FOREIGN KEY (director_idx) REFERENCES director(idx),
ADD FOREIGN KEY (video_idx) REFERENCES video(idx);

ALTER TABLE director
ADD FOREIGN KEY (related_video_idx) REFERENCES video(idx);

ALTER TABLE screenwriter
ADD FOREIGN KEY (related_video_idx) REFERENCES video(idx);

ALTER TABLE video_sceenwriter_bridge
ADD FOREIGN KEY (screenwriter_idx) REFERENCES screenwriter(idx),
ADD FOREIGN KEY (video_idx) REFERENCES video(idx);

ALTER TABLE notification
ADD FOREIGN KEY (nickname_idx) REFERENCES nickname(idx),
ADD FOREIGN KEY (video_idx) REFERENCES video(idx);

ALTER TABLE recommend
ADD FOREIGN KEY (video_idx) REFERENCES video(idx),
ADD FOREIGN KEY (comming_this_week_idx) REFERENCES comming_this_week(idx),
ADD FOREIGN KEY (comming_next_week_idx) REFERENCES comming_next_week(idx);

ALTER TABLE comming_this_week
ADD FOREIGN KEY (video_idx) REFERENCES video(idx);

ALTER TABLE comming_next_week
ADD FOREIGN KEY (video_idx) REFERENCES video(idx);
