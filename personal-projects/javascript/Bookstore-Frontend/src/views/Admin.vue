<template>
<div class="container py-4">
    <router-link :to="{name: 'AdminGenre'}" >
        <button class="btn btn-primary btn-lg"> Admin Genre</button>
    </router-link>
    <br />
    <router-link :to="{name: 'AdminBook'}" >
        <button class="btn btn-primary btn-lg"> Admin Book</button>
    </router-link>
</div>

</template>
<script>
export default {
    mounted() {
    if (!localStorage.getItem('token')) {
      this.$router.push({name : 'Signin'});
    }
  }
}
</script>
<style>
    .btn {
        margin-bottom: 20px;
    }
</style>