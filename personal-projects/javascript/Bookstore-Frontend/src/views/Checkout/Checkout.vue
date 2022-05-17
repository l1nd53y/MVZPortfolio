<template>
  <div class="text-center">
<h3 class = "pt3">You will be redirected to payment page</h3>
    <div class="alert alert-primary">
      While making TEST payment use card number 4242 4242 4242 4242 and enter random
      date and CVV (3 digit)
    </div>

    <button class="btn btn-primary" @click="goToCheckout">Make Payment</button>
  </div>
</template>

<script>
import axios from 'axios';
export default {
  data() {
    return {
      stripeAPIToken: 'pk_test_51KQKAzJjzZZNW0zFccmgoaEgItmVpZS1CKlpteQFPiEZJhGDAk9VlspxXQgBE8D6vECWbern2M69Nv9vLCKoOC8m00MqXtTzuB',
      stripe: '',
      token: null,
      checkoutBodyArray: [],
    };
  },
  name: 'Checkout',
  props: ['baseURL'],
  methods: {
    getAllItems() {
      axios
        .get(`${this.baseURL}cart/?token=${this.token}`)
        .then((response) => {
          if (response.status == 200) {
            let books = response.data;
            for (let i = 0; i < books.cartItems.length; i++) {
              this.checkoutBodyArray.push({
                price: books.cartItems[i].book.price,
                quantity: books.cartItems[i].quantity,
                bookName: books.cartItems[i].book.title,
                bookId: books.cartItems[i].book.id,
              });
            }
          }
        })
        .catch((err) => console.log(err));
    },
    goToCheckout() {
      console.log('checkoutBodyArray', this.checkoutBodyArray);
      axios
        .post(
          `${this.baseURL}order/create-checkout-session`,
          this.checkoutBodyArray
        )
        .then((response) => {
          localStorage.setItem('sessionId', response.data.sessionId);
          console.log('session', response.data);
          this.stripe.redirectToCheckout({
            sessionId: response.data.sessionId,
          });
        })
        .catch((err) => console.log(err));
    },
  },
  mounted() {
    this.token = localStorage.getItem('token');
    this.stripe = window.Stripe(this.stripeAPIToken);
    this.getAllItems();
  },
};
</script>
<style scoped>
/* .alert {
  width: 50%;
  text-align: center;
} */
.div_class {
  margin-top: 5%;
  margin-left: 30%;
}
.checkout_button {
  background-color: #5d3dec;
  margin: 10px;
}
</style>