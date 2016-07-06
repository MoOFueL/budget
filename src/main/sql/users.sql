DROP TABLE IF EXISTS users CASCADE;
CREATE TABLE users (
  id              SERIAL,
  created_at      TIMESTAMP              NOT NULL DEFAULT NOW(),
  fio             CHARACTER VARYING(256) NOT NULL,
  additional_info CHARACTER VARYING(512),
  is_active       BOOLEAN                NOT NULL DEFAULT FALSE,
  synchronized_at TIMESTAMP              NOT NULL DEFAULT NOW(),

  PRIMARY KEY (id)
);

ALTER TABLE users OWNER TO backend;

COMMENT ON TABLE users IS 'Пользователи';
COMMENT ON COLUMN users.id IS 'Идентификатор пользователя';
COMMENT ON COLUMN users.created_at IS 'Дата/время создания пользователя';
COMMENT ON COLUMN users.fio IS 'ФИО пользователя';
COMMENT ON COLUMN users.additional_info IS 'Дополнительная информация о пользователе';
COMMENT ON COLUMN users.is_active IS 'Признак активности пользователя';
COMMENT ON COLUMN users.synchronized_at IS 'Дата/время последней синхронизации';
