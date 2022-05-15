# Introduction | LightNote - RESTful API with auth

<blockquote>Light Yagami (aka "Kira") is an ambitious student who wants to build a better world... at any cost necessary. Create an API for his Death Note, where he may add, update, and retrieve the names, photos, and cause of death of "criminals" who must be "deleted." This Death Note must be kept away from Interpol and the Detective L, who are looking to discover the identity of the mysterious "Kira."</blockquote>

This is a RESTful API that implements both an Auth0 SSO login and requires a bearer token for a User to interact with the database - stored passwords are hashed.


## Table of contents

- **[Overview](#overview)**
  - [Objectives](#objectives)
  - [Screenshots](#screenshots)
  - [Links](#links)
- **[Development](#development)**
  - [Technologies](#technologies)
  - [What I learned](#what-i-learned)
  - [Setup](#setup)
- **[Collaborators](#collaborators)**
- **[Competencies](#competencies)**


## Overview

### Objectives:

Users should be able to:

- [x] Read entries from the database
- [x] Add entries to the database
- [x] Delete entries from the database
- [x] Edit entries in the database
- [x] Log in to the API
- [x] Encrypt sensitive info in the database
- [x] Protect info from unauthorized users
- [x] As potential User, be able to sign up for API
- [x] Be granted authorization to API as a signed-up User

Stretch goals (to-do):

- [ ] Further develop front end of application
- [ ] Optimize authorization implementation
- [ ] Deploy application

### Screenshots
<details>
  <summary>Click to expand!</summary>

<img src="https://github.com/l1nd53y/MVZPortfolio/blob/main/module-projects/mod-2/RESTful-API-Auth/screenshots/auth0.png" width=70% height=70%> <img src="https://github.com/l1nd53y/MVZPortfolio/blob/main/module-projects/mod-2/RESTful-API-Auth/screenshots/logged-in.png" width=70% height=70%> <img src="https://github.com/l1nd53y/MVZPortfolio/blob/main/module-projects/mod-2/RESTful-API-Auth/screenshots/browser-view-criminals.png" width=70% height=70%> <img src="https://github.com/l1nd53y/MVZPortfolio/blob/main/module-projects/mod-2/RESTful-API-Auth/screenshots/bearer-token.png" width=70% height=70%> <img src="https://github.com/l1nd53y/MVZPortfolio/blob/main/module-projects/mod-2/RESTful-API-Auth/screenshots/MySQL-view-users.png" width=70% height=70%>
---
<img src="https://github.com/l1nd53y/MVZPortfolio/blob/main/module-projects/mod-2/RESTful-API-Auth/screenshots/POST-register-user.png" width=70% height=70%> <img src="https://github.com/l1nd53y/MVZPortfolio/blob/main/module-projects/mod-2/RESTful-API-Auth/screenshots/PUT-user.png" width=70% height=70%> <img src="https://github.com/l1nd53y/MVZPortfolio/blob/main/module-projects/mod-2/RESTful-API-Auth/screenshots/GET-users.png" width=70% height=70%> <img src="https://github.com/l1nd53y/MVZPortfolio/blob/main/module-projects/mod-2/RESTful-API-Auth/screenshots/GET-user.png" width=70% height=70%> <img src="https://github.com/l1nd53y/MVZPortfolio/blob/main/module-projects/mod-2/RESTful-API-Auth/screenshots/DELETE-user.png" width=70% height=70%> 
--- 
<img src="https://github.com/l1nd53y/MVZPortfolio/blob/main/module-projects/mod-2/RESTful-API-Auth/screenshots/POST-criminal.png" width=70% height=70%> <img src="https://github.com/l1nd53y/MVZPortfolio/blob/main/module-projects/mod-2/RESTful-API-Auth/screenshots/PUT-criminal.png" width=70% height=70%> <img src="https://github.com/l1nd53y/MVZPortfolio/blob/main/module-projects/mod-2/RESTful-API-Auth/screenshots/GET-criminals.png" width=70% height=70%> <img src="https://github.com/l1nd53y/MVZPortfolio/blob/main/module-projects/mod-2/RESTful-API-Auth/screenshots/GET-criminal.png" width=70% height=70%> <img src="https://github.com/l1nd53y/MVZPortfolio/blob/main/module-projects/mod-2/RESTful-API-Auth/screenshots/DELETE-criminal.png" width=70% height=70%>
</details>

### Links

- Presentation for this project can be viewed [here](https://github.com/l1nd53y/MVZPortfolio/blob/main/module-projects/mod-2/RESTful-API-Auth/LightbookPresentation.pdf)


## Development

### Technologies

- Java
- Spring
- MySQL
- Postman
- Auth0
- Git


### What I learned

I learned how to implement Auth0 and experienced trying to implement different authentication menthods (basic auth, etc.) in addition to learning how to require a bearer token for security purposes. I also learned about password hashing.


### Setup:
```
Clone and run project connected to a local database named "lightnote"~

Using POSTMAN with BEARER TOKEN:
GET http://localhost:8080/api/users - retrieve all existing users
GET http://localhost:8080/api/users/{id} - retrieve specific user
POST http://localhost:8080/api/users/register - add user
PUT http://localhost:8080/api/users/{id} - edit user
DELETE http://localhost:8080/api/users/{id} - delete user

GET http://localhost:8080/api/criminals - retrieve all existing criminals
GET http://localhost:8080/api/criminals/{id} - retrieve specific criminal
POST http://localhost:8080/api/criminals - add criminal
PUT http://localhost:8080/api/criminals/{id} - edit criminal
DELETE http://localhost:8080/api/criminals/{id} - delete criminal
```


## Collaborators:
- Lindsey (l1nd53y)
- Crystal (CrystalMorris)
- Nate (nzeru17)
- Michael (Ainouzmichael)

## Competencies:
- **J.F 1.4:** *Knows the similarities and differences between different software development methodologies, such as agile and waterfall.*
  - Utlized Agile methodology through daily stand-ups and working towards MVP - aware of "waterfall" method but did not use it, since Agile is the preferred method

- **J.F 3.4:** *Able to create simple software designs to effectively communicate understanding of the program*
  - Despite this project's "UI" being very simple, even maybe underdeveloped, we still were able to illustrate the point of the project and its functionality
  
- **J.F 3.7:** *Acts with integrity with respect to ethical, legal and regulatory ensuring the protection of personal data, safety and security.*
  - Implemented Auth0 for database access to meet project's security criteria

- **J.F 4.2:** *Knows the principles and uses of relational and non-relational databases*
  - Project uses relational database (a database that stores data in tables)

- **J.F 4.6:** *Understands how to apply an appropriate software development approach according to the relevant paradigm (for example object oriented, event driven or procedural)*
  - Project uses Java (object-oriented programming language)

- **J.F 5.5:** *Understands and can apply structured techniques to problem solving, can debug code and can understand the structure of programmes to identify and resolve issues*
  - Demonstrated the ability to debug through solving the many errors we encountered through attempts to implement an authentication method and ways to hash passwords
