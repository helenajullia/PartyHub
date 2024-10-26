export async function registerUser(userData) {
    try {
      const response = await fetch('http://localhost:8080/api/users/register', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(userData)
      });
  
      console.log("Response status:", response.status);
      if (!response.ok) {
        const errorText = await response.text();
        console.error("Error response text:", errorText);
        throw new Error('Failed to register user');
      }
  
      const responseData = await response.json();
      localStorage.setItem('userId', responseData.userId);
      localStorage.setItem('username', responseData.username);
  
      return responseData;
    } catch (error) {
      console.error('Error in registerUser:', error);
      throw error;
    }
  }
  export async function verifyUser(loginData) {
    try {
      const response = await fetch('http://localhost:8080/api/users/verify', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(loginData)
      });
  
      console.log("Response status:", response.status);
      if (!response.ok) {
        const errorText = await response.text();
        console.error("Error response text:", errorText);
        throw new Error('Failed to verify user');
      }
  
      const responseData = await response.json();
      localStorage.setItem('userId', responseData.userId);
      
  
      return responseData;
    } catch (error) {
      console.error('Error in verifyUser:', error);
      throw error;
    }
  }
  