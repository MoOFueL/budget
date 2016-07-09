DROP TABLE IF EXISTS files CASCADE;
CREATE TABLE files (
  id         SERIAL,
  created_at TIMESTAMP NOT NULL DEFAULT NOW(),
  name       CHARACTER VARYING(256),
  image      BYTEA     NOT NULL,
  PRIMARY KEY (id)
);

ALTER TABLE files
  OWNER TO backend;

COMMENT ON TABLE files IS 'Чеки';
COMMENT ON COLUMN files.id IS 'Идентификатор файла';
COMMENT ON COLUMN files.created_at IS 'Дата/время создания файла';
COMMENT ON COLUMN files.name IS 'Название файла';
COMMENT ON COLUMN files.image IS 'Фотография чека';

INSERT INTO files (created_at, name, image)
VALUES (now(), 'Чек из табриса 1', 'djkhfjkshfjkhsdjkfhsjkdhfjksdhf98078273HSBFKJSHJFHHJ');

INSERT INTO files (created_at, name, image)
VALUES (now(), 'Чек из табриса 2', 'djkhfjkshfjkhsdjkfhsjksdfsdfdhfjksdhf98078273HSBFKJSHJFHHJ');

INSERT INTO files (created_at, name, image)
VALUES (now(), 'Чек из табриса 3', 'djkhfjkshfjkhsdjkfhsjdsfjhugkhjasfafqawfsfsdkdhfjksdhf98078273HSBFKJSHJFHHJ');