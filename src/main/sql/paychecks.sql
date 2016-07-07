DROP TABLE IF EXISTS paychecks CASCADE;
CREATE TABLE paychecks (
  id              SERIAL,
  created_at      TIMESTAMP NOT NULL DEFAULT NOW(),
  user_id         INT REFERENCES users (id) ON DELETE RESTRICT,
  name            CHARACTER VARYING(128) NOT NULL,
  additional_info CHARACTER VARYING(512),
  sum             INT,
  image_id        INT REFERENCES files (id) ON DELETE RESTRICT,
  PRIMARY KEY (id)
);

ALTER TABLE paychecks
  OWNER TO backend;

COMMENT ON TABLE paychecks IS 'Чеки';
COMMENT ON COLUMN paychecks.id IS 'Идентификатор чека';
COMMENT ON COLUMN paychecks.created_at IS 'Дата/время создания чека';
COMMENT ON COLUMN paychecks.user_id IS 'Идентификатор пользователя';
COMMENT ON COLUMN paychecks.name IS 'Название чека';
COMMENT ON COLUMN paychecks.additional_info IS 'Дополнительная информация по чеку';
COMMENT ON COLUMN paychecks.image_id IS 'Идентификатор загруженного файла';