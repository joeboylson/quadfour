# SET UP MYSQL WITH DOCKER:

This is an alternative to using the LAMP stack and should not give any different results.

The application should not have to change (don't use this method if it has to) because a database is a database - whether its running with LAMP or Docker.

I prefer this method because I already had Docker and MySQL workbench installed and I had used this method for a previous project. I thought it was pointless to download another piece of software.

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
docker run --name quadfour_mysql -e MYSQL_ROOT_PASSWORD=password -p 3306:3306 -d mysql:latest
```

`--name quadfour_mysql` : the name of the container (change this if you want)

`-e MYSQL_ROOT_PASSWORD=password` : the database password

`-p 3306:3306` : the port that will be exposed. If you need a different port, use `XXXX:3306`

`d mysql:latest` : the version of mysql

---

### Connecting

After you run the command, you should be able to connect as usual. The database will be open on localhost:3306 (or whatever port you chose).

Open it in MySQL Workbench or something!

---

::: &nbsp; Joe Boylson