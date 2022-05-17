<template>
   <div class="container">
     <div class="row">
       <div class="col-12 text-center">
         <h4 class="pt-3">Books</h4>
         <router-link :to="{name : 'AddBook'}">
           <button class="btn" style="float: right">Add Book</button>
         </router-link>
     </div>
</div>
<div class="row">
  <div v-for="book of books" :key="book.id" class="col-xl-4 col-md-6 col-12 pt-3 d-flex">
      <BookBox  :book="book" />
  </div>
</div>
</div>
</template>

<script>
import BookBox from "@/components/BookBox.vue"
const axios =  require('axios');
export default {
  name: "AdminBook",
  //props: ["books"],
  components: {BookBox},
  data(){
    return {
      baseURL: "https://baobabookstore.herokuapp.com",
      books: [],
    };
  },
  methods : {
    async getBooks() {
      await axios.get(`${this.baseURL}/book/`)
      .then(res => this.books = res.data)
      .catch(err => console.log(err))
    }   
  },
  mounted() {
    this.getBooks();
  }
};
</script>

<style scoped>
h4 {
  font-family: 'Roboto', sans-serif;
  color: #484848;
  font-weight: 700;
}
</style>