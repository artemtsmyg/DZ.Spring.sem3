create TABLE IF NOT EXISTS "user" (
                                      id INT AUTO_INCREMENT PRIMARY KEY,
                                      name varchar(50) NOT NULL,
    age  int NOT NULL,
    email varchar(50) not null
    );

insert into "user" (name, age, email) values ("Artur", 23, "exam1@yandex.ru");
insert into "user" (name, age, email) values ("Janna", 34, "exam3@yandex.ru");
insert into "user" (name, age, email) values ("Artem", 35, "artemtsmyg@yandex.ru");