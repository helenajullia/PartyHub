export async function createEvent(eventData) {
    try {
      console.log("Sending event data to server:", eventData);
  
      const response = await fetch('http://localhost:8080/api/events', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(eventData),
      });
  
      if (!response.ok) {
        const errorText = await response.text();
        console.error("Server error response:", errorText);
        throw new Error('Failed to create event');
      }
  
      return await response.json();
    } catch (error) {
      console.error('Error creating event:', error);
      throw error;
    }
  }
  export async function fetchUserEvents(userId) {
    try {
      const response = await fetch(`http://localhost:8080/api/events/user/${userId}`);
      if (!response.ok) {
        throw new Error('Failed to fetch user events');
      }
      return await response.json();
    } catch (error) {
      console.error('Error fetching user events:', error);
      throw error;
    }
  }
  