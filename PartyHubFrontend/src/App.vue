<template>
  <div id="app">
    <router-view @userLoggedIn="updateUsername"></router-view>
  </div>
</template>

<script>
export default {
  data() {
    return {
      loggedInUsername: localStorage.getItem('username') || 'Guest'
    };
  },
  methods: {
    updateUsername(username) {
      this.loggedInUsername = username;
    }
  }
};
</script>

<style>
html, body, #app {
  margin: 0;
  padding: 0;
  width: 100%;
  height: 100%;
  box-sizing: border-box;
}
</style>


