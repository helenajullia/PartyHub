<template>
  <div class="home-container">
    <div class="overlay"></div>
    <div class="content">
      <div class="text-background">
        <h1>PartyHub</h1>
        <p>Plan the ultimate party with friends.</p>
        <button class="btn" @click="goToAuth">Get Started</button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  methods: {
    goToAuth() {
      this.$router.push('/auth');
    }
  }
};
</script>

<style scoped>
.home-container {
  position: relative;
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  width: 100vw;
  background-image: url('@/assets/images/party-background2.jpg');
  background-size: cover;
  background-position: center;
  padding: 0;
  margin: 0;
  color: #ffffff;
}

.overlay {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.7);
}

.content {
  position: relative;
  text-align: center;
  padding: 20px;
  z-index: 1;
}

.text-background {
  background-color: rgba(128, 128, 128, 0.3);
  padding: 20px 30px;
  border-radius: 8px;
}

h1 {
  font-size: 2rem;
  margin-bottom: 10px;
  color: #ffffff;
  font-weight: 600;
}

p {
  font-size: 1rem;
  margin-bottom: 20px;
  color: #cccccc;
}

.btn {
  padding: 8px 16px;
  background-color: #ffffff;
  color: #333333;
  border: none;
  border-radius: 3px;
  font-size: 0.9rem;
  cursor: pointer;
  transition: background-color 0.3s ease, transform 0.2s ease;
}

.btn:hover {
  background-color: #f0f0f0;
  transform: scale(1.05);
}
</style>
