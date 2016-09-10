DROP TABLE IF EXISTS paychecks CASCADE;
CREATE TABLE paychecks (
  id              SERIAL,
  user_id         INT,
  created_at      TIMESTAMP              NOT NULL DEFAULT NOW(),
  name            CHARACTER VARYING(128) NOT NULL,
  additional_info CHARACTER VARYING(512),
  sum             INT,
  PRIMARY KEY (id)
);

ALTER TABLE paychecks
  OWNER TO backend;

COMMENT ON TABLE paychecks IS 'Чеки';
COMMENT ON COLUMN paychecks.id IS 'Идентификатор чека';
COMMENT ON COLUMN paychecks.user_id IS 'Идентификатор пользователя, к которому относится данный чек';
COMMENT ON COLUMN paychecks.created_at IS 'Дата/время создания чека';
COMMENT ON COLUMN paychecks.name IS 'Название чека';
COMMENT ON COLUMN paychecks.additional_info IS 'Дополнительная информация по чеку';

INSERT INTO paychecks (created_at, user_id, name, additional_info, sum)
VALUES (now(), 1, 'Tabris', 'pivasik', 50000);

INSERT INTO paychecks (created_at, user_id, name, additional_info, sum)
VALUES (now(), 2, 'aliexpress', 'Платье', 100000);

INSERT INTO paychecks (created_at, user_id, name, additional_info, sum)
VALUES (now(), 3, 'Tabris', 'Колбаса, сыр, овощи и тд', 100000);