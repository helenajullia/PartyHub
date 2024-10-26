export async function createEvent(eventData) {
    try {
      const response = await fetch('http://localhost:8080/api/events', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(eventData),
      });
  
      if (!response.ok) {
        throw new Error('Failed to create event');
      }
  
      return await response.json();
    } catch (error) {
      console.error('Error creating event:', error);
      throw error;
    }
  } 