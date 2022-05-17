<template>
  <div class="container">
    <div class="row">
      <div class="col-12 text-center">
        <h4 class="pt-3">{{genre.genreName}}</h4>
        <h5>{{msg}}</h5>
      </div>
    </div>

    <div class="row">
      <div v-for="book in book" :key="book.id" class="col-md-6 col-xl-4 col-12 pt-3  justify-content-around d-flex">
        <BookBox :book="book">
        </BookBox>
      </div>
    </div>
  </div>
</template>

<script>
import BookBox from '../../components/BookBox';
export default {
  name: 'ListBooks',
  data(){
    return {
      id: null,
      genre: {},
      msg: '',
      book: {}, 
    }
  },
  components: {BookBox},
        props: ["baseURL", "books", "genres"],
        mounted() {
            this.id = this.$route.params.id;
            this.genre = this.genres.find(genre => genre.id == this.id)
            this.book = this.books.filter(book => book.genreId == this.id)

            if (this.book.length == 0) {
                this.msg = "No books found"
            } else if (this.book.length == 1) {
                this.msg = "Only 1 book found"
            } else {
                this.msg = this.book.length + " books found"
            }

        }
}
</script>

<style scoped>
h4 {
  font-family: 'Roboto', sans-serif;
  color: #484848;
  font-weight: 700;
}
h5 {
  font-family: 'Roboto', sans-serif;
  color: #686868;
  font-weight: 300;
}
</style>