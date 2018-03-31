# Final Project for ITMD 515

## JPA and ERD assignment

We have reduced our final DB to the following entities and relationships:

![erdplus-diagram](https://user-images.githubusercontent.com/6637058/38157993-5b20451a-3452-11e8-9259-671e1b41f0c9.png))

In this project we are going to use a MySQL server launched in our localhost at port 3306. Our particular database named itmd515 will store all the necessary data for our web application to work.

At the package https://github.com/pacoard/javaEE-projects/tree/master/project/src/main/java/edu/iit/itmd515/model we can see all the entities' classes and their correspondent DAO implementations, where there are specified all the possible interactions woth the database.

The https://github.com/pacoard/javaEE-projects/blob/master/project/src/main/java/edu/iit/itmd515/HibernateUtil.java class is used to manage the sessions with Hibernate and test the database functionality until the web application is completely developed.

The https://github.com/pacoard/javaEE-projects/blob/master/project/src/main/resources/hibernate.cfg.xml file is where we have indicated the configuration of Hibernate and the entities that are declared in this project.