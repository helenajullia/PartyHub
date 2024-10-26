<template>
  <div>
    <header class="header">
      <div class="logo">PartyHub</div>
      <nav class="nav">
        <a href="#" class="nav-link">Home</a>
        <a href="#" class="nav-link">About</a>
        <a href="#" class="nav-link">Features</a>
        <a href="#" class="nav-link">Contact</a>
      </nav>
      <div class="user-info" @click="goToUserEvents" style="cursor: pointer;">
        <i class="fas fa-user-circle user-icon"></i>
        <span class="username">{{ username }}</span>
      </div>
    </header>

    <div class="plan-party-container">
      <h1>Create Your Event</h1>
      <p class="subtitle">Plan and customize every aspect of your event with ease.</p>
      <form @submit.prevent="handleSubmit" class="event-form">
        <input type="text" placeholder="Event Name" v-model="eventName" class="input-field" />
        <input type="text" placeholder="Location" v-model="location" class="input-field" />
        <input type="number" placeholder="Budget" v-model="budget" class="input-field" />
        <input type="datetime-local" v-model="date" class="input-field" />
        <textarea v-model="description" placeholder="Event Description" class="input-field textarea"></textarea>
        <button type="submit" class="btn-submit">Create Event</button>
      </form>
    </div>
  </div>
</template>

<script>
import { createEvent } from '@/services/event_service';

export default {
  name: 'PlanYourParty',
  data() {
    return {
      username: localStorage.getItem('username') || 'Guest',
      eventName: '',
      location: '',
      budget: null,
      date: '',
      description: ''
    };
  },
  methods: {
    async handleSubmit() {
  const organizerId = localStorage.getItem('userId');
  const organizerUsername = localStorage.getItem('username');

  if (!organizerId) {
    alert('User ID not found. Please log in again.');
    return;
  }

  const eventData = {
    name: this.eventName,
    location: this.location,
    budget: this.budget,
    date: new Date(this.date).toISOString(), 
    description: this.description,
    organizer_id: parseInt(organizerId),
    organizer_username: organizerUsername
  };

  try {
    const response = await createEvent(eventData);
    alert(response.message);

    this.eventName = '';
    this.location = '';
    this.budget = null;
    this.date = '';
    this.description = '';
  } catch (error) {
    alert('Failed to create event');
  }
}, goToUserEvents() {
    this.$router.push('/my-events');
  }
  }
};
</script>

<style scoped>
.header {
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  z-index: 1000;
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
  cursor: pointer; 
}

.user-icon {
  font-size: 1.5rem;
  margin-right: 8px;
}

.plan-party-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  padding: 2rem;
  background-image: url('@/assets/images/party-background2.jpg');
  background-size: cover;
  background-position: center;
  background-repeat: no-repeat;
  width: 100vw;
  height: 100vh;
  color: white;
  text-align: center;
  margin-top: 80px;
}

h1 {
  font-size: 2.5rem;
  color: #ffffff;
  margin-bottom: 1rem;
}

.subtitle {
  font-size: 1.2rem;
  margin-bottom: 2rem;
  color: #ffffffbb;
}

.event-form {
  display: flex;
  flex-direction: column;
  gap: 1rem;
  width: 90%;
  max-width: 600px;
  background-color: rgba(255, 255, 255, 0.9);
  padding: 2rem;
  border-radius: 10px;
  box-shadow: 0px 4px 20px rgba(0, 0, 0, 0.2);
}

.input-field {
  padding: 0.75rem;
  font-size: 1rem;
  border-radius: 5px;
  border: 1px solid #ddd;
}

.textarea {
  min-height: 100px;
  resize: vertical;
}

.btn-submit {
  padding: 0.75rem;
  font-size: 1.2rem;
  background-color: #e63946;
  color: white;
  border: none;
  border-radius: 25px;
  cursor: pointer;
  transition: background-color 0.3s ease, transform 0.2s ease;
}

.btn-submit:hover {
  background-color: #d62828;
  transform: scale(1.05);
}
</style>
