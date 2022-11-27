## APACHE CASSANDRA
Apache Cassandra is an open source distributed database management system designed to handle large amounts of data across many commodity servers, providing high availability with no single point of failure.

1- GET CASSANDRA USING DOCKER

```
docker pull cassandra:latest
```

2- START CASSANDRA

```
docker run --name <container_name> -p 9042:9042 -d cassandra:latest

```

![image](https://user-images.githubusercontent.com/78444522/204147705-22e58317-e0d2-4e93-b0ad-f91a96e28a18.png)



## IntelliJ Cassandra Database Connection

![image](https://user-images.githubusercontent.com/78444522/201498662-96cde2c1-d319-4bf0-b3cd-f1ec47ca4da6.png)

> default username and password = cassandra

![image](https://user-images.githubusercontent.com/78444522/201498676-9362ba3f-0794-4494-b157-b22880df8773.png)

## Create Keyspace (database)

```
CREATE KEYSPACE IF NOT EXISTS account_service WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : '1' };
```

![image](https://user-images.githubusercontent.com/78444522/204148498-1acda3c3-25d2-45a2-bdaa-594aeed42ceb.png)



