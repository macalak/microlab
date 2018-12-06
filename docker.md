# Docker 
Docker utilises Linux features which enables to isolate rinning processes in terms 
of Network, Security, and Disk. Docker work with images, which are read-only templates
used to create containers.Images are created with the docker build command, either by
you or by other docker users. Images are composed of layers of other images. Images 
are stored in a Docker registry. Docker container is instance of an image.

## Dockerfile
Docker can build images automatically by reading the instructions from a Dockerfile. 
A Dockerfile is a text document that contains all the commands a user could call 
on the command line to assemble an image.

Example:
```
FROM itexperts/oraclejdk:jre8u112
MAINTAINER Ivan Macalak <macalak@itexperts.sk>

# Create service related directory
RUN mkdir -p /opt/itexperts/service/

# copy the service JAR file to the right place
COPY /files/castle-1.0.0-SNAPSHOT.jar /opt/itexperts/service/service.jar
# copy the container starting script to the right place
COPY /files/run.service.sh /opt/itexperts/service/

# set the working directory
WORKDIR /opt/itexperts/service/

# Expose port and run startup script
EXPOSE 8080
# Starting script
CMD ["/opt/itexperts/service/run.service.sh"]
```

1. There is _castle\docker_ folder with _Dockerfile_ avaliable
   Copy _docker_ folder into _c:\microservices\vagrant_box\_ as ths folder is shared with vagrant machine
2. Now create executable JAR od castle module `gradlew assemble`
   Copy _build/libs/castle-1.0.0-SNAPSHOT.jar_ into _c:\microservices\vagrant_box\docker\files_   
3. From vagrant machinne (/vagrant/docker folder) run `docker build --no-cache -t localhost:5000/castle:latest .`
4. Yu can push created image into local Docker registry `docker push localhost:5000/castle:latest`
5. Now, you can run Docker container as `docker run -d -p 8091:8091 -p 9194:9194 -e CONFIG_HOST=10.0.2.2 -e REGISTRY_SERVER_IP=10.0.2.2 localhost:5000/castle:latest`
6. You can check container console logs `docker logs <container-id>`
7. Castle API is available on http://192.168.122.230:8091 and actuator endpoints on http://192.168.122.230:9194/actuator
8. You can stop container `docker stop <container-id>`




