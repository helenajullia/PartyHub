<template>
  <div class="home-container">
    <header class="header">
      <div class="logo">PartyHub</div>
      <nav class="nav">
        <a href="#" class="nav-link">Home</a>
        <a href="#" class="nav-link">About</a>
        <a href="#" class="nav-link">Features</a>
        <a href="#" class="nav-link">Contact</a>
      </nav>
      <!-- <div class="user-info">
        <i class="fas fa-user-circle user-icon"></i>
        <span class="username">{{ username }}</span>
      </div> -->
    </header>

    <section class="hero">
      <div class="hero-content">
        <h1>Welcome to PartyHub</h1>
        <p>Your ultimate platform to organize and enjoy parties with friends!</p>
        <button class="hero-button" @click="goToPlanYourParty">Start Planning</button>
      </div>
    </section>

    <section class="features">
      <div class="feature">
        <h3>Organize Events</h3>
        <p>Create and customize parties, set budgets, and assign responsibilities.</p>
      </div>
      <div class="feature">
        <h3>Invite Friends</h3>
        <p>Send invitations and track RSVPs easily with PartyHub.</p>
      </div>
      <div class="feature">
        <h3>Stay Connected</h3>
        <p>Communicate and plan seamlessly with everyone involved.</p>
      </div>
    </section>

    <footer class="footer">
      <p>&copy; 2024 PartyHub. All rights reserved.</p>
    </footer>
  </div>
</template>

<script>
export default {
  name: 'HomeView',
  // data() {
  //   return {
  //     username: localStorage.getItem('username') || 'Guest'
  //   };
  // },
  methods: {
  goToPlanYourParty() {
    this.$router.push('/plan');
  }
},
  // mounted() {
  //   
  //   this.username = localStorage.getItem('username') || 'Guest';
  // }
};
</script>

<style scoped>
@import url('https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css'); 

* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

html, body {
  height: 100%;
  margin: 0;
  padding: 0;
  font-family: Arial, sans-serif;
}

.home-container {
  display: flex;
  flex-direction: column;
  min-height: 100vh;
  width: 100vw;
}

.header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 1rem 2rem;
  background-color: #e63946;
  color: white;
  width: 100%;
  box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.2);
}

.logo {
  font-size: 1.5rem;
  font-weight: bold;
  color: white;
}

.nav {
  display: flex;
  gap: 1.5rem;
}

.nav-link {
  color: white;
  text-decoration: none;
  font-size: 1rem;
  transition: color 0.3s, transform 0.2s;
}

.nav-link:hover {
  color: #f0f0f0;
  transform: scale(1.1);
}

.user-info {
  display: flex;
  align-items: center;
  color: white;
  font-size: 1rem;
}

.user-icon {
  font-size: 1.5rem;
  margin-right: 8px;
}

.hero {
  flex: 1;
  display: flex;
  align-items: center;
  justify-content: center;
  width: 100vw;
  background-image: url('@/assets/images/party-background2.jpg');
  background-size: cover;
  background-position: center;
  text-align: center;
  color: white;
  padding: 0 2rem;
}

.hero-content {
  max-width: 600px;
  background-color: rgba(0, 0, 0, 0.6);
  padding: 30px;
  border-radius: 10px;
}

.hero h1 {
  font-size: 3rem;
  margin-bottom: 1rem;
}

.hero p {
  font-size: 1.25rem;
  margin-bottom: 1.5rem;
  color: #f0f0f0;
}

.hero-button {
  padding: 0.75rem 1.5rem;
  font-size: 1rem;
  background-color: #ffffff;
  color: #e63946;
  border: none;
  border-radius: 25px;
  cursor: pointer;
  transition: background-color 0.3s, transform 0.2s;
}

.hero-button:hover {
  background-color: #f0f0f0;
  transform: scale(1.05);
}

.features {
  display: flex;
  justify-content: space-around;
  flex-wrap: wrap;
  width: 100%;
  padding: 3rem 2rem;
  background-color: #f5f5f5;
}

.feature {
  flex: 1 1 30%;
  max-width: 300px;
  margin: 1rem;
  text-align: center;
}

.feature h3 {
  font-size: 1.5rem;
  margin-bottom: 1rem;
  color: #e63946;
}

.feature p {
  font-size: 1rem;
  color: #666;
}

.footer {
  text-align: center;
  padding: 1rem;
  background-color: #333;
  color: white;
  font-size: 0.875rem;
  width: 100%;
}

@media (max-width: 768px) {
  .nav {
    flex-direction: column;
    gap: 0.5rem;
  }

  .features {
    flex-direction: column;
    align-items: center;
  }

  .feature {
    max-width: 80%;
  }

  .hero h1 {
    font-size: 2.5rem;
  }

  .hero p {
    font-size: 1rem;
  }

  .hero-button {
    font-size: 0.9rem;
  }
}
</style>
