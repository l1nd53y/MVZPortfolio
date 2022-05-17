<template>
  <div class="container">
    <div class="row">
      <div class="col-12 text-center">
        <h4 class="pt-3">Edit Genre</h4>
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
            <input type="url" class="form-control" v-model="imageUrl" required>
          </div>
          <button type="button" class="btn btn-primary" @click="editGenre">Submit</button>
        </form>
      </div>
      <div class="col-3"></div>
    </div>
  </div>
</template>

<script>
const axios =  require('axios')
import swal from 'sweetalert';
export default {
  data(){
    return {
      id : null,
      genreName : null,
      description : null,
      imageUrl : null,
      genreIndex : null
    }
  },
  props : ["baseURL", "genres"],
  methods : {
    async editGenre() {
      const updatedGenre = {
        id : this.id,
        genreName : this.genreName,
        description : this.description,
        imageUrl : this.imageUrl,
      };
      axios.post(this.baseURL+"bookstore/genre/update/"+this.id, updatedGenre)
      .then(() => {
          this.$emit("fetchData");
          this.$router.push({name: 'AdminGenre'});
          swal({
              text: "Genre updated!",
              icon: "success"
          })
        }).catch((err) => {
            console.log("err", err);
        });
    }
  },
  mounted() {
    this.id = this.$route.params.id;
    this.genre = this.genres.filter(genre => genre.id == this.id)[0];
    this.genreName = this.genre.genreName;
    this.description = this.genre.description;
    this.imageUrl = this.genre.imageUrl;
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