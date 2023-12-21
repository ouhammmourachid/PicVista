# Create Database

```
cd Database
docker build -t mysql_picvista_image .
docker run --name picvista_database -p 3306:3306 -d mysql_picvista_image

docker exec -it your_container_id sh
mysql -proot_password
CREATE DATABASE your_database_name
```