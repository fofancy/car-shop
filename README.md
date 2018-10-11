# car-shop
Car shop

The architecture of a whole project is following : there is a frontend server and backend. 
They work separately. Frontend server is based on webpack-dev-server and angularjs which starts at 8081 port on a localhost and
has a proxy to 8080 backend port. And backend is deployed on Tomcat application server using Spring Boot technology.

The idea is following: user does some actions on a web-site, client sends http request to webpack-dev-server and frontend web server 
redirects it to backend application server which interacts with database server and processes requests.

The backend architecture is classic. It has 3 layers : controller, service and repository. There were created Car entity class. For purchased cars aditional entity was created - Inventory_Item. It contains also additional information, for example, purchase date. It is also extendable. The same is with sold cars. And of course the common list of not purchased yet cars is seperated with CarsToPurchase entity. Also would be a better solution to use for example CarToSellDto class for communivation between frontend and backend. For data layer was used Spring data.

The frontend architecture also very simple. Angularjs controllers handel user actions and uses service wrappers for http requests and sends them to a backend. Bootstrap styles was atively used for html/css. Npm modules and webpack were used to load dependencies and build project.

As RDBMS was used postgres rdbms.

Also what I'd like to add : validation and tests.


<h2> How to launch </h2>
<h3> Prerequisites </h3>
    1. NPM
    2. Webpack
    3. Postgres rdbms
    
 <h3> Launch project </h3>    
1. Clone the Repo 
    git clone https://github.com/fofancy/test-task-ossystem.git

2. Create database as follows:
	createdb -h localhost -p 5432 -U postgres carshop

Set password : postgres

You can use your own database, you just need to change configuration in application.properties file.
3. Set all comfortable ports for frontend server and backend. Or free 8080 and 8081
4. cd backend
5. gradlew bootRun
    It should connet to you postgres db. Make sure there is a possibility to establish a connection.

6. Open the second terminal in the project root folder
7. cd frontend
8. npm install
9. webpack-dev-server

10. Open a browser and enter localhost:[webpack-dev-server.port]/
