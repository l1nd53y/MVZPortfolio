<template>
  <div class="container">
    <div class="row">
      <div class="col-12 text-center">
        <h4 class="pt-3">Edit Book</h4>
      </div>
    </div>

    <div class="row">
      <div class="col-3"></div>
      <div class="col-md-6 px-5 px-md-0">
        <form>
          <div class="form-group">
            <label>Genre</label>
            <select class="form-control" v-model="genreId" required>
              <option v-for="genre of genres" :key="genre.id" :value="genre.id">{{genre.genreName}}</option>
            </select>
          </div>
          <div class="form-group">
            <label>Title</label>
            <input type="text" class="form-control" v-model="title" required>
          </div>
          <div class="form-group">
            <label>Author</label>
            <input type="text" class="form-control" v-model="author" required>
          </div>
          <div class="form-group">
            <label>Description</label>
            <input type="text" class="form-control" v-model="description" required>
          </div>
          <div class="form-group">
            <label>Image URL</label>
            <input type="url" class="form-control" v-model="imageURL" required>
          </div>
          <div class="form-group">
            <label>Price</label>
            <input type="number" class="form-control" v-model="price" required>
          </div>
          <button type="button" class="btn btn-primary" @click="editBook">Submit</button>
        </form>
      </div>
      <div class="col-3"></div>
    </div>
  </div>
</template>

<script>
var axios =  require('axios');
import swal from 'sweetalert';
export default {
  data(){
    return {
      id : null,
      genreId : 0,
      title : null,
      author : null,
      description : null,
      imageURL : null,
      price : 0,
      bookIndex : null
    }
  },
  props : ["baseURL", "books", "genres"],
  methods : {
    async editBook() {
      const updatedBook = {
        id : this.id,
        genreId : this.genreId,
        title : this.title,
        author: this.author,
        description : this.description,
        imageURL : this.imageURL,
        price : this.price
      };

      axios.post(this.baseURL+"book/update/"+this.id, updatedBook)
      .then(() => {
          this.$emit("fetchData");
          this.$router.push({name: 'AdminBook'});
          swal({
              text: "Book updated!",
              icon: "success"
          })
        }).catch((err) => {
            console.log("err", err);
        });
    }
  },
  mounted() {
    this.id = this.$route.params.id;
    this.bookIndex = this.books.findIndex(book => book.id == this.id);
    //input fields
    this.genreId = this.books[this.bookIndex].genreId;
    this.title = this.books[this.bookIndex].title;
    this.author = this.books[this.bookIndex].author;
    this.description = this.books[this.bookIndex].description;
    this.imageURL = this.books[this.bookIndex].imageURL;
    this.price = this.books[this.bookIndex].price;
  }
}
</script>

<style scoped>
h4 {
  font-family: 'Roboto', sans-serif;
  color: #484848;
  font-weight: 700;
}
</style>