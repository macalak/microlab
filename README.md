# Microservices course labs

1. [Architecture](architecture.md)
2. [DDD](ddd.md)
3. [Config server](configserver.md) 
4. [Service registry](registry.md)
5. [API Gateway](gateway.md)
6. [DevOps](devops.md)
7. [Development process](dev_proccess.md)

## Links and info
* GitLab
  * url: http://192.168.122.230:8010/
  * default admin account admin@example.com/Expert123*
  * data are stored on VB machine in /srv/gitlab folder
* docker registry
  * 192.168.122.230:5000
  * data are stored on VB machine in /srv/registry folder
* RabbitMQ
  * url: http://192.168.122.230:15672/
  * default account user/password
* Graylog
  * url: http://192.168.122.230:9000/
  * default account admin/admin
* Grafana
  * http://192.168.122.230:3000/
  * default account admin/admin
* Prometheus
  * http://192.168.122.230:19090
* Usefull stuff
  * Install vbguest plugin to Vagrant `vagrant plugin install vagrant-vbguest`
  * Export Vagrant box `vagrant package --output microservices.box`
  * Add Vagrant box `vagrant box add --name mynewbox mynew.box`
  * Start VM `vagrant up microservices`
  * Halt VM `vagrant halt microservices`

## References
* https://start.spring.io/

