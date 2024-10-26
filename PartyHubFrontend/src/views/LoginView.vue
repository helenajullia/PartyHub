<template>
  <div class="login-container">
    <div class="login-box">
      <div class="login-box-left">
        <h2>Sign in to MealMuse</h2>
        <form @submit.prevent="handleLogin" class="login-form">
          <input type="text" placeholder="Username" v-model="username" class="input-field" />
          <input type="password" placeholder="Password" v-model="password" class="input-field" />
          <a href="#" class="forgot-password">Forgot your password?</a>
          <button type="submit" class="btn-login">Sign In</button>
        </form>
      </div>
      <div class="login-box-right">
        <h2>Hello, Friend!</h2>
        <p>Enter your personal details and start your journey with us</p>
        <button class="btn-signup" @click="goToSignup">Sign Up</button>
      </div>
    </div>
  </div>
</template>

<script>
import { verifyUser } from '@/services/user_service'; 

export default {
  name: 'LoginView',
  data() {
    return {
      username: '',
      password: ''
    };
  },
  methods: {
    goToSignup() {
      this.$router.push('/auth');
    },
    async handleLogin() {
  try {
    const loginData = {
      username: this.username,
      password: this.password
    };

    const response = await verifyUser(loginData);

    if (response.message === "User exists") {
      alert(response.message);

      localStorage.setItem('userId', response.userId);
      localStorage.setItem('username', response.username);

      this.$router.push('/home');
    } else {
      alert('Invalid username or password');
    }
  } catch (error) {
    alert('Failed to verify user');
  }
}
  }
};
</script>

<style scoped>
.login-container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  width: 100vw;
  background-color: #f0f0f0;
  padding: 0;
  margin: 0;
}

.login-box {
  display: flex;
  width: 90%;
  max-width: 1200px;
  height: 70%;
  background: white;
  border-radius: 8px;
  overflow: hidden;
  box-shadow: 0px 4px 20px rgba(0, 0, 0, 0.1);
}

.login-box-left, .login-box-right {
  flex: 1;
  display: flex;
  flex-direction: column;
  justify-content: center;
  padding: 30px;
  text-align: center;
}

.login-box-left {
  background-color: #ffffff;
  color: #333;
}

.login-box-right {
  background-image: url('@/assets/images/auth-background.jpg');
  background-size: cover;
  background-position: center;
  color: white;
}

.login-box-left h2,
.login-box-right h2 {
  margin-bottom: 20px;
}

.login-box-right p {
  margin-bottom: 40px;
}

.login-form {
  display: flex;
  flex-direction: column;
  gap: 10px;
  align-items: center;
}

.input-field {
  padding: 8px;
  font-size: 14px;
  border-radius: 5px;
  border: 1px solid #dddddd;
  width: 70%;
}

.btn-login {
  background-color: #e63946;
  color: white;
  border: none;
  padding: 10px;
  border-radius: 25px;
  font-size: 14px;
  cursor: pointer;
  width: 50%;
  margin: 0 auto;
  transition: background-color 0.3s ease, transform 0.2s ease;
}

.btn-login:hover {
  background-color: #d62828;
  transform: scale(1.05);
}

.forgot-password {
  font-size: 12px;
  color: #666;
  text-decoration: none;
  margin-bottom: 20px;
}

.btn-signup {
  background-color: rgba(255, 255, 255, 0.9);
  color: #e63946;
  border: none;
  padding: 10px 16px;
  border-radius: 25px;
  font-size: 14px;
  cursor: pointer;
  width: 70%;
  margin: 0 auto;
  transition: background-color 0.3s ease, transform 0.2s ease;
}

.btn-signup:hover {
  background-color: #ffffff;
  transform: scale(1.05);
}

@media (max-width: 768px) {
  .login-box {
    flex-direction: column;
    height: auto;
  }

  .login-box-left, .login-box-right {
    padding: 20px;
  }

  .btn-login, .btn-signup {
    font-size: 12px;
    padding: 8px 12px;
  }

  .input-field, .btn-login {
    width: 80%;
  }
}
</style>
