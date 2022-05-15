# Introduction | Brilliant Bananas Warehouse Inventory App

An inventory app for 4 "warehouses." Each warehouse displays a list of all items in its aisles. The user can view details of each item (name, price, description and category) by clicking on any specific item from the list. A new item can be added in each aisle by submitting the form. An item can also be edited or removed from the warehouse.


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

Stretch goals (to-do):

- [ ] Add shopping cart functionality
- [ ] Create models/routes for users & orders
- [ ] Implement login

### Screenshots
<details>
  <summary>Click to expand!</summary>

<img src="https://github.com/l1nd53y/MVZPortfolio/blob/main/module-projects/mod-1/Inventory-App/screenshots/landing-desktop.png" width=40% height=40%> <img src="https://github.com/l1nd53y/MVZPortfolio/blob/main/module-projects/mod-1/Inventory-App/screenshots/warehouses-desktop.png" width=40% height=40%> <img src="https://github.com/l1nd53y/MVZPortfolio/blob/main/module-projects/mod-1/Inventory-App/screenshots/single-warehouse-desktop.png" width=40% height=40%> <img src="https://github.com/l1nd53y/MVZPortfolio/blob/main/module-projects/mod-1/Inventory-App/screenshots/single-item-desktop.png" width=40% height=40%> <img src="https://github.com/l1nd53y/MVZPortfolio/blob/main/module-projects/mod-1/Inventory-App/screenshots/form-desktop.png" width=40% height=40%>
 
<img src="https://github.com/l1nd53y/MVZPortfolio/blob/main/module-projects/mod-1/Inventory-App/screenshots/landing-mobile.png" width=25% height=25%> <img src="https://github.com/l1nd53y/MVZPortfolio/blob/main/module-projects/mod-1/Inventory-App/screenshots/warehouses-mobile.png" width=25% height=25%> <img src="https://github.com/l1nd53y/MVZPortfolio/blob/main/module-projects/mod-1/Inventory-App/screenshots/single-warehouse-mobile.png" width=25% height=25%> <img src="https://github.com/l1nd53y/MVZPortfolio/blob/main/module-projects/mod-1/Inventory-App/screenshots/single-item-mobile.png" width=25% height=25%> <img src="https://github.com/l1nd53y/MVZPortfolio/blob/main/module-projects/mod-1/Inventory-App/screenshots/form-mobile.png" width=25% height=25%> 
</details>

### Deployment

- This app is deployed on [Heroku](https://brilliant-bananas-project.herokuapp.com/)


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


### What I learned

I learned a lot about what it's like to work with a team to accomplish the common goal of an MVP. I also learned more about the value of independent research towards devising a solution to a problem.


### Setup:
```
$ cd ../project_name
$ npm install
$ npm run seed
$ npm start
```


## Collaborators:
- Chad (ceckles)
- Sharon (sharon3233)
- Lindsey (l1nd53y)
- Afreen (afreensafdar)

## Competencies:
  
- **J.F 1.7:** *Demonstrates creativity and tenacity in their approach to solutions and the methods used to come to a solution for example, sees the task through to the end by devising new solutions and despite obstacles and problems along the way.*
  - I had issues while working on the editItemForm.handlebars upon discovering that by the HTML standard, the only valid form methods are GET and POST. While doing some research I discovered that through utilizing the method-override dependency, it was possible to also use PUT the method in creating the form to edit an item

- **J.F 2.2:** *Understands how to create and analyze artefacts, such as use cases and/or user stories*
  - Before beginning work on the project, wrote use cases/user stories (above)

- **J.F 3.2:** *Knows relevant and up-to-date software designs and how to read and implement functional/technical specifications*
  - Was mindful of completing the project according to the criteria we were assigned to meet

- **J.F 4.5:** *Is able to build, manage and deploy code into the relevant environment*
  - Participated in deploying code and communicating changes, and troubleshooting Git issues when applicable

- **J.F 5.2:** *Understands how to test code and analyze results to correct errors found using unit testing*
  - Used Jest for testing and when failed tests occurred, analyzed the errors to determine how to fix them

- **J.F 6.4:** *Works independently and takes responsibility. For example, has a disciplined and responsible approach to risk, and stays motivated and committed when facing challenges*
  - Developed a sense of being able to determine when the amount of time didn't allow for specific solution I was hoping to implement and when to go with a different approach instead - independently troubleshooted problems that occurred during completion of my tasks

