<template>
  <div id="home">
    <!-- Page Wrapper -->
    <div id="background-div" class="page-holder bg-cover">

      <div class="container py-5">
        <header class="text-left text-white py-5">
          <h3 class="mb-4 rounded"><a href="#start-shopping" class="bg-white px-2 py-2 rounded" id="heading">Welcome to Baobabookstore</a></h3>
          <p id="content" class="lead mb-0 bg-dark p-1 rounded">A collection of books curated by Lindsey.</p>
        </header>
      </div>
    </div>

    <div id="start-shopping" class="container">
      <div class="row">
        <div class="col-12 text-center">
          <h2 class="pt-3">Top Genres</h2>
        </div>
      </div>
      <div class="row">
        <div v-for="index in this.genre_size" :key="index" class="col-md-6 col-xl-4 col-12 pt-3  justify-content-around d-flex">
          <GenreBox :genre="genres[index-1]">
          </GenreBox>
        </div>
      </div>
    </div>
<br><br>
    <hr>
    <div class="container">
      <div class="row">
        <div class="col-12 text-center">
          <h2 class="pt-3">Top Books</h2>
        </div>
      </div>
      <div class="row">
        <div v-for="index in this.book_size" :key="index" class="col-md-6 col-xl-4 col-12 pt-3  justify-content-around d-flex">
          <BookBox :book="books[index-1]">
          </BookBox>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  import BookBox from "../components/BookBox";
  import GenreBox from "../components/Genre/GenreBox";
  export default {
    name: 'Home',
    components : { BookBox, GenreBox},
    props : ["baseURL", "books", "genres"],
    data(){
      return{
        genre_size:0,
        book_size:0
      }
    },
    mounted(){
      this.genre_size = this.genres.length;
      this.genre_size = Math.min(3, this.genre_size);
      this.book_size = this.books.length;
      this.book_size = Math.min(3, this.book_size);
    }
  }
</script>

<style>
  .page-holder {
    min-height: 100vh;
  }
  .bg-cover {
    background-size: cover !important;
  }
  #background-div {
    background: url(../assets/dan-wayman-5twimJ0bLFE-unsplash.jpeg);
  }
  #heading {
    text-decoration: none;
    font-family: 'Roboto', sans-serif;
    font-weight: 400;
    opacity: 0.8;
    font-family: 'Josefin Sans', sans-serif;
  }
  #content {
    opacity: 0.8;
  }
  h2 {
    font-family: 'Josefin Sans', sans-serif;
  }
</style>
