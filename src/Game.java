import java.util.*;

public class Game {

    private List<String>players = new LinkedList<>();
    private List<Integer>playerNumbers = new LinkedList<>();
    private boolean running = true;

    /* Method to assign name
     * We use a for loop to give each index a value
     * In this case, each index will contain a name obtained from a scanner.
     */
    public void thePlayers(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome! How  many players are there today?");
        int howManyPlayers = scanner.nextInt();
        players = Arrays.asList(new String[howManyPlayers]);

        scanner.nextLine();

        for (int i = 0; i < players.size(); i++){
            System.out.println("Enter your names, please: ");
            players.set(i, scanner.nextLine());
        }

        System.out.println("Players are: " + Arrays.toString(players.toArray()));


    }

    //Here we are assigning each playerNumbers array index with random generated numbers
    public void assignPlayerNumbers(){
        int amountOfPlayers = players.size();

        playerNumbers = Arrays.asList(new Integer[amountOfPlayers]);

        for (int i = 0; i < playerNumbers.size(); i++){
            int random = (int) (Math.random() * (10 + 1));
            playerNumbers.set(i, random);

            //Prints out the players name, and the players random numbers generated for them.
            System.out.println(players.get(i) + " " + "guessed the number: " + playerNumbers.get(i));
        }

    }

    /* The game method, where all the methods are coming together. */
     public void startTheGame() {
         Scanner scanner = new Scanner(System.in);

         while (running) {
             resetData();
             thePlayers();
             assignPlayerNumbers();

             int randomNumber = (int) (Math.random() * 10) + 1;

             System.out.print("\nLet's finally start the game!");
             System.out.println();
             System.out.println("Our guessing number is between 1 and 10");
             System.out.println("--------------------------------");
             System.out.println("The players random numbers are: ");


             /* FOR loop which will iterate through and find the player names and their randomized numbers by the computer */

             System.out.println("-----------------");

             for (int i = 0; i < players.size(); i++) {
                 System.out.println(players.get(i) + "\t" + " | " + playerNumbers.get(i) + " | ");
             }

             System.out.println("-----------------");


               /*   Checking if we have a winner with the right number  */

                 for (int i = 0; i < players.size(); i++) {

                     if (playerNumbers.get(i) == randomNumber) {

                         System.out.println("Our winner/winners are: " + players.get(i) + "!");

                     } else {
                         System.out.println("No winners, better luck next time :)");
                         System.out.println("Right number was: " + randomNumber);
                         break;
                     }
                 }


             System.out.println("----------------");

             System.out.println("Want to play again?");
             System.out.println("Enter Y for Yes or N for NO");
             String choice = getStringInput().toUpperCase();
             System.out.println("----------------");

             if (choice.startsWith("Y")) {

                 running = true;

             } else {
                 running = false;
                 System.out.println("See you next time!");

            }

         }

     }

     //Returns a scanner
        public String getStringInput(){
         Scanner scanner = new Scanner(System.in);
         return scanner.nextLine();
     }


     /* Resets the ArrayList players and playerNumbers */
        public void resetData(){
            playerNumbers = null;
            players = null;
        }


     }








