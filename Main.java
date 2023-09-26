import java.util.Random;
import java.util.Scanner;

public class TextRPG {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int playerHealth = 100;
        int playerAttack = 20;
        int playerGold = 0;

        System.out.println("Welcome to my RPG!");
        System.out.println("You are to venture forth on this short adventure!");

        while (playerHealth > 0) {
            System.out.println("\nOptions:");
            System.out.println("1. Explore");
            System.out.println("2. Rest");
            System.out.println("3. Quit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    int monsterHealth = random.nextInt(50) + 50;
                    int monsterAttack = random.nextInt(10) + 10;

                    System.out.println("You encountered a boar!");

                    while (monsterHealth > 0 && playerHealth > 0) {
                        System.out.println("\n1. Attack");
                        System.out.println("2. Run");
                        System.out.print("Choose an action: ");
                        int action = scanner.nextInt();

                        if (action == 1) {

                            int damageDealt = random.nextInt(playerAttack);
                            int damageTaken = random.nextInt(monsterAttack);
                            monsterHealth -= damageDealt;
                            playerHealth -= damageTaken;

                            System.out.println("You dealt " + damageDealt + " damage to the boar.");
                            System.out.println("The boar dealt " + damageTaken + " damage to you.");
                        } else if (action == 2) {

                            System.out.println("You ran away from the boar.");
                            break;
                        }
                    }

                    if (playerHealth <= 0) {
                        System.out.println("Game Over! You were slain by the boar.");
                    } else {
                        int goldFound = random.nextInt(20) + 10;
                        playerGold += goldFound;
                        System.out.println("You defeated the boar and found " + goldFound + " gold.");
                    }
                    break;

                case 2:

                    int healthRestored = random.nextInt(20) + 10;
                    playerHealth += healthRestored;
                    System.out.println("You rested and restored " + healthRestored + " health.");
                    break;

                case 3:

                    System.out.println("Thanks for playing! You earned " + playerGold + " gold over the course of your adventure.");
                    return;

                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }
}
