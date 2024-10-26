<template>
    <div class="user-events-container">
      <h1>Your Events</h1>
      <ul v-if="events.length > 0">
        <li v-for="event in events" :key="event.id" class="event-item">
          <h2>{{ event.name }}</h2>
          <p><strong>Location:</strong> {{ event.location }}</p>
          <p><strong>Date:</strong> {{ new Date(event.date).toLocaleString() }}</p>
          <p><strong>Budget:</strong> {{ event.budget }}</p>
          <p><strong>Description:</strong> {{ event.description }}</p>
        </li>
      </ul>
      <p v-else>No events found.</p>
    </div>
  </template>
  
  <script>
  import { fetchUserEvents } from '@/services/event_service';
  
  export default {
    name: 'UserEventsView',
    data() {
      return {
        events: []
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
    }
  };
  </script>
  
  <style scoped>
  .user-events-container {
    padding: 2rem;
    color: #333;
  }
  .event-item {
    background: #f9f9f9;
    padding: 1rem;
    margin-bottom: 1rem;
    border-radius: 5px;
    box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
  }
  </style>
  