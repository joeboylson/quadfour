# SET UP MYSQL WITH DOCKER:

This is an alternative way of using the LAMP stack and should not give any different results.

I prefer this method because I already had Docker and MySQL workbench installed and I had used this method for a previous project.

---

### Assumed:
- Docker is installed on your machine
    - check by entering 'docker ps' on your machine
    - Install Docker for Mac: https://docs.docker.com/docker-for-mac/install/
    - Install Docker for Windows: https://docs.docker.com/docker-for-windows/install/
        - this method is a little tricky and took me a bit to get it working (I use Windows)
        - LAMP might be better if Docker isn't already installed
    - Install Docker for Linux: https://runnable.com/docker/install-docker-on-linux

### Command

Once Docker is installed _and running_, enter this command in your terminal:

```
docker run --detach --name quadfour_mysql -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=tasks -p 3306:3306 -e MYSQL_USER=tasks_user -e MYSQL_PASSWORD=password -d mysql:latest
```
`--detach`: Runs the docker container in the background of your terminal.

`--name quadfour_mysql` : The name of the container (change this if you want).

`-e MYSQL_ROOT_PASSWORD=password` : The database password.

`-e MYSQL_DATABASE=tasks`: Creates the tasks database which our application will write to.

`-p 3306:3306` : The port that will be exposed. If you need a different port, use `XXXX:3306`

`-e MYSQL_USER=tasks_user`: Creates a MySQL user named tasks_user.

`-e MYSQL_PASSWORD=password`: Provides the tasks_user with a password.

`-d mysql:latest` : Version of MySQL.

---

### Connecting

Once your database is up and running, you can link it to phpMyAdmin to view the data in a GUI.

```
docker run --name myadmin -d --link quadfour_mysql:db -p 8181:80 phpmyadmin/phpmyadmin 
```

`--link quadfour_mysql:db`: Links the previously created MySQL container with our new phpMyAdmin container.

`phpmyadmin/phpmyadmin`: Pulls the phpMyAdmin image from Docker Hub.

Navigate to http://localhost:8181/, and you will be able to view the database in phpMyAdmin.

###Other Connection Options

If you would rather view the database in another tool, it will be open on localhost:3306 (or whatever port you chose).

Open it in MySQL Workbench or something!

---

::: &nbsp; Joe Boylson and Hunter Holland