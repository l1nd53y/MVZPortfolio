<template>
  <Navbar :cartCount="cartCount"
    @resetCartCount="resetCartCount"
    v-if="!['Signup', 'Signin'].includes($route.name)"/>
  <!-- <div id="nav">
    <router-link to="/">Home</router-link> |
    <router-link to="/about">About</router-link> 
  </div> -->
  <router-view v-if="genres && books"
  :baseURL="baseURL"
  :genres="genres"
  :books="books"
  @fetchData="fetchData"
  >
  </router-view>
  <Footer v-if="!['Signup', 'Signin'].includes($route.name)" />
</template>

<script>
import Navbar from './components/Navbar.vue';
import Footer from './components/Footer.vue';
import axios from 'axios';
export default {
  components: { Navbar, Footer },
  data() {
    return {
      // baseURL : "http://localhost:8080/",
      baseURL : "https://baobabookstore.herokuapp.com/",
      books: [],
      genres: [],
      cartCount: 0,
    }
  },
  methods: {
    async fetchData() {

      // api call to get all genres
      await axios.get(this.baseURL + "bookstore/genre/")
      .then(res => {
        this.genres = res.data
      }).catch((err) => console.log('err', err));

      // api call to get books
      await axios.get(this.baseURL + "book/")
      .then(res => {
        this.books = res.data
      }).catch((err) => console.log('err', err));

      if (this.token) {
        axios
          .get(`${this.baseURL}cart/?token=${this.token}`)
          .then((res) => {
            const result = res.data;
            this.cartCount = result.cartItems.length;
          })
          .catch((err) => console.log("err", err));
      }
    },
    resetCartCount() {
      this.cartCount = 0;
    },
  },
  mounted() {
    this.token = localStorage.getItem("token");
    this.fetchData();
  }
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
html {
  overflow-y: scroll;
}
</style>

Navbar