FROM mysql:latest

ENV MYSQL_ROOT_PASSWORD=root_password

COPY ./schema.sql /docker-entrypoint-initdb.d/
EXPOSE 3306