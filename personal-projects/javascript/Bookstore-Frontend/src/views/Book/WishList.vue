<template>
  <div class="container">
    <div class="row">
      <div class="col-12 text-center">
        <h4 class="pt-3">Your WishList</h4>
      </div>
    </div>

    <!-- diaplay products -->

    <div class="row">
      <div
        v-for="book of books"
        :key="book.id"
        class="col-md-6 col-xl-4 col-12 pt-3 justify-content-around d-flex"
      >
        <BookBox :book="book"> </BookBox>
      </div>
    </div>
  </div>
</template>
<script>
import axios from "axios";
import BookBox from "../../components/BookBox.vue";
export default {
  components: { BookBox },
  data() {
    return {
      token: null,
      books: null,
    };
  },
  props: ["baseURL"],
  methods: {
    fetchWishList() {
      axios
        .get(`${this.baseURL}wishlist/${this.token}`)
        .then((data) => {
          this.books = data.data;
        })
        .catch((err) => {
          console.log("err", err);
        });
    },
  },
  mounted() {
    this.token = localStorage.getItem("token");
    this.fetchWishList();
  },
};
</script>