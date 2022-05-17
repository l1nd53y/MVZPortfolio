<template>
   <div class="container">
     <div class="row">
       <div class="col-12 text-center">
         <h4 class="pt-3">Genres</h4>
         <router-link :to="{name : 'AddGenre'}">
           <button class="btn" style="float: right">Add Genre</button>
         </router-link>
     </div>
</div>
<div class="row">
  <div v-for="genre of genres" :key="genre.id" class="col-xl-4 col-md-6 col-12 pt-3 d-flex">
      <GenreBox  :genre="genre" />
  </div>
</div>
</div>
</template>

<script>
import GenreBox from "@/components/Genre/GenreBox.vue"
const axios =  require('axios');
export default {
  name: "AdminGenre",
  //props: ["genres"],
  components: {GenreBox},
  data(){
    return {
      baseURL: "https://baobabookstore.herokuapp.com",
      genres: [],
    };
  },
  methods : {
    async getGenres() {
      await axios.get(`${this.baseURL}/bookstore/genre/`)
      .then(res => this.genres = res.data)
      .catch(err => console.log(err))
    }   
  },
  mounted() {
    this.getGenres();
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