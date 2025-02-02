package Observer;

// The Observer Design Pattern is a behavioral design pattern that defines a one-to-many dependency
// between objects, so that when one object (the subject) changes state, all its dependent objects
// (the observers) are notified and updated automatically.
// It is commonly used to implement event handling systems,where multiple components need to react
// to changes in a specific object or state.

// When to Use:
// Implementing event handling systems(e.g.,GUIs,messaging systems).
// Reacting to changes in a central object(e.g.,stock prices,configuration changes).
// Distributed systems where multiple objects need to synchronize their state.

public class WeatherApp {
  public static void main(String[] args) {
    WeatherStation weatherStation = new WeatherStation();

    Observer phoneDisplay = new PhoneDisplay();
    Observer tvDisplay = new TVDisplay();

    weatherStation.addObserver(phoneDisplay);
    weatherStation.addObserver(tvDisplay);

    // Simulating weather change
    weatherStation.setWeather("Sunny");

    // Output:
    // Phone Display: Weather updated - Sunny
    // TV Display: Weather updated - Sunny
  }
}
