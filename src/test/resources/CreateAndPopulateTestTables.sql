DROP TABLE IF EXISTS users CASCADE;
CREATE TABLE users (
  id              SERIAL,
  created_at      TIMESTAMP              NOT NULL DEFAULT NOW(),
  fio             CHARACTER VARYING(256) NOT NULL,
  password        CHARACTER VARYING(256) NOT NULL,
  additional_info CHARACTER VARYING(512),
  is_active       BOOLEAN                NOT NULL DEFAULT FALSE,
  synchronized_at TIMESTAMP              NOT NULL DEFAULT NOW(),

  PRIMARY KEY (id)
);

ALTER TABLE users
  OWNER TO backend;

INSERT INTO users (created_at, fio, password, additional_info, is_active, synchronized_at)
VALUES (now(), 'Димон_тест', 'QWERTYUIOP1234567890asdfghjkl', 'Потратил 50к на 980TI', TRUE, now());

INSERT INTO users (created_at, fio, password, additional_info, is_active, synchronized_at)
VALUES (now(), 'Света', '1234567890qwertyuiop', 'Тратит деньги на одежду', FALSE, now());

INSERT INTO users (created_at, fio, password, additional_info, is_active, synchronized_at)
VALUES (now(), 'Димон_тест', '0987654321QWERTYUIOP', 'Главбух', TRUE, now());

DROP TABLE IF EXISTS paychecks CASCADE;
CREATE TABLE paychecks (
  id              SERIAL,
  created_at      TIMESTAMP              NOT NULL DEFAULT NOW(),
  user_id         INT,
  name            CHARACTER VARYING(128) NOT NULL,
  additional_info CHARACTER VARYING(512),
  sum             INT,
  PRIMARY KEY (id)
);

ALTER TABLE paychecks
  OWNER TO backend;

INSERT INTO paychecks (created_at, user_id, name, additional_info, sum)
VALUES (now(), 1, 'Tabris', 'pivasik', 50000);

INSERT INTO paychecks (created_at, user_id, name, additional_info, sum)
VALUES (now(), 2, 'aliexpress', 'Платье', 100000);

INSERT INTO paychecks (created_at, user_id, name, additional_info, sum)
VALUES (now(), 3, 'Tabris', 'Колбаса, сыр, овощи и тд', 100000);

DROP TABLE IF EXISTS files CASCADE;
CREATE TABLE files (
  id          SERIAL,
  created_at  TIMESTAMP NOT NULL DEFAULT NOW(),
  paycheck_id INT,
  name        CHARACTER VARYING(256),
  image       BYTEA     NOT NULL,
  PRIMARY KEY (id)
);

ALTER TABLE files
  OWNER TO backend;

INSERT INTO files (created_at, paycheck_id, name, image)
VALUES (now(), 1, 'Чек из табриса 1', 'djkhfjkshfjkhsdjkfhsjkdhfjksdhf98078273HSBFKJSHJFHHJ');

INSERT INTO files (created_at, paycheck_id, name, image)
VALUES (now(), 2, 'Чек из табриса 2', 'djkhfjkshfjkhsdjkfhsjksdfsdfdhfjksdhf98078273HSBFKJSHJFHHJ');

INSERT INTO files (created_at, paycheck_id, name, image)
VALUES (now(), 3, 'Чек из табриса 3', 'djkhfjkshfjkhsdjkfhsjdsfjhugkhjasfafqawfsfsdkdhfjksdhf98078273HSBFKJSHJFHHJ');

DROP TABLE IF EXISTS paychecks_files CASCADE;
CREATE TABLE paychecks_files (
  id          SERIAL,
  paycheck_id INT NOT NULL REFERENCES paychecks (id) ON DELETE RESTRICT,
  file_id     INT NOT NULL REFERENCES files (id) ON DELETE RESTRICT,
  PRIMARY KEY (id)
);

ALTER TABLE paychecks_files
  OWNER TO backend;

INSERT INTO paychecks_files (paycheck_id, file_id) VALUES (1, 1);

INSERT INTO paychecks_files (paycheck_id, file_id) VALUES (2, 2);

INSERT INTO paychecks_files (paycheck_id, file_id) VALUES (3, 3);