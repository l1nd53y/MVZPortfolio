<template>
    <div class="card h-100 w-100">
        <div class="embed-responsive embed-responsive-16by9">
            <img
                class="card-img-top embed-responsive-item"
                :src="book.imageURL"
                alt="Card image cap"
            />
        </div>
        <div class="card-body">
            <router-link :to="{ name: 'ShowDetails', params: { id : book.id } }"><h5 class="card-title">{{book.title}}</h5></router-link>
            <p class="card-text"><sup>$</sup>{{book.price}}</p>
      <p class="card-text font-italic">{{book.description.substring(0,65)}}...</p>
      <router-link id="edit-book" :to="{name : 'EditBook', params : {id : book.id} }" v-show="$route.name=='AdminBook'">
        Edit
      </router-link>
        </div>
    </div>
</template>
<script>
    export default {
        name: "BookBox",
        props: ["book"]
    }
</script>
<style scoped>
    .embed-responsive .card-img-top {
  object-fit: cover;
}
a {
  text-decoration: none;
}
.card-title {
  color: #484848;
  font-size: 1.1rem;
  font-weight: 400;
}
.card-title:hover {
  font-weight: bold;
}
.card-text {
  font-size: 0.9rem;
}
#edit-book {
  float: right;
}
</style>