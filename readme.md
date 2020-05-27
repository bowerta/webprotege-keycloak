WebProtégé
==========

What is WebProtégé?
-------------------

WebProtégé is a free, open source collaborative ontology development environment.

It provides the following features:
- Support for editing OWL 2 ontologies
- A default simple editing interface, which provides access to commonly used OWL constructs
- Full change tracking and revision history
- Collaboration tools such as, sharing and permissions, threaded notes and discussions, watches and email notifications
- Customizable user interface
- Support for editing OBO ontologies
- Multiple file formats for upload and download of ontologies (supported formats: RDF/XML, Turtle, OWL/XML, OBO, and others)

WebProtégé runs as a Web application. End users access it through their Web browsers.
They do not need to download or install any software. We encourage end-users to use

https://webprotege.stanford.edu

If you have downloaded the webprotege war file from GitHub, and would like to deploy it on your own server,
please follow the instructions at:

https://github.com/protegeproject/webprotege/wiki/WebProtégé-4.0.0-beta-x-Installation

Building
--------

To build WebProtégé from source

1) Clone the github repository
   ```
   git clone https://github.com/protegeproject/webprotege.git
   ```
2) Open a terminal in the directory where you clone the repository to
3) Use maven to package WebProtégé
   ```
   mvn clean package
   ```
5) The WebProtege .war file will be built into the webprotege-server directory

Running from Maven
------------------

To run WebProtégé in SuperDev Mode using maven

1) Start the GWT code server in one terminal window
    ```
    mvn gwt:codeserver
    ```
2) In a different terminal window start the tomcat server
    ```
    mvn -Denv=dev tomcat7:run
    ```
3) Browse to WebProtégé in a Web browser by navigating to [http://localhost:8080](http://localhost:8080)

Running from Docker
-------------------

To run WebProtégé using the Docker container

1) Create a new file called "docker-compose.yml" and copy-and-paste the following text:
   ```yml
   version: '3'

   services:
     wpmongo:
       image: mongo:4.1-bionic
     webprotege:
       image: protegeproject/webprotege
       restart: always
       environment:
         - webprotege.mongodb.host=wpmongo
       ports:
         - 5000:8080
       depends_on:
         - wpmongo
   ```
2) Enter this following command in the Terminal to start the docker container.
   ```bash
   $ docker-compose up
   ```
3) Browse to WebProtégé in a Web browser by navigating to [http://localhost:5000](http://localhost:5000)


Modifications from main webprotege project
------------------------------------------
1) Changed BASIC auth method to KEYCLOAK auth method in webprotege-server/pom.xml

2) Switched to tomcat8 adapter for keycloak, and included the adapter in the Dockerfile build

Set up steps
------------
1) Set up keycloak and webprotege containers

2) Log in to keycloak as admin, and import realm from official webprotege-keycloak repo

3) Add a user to the realm and assign the client role 'user'
