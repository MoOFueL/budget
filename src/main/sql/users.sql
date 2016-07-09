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

COMMENT ON TABLE users IS 'Пользователи';
COMMENT ON COLUMN users.id IS 'Идентификатор пользователя';
COMMENT ON COLUMN users.password IS 'Пароль пользователя';
COMMENT ON COLUMN users.created_at IS 'Дата/время создания пользователя';
COMMENT ON COLUMN users.fio IS 'ФИО пользователя';
COMMENT ON COLUMN users.additional_info IS 'Дополнительная информация о пользователе';
COMMENT ON COLUMN users.is_active IS 'Признак активности пользователя';
COMMENT ON COLUMN users.synchronized_at IS 'Дата/время последней синхронизации';

INSERT INTO users (created_at, fio, password, additional_info, is_active, synchronized_at)
VALUES (now(), 'Димон', 'QWERTYUIOP1234567890asdfghjkl', 'Потратил 50к на 980TI', TRUE, now());

INSERT INTO users (created_at, fio, password, additional_info, is_active, synchronized_at)
VALUES (now(), 'Света', '1234567890qwertyuiop', 'Тратит деньги на одежду', TRUE, now());

INSERT INTO users (created_at, fio, password, additional_info, is_active, synchronized_at)
VALUES (now(), 'Димон', '0987654321QWERTYUIOP', 'Главбух', TRUE, now());


