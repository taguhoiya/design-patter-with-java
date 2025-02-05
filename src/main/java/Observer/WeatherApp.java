package Observer;

import java.util.ArrayList;
import java.util.List;


// Observer defines an interface with an update method that concrete observers must implement and
// ensures a common or consistent way for concrete observers to receive updates from the subject.
// The “Observer" interface defines a contract for objects that want to be notified about changes in
// the subject (“WeatherStation" in this case).
// It includes a method “update" that concrete observers must implement to receive and handle
// updates.
interface Observer {
  void update(String weather);
}


// The subject maintains a list of observers (subscribers or listeners).
// It Provides methods to register and unregister observers dynamically and defines a method to
// notify observers of changes in its state.
// The “Subject" interface outlines the operations a subject (like “WeatherStation") should support.
// "addObserver" and “removeObserver" are for managing the list of observers.
// "notifyObservers" is for informing observers about changes.
interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}


// ConcreteSubjects are specific implementations of the subject. They hold the actual state or data
// that observers want to track. When this state changes, concrete subjects notify their observers.
// For instance, if a weather station is the subject, specific weather stations in different
// locations would be concrete subjects.
// "WeatherStation" is the concrete subject implementing the “Subject" interface.
// It maintains a list of observers (“observers") and provides methods to manage this list.
// "notifyObservers" iterates through the observers and calls their “update" method, passing the
// current weather.
// "setWeather" method updates the weather and notifies observers of the change.
class WeatherStation implements Subject {
  private List<Observer> observers = new ArrayList<>();
  private String weather;

  @Override
  public void addObserver(Observer observer) {
    observers.add(observer);
  }

  @Override
  public void removeObserver(Observer observer) {
    observers.remove(observer);
  }

  @Override
  public void notifyObservers() {
    for (Observer observer : observers) {
      observer.update(weather);
    }
  }

  public void setWeather(String newWeather) {
    this.weather = newWeather;
    notifyObservers();
  }
}


// Concrete Observer implements the observer interface. They register with a concrete subject and
// react when notified of a state change.
// When the subject’s state changes, the concrete observer’s update() method is invoked, allowing it
// to take appropriate actions.
// For example, a weather app on your smartphone is a concrete observer that reacts to changes from
// a weather station.
// "PhoneDisplay" is a concrete observer implementing the “Observer" interface.
// It has a private field weather to store the latest weather.
// The “update" method sets the new weather and calls the “display" method.
// "display" prints the updated weather to the console.
// ConcreteObserver Class
class PhoneDisplay implements Observer {
  private String weather;

  @Override
  public void update(String weather) {
    this.weather = weather;
    display();
  }

  private void display() {
    System.out.println("Phone Display: Weather updated - " + weather);
  }
}


// ConcreteObserver Class
class TVDisplay implements Observer {
  private String weather;

  @Override
  public void update(String weather) {
    this.weather = weather;
    display();
  }

  private void display() {
    System.out.println("TV Display: Weather updated - " + weather);
  }
}


// Usage Class
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
