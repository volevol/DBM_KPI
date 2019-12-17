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
INSERT INTO project(name,description) VALUES('Математика навколо нас','Використання геометричних фігур в архітектурі міста Києва');
INSERT INTO project(name,description) VALUES('Країна дитячих мрій','Творчі виступи, змагання, концерти та благодійні внески');
INSERT INTO project(name,description) VALUES('Оцінка якості атмосферного повітря','Використання комплексу методу біомоніторингу');
create table task (
	id BIGSERIAL NOT NULL PRIMARY KEY,
	name VARCHAR(100) NOT NULL,
	description VARCHAR(1000),
	deadline DATE,
	project_id BIGINT REFERENCES project(id)
);
INSERT INTO task(name, description, deadline, project_id) VALUES('Гіпотеза','Висунути гіпотезу щодо шляху вирішення проблеми','2020-12-29', 1);
INSERT INTO task(name, description, deadline, project_id) VALUES('Метод','Вибрати метод для перевірки та обговорення інформації','2020-12-31', 1);
INSERT INTO task(name, description, deadline, project_id) VALUES('Оформлення','Обговорення оформлення результатів','2021-01-05', 1);
INSERT INTO task(name, description, deadline, project_id) VALUES('Захист','Захист всього проекту','2021-01-15', 1);
INSERT INTO task(name, description, deadline, project_id) VALUES('Концерт і змагання','Провести змагання та концерт','2020-12-18', 2);
INSERT INTO task(name, description, deadline, project_id) VALUES('Благодійність та виступи','Провести збір благодійних внесків під час виступів','2020-12-19', 2);
INSERT INTO task(name, description, deadline, project_id) VALUES('Місце проведення','Вибрати ділянки для проведення досліджень','2021-10-15', 3);
INSERT INTO task(name, description, deadline, project_id) VALUES('Проведення вимірів','Виміряти значення забрудненості повітря','2021-10-18', 3);
INSERT INTO task(name, description, deadline, project_id) VALUES('Висновки','Визначити основні джерела забруднення та методи їх запобігання','2021-10-25', 3);
create table artfrole (
	id BIGSERIAL NOT NULL PRIMARY KEY,
	name VARCHAR(100) NOT NULL,
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
INSERT INTO artifact(name,type,content) VALUES('Геометрія 7 клас','книга','Математичні формули та малюнки');
INSERT INTO artifact(name,type,content) VALUES('Карта міста Києва','мапа','Розміщення головних історичних памяток архітектури');
INSERT INTO artifact(name,type,content) VALUES('Архітектура Києва','книга','Головні історичні памятки Києва та їхня геометрична побудова');
INSERT INTO artifact(name,type,content) VALUES('Алгебра 7 клас','книга','Математичні формули та їх застосування');
INSERT INTO artifact(name,type,content) VALUES('Програма концерту','документ','Список учасників');
INSERT INTO artifact(name,type,content) VALUES('Нагорода','цінність','-');
INSERT INTO artifact(name,type,content) VALUES('Скринька','цінність','Зберігання грошей для благодійних внесків');
INSERT INTO artifact(name,type,content) VALUES('Вимірювальні прилади','інструмент','Призначений для знаходження точного значення вимірювальної величини');
INSERT INTO artifact(name,type,content) VALUES('Карта місцевості','мапа','Розміщення досліджуваної території');
create table association (
	id BIGSERIAL NOT NULL PRIMARY KEY,
	artifact_id BIGINT REFERENCES artifact(id),
	artfrole_id BIGINT REFERENCES artfrole(id),
	task_id BIGINT REFERENCES task(id)
);
INSERT INTO association(artifact_id, artfrole_id, task_id) VALUES(1, 2, 1);
INSERT INTO association(artifact_id, artfrole_id, task_id) VALUES(2, 2, 2);
INSERT INTO association(artifact_id, artfrole_id, task_id) VALUES(3, 2, 3);
INSERT INTO association(artifact_id, artfrole_id, task_id) VALUES(4, 2, 1);
INSERT INTO association(artifact_id, artfrole_id, task_id) VALUES(5, 1, 5);
INSERT INTO association(artifact_id, artfrole_id, task_id) VALUES(6, 3, 6);
INSERT INTO association(artifact_id, artfrole_id, task_id) VALUES(7, 2, 6);
INSERT INTO association(artifact_id, artfrole_id, task_id) VALUES(8, 2, 8);
INSERT INTO association(artifact_id, artfrole_id, task_id) VALUES(9, 2, 7);
create table role (
	id BIGSERIAL NOT NULL PRIMARY KEY,
	name VARCHAR(100) NOT NULL,
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
	role_id BIGINT REFERENCES role(id),
	task_id BIGINT REFERENCES task(id)
);
INSERT INTO assignment(worker_id, role_id, task_id) VALUES(1, 1, 1);
INSERT INTO assignment(worker_id, role_id, task_id) VALUES(2, 1, 3);
INSERT INTO assignment(worker_id, role_id, task_id) VALUES(3, 1, 4);
INSERT INTO assignment(worker_id, role_id, task_id) VALUES(4, 1, 2);
INSERT INTO assignment(worker_id, role_id, task_id) VALUES(5, 1, 5);
INSERT INTO assignment(worker_id, role_id, task_id) VALUES(6, 1, 6);
INSERT INTO assignment(worker_id, role_id, task_id) VALUES(7, 1, 9);
INSERT INTO assignment(worker_id, role_id, task_id) VALUES(8, 1, 8);
INSERT INTO assignment(worker_id, role_id, task_id) VALUES(9, 1, 7);
INSERT INTO assignment(worker_id, role_id, task_id) VALUES(1, 2, 3);
INSERT INTO assignment(worker_id, role_id, task_id) VALUES(2, 2, 1);
INSERT INTO assignment(worker_id, role_id, task_id) VALUES(10, 2, 4);
INSERT INTO assignment(worker_id, role_id, task_id) VALUES(4, 2, 2);
INSERT INTO assignment(worker_id, role_id, task_id) VALUES(3, 2, 1);
INSERT INTO assignment(worker_id, role_id, task_id) VALUES(6, 2, 4);
INSERT INTO assignment(worker_id, role_id, task_id) VALUES(7, 2, 5);
INSERT INTO assignment(worker_id, role_id, task_id) VALUES(8, 2, 6);
INSERT INTO assignment(worker_id, role_id, task_id) VALUES(9, 2, 6);
INSERT INTO assignment(worker_id, role_id, task_id) VALUES(3, 2, 6);
INSERT INTO assignment(worker_id, role_id, task_id) VALUES(2, 2, 5);
INSERT INTO assignment(worker_id, role_id, task_id) VALUES(10, 2, 7);
INSERT INTO assignment(worker_id, role_id, task_id) VALUES(4, 2, 7);
INSERT INTO assignment(worker_id, role_id, task_id) VALUES(9, 2, 8);
INSERT INTO assignment(worker_id, role_id, task_id) VALUES(6, 2, 8);
INSERT INTO assignment(worker_id, role_id, task_id) VALUES(5, 2, 9);
INSERT INTO assignment(worker_id, role_id, task_id) VALUES(5, 3, 1);
INSERT INTO assignment(worker_id, role_id, task_id) VALUES(7, 3, 2);
INSERT INTO assignment(worker_id, role_id, task_id) VALUES(2, 3, 3);
INSERT INTO assignment(worker_id, role_id, task_id) VALUES(1, 3, 4);
INSERT INTO assignment(worker_id, role_id, task_id) VALUES(4, 3, 5);
INSERT INTO assignment(worker_id, role_id, task_id) VALUES(10, 3, 6);
INSERT INTO assignment(worker_id, role_id, task_id) VALUES(8, 3, 7);
INSERT INTO assignment(worker_id, role_id, task_id) VALUES(3, 3, 8);
INSERT INTO assignment(worker_id, role_id, task_id) VALUES(2, 3, 9);
COMMIT;"
