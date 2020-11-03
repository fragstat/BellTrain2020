INSERT INTO Organisation (id, org_name, full_name, inn, kpp, address, phone, is_active) VALUES (1,'ТД "Арсенал-Метиз"','Торговый дом "Арсенал-Метиз"', '5008055603', '500801001', '141707, Московская область, г. Долгопрудный, Лихачевский проспект, д.18, стр.1', '74995037363', true );

INSERT INTO Office (id, org_id, office_name, address, phone, is_active) VALUES (1, 1, 'Долгопрудный', '141707, Московская область, г. Долгопрудный, Лихачевский проспект, д.18, стр.1', '74995037363', true);

INSERT INTO Worker (id, office_id, first_name, position_value, citizenship_code, is_identified) VALUES (1, 1, 'Сергей', 'Java разработчик', 643, true);
INSERT INTO Worker (id, office_id, first_name, position_value, citizenship_code, is_identified) VALUES (2, 1, 'Александр', 'Управлящий', 112, true);

INSERT INTO User_Document (id, user_id, doc_code, doc_number, doc_date) VALUES (1,1, 21, '123456789101', DATE(NOW()));
INSERT INTO User_Document (id, user_id, doc_code, doc_number, doc_date) VALUES (2,3, 13, '123456789101', DATE(NOW()));

INSERT INTO Document_Type (code, doc_name) VALUES (13, 'Удостоверение беженца');
INSERT INTO Document_Type (code, doc_name) VALUES (21, 'Паспорт гражданина Российской Федерации');

INSERT INTO Country (code, country_name) VALUES (643,'Российская Федерация');
INSERT INTO Country (code, country_name) VALUES (112,'Республика Беларусь');