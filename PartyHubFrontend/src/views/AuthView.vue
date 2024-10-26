<template>
  <div class="auth-container">
    <div class="auth-box">
      <div class="auth-box-left">
        <h2>Welcome Back!</h2>
        <p>To keep connected with us please login with your personal info</p>
        <button class="btn-signin" @click="goToLogin">Sign In</button>
      </div>

      <div class="auth-box-right">
        <h2>Create Account</h2>
        <form @submit.prevent="handleSignup" class="form-signup">
          <input type="text" placeholder="Full Name" v-model="fullName" class="input-field" />
          <input type="text" placeholder="Username" v-model="username" class="input-field" />
          <input type="email" placeholder="Email" v-model="email" class="input-field" />
          <input type="password" placeholder="Password" v-model="password" class="input-field" />
          <button type="submit" class="btn-signup">Sign Up</button>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
import { registerUser } from '@/services/user_service';

export default {
  name: 'AuthView',
  data() {
    return {
      fullName: '',
      username: '',
      email: '',
      password: ''
    };
  },
  methods: {
    goToLogin() {
      this.$router.push('/login');
    },
    async handleSignup() {
  const userData = {
    fullName: this.fullName,
    username: this.username,
    email: this.email,
    password: this.password
  };

  try {
    const response = await registerUser(userData);
    console.log("Server response:", response); 

    if (response && response.message) {
      localStorage.setItem('userId', response.userId);
      localStorage.setItem('username', response.username);
      
      
      console.log("Saved userId:", localStorage.getItem('userId'));
      console.log("Saved username:", localStorage.getItem('username'));

      alert(response.message);
      this.$router.push('/home');
    } else {
      alert('Registration failed. Please try again.');
    }
  } catch (error) {
    console.error("Error in registration:", error);
    alert('Failed to register user');
  }
}

  }
};
</script>
<style scoped>
.auth-container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  width: 100vw;
  background-color: #f0f0f0;
  padding: 0;
  margin: 0;
}

.auth-box {
  display: flex;
  width: 90%;
  max-width: 1200px;
  height: 70%;
  background: white;
  border-radius: 8px;
  overflow: hidden;
  box-shadow: 0px 4px 20px rgba(0, 0, 0, 0.15);
}

.auth-box-left, .auth-box-right {
  flex: 1;
  display: flex;
  flex-direction: column;
  justify-content: center;
  padding: 30px;
  text-align: center;
}

.auth-box-left {
  background-image: url('@/assets/images/auth-background.jpg');
  background-size: cover;
  background-position: center;
  color: #fff;
}

.auth-box-left h2 {
  margin-bottom: 20px;
  color: #ffffff;
}

.auth-box-left p {
  margin-bottom: 40px;
  color: #cccccc;
}

.btn-signin {
  background-color: rgba(255, 255, 255, 0.9);
  color: #e63946;
  border: none;
  padding: 10px 20px;
  border-radius: 25px;
  font-size: 14px;
  cursor: pointer;
  width: 70%;
  margin: 0 auto;
  transition: background-color 0.3s ease, transform 0.2s ease;
}

.btn-signin:hover {
  background-color: #ffffff;
  transform: scale(1.05);
}

.auth-box-right h2 {
  margin-bottom: 20px;
  color: #333333;
}

.form-signup {
  display: flex;
  flex-direction: column;
  gap: 15px;
  align-items: center;
}

.input-field {
  padding: 10px;
  font-size: 14px;
  border-radius: 5px;
  border: 1px solid #dddddd;
  width: 70%;
  background-color: #f8f8f8;
}

.btn-signup {
  background-color: #e63946;
  color: white;
  border: none;
  padding: 10px;
  border-radius: 25px;
  font-size: 14px;
  cursor: pointer;
  width: 50%;
  transition: background-color 0.3s ease, transform 0.2s ease;
}

.btn-signup:hover {
  background-color: #d62828;
  transform: scale(1.05);
}

@media (max-width: 768px) {
  .auth-box {
    flex-direction: column;
    height: auto;
  }

  .auth-box-left, .auth-box-right {
    padding: 20px;
  }

  .btn-signin, .btn-signup {
    font-size: 12px;
    padding: 8px 12px;
  }

  .input-field, .btn-signup {
    width: 80%;
  }
}
</style>
