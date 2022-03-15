# Introduction | LightNote - A RESTful API with auth

<blockquote>Light Yagami (aka "Kira") is an ambitious student who wants to build a better world... at any cost necessary. Create an API for his Death Note, where he may add, update, and retrieve the names, photos, and cause of death of "criminals" who must be "deleted." This Death Note must be kept away from Interpol and the Detective L, who are looking to discover the identity of the mysterious "Kira."</blockquote>

This is a RESTful API that implements both an Auth0 login and requires a bearer token for a User to interact with the database.


## Table of contents

- **[Overview](#overview)**
  - [Objectives](#objectives)
  - [Screenshots](#screenshots)
  <!-- - [Deployment](#deployment) -->
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
- [x] As an unauthorized User, see a message that user does not have access to API
- [x] As potential User, be able to sign up for API
- [x] Be granted authorization to API as a signed-up User

Stretch goals (to-do):

- [ ] Further develop front end of application
- [ ] Optimize authorization implementation

### Screenshots
<details>
  <summary>Click to expand!</summary>

<img src="https://github.com/l1nd53y/MVZPortfolio/blob/main/module-projects/mod-1/Inventory-App/screenshots/landing-desktop.png" width=40% height=40%> <img src="https://github.com/l1nd53y/MVZPortfolio/blob/main/module-projects/mod-1/Inventory-App/screenshots/warehouses-desktop.png" width=40% height=40%> <img src="https://github.com/l1nd53y/MVZPortfolio/blob/main/module-projects/mod-1/Inventory-App/screenshots/single-warehouse-desktop.png" width=40% height=40%> <img src="https://github.com/l1nd53y/MVZPortfolio/blob/main/module-projects/mod-1/Inventory-App/screenshots/single-item-desktop.png" width=40% height=40%> <img src="https://github.com/l1nd53y/MVZPortfolio/blob/main/module-projects/mod-1/Inventory-App/screenshots/form-desktop.png" width=40% height=40%>
 
<img src="https://github.com/l1nd53y/MVZPortfolio/blob/main/module-projects/mod-1/Inventory-App/screenshots/landing-mobile.png" width=25% height=25%> <img src="https://github.com/l1nd53y/MVZPortfolio/blob/main/module-projects/mod-1/Inventory-App/screenshots/warehouses-mobile.png" width=25% height=25%> <img src="https://github.com/l1nd53y/MVZPortfolio/blob/main/module-projects/mod-1/Inventory-App/screenshots/single-warehouse-mobile.png" width=25% height=25%> <img src="https://github.com/l1nd53y/MVZPortfolio/blob/main/module-projects/mod-1/Inventory-App/screenshots/single-item-mobile.png" width=25% height=25%> <img src="https://github.com/l1nd53y/MVZPortfolio/blob/main/module-projects/mod-1/Inventory-App/screenshots/form-mobile.png" width=25% height=25%> 
</details>

<!-- ### Deployment

- This app is deployed on [Heroku](https://) -->


## Development

### Technologies

- Java
- Spring
- MySQL
- Postman
- Auth0
- Git


### What I learned

Use this section to recap over some of your major learnings while working through this project. Writing these out and providing code samples of areas you want to highlight is a great way to reinforce your own knowledge.


### Setup:
```
$ cd ../project_name
$ npm install
$ npm run seed
$ npm start
```


## Collaborators:
- Lindsey (l1nd53y)
- Crystal (CrystalMorris)
- Nate (nzeru17)
- Michael (Ainouzmichael)

## Competencies:
- **J.F 2.2:** *Understands how to create and analyze artefacts, such as use cases and/or user stories*
  - Blah
