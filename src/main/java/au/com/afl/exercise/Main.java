package au.com.afl.exercise;


import au.com.afl.exercise.exception.GameException;
import au.com.afl.exercise.service.Game;

import java.util.Scanner;

public class Main
{
    public static void main( String[] args )
    {
        System.out.println( "Let's try playing a counting game!" );
        System.out.println( "Have Fun" );

        Scanner sc = new Scanner(System.in);

        System.out.println( "Enter the number of players:" );
        Integer numberOfPlayers = 0;
        do {
            try {
                numberOfPlayers = sc.nextInt();
            } catch (Exception e) {
                System.out.println("OOPS Invalid Number. Try Again...");
                sc.next();
            }
        }while (numberOfPlayers==0);


        System.out.println( "Enter the count limit:" );
        Integer counterLimit = 0;
        do {
            try {
                counterLimit = sc.nextInt();
            } catch (Exception e) {
                System.out.println("OOPS Invalid Number. Try Again...");
                sc.next();
            }
        }while (counterLimit==0);

        Game gameSimulation = new Game();
        try {
            gameSimulation.init(numberOfPlayers,counterLimit);
            gameSimulation.play();
        } catch (GameException e) {
            System.out.println("OOPS "+e.getMessage());
            System.out.println("Let's try again");
        }

//            System.out.println(adapter.input(input));


    }
}
