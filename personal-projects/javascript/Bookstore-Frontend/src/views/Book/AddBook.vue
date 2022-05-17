<template>
  <div class="container">
    <div class="row">
      <div class="col-12 text-center">
        <h4 class="pt-3">Add Book</h4>
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
          <button type="button" class="btn btn-primary" @click="addBook">Submit</button>
        </form>
      </div>
      <div class="col-3"></div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
import swal from 'sweetalert';
export default {
  props : ["baseURL", "genres"],
  data(){
    return {
      id : null,
      genreId : null,
      author : null,
      title : null,
      description : null,
      imageURL : null,
      price : null
    }
  },
  
  methods : {
    addBook() {
      const newBook = {
        genreId : this.genreId,
        author: this.author,
        title : this.title,
        description : this.description,
        imageURL : this.imageURL,
        price : this.price
      };
      
      axios.post(this.baseURL+"book/add", newBook)
      .then(() => {
          this.$emit("fetchData");
          this.$router.push({name: 'AdminBook'});
          swal({
              text: "Book added!",
              icon: "success"
          })
        }).catch((err) => {
            console.log("err", err);
        })
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
</style>