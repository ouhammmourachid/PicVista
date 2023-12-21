# Create Database

```
cd Database
docker build -t mysql_picvista_image .
docker run --name picvista_database -p 3306:3306 -d mysql_picvista_image
```