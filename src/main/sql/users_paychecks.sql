DROP TABLE IF EXISTS users_paychecks CASCADE;
CREATE TABLE users_paychecks (
  id          SERIAL,
  user_id     INT NOT NULL REFERENCES users (id) ON DELETE RESTRICT,
  paycheck_id INT NOT NULL REFERENCES paychecks (id) ON DELETE RESTRICT,
  PRIMARY KEY (id)
);

ALTER TABLE users_paychecks
  OWNER TO backend;

COMMENT ON TABLE users_paychecks IS 'Связь чеков и их фотографий';
COMMENT ON COLUMN users_paychecks.paycheck_id IS 'Идентификатор чека';
COMMENT ON COLUMN users_paychecks.user_id IS 'Идентификатор файла';

INSERT INTO users_paychecks (user_id, paycheck_id) VALUES (1, 1);

INSERT INTO users_paychecks (user_id, paycheck_id) VALUES (2, 2);

INSERT INTO users_paychecks (user_id, paycheck_id) VALUES (3, 3);