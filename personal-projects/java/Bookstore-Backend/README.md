# Introduction | Bookstore Ecommerce App (Backend)

An ecommerce bookstore application. Backend setup allows a user to CRUD books and genres, create users, create wishlists, add to cart, and place orders.


## Table of contents

- **[Overview](#overview)**
  - [Objectives](#objectives)
  - [Demo](#demo)
  - [Deployment](#deployment)
- **[Development](#development)**
  - [Technologies](#technologies)
  - [What I learned](#what-i-learned)
  - [Setup](#setup)
- **[Competencies](#competencies)**


## Overview

### Objectives:

Users should be able to:

- [x] Access an inventory of books
- [x] Add a book to an order
- [x] Check out an order
- [x] Sign in and out of bookstore account
- [x] Sign up for an account
- [x] Create a wishlist

Stretch goals (to-do):

- [ ] See a previous order

### Demo

<img src="https://github.com/l1nd53y/MVZPortfolio/blob/main/personal-projects/java/Bookstore-Backend/screenshots/swagger-bookstore.gif" width=100% height=100%>

### Deployment

- This backend is deployed on [Heroku](https://baobabookstore.herokuapp.com/swagger-ui.html)


## Development

### Technologies

- Java
- IntelliJ
- Spring Boot
- Maven
- MySQL
- Swagger UI
- Postman
- Git
- Heroku


### What I learned

I developed more practice/experience with using Java, the dependencies that can be implemented, and deploying a database. This was also my first time using Swagger UI. The entire process involved a *lot* of debugging, Google research, and coffee :)


### Setup:
```
$ Clone project
$ cd ../project_name
$ Change the application properties (e.g. username/password of database) present in src/main/resources/application.properties according to your local mysql-server
$ To run application in IntelliJ, click green arrow button at the top right of screen
$ After starting application, go to http://localhost:8080/api/swagger-ui.html/
```

## Competencies:
- **J.F 1.6:** *Shows curiosity to the business context in which the solution will be used, displaying an inquisitive approach to solving the problem. This includes the curiosity to explore new opportunities, and techniques; the tenacity to improve methods and maximise performance of the solution; and creativity in their approach to solutions.*
  - I ran into a lot of problems while developing this backend, and it was through excessive Googling and utilization of tutorials etc. that I was able to resolve my issues - some were large bugs, while some were so small and inoccuous! I learned a lot about how dependencies and properties settings can make or break an application, in addition to tiny syntax errors

- **J.F 2.4:** *Demonstrates commitment to continued professional development.*
  - This project really frustrated me at times, but I persevered in the interest of growth

- **J.F 3.1:** *Knows how to design software approaches and patterns, to identify reusable solutions to commonly occurring problems*
  - The more projects I've worked on, the more educated my debugging "research" has become. Many times throughout this project I would start researching solutions more specifically (dependency conflicts etc.) and as a result, find answers sooner
  
- **J.F 4.2:** *Knows the principles and uses of relational and non-relational databases*
  - Project uses relational database (a database that stores data in tables)

- **J.F 5.5:** *Understands and can apply structured techniques to problem solving, can debug code and can understand the structure of programmes to identify and resolve issues*
  - I was only able to complete this project through a lot of patience, problem-solving, and attention to detail re: the codebase structure, dependencies, syntax errors, and how different elements/properties can interact with each other

- **J.F 6.6:** *Shows initiative for solving problems within their own remit, being resourceful when faced with a problem to solve*
  - There are people that would kindly help me debug this project along the way, but I wanted to challenge myself to independently problem-solve 





