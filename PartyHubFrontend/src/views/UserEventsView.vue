<template>
    <div class="user-events-page">
      <header class="header">
        <div class="logo">PartyHub</div>
        <nav class="nav">
          <a href="#" class="nav-link">Home</a>
          <a href="#" class="nav-link">About</a>
          <a href="#" class="nav-link">Features</a>
          <a href="#" class="nav-link">Contact</a>
        </nav>
        <div class="user-info" @click="goToUserProfile">
          <i class="fas fa-user-circle user-icon"></i>
          <span class="username">{{ username }}</span>
        </div>
      </header>
  
      <main class="user-events-container">
        <h1>Your Events</h1>
        <ul v-if="events.length > 0" class="events-list">
          <li v-for="event in events" :key="event.id" class="event-item">
            <h2>{{ event.name }}</h2>
            <p><strong>Location:</strong> {{ event.location }}</p>
            <p><strong>Date:</strong> {{ new Date(event.date).toLocaleString() }}</p>
            <p><strong>Budget:</strong> {{ event.budget }}</p>
            <p><strong>Description:</strong> {{ event.description }}</p>
          </li>
        </ul>
        <p v-else class="no-events">No events found.</p>
      </main>
  
      <footer class="footer">
        <p>&copy; 2024 PartyHub. All rights reserved.</p>
      </footer>
    </div>
  </template>
  
  <script>
  import { fetchUserEvents } from '@/services/event_service';
  
  export default {
    name: 'UserEventsView',
    data() {
      return {
        events: [],
        username: localStorage.getItem('username') || 'Guest'
      };
    },
    async mounted() {
      const userId = localStorage.getItem('userId');
      if (userId) {
        try {
          const response = await fetchUserEvents(userId);
          this.events = response;
        } catch (error) {
          console.error('Failed to load events:', error);
        }
      } else {
        alert('User ID not found. Please log in again.');
        this.$router.push('/login');
      }
    },
    methods: {
      goToUserProfile() {
        this.$router.push('/profile');
      }
    }
  };
  </script>
  
  <style scoped>
  .header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 1rem 2rem;
    background-color: #e63946;
    color: white;
    position: fixed;
    width: 100%;
    top: 0;
    z-index: 1000;
    box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.2);
  }
  
  .logo {
    font-size: 1.5rem;
    font-weight: bold;
  }
  
  .nav {
    display: flex;
    gap: 1.5rem;
  }
  
  .nav-link {
    color: white;
    text-decoration: none;
    font-size: 1rem;
    transition: color 0.3s ease, transform 0.2s ease;
  }
  
  .nav-link:hover {
    color: #f0f0f0;
    transform: scale(1.1);
  }
  
  .user-info {
    display: flex;
    align-items: center;
    color: white;
    cursor: pointer;
  }
  
  .user-icon {
    font-size: 1.5rem;
    margin-right: 8px;
  }
  

  .user-events-page {
    display: flex;
    flex-direction: column;
    min-height: 100vh;
    padding-top: 80px;
  }
  
  .user-events-container {
    padding: 2rem;
    color: #333;
    text-align: center;
    max-width: 800px;
    margin: auto;
  }
  
  .user-events-container h1 {
    font-size: 2.5rem;
    color: #e63946;
    margin-bottom: 1.5rem;
  }
  
  .events-list {
    list-style: none;
    padding: 0;
  }
  
  .event-item {
    background: #ffffff;
    padding: 1.5rem;
    margin-bottom: 1rem;
    border-radius: 8px;
    box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.15);
    transition: transform 0.3s ease;
  }
  
  .event-item:hover {
    transform: scale(1.03);
  }
  
  .event-item h2 {
    font-size: 1.8rem;
    color: #e63946;
    margin-bottom: 0.5rem;
  }
  
  .event-item p {
    font-size: 1rem;
    color: #333;
    margin: 0.3rem 0;
  }
  
  .no-events {
    font-size: 1.2rem;
    color: #666;
    margin-top: 2rem;
  }
  

  .footer {
  text-align: center;
  padding: 1rem;
  background-color: #333;
  color: white;
  font-size: 0.875rem;
  width: 100%;
  bottom: 0;
}
  </style>
  