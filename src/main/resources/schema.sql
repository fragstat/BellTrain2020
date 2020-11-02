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

CREATE TABLE IF NOT EXISTS Document (
    id INTEGER COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    version INTEGER NOT NULL COMMENT 'Служебное поле hibernate',
    user_id INTEGER UNIQUE NOT NULL COMMENT 'Пользователь, кому принадлежит документ',
    doc_code INTEGER COMMENT 'Код документа',
    doc_number VARCHAR(20) COMMENT 'Номер документа',
    doc_date DATE COMMENT 'Дата выдачи документа'
);

CREATE TABLE IF NOT EXISTS Documents (
    id INTEGER PRIMARY KEY COMMENT 'Уникальный идентификатор',
    code INTEGER UNIQUE COMMENT 'Код документа',
    doc_name VARCHAR(100) COMMENT 'Название документа'
);
COMMENT ON TABLE Document IS 'Документы';

CREATE TABLE IF NOT EXISTS Country (
    id INTEGER PRIMARY KEY COMMENT 'Уникальный идентификатор',
    code INTEGER UNIQUE COMMENT 'Код страны',
    country_name VARCHAR(100) COMMENT 'Название страны'
);
COMMENT ON TABLE Country IS 'Страны';

CREATE INDEX UX_Organisation_Id ON Organisation (id);

CREATE INDEX IX_Office_Org_Id ON Office (org_id);
ALTER TABLE Office ADD FOREIGN KEY (org_id) REFERENCES Organisation(id);

CREATE INDEX UX_Office_Id ON Office (id);

CREATE INDEX UX_Worker_Id ON Worker (id);

CREATE INDEX IX_Worker_Office_Id ON Worker (office_id);
ALTER TABLE Worker ADD FOREIGN KEY (office_id) REFERENCES Office(id);

CREATE INDEX IX_Worker_Citizenship_Code ON Worker (citizenship_code);
ALTER TABLE Worker ADD FOREIGN KEY (citizenship_code) REFERENCES Country(id);

CREATE INDEX UX_Document_Id ON Document (id);

CREATE INDEX IX_Document_User_Id ON Document (user_id);
ALTER TABLE Document ADD FOREIGN KEY (user_id) REFERENCES Worker(id);

CREATE INDEX IX_Document_Doc_Code ON  Document (doc_code);
ALTER TABLE Document ADD FOREIGN KEY (doc_code) REFERENCES Documents(id);

CREATE INDEX UX_Documents_Code ON Documents (id);

CREATE INDEX UX_Country_Code ON Country (id);

CREATE INDEX UX_Organisation_Name ON Organisation (org_name);

CREATE INDEX UX_Office_Office_Name ON Office (office_name);

CREATE INDEX UX_Worker_First_Name ON Worker (first_name);

