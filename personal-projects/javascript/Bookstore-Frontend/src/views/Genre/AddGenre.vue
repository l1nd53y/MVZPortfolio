<template>
   <div class="container">
     <div class="row">
       <div class="col-12 text-center">
         <h4 class="pt-3">Add new Genre</h4>
       </div>
     </div>

     <div class="row">
       <div class="col-3"></div>
       <div class="col-md-6 px-5 px-md-0">
        <form>
          <div class="form-group">
            <label>Genre Name</label>
            <input type="text" class="form-control" v-model="genreName" required>
          </div>
          <div class="form-group">
            <label>Description</label>
            <input type="text" class="form-control" v-model="description" required>
          </div>
          <div class="form-group">
            <label>Image URL</label>
            <input type="url" class="form-control" v-model="imageURL" required>
          </div>
          <button type="button" class="btn btn-primary" @click="addGenre">Submit</button>
        </form>
       </div>
       <div class="col-3"></div>
     </div>
  </div>
</template>

<script>
const axios =  require('axios')
const swal = require('sweetalert');
export default {
  props : ["baseURL", "genres"],
  data(){
    return {
      genreName : null,
      description : null,
      imageURL : null,
    }
  },
  methods : {
    async addGenre() {
      const newGenre = {
        genreName : this.genreName,
        description : this.description,
        imageUrl : this.imageURL,
      };
      
      axios.post(this.baseURL+"bookstore/genre/create", newGenre)
      .then(() => {
          this.$emit("fetchData");
          this.$router.push({name: 'AdminGenre'});
          swal({
              text: "Genre added!",
              icon: "success"
          })
        }).catch((err) => {
            console.log("err", err);
        });
    }
  },
  mounted(){
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