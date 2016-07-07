DROP TABLE IF EXISTS paychecks_files CASCADE;
CREATE TABLE paychecks_files (
  id          SERIAL,
  paycheck_id INT NOT NULL REFERENCES paychecks (id) ON DELETE RESTRICT,
  file_id     INT NOT NULL REFERENCES files (id) ON DELETE RESTRICT,
  PRIMARY KEY (id)
);

ALTER TABLE paychecks_files
  OWNER TO backend;

COMMENT ON TABLE paychecks_files IS 'Связь чеков и их фотографий';
COMMENT ON COLUMN paychecks_files.paycheck_id IS 'Идентификатор чека';
COMMENT ON COLUMN paychecks_files.file_id IS 'Идентификатор файла';