package machine;

import java.util.Scanner;

public class CoffeeMachine {
    private static int waterAvailable = 400;
    private static int milkAvailable = 540;
    private static int coffeBeansAvailable = 120;
    private static int cupsAvailable = 9;
    private static int moneyAvailable = 550;
    private static boolean exit = false;


    public static void main(String[] args) {

        while (exit == false) {
            programStart();
            System.out.println();
        }

    }

    public static void fill() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water you want to add: ");
        int addWater = scanner.nextInt();
        waterAvailable += addWater;
        System.out.println("Write how many ml of milk you want to add: ");
        int addMilk = scanner.nextInt();
        milkAvailable += addMilk;
        System.out.println("Write how many grams of coffee beans you want to add: ");
        int addCoffeeBeans = scanner.nextInt();
        coffeBeansAvailable += addCoffeeBeans;
        System.out.println("Write how many disposable cups of coffee you want to add: ");
        int addCups = scanner.nextInt();
        cupsAvailable += addCups;
    }

    public static void programStart() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write action (buy, fill, take, remaining, exit): ");
        String action = scanner.nextLine();
        switch (action) {
            case "buy":
                buy();
                break;
            case "fill":
                fill();
                break;
            case "take":
                take();
                break;
            case "remaining":
                machineStatus();
                break;
            case "exit":
                exit = true;
                break;
            default:
                System.out.println("Unrecognized command.");
                break;
        }
    }

    public static void machineStatus() {
        System.out.println("The coffee machine has: ");
        System.out.println(waterAvailable + " ml of water");
        System.out.println(milkAvailable + " ml of milk");
        System.out.println(coffeBeansAvailable + " g of coffee beans");
        System.out.println(cupsAvailable + " disposable cups");
        System.out.println("$" + moneyAvailable + " of money");
    }

    public static void take() {
        System.out.println("I gave you $" + moneyAvailable);
        System.out.println();
        moneyAvailable = 0;
    }

    public static void buy() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        String action = scanner.nextLine();
        switch (action) {
            case "1":
                espressoBuy();
                break;
            case "2":
                latteBuy();
                break;
            case "3":
                cappuccinoBuy();
                break;
            case "back":
                programStart();
            default:
                System.out.println("Wrong commands.");
                break;
        }
    }

    public static void espressoBuy() {
        int espressoCoffee = Math.min(Math.min(waterAvailable / 250, (coffeBeansAvailable / 16)), (cupsAvailable / 1));
        if (espressoCoffee >= 1) {
            waterAvailable -= 250;
            coffeBeansAvailable -= 16;
            cupsAvailable -= 1;
            moneyAvailable += 4;
            successBuy();
        }
    }

    public static void latteBuy() {
        int latteCoffee = Math.min(Math.min(waterAvailable / 350, milkAvailable / 75), Math.min(coffeBeansAvailable / 20, cupsAvailable / 1));
        if (latteCoffee >= 1) {
            waterAvailable -= 350;
            milkAvailable -= 75;
            coffeBeansAvailable -= 20;
            cupsAvailable -= 1;
            moneyAvailable += 7;
            successBuy();
        }
    }

    public static void cappuccinoBuy() {
        int cappuccinoCoffee = Math.min(Math.min(waterAvailable / 200, milkAvailable / 100), Math.min(coffeBeansAvailable / 12, cupsAvailable / 1));
        if (cappuccinoCoffee >= 1) {
            waterAvailable -= 200;
            milkAvailable -= 100;
            coffeBeansAvailable -= 12;
            cupsAvailable -= 1;
            moneyAvailable += 6;
            successBuy();
        }
    }

    public static void successBuy() {
        System.out.println("I have enough resources, making you a coffee!");

    }
}
