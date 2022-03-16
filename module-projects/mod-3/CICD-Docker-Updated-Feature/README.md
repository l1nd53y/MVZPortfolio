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

<img src="https://github.com/l1nd53y/MVZPortfolio/blob/main/module-projects/mod-1/Inventory-App/screenshots/landing-desktop.png" width=40% height=40%> <img src="https://github.com/l1nd53y/MVZPortfolio/blob/main/module-projects/mod-1/Inventory-App/screenshots/warehouses-desktop.png" width=40% height=40%> <img src="https://github.com/l1nd53y/MVZPortfolio/blob/main/module-projects/mod-1/Inventory-App/screenshots/single-warehouse-desktop.png" width=40% height=40%> <img src="https://github.com/l1nd53y/MVZPortfolio/blob/main/module-projects/mod-1/Inventory-App/screenshots/single-item-desktop.png" width=40% height=40%> <img src="https://github.com/l1nd53y/MVZPortfolio/blob/main/module-projects/mod-1/Inventory-App/screenshots/form-desktop.png" width=40% height=40%>
 
<img src="https://github.com/l1nd53y/MVZPortfolio/blob/main/module-projects/mod-1/Inventory-App/screenshots/landing-mobile.png" width=25% height=25%> <img src="https://github.com/l1nd53y/MVZPortfolio/blob/main/module-projects/mod-1/Inventory-App/screenshots/warehouses-mobile.png" width=25% height=25%> <img src="https://github.com/l1nd53y/MVZPortfolio/blob/main/module-projects/mod-1/Inventory-App/screenshots/single-warehouse-mobile.png" width=25% height=25%> <img src="https://github.com/l1nd53y/MVZPortfolio/blob/main/module-projects/mod-1/Inventory-App/screenshots/single-item-mobile.png" width=25% height=25%> <img src="https://github.com/l1nd53y/MVZPortfolio/blob/main/module-projects/mod-1/Inventory-App/screenshots/form-mobile.png" width=25% height=25%> 
</details>

### Deployment

- This app is deployed on [Heroku](https://mod3-project.herokuapp.com/)


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
- Elizabeth (e-abraham)
- Abdi (Abdi-Aden)
- James (jamesg88)

## Competencies:
- **J.F 1.7:** *Demonstrates creativity and tenacity in their approach to solutions and the methods used to come to a solution for example, sees the task through to the end by devising new solutions and despite obstacles and problems along the way.*
  - Blah