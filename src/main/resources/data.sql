INSERT INTO Organisation (id, version, org_name, full_name, inn, kpp, address, phone, is_active) VALUES (1, 0, 'ТД "Арсенал-Метиз"','Торговый дом "Арсенал-Метиз"', '5008055603', '500801001', 'г. Долгопрудный, Лихачевский проспект, д.18, стр.1', '74995037363', true );

INSERT INTO Office (id, version, org_id, office_name, address, phone, is_active) VALUES (1, 0, 1, 'Долгопрудный', 'г. Долгопрудный, Лихачевский проспект, д.18, стр.1', '74995037363', true);

INSERT INTO Document_Type (id, code, doc_name) VALUES (1, 13, 'Удостоверение беженца');
INSERT INTO Document_Type (id, code, doc_name) VALUES (2, 21, 'Паспорт гражданина Российской Федерации');

INSERT INTO Country (id, code, country_name) VALUES (1, 643,'Российская Федерация');
INSERT INTO Country (id, code, country_name) VALUES (2, 112,'Республика Беларусь');

INSERT INTO Worker (id, version,  office_id, first_name, position_value, citizenship_code, is_identified) VALUES (1, 0, 1, 'Сергей', 'Java разработчик', 1, true);
INSERT INTO Worker (id, version, office_id, first_name, position_value, citizenship_code, is_identified) VALUES (2, 0, 1, 'Александр', 'Управлящий', 2, true);

INSERT INTO User_Document (id, version, doc_code, doc_number, doc_date) VALUES (1,0,1,'123456789101', NOW());
INSERT INTO User_Document (id, version, doc_code, doc_number, doc_date) VALUES (2,0,2,'123456789101', NOW());
