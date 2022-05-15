# Introduction | Updated Inventory App (CI/CD - Docker, GitHub Actions, Heroku)

An inventory app for 4 "warehouses." Each warehouse displays a list of all items in its aisles. The user can view details of each item (name, price, description and category) by clicking on any specific item from the list. A new item can be added in each aisle by submitting the form. An item can also be edited or removed from the warehouse.

App was updated from previous version using Docker & GitHub Actions to implement Auth0 SSO login for access to warehouses.


## Table of contents

- **[Overview](#overview)**
  - [Objectives](#objectives)
  - [Screenshots](#screenshots)
  - [Deployment](#deployment)
- **[Development](#development)**
  - [Technologies](#technologies)
  - [What I learned](#what-i-learned)
  - [Setup](#setup)
- **[Collaborators](#collaborators)**
- **[Competencies](#competencies)**


## Overview

### Objectives:

Users should be able to:

- [x] View all items in the inventory
- [x] View any individual item in the inventory
- [x] Add an item to the inventory through completing a front-end form
- [x] Delete an item from the inventory (delete button on single item view)
- [x] Edit an item through completing a front-end form
- [x] Observe that the app is mobile-friendly

UPDATED FEATURES:

- [x] Containerize app using Docker
- [x] Integrate GitHub Actions
- [x] Add Auth0 SSO login to landing page

Stretch goals (to-do):

- [ ] Optimize authorization

### Screenshots
<details>
  <summary>Click to expand!</summary>

See all screenshots from original app [here](https://github.com/l1nd53y/MVZPortfolio/tree/main/module-projects/mod-1/Inventory-App#screenshots)

MODIFIED LANDING PAGE<br>
<img src="https://github.com/l1nd53y/MVZPortfolio/blob/main/module-projects/mod-3/CICD-Docker-Updated-Feature/screenshots/updated-landing.png" width=70% height=70%> 
  
AUTH0 ADDITION<br>
<img src="https://github.com/l1nd53y/MVZPortfolio/blob/main/module-projects/mod-3/CICD-Docker-Updated-Feature/screenshots/auth-addition.png" width=70% height=70%>
<img src="https://github.com/l1nd53y/MVZPortfolio/blob/main/module-projects/mod-3/CICD-Docker-Updated-Feature/screenshots/updated-warehouses.png" width=70% height=70%> 
  
SINGLE AISLE BEFORE<br>
<img src="https://github.com/l1nd53y/MVZPortfolio/blob/main/module-projects/mod-3/CICD-Docker-Updated-Feature/screenshots/before-single-warehouse-update.png" width=70% height=70%><br>
SINGLE AISLE AFTER<br>
<img src="https://github.com/l1nd53y/MVZPortfolio/blob/main/module-projects/mod-3/CICD-Docker-Updated-Feature/screenshots/updated-single-warehouse-list-view.png" width=70% height=70%>
 
<img src="https://github.com/l1nd53y/MVZPortfolio/blob/main/module-projects/mod-3/CICD-Docker-Updated-Feature/screenshots/docker.png" width=70% height=70%> 
<img src="https://github.com/l1nd53y/MVZPortfolio/blob/main/module-projects/mod-3/CICD-Docker-Updated-Feature/screenshots/github-actions-1.png" width=70% height=70%>
<img src="https://github.com/l1nd53y/MVZPortfolio/blob/main/module-projects/mod-3/CICD-Docker-Updated-Feature/screenshots/github-actions-2.png" width=70% height=70%>
<img src="https://github.com/l1nd53y/MVZPortfolio/blob/main/module-projects/mod-3/CICD-Docker-Updated-Feature/screenshots/heroku-container.png" width=70% height=70%>
<img src="https://github.com/l1nd53y/MVZPortfolio/blob/main/module-projects/mod-3/CICD-Docker-Updated-Feature/screenshots/heroku-deployment.png" width=70% height=70%> 
</details>

### Deployment

- This app is deployed on [Heroku](https://mod3-project.herokuapp.com/)
- Project presentation can be viewed [here](https://github.com/l1nd53y/MVZPortfolio/blob/main/module-projects/mod-3/CICD-Docker-Updated-Feature/Mod3-Presentation.pdf)


## Development

### Technologies

- SQLite
- Sequelize
- Node.js
- Express
- Handlebars
- Jest
- CSS
- Git
- Heroku
- Docker
- GitHub Actions
- Auth0


### What I learned

I learned about CI/CD, and using GitHub Actions and Docker to implement changes being made to a pre-existing project.


### Setup:
```
$ cd ../project_name
$ npm install
$ npm run seed
$ npm start
```


## Collaborators:
- Lindsey (l1nd53y)
- Elizabeth (e-abraham)
- Abdi (Abdi-Aden)
- James (jamesg88)
- Ayman (Ayman-zaki)

## Competencies:
- **J.F 2.4:** *Demonstrates commitment to continued professional development.*
  - Showed commitment to professional development/improvement through improving a previous project using new concepts/technologies such as CI/CD, Docker, and GitHub Actions

- **J.F 3.3:** *Understands how to develop effective user interfaces*
  - Improved the UI of previous page (single aisle view) in the project to be more useful/attractive

- **J.F 4.8:** *Is able to interpret and implement a given design whilst remaining compliant with security and maintainability requirements*
  - Analyzed/interpreted the previous codebase design and maintained pre-existing functionality while adding new security feature
  
- **J.F 6.2:** *Understands how to follow company, team or client approaches to continuous integration, version and source control*
  - Project involved CI/CD concepts using Docker/Heroku/GitHub Actions and Git.

- **J.F 6.5:** *Works collaboratively with a wide range of people in different roles, internally and externally, with a positive attitude to inclusion & diversity*
  - Not only did I collaborate with a team for this project, but in a way it also involved collaborating with the group who created the original version of the project we were improving, through understanding the pre-existing codebase and project structure
