import java.util.*;

class Umpire {
    int numFromGuesser;
    int numFromPlayer1;
    int numFromPlayer2;
    int numFromPlayer3;

    void getNumFromGuesser() {
        Gusser g1 = new Gusser();
        numFromGuesser = g1.guessNum();
    }

    void getNumFromPlayers() {
        Player p1 = new Player();
        Player p2 = new Player();
        Player p3 = new Player();
        numFromPlayer1 = p1.guessNum();
        numFromPlayer2 = p2.guessNum();
        numFromPlayer3 = p3.guessNum();
    }

    void compare() {
        if (numFromGuesser == numFromPlayer1) {
            if ((numFromGuesser == numFromPlayer2) && (numFromGuesser == numFromPlayer3)) {
                System.out.println("All players won the game");
            } else if (numFromGuesser == numFromPlayer2) {
                System.out.println("p1 and p2 won the game");
            } else if (numFromGuesser == numFromPlayer3) {
                System.out.println("p1 and p3 won the game");
            } else {
                System.out.println("player 1 won");
            }
        } else if (numFromGuesser == numFromPlayer2) {
            if (numFromGuesser == numFromPlayer3) {
                System.out.println("p2 and p3 won the game");
            } else {
                System.out.println("player 2 won");
            }
        } else if (numFromGuesser == numFromPlayer3) {
            System.out.println("player 3 won");
        } else {
            System.out.println("No one won the game");
        }
    }
}

class Gusser {
    int guessNum;

    int guessNum() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Guesser, please select a number");
        guessNum = scan.nextInt();
        return guessNum;
    }
}

class Player {
    int guessNum;

    int guessNum() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Player, please guess a number:");
        guessNum = scan.nextInt();
        return guessNum;
    }
}

public class Gussergame {
    public static void main(String[] args) {
        Umpire ump = new Umpire();
        ump.getNumFromGuesser();
        ump.getNumFromPlayers();
        ump.compare();
    }
}
