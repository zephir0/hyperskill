package cinema;

import javax.naming.NameNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Cinema {
    private static int ticketPrice;
    private static final int ifLessThan60Price = 10;
    private static final int frontRowsPrice = 10;
    private static final int backRowsPrice = 8;
    private static final char SEAT = 'S';
    private static char[][] cinemaHall;
    private static int counter = 0;
    public static int totalNumberOfSeats;
    private static int seatRow;
    private static int seatNumber;
    public static int totalIncome;
    public static int currentIncome;

    public static void main(String[] args) {
        makeCinema();
    }

    public static void makeCinema() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();
        if (rows <= 9 && seats <= 9) {
            cinemaHall = new char[rows][seats];
        } else {
            System.out.println("The cinema is too big.");
            makeCinema();
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seats; j++) {
                cinemaHall[i][j] = SEAT;
            }
        }
        cinemaManager();
    }


    public static void printCinema() {
        System.out.println("Cinema: ");
        System.out.print(" ");
        for (int i = 0; i < cinemaHall[0].length; i++) {
            System.out.print(" " + (i + 1));
        }
        System.out.println();

        for (int i = 0; i < cinemaHall.length; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < cinemaHall[0].length; j++) {
                System.out.print(" " + cinemaHall[i][j]);
            }
            System.out.println();
        }
    }


    public static void makeTicket() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a row number: ");
        seatRow = scanner.nextInt();
        System.out.println("Enter a seat number in that row: ");
        seatNumber = scanner.nextInt();

        //TICKET PRICE
        totalNumberOfSeats = cinemaHall.length * cinemaHall[0].length;
        if (seatRow <= cinemaHall.length && seatNumber <= cinemaHall[0].length && (cinemaHall[seatRow - 1][seatNumber - 1] != 'B')) {
            if (totalNumberOfSeats <= 60) {
                ticketPrice = ifLessThan60Price;
            } else {
                int frontHalf = cinemaHall.length / 2;
                if (seatRow <= frontHalf) {
                    ticketPrice = frontRowsPrice;
                } else {
                    ticketPrice = backRowsPrice;
                }
                currentIncome += ticketPrice;
            }
        }

        if (seatRow > cinemaHall.length || seatNumber > cinemaHall[0].length) {
            System.out.println("Wrong input!");
            makeTicket();
        } else if (cinemaHall[seatRow - 1][seatNumber - 1] == 'B') {
            System.out.println("That ticket has already been purchased!");
            makeTicket();
        } else {
            cinemaHall[seatRow - 1][seatNumber - 1] = 'B';
            counter++; // DODAJE 1 DO LICZNIKA, JEŻELI ZAKUPIONO BILET
            System.out.println("Ticket price: $" + ticketPrice);
            System.out.println();

        }
    }

    public static void statistics() {

        System.out.println("Number of purchased tickets: " + counter); // LICZY ILE RAZY METODA MAKETICKET ZOSTAŁA
        double percentageOfSaledTickets = ((float) counter / (float) totalNumberOfSeats) * 100;
        if(counter == 0){
            percentageOfSaledTickets = 0;
        }
        System.out.println("Percentage: " + String.format("%.2f", percentageOfSaledTickets) + "%");
        printCurrentIncome();
        printTotalIncome();

        // IF ALL SPACES TAKEN - TYLKO DZIAŁA DOPIERO PO ZAKUPIENIU BILETU / PO SAMYM STWORZENIU KINA WYWALA 0.
    }

    public static void cinemaManager() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
        int answer = scanner.nextInt();
        switch (answer) {
            case 1:
                printCinema();
                cinemaManager();
                break;
            case 2:
                makeTicket();
                cinemaManager();
                break;
            case 3:
                statistics();
                cinemaManager();
                break;
            case 0:
                scanner.close();
                break;
            default:
                cinemaManager();
        }
    }

    public static void printTotalIncome() {
        totalNumberOfSeats = cinemaHall.length * cinemaHall[0].length;
        if (totalNumberOfSeats <= 60) {
            totalIncome = totalNumberOfSeats * 10;
        } else {
            if (cinemaHall.length % 2 == 1) {
                int firstHalf = cinemaHall.length / 2;
                int secondHalf = cinemaHall.length / 2 + 1;
                int totalIncomeFirstHalf = firstHalf * cinemaHall[0].length * 10;
                int totalIncomeSecondHalf = secondHalf * cinemaHall[0].length * 8;
                totalIncome = totalIncomeFirstHalf + totalIncomeSecondHalf;
            } else {
                int firstHalf = cinemaHall.length / 2;
                int secondHalf = cinemaHall.length / 2;
                int totalIncomeFirstHalf = firstHalf * cinemaHall[0].length * 10;
                int totalIncomeSecondHalf = secondHalf * cinemaHall[0].length * 8;
                totalIncome = totalIncomeFirstHalf + totalIncomeSecondHalf;
            }
        }
        System.out.println("Total income: $" + totalIncome);
    }

    public static void printCurrentIncome() {
        System.out.println("Current income: $" + currentIncome);
    }

 //// ZAMIENIĆ NAN NA 0% I CHYBA BĘÐZIE SKOŃCZONE
}
