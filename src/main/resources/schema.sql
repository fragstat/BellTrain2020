CREATE TABLE IF NOT EXISTS Organisation (
    id         INTEGER              COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
    version    INTEGER NOT NULL     COMMENT 'Служебное поле hibernate',
    org_name VARCHAR(50) NOT NULL COMMENT 'Назавание',
    full_name VARCHAR(150) NOT NULL COMMENT 'Полное название',
    inn VARCHAR(12) NOT NULL COMMENT 'ИНН',
    kpp VARCHAR(9) NOT NULL COMMENT 'КПП',
    address VARCHAR(75) NOT NULL COMMENT 'Адрес',
    phone VARCHAR(11) NOT NULL COMMENT 'Телефон',
    is_active BOOLEAN NOT NULL COMMENT 'Действующая'
);
COMMENT ON TABLE Organisation IS 'Организация';

CREATE TABLE IF NOT EXISTS Office (
    id INTEGER COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    org_id INTEGER COMMENT 'Организация',
    version INTEGER NOT NULL COMMENT 'Служебное поле hibernate',
    office_name VARCHAR(25) COMMENT 'Название',
    address VARCHAR(75) COMMENT 'Адрес',
    phone VARCHAR(11) COMMENT 'Телефон',
    is_active BOOLEAN COMMENT 'Действующая'
);
COMMENT ON TABLE Office IS 'Офис';

CREATE TABLE IF NOT EXISTS Worker (
    id INTEGER COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    version INTEGER NOT NULL COMMENT 'Служебное поле hibernate',
    office_id INTEGER NOT NULL COMMENT 'Номер офиса',
    first_name VARCHAR(25) NOT NULL COMMENT 'Имя',
    second_name VARCHAR(25) COMMENT 'Фамилия',
    middle_name VARCHAR(25) COMMENT 'Отчество\второе имя',
    position_value VARCHAR(50) NOT NULL COMMENT 'Должность',
    phone VARCHAR(11) COMMENT 'Телефон',
    citizenship_code INTEGER COMMENT 'Код страны гражданства',
    is_identified BOOLEAN COMMENT 'Прохождение идентификации'
);
COMMENT ON TABLE Worker IS 'Пользователь';

CREATE TABLE IF NOT EXISTS User_Document (
    id INTEGER COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    version INTEGER NOT NULL COMMENT 'Служебное поле hibernate',
    doc_code INTEGER COMMENT 'Код документа',
    doc_number VARCHAR(20) COMMENT 'Номер документа',
    doc_date DATE COMMENT 'Дата выдачи документа'
);
COMMENT ON TABLE User_Document IS 'Документ';

CREATE TABLE IF NOT EXISTS Document_Type (
    id INTEGER PRIMARY KEY COMMENT 'Уникальный идентификатор',
    code INTEGER UNIQUE COMMENT 'Код документа',
    doc_name VARCHAR(100) COMMENT 'Название документа'
);
COMMENT ON TABLE Document_Type IS 'Типы документов';

CREATE TABLE IF NOT EXISTS Country (
    id INTEGER PRIMARY KEY COMMENT 'Уникальный идентификатор',
    code INTEGER UNIQUE COMMENT 'Код страны',
    country_name VARCHAR(100) COMMENT 'Название страны'
);
COMMENT ON TABLE Country IS 'Страны';

CREATE INDEX IX_Office_Org_Id ON Office (org_id);
ALTER TABLE Office ADD FOREIGN KEY (org_id) REFERENCES Organisation(id);

CREATE INDEX IX_Worker_Office_Id ON Worker (office_id);
ALTER TABLE Worker ADD FOREIGN KEY (office_id) REFERENCES Office(id);

CREATE INDEX IX_Worker_Citizenship_Code ON Worker (citizenship_code);
ALTER TABLE Worker ADD FOREIGN KEY (citizenship_code) REFERENCES Country(id);

CREATE INDEX IX_User_Document_User_Id ON User_Document (id);
ALTER TABLE User_Document ADD FOREIGN KEY (id) REFERENCES Worker(id);

CREATE INDEX IX_User_Document_Doc_Code ON User_Document (doc_code);
ALTER TABLE User_Document ADD FOREIGN KEY (doc_code) REFERENCES Document_Type(id);



