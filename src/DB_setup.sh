
sudo -i -u postgres psql -c "DROP DATABASE obd;"

sudo -i -u postgres psql -c \
"
CREATE DATABASE obd;"
printf "Чи перший раз ви запустили мене ? : [y/n] : "
read ans
if [[ $ans == 'y' ]] ; then
echo "Введіть новий пароль для користувача за замовчуванням ."
sudo -i -u postgres psql -c \
"\password postgres"
fi
sudo -i -u postgres psql -h localhost -p 5432 -d obd -c \
"
create table project (
	id BIGSERIAL NOT NULL PRIMARY KEY,
	name VARCHAR(100) NOT NULL,
	description VARCHAR(1000)
);

INSERT INTO project(id,name,description) VALUES(1,'Математика навколо нас','Використання геометричних фігур в архітектурі міста Києва');
INSERT INTO project(id,name,description) VALUES(2,'Країна дитячих мрій','Творчі виступи, змагання, концерти та благодійні внески');
INSERT INTO project(id,name,description) VALUES(3,'Оцінка якості атмосферного повітря','Використання комплексу методу біомоніторингу');

create table task (
	id BIGSERIAL NOT NULL PRIMARY KEY,
	name VARCHAR(100) NOT NULL,
	description VARCHAR(1000),
	deadline DATE,
	project_id BIGINT REFERENCES project(id)
);

INSERT INTO task(id, name, description, deadline, project_id) VALUES(1,'Гіпотеза','Висунути гіпотезу щодо шляху вирішення проблеми','2020-12-29', 1);
INSERT INTO task(id, name, description, deadline, project_id) VALUES(2,'Метод','Вибрати метод для перевірки та обговорення інформації','2020-12-31', 1);
INSERT INTO task(id, name, description, deadline, project_id) VALUES(3,'Оформлення','Обговорення оформлення результатів','2021-01-05', 1);
INSERT INTO task(id, name, description, deadline, project_id) VALUES(4,'Захист','Захист всього проекту','2021-01-15', 1);

INSERT INTO task(id, name, description, deadline, project_id) VALUES(5,'Концерт і змагання','Провести змагання та концерт','2020-12-18', 2);
INSERT INTO task(id, name, description, deadline, project_id) VALUES(6,'Благодійність та виступи','Провести збір благодійних внесків під час виступів','2020-12-19', 2);

INSERT INTO task(id, name, description, deadline, project_id) VALUES(7,'Місце проведення','Вибрати ділянки для проведення досліджень','15-10-2021', 3);
INSERT INTO task(id, name, description, deadline, project_id) VALUES(8,'Проведення вимірів','Виміряти значення забрудненості повітря','18-10-2021', 3);
INSERT INTO task(id, name, description, deadline, project_id) VALUES(9,'Висновки','Визначити основні джерела забруднення та методи їх запобігання','25-10-2021', 3);

create table artfrole (
	name VARCHAR(100) NOT NULL PRIMARY KEY,
	access_level NUMERIC(6,2) NOT NULL,
	UNIQUE(name)
);
INSERT INTO artfrole(name,access_level) VALUES('Документація', 1);
INSERT INTO artfrole(name,access_level) VALUES('Вхідний', 4);
INSERT INTO artfrole(name,access_level) VALUES('Вихідний', 2);

create table artifact (
	id BIGSERIAL NOT NULL PRIMARY KEY,
	name VARCHAR(100) NOT NULL ,
	type VARCHAR(100) NOT NULL ,
	content TEXT NOT NULL
);

INSERT INTO artifact(id,name,type,content) VALUES(1,'Геометрія 7 клас','книга','Математичні формули та малюнки');
INSERT INTO artifact(id,name,type,content) VALUES(2,'Карта міста Києва','мапа','Розміщення головних історичних памяток архітектури');
INSERT INTO artifact(id,name,type,content) VALUES(3,'Архітектура Києва','книга','Головні історичні памятки Києва та їхня геометрична побудова');
INSERT INTO artifact(id,name,type,content) VALUES(4,'Алгебра 7 клас','книга','Математичні формули та їх застосування');

INSERT INTO artifact(id,name,type,content) VALUES(5,'Програма концерту','документ','Список учасників');
INSERT INTO artifact(id,name,type,content) VALUES(6,'Нагорода','цінність','-');
INSERT INTO artifact(id,name,type,content) VALUES(7,'Скринька','цінність','Зберігання грошей для благодійних внесків');

INSERT INTO artifact(id,name,type,content) VALUES(8,'Вимірювальні прилади','інструмент','Призначений для знаходження точного значення вимірювальної величини');
INSERT INTO artifact(id,name,type,content) VALUES(9,'Карта місцевості','мапа','Розміщення досліджуваної території');


create table association (
	id BIGSERIAL NOT NULL PRIMARY KEY,
	artifact_id BIGINT REFERENCES artifact(id),
	artfrole_name VARCHAR(100) REFERENCES artfrole(name),
	task_id BIGINT REFERENCES task(id)
);

INSERT INTO association(id, artifact_id, artfrole_name, task_id) VALUES(1, 1, 'Вхідний', 1);
INSERT INTO association(id, artifact_id, artfrole_name, task_id) VALUES(2, 2, 'Вхідний', 2);
INSERT INTO association(id, artifact_id, artfrole_name, task_id) VALUES(3, 3, 'Вхідний', 3);
INSERT INTO association(id, artifact_id, artfrole_name, task_id) VALUES(4, 4, 'Вхідний', 1);

INSERT INTO association(id, artifact_id, artfrole_name, task_id) VALUES(5, 5, 'Документація', 5);
INSERT INTO association(id, artifact_id, artfrole_name, task_id) VALUES(6, 6, 'Вихідний', 6);
INSERT INTO association(id, artifact_id, artfrole_name, task_id) VALUES(7, 7, 'Вхідний', 6);

INSERT INTO association(id, artifact_id, artfrole_name, task_id) VALUES(8, 8, 'Вхідний', 8);
INSERT INTO association(id, artifact_id, artfrole_name, task_id) VALUES(9, 9, 'Вхідний', 7);

create table role (
	name VARCHAR(100) NOT NULL PRIMARY KEY,
	duties VARCHAR(100) NOT NULL,
	rights VARCHAR(100) NOT NULL
);

INSERT INTO role(name,duties,rights) VALUES('Автор','Створення проекту','Редагування проекту та розподіл обовязків');
INSERT INTO role(name,duties,rights) VALUES('Контрибутор','Створення та редагування артефакту','Редагування артефактів');
INSERT INTO role(name,duties,rights) VALUES('Виконавець','Виконання свого завдання','Перегляд проекту');


create table worker (
	id BIGSERIAL NOT NULL PRIMARY KEY,
	name VARCHAR(100) NOT NULL
);


INSERT INTO worker(id,name) VALUES(1,'Іван');
INSERT INTO worker(id,name) VALUES(2,'Петро');
INSERT INTO worker(id,name) VALUES(3,'Дмитро');

INSERT INTO worker(id,name) VALUES(4,'Олександр');
INSERT INTO worker(id,name) VALUES(5,'Олег');
INSERT INTO worker(id,name) VALUES(6,'Денис');
INSERT INTO worker(id,name) VALUES(7,'Михайло');

INSERT INTO worker(id,name) VALUES(8,'Оксана');
INSERT INTO worker(id,name) VALUES(9,'Юлія');
INSERT INTO worker(id,name) VALUES(10,'Тетяна');

create table assignment (
	id BIGSERIAL NOT NULL PRIMARY KEY,
	worker_id BIGINT REFERENCES worker(id),
	role_name VARCHAR(100) REFERENCES role(name),
	task_id BIGINT REFERENCES task(id)
);
INSERT INTO assignment(id, worker_id, role_name, task_id) VALUES(1, 1, 'Автор', 1);
INSERT INTO assignment(id, worker_id, role_name, task_id) VALUES(2, 2, 'Автор', 3);
INSERT INTO assignment(id, worker_id, role_name, task_id) VALUES(3, 3, 'Автор', 4);
INSERT INTO assignment(id, worker_id, role_name, task_id) VALUES(4, 4, 'Автор', 2);

INSERT INTO assignment(id, worker_id, role_name, task_id) VALUES(5, 5, 'Автор', 5);
INSERT INTO assignment(id, worker_id, role_name, task_id) VALUES(6, 6, 'Автор', 6);

INSERT INTO assignment(id, worker_id, role_name, task_id) VALUES(7, 7, 'Автор', 9);
INSERT INTO assignment(id, worker_id, role_name, task_id) VALUES(8, 8, 'Автор', 8);
INSERT INTO assignment(id, worker_id, role_name, task_id) VALUES(9, 9, 'Автор', 7);

INSERT INTO assignment(id, worker_id, role_name, task_id) VALUES(10, 1, 'Контрибутор', 3);
INSERT INTO assignment(id, worker_id, role_name, task_id) VALUES(11, 2, 'Контрибутор', 1);
INSERT INTO assignment(id, worker_id, role_name, task_id) VALUES(12, 10, 'Контрибутор', 4);
INSERT INTO assignment(id, worker_id, role_name, task_id) VALUES(13, 4, 'Контрибутор', 2);
INSERT INTO assignment(id, worker_id, role_name, task_id) VALUES(14, 3, 'Контрибутор', 1);
INSERT INTO assignment(id, worker_id, role_name, task_id) VALUES(15, 6, 'Контрибутор', 4);

INSERT INTO assignment(id, worker_id, role_name, task_id) VALUES(16, 7, 'Контрибутор', 5);
INSERT INTO assignment(id, worker_id, role_name, task_id) VALUES(17, 8, 'Контрибутор', 6);
INSERT INTO assignment(id, worker_id, role_name, task_id) VALUES(18, 9, 'Контрибутор', 6);
INSERT INTO assignment(id, worker_id, role_name, task_id) VALUES(19, 3, 'Контрибутор', 6);
INSERT INTO assignment(id, worker_id, role_name, task_id) VALUES(20, 2, 'Контрибутор', 5);

INSERT INTO assignment(id, worker_id, role_name, task_id) VALUES(21, 10, 'Контрибутор', 7);
INSERT INTO assignment(id, worker_id, role_name, task_id) VALUES(22, 4, 'Контрибутор', 7);
INSERT INTO assignment(id, worker_id, role_name, task_id) VALUES(23, 9, 'Контрибутор', 8);
INSERT INTO assignment(id, worker_id, role_name, task_id) VALUES(24, 6, 'Контрибутор', 8);
INSERT INTO assignment(id, worker_id, role_name, task_id) VALUES(25, 5, 'Контрибутор', 9);

INSERT INTO assignment(id, worker_id, role_name, task_id) VALUES(26, 5, 'Виконавець', 1);
INSERT INTO assignment(id, worker_id, role_name, task_id) VALUES(27, 7, 'Виконавець', 2);
INSERT INTO assignment(id, worker_id, role_name, task_id) VALUES(28, 2, 'Виконавець', 3);
INSERT INTO assignment(id, worker_id, role_name, task_id) VALUES(29, 1, 'Виконавець', 4);

INSERT INTO assignment(id, worker_id, role_name, task_id) VALUES(30, 4, 'Виконавець', 5);
INSERT INTO assignment(id, worker_id, role_name, task_id) VALUES(31, 10, 'Виконавець', 6);

INSERT INTO assignment(id, worker_id, role_name, task_id) VALUES(32, 8, 'Виконавець', 7);
INSERT INTO assignment(id, worker_id, role_name, task_id) VALUES(33, 3, 'Виконавець', 8);
INSERT INTO assignment(id, worker_id, role_name, task_id) VALUES(34, 2, 'Виконавець', 9);

COMMIT;"
