import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'
import AddGenre from "../views/Genre/AddGenre";
import AdminGenre from "../views/Genre/AdminGenre";
import EditGenre from "../views/Genre/EditGenre";
import Admin from "../views/Admin";
import AdminBook from "../views/Book/AdminBook";
import AddBook from "../views/Book/AddBook";
import EditBook from "../views/Book/EditBook";
import ShowDetails from "../views/Book/ShowDetails";
import ListBooks from "../views/Genre/ListBooks";
import Signup from "../views/Signup";
import Signin from '../views/Signin';
import WishList from "../views/Book/WishList";
import Cart from '../views/Cart';
import Success from '../views/Payment/Success';
import Failed from '../views/Payment/Failed';
import Checkout from '../views/Checkout/Checkout';
import Book from '../views/Book/Book.vue';
import Genre from '../views/Genre/Genre.vue';

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/genre/show/:id",
    name: "ListBooks",
    component: ListBooks,
  },
  {
    path: "/admin/genre/add",
    name: "AddGenre",
    component: AddGenre,
  },
  {
    path: "/admin/genre",
    name: "AdminGenre",
    component: AdminGenre,
  },
  {
    path: "/admin/genre/:id",
    name: "EditGenre",
    component: EditGenre,
    props: true,
  },
  {
    path: "/admin",
    name: "Admin",
    component: Admin
  },
  {
    path: '/admin/book',
    name: 'AdminBook',
    component: AdminBook
  },
  {
    path: '/admin/book/new',
    name: 'AddBook',
    component: AddBook
  },
  {
    path: '/admin/book/update/:id',
    name: 'EditBook',
    component: EditBook
  },
  {
    path : '/book/show/:id',
    name : 'ShowDetails',
    component: ShowDetails
  },
  {
    path: '/signup',
    name: 'Signup',
    component: Signup
  },
  {
    path: '/signin',
    name: 'Signin',
    component: Signin
  },
  {
    path: '/wishlist',
    name: 'WishList',
    component: WishList
  },
  {
    path: '/cart',
    name: 'Cart',
    component: Cart
  },
  {
    path: '/payment/success',
    name: 'PaymentSuccess',
    component: Success,
  },

  {
    path: '/payment/failed',
    name: 'PaymentFailed',
    component: Failed,
  },

  {
    path: '/checkout',
    name: 'Checkout',
    component: Checkout,
  },
  {
    path: '/books',
    name: 'Book',
    component: Book,
  },
  {
    path: '/genres',
    name: 'Genre',
    component: Genre,
  }
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router