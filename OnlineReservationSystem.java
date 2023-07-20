import java.util.ArrayList;
import java.util.Scanner;

class Reservation {
    private String name;
    private String trainNumber;
    private String classType;
    private String dateOfJourney;
    private String from;
    private String destination;

    public Reservation(String name, String trainNumber, String classType, String dateOfJourney, String from, String destination) {
        this.name = name;
        this.trainNumber = trainNumber;
        this.classType = classType;
        this.dateOfJourney = dateOfJourney;
        this.from = from;
        this.destination = destination;
    }

    // Getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public String getDateOfJourney() {
        return dateOfJourney;
    }

    public void setDateOfJourney(String dateOfJourney) {
        this.dateOfJourney = dateOfJourney;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}

class ReservationSystem {
    private ArrayList<Reservation> reservations;

    public ReservationSystem() {
        this.reservations = new ArrayList<>();
    }

    public void makeReservation(Reservation reservation) {
        reservations.add(reservation);
        System.out.println("Reservation successful!");
    }

    public void viewAllReservations() {
        for (Reservation reservation : reservations) {
            System.out.println("Name: " + reservation.getName());
            System.out.println("Train Number: " + reservation.getTrainNumber());
            System.out.println("Class Type: " + reservation.getClassType());
            System.out.println("Date of Journey: " + reservation.getDateOfJourney());
            System.out.println("From: " + reservation.getFrom());
            System.out.println("Destination: " + reservation.getDestination());
            System.out.println("--------------------------");
        }
    }

    public void cancelReservation(String name) {
        for (Reservation reservation : reservations) {
            if (reservation.getName().equals(name)) {
                reservations.remove(reservation);
                System.out.println("Reservation canceled!");
                return;
            }
        }
        System.out.println("No reservation found for the given name.");
    }
}

public class OnlineReservationSystem {
    public static void main(String[] args) {
        ReservationSystem reservationSystem = new ReservationSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to the Online Reservation System");
            System.out.println("1. Make a reservation");
            System.out.println("2. View all reservations");
            System.out.println("3. Cancel a reservation");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter train number: ");
                    String trainNumber = scanner.nextLine();
                    System.out.print("Enter class type: ");
                    String classType = scanner.nextLine();
                    System.out.print("Enter date of journey: ");
                    String dateOfJourney = scanner.nextLine();
                    System.out.print("Enter from: ");
                    String from = scanner.nextLine();
                    System.out.print("Enter destination: ");
                    String destination = scanner.nextLine();
                    Reservation reservation = new Reservation(name, trainNumber, classType, dateOfJourney, from, destination);
                    reservationSystem.makeReservation(reservation);
                    break;
                case 2:
                    reservationSystem.viewAllReservations();
                    break;
                case 3:
                    System.out.print("Enter your name to cancel the reservation: ");
                    String cancelName = scanner.nextLine();
                    reservationSystem.cancelReservation(cancelName);
                    break;
                case 4:
                    System.out.println("Exiting the program...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
