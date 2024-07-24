import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main (String [] args)
    {
        boolean hasWon = false;
        int winner = 0;
        int[] scores;
        int selection;
        String name;
        int players;
        String[] names;
        ArrayList<ZombieDie> hand = new ArrayList<ZombieDie>();
        ArrayList<ZombieDie> brains = new ArrayList<ZombieDie>();
        ArrayList<ZombieDie> shots = new ArrayList<ZombieDie>();
        ArrayList<ZombieDie> runners = new ArrayList<ZombieDie>();

        Scanner keyboard = new Scanner (System.in);

        System.out.print("\nHow many players are playing (2-5): ");
        players = keyboard.nextInt();

        while (players < 2 || players > 5)
        {
            System.out.print("\nThat is an invalid choice. Please try again.");
            System.out.print("\nHow many players are playing (2-5): ");
            players = keyboard.nextInt();
        }

        names = new String[players];

        ZombieDiceBucket bucket = new ZombieDiceBucket();

        for (int x = 0; x < names.length; x++)
        {
            System.out.print("\nEnter a player's name: ");
            name = keyboard.next();
            names[x] = name;
        }

        scores = new int [players];

        shuffleNames(names);

        System.out.println("\n" + names[0] + " it is your turn and you have " + scores[0] + " brains in your bank.");

        do {
            for (int y = 0; y < players;)
            {
                do{
                    hand.clear();

                    System.out.println("\n\tTurn summary:");
                    System.out.println("\t\tBrain: " + brains);
                    System.out.println("\t\tShots: " + shots);
                    System.out.println("\t\tRunners: " + runners);
                    System.out.println("\t1. Keep Going");
                    System.out.println("\t2. Stop and add to bank");
                    System.out.print("\t\nEnter selection: ");
                    selection = keyboard.nextInt();

                    if (selection == 2)
                    {
                        break;
                    }

                    bucket.loadBucket();

                    if (runners.size() > 0)
                    {
                        System.out.print("\nAfter drawing you have the following dice: [ ");
                        for (int z = 0; z < 3 - runners.size(); z++)
                        {
                            hand.add(bucket.draw());
                            System.out.print(hand.get(z) + ", ");
                        }
                        for (int i = 0; i < runners.size(); i++)
                        {
                            if (i == runners.size()-1)
                            {
                                if (runners.get(i).getDieColor() == 1)
                                {
                                    System.out.print("RED ]");
                                }
                                else if (runners.get(i).getDieColor() == 2)
                                {
                                    System.out.print("GREEN ]");
                                }
                                else
                                {
                                    System.out.print("YELLOW ]");
                                }
                            }
                            else
                            {
                                if (runners.get(i).getDieColor() == 1)
                                {
                                    System.out.print("RED, ");
                                }
                                else if (runners.get(i).getDieColor() == 2)
                                {
                                    System.out.print("GREEN, ");
                                }
                                else
                                {
                                    System.out.print("YELLOW, ");
                                }
                            }
                        }

                        System.out.println("\n\tRolling...");
                        System.out.print("\nThe results of your rolls were: [ ");
                        for (int x = 0; x < 3 - runners.size(); x++)
                        {
                            hand.get(x).roll();
                            System.out.print(hand.get(x).toString() + ", ");
                        }
                        for (int x = 0; x < runners.size(); x++)
                        {
                            hand.add(runners.get(x));
                            runners.get(x).roll();
                            if (x == runners.size()-1)
                            {
                                System.out.print(runners.get(x).toString() + " ]");
                            }
                            else
                            {
                                System.out.print(runners.get(x).toString() + ", ");
                            }
                        }

                        runners.clear();
                    }
                    else
                    {
                        hand.add(bucket.draw());
                        hand.add(bucket.draw());
                        hand.add(bucket.draw());
                        System.out.println("\nAfter drawing you have the following dice: "+ hand);
                        for (int x = 0; x < 3; x++)
                        {
                            hand.get(x).roll();
                        }

                        System.out.println("\n\tRolling...");

                        System.out.println("The results of your rolls were: " + hand);
                    }


                    for (int x = 0; x < hand.size(); x++)
                    {
                        if (hand.get(x).getValue() == 1)
                        {
                            runners.add(hand.get(x));
                        }
                        else if (hand.get(x).getValue() == 2)
                        {
                            brains.add(hand.get(x));
                        }
                        else
                        {
                            shots.add(hand.get(x));
                        }
                    }

                } while (shots.size() < 3 && selection == 1);

                if (selection == 2)
                {
                    System.out.println("\n" + brains.size() + " brains will be added to your bank");
                    scores[y] = scores[y] + brains.size();
                    brains.clear();
                    shots.clear();
                    runners.clear();
                }
                else
                {
                    System.out.println("\nYou got shot and lost all your brains!");
                    brains.clear();
                    shots.clear();
                    runners.clear();
                }

                if( hasWon == true)
                {
                    break;
                }

                if (scores[y] >= 13)
                {
                    if (hasWon == false)
                    {
                        hasWon = true;
                    }
                }

                y++;
                if (y >= players)
                {
                    y = 0;
                }

                System.out.println("\n" + names[y] + " it is your turn and you have " + scores[y] + " brains in your bank.");
            }

        } while (findWinner(names, scores) == null);

        if (findWinner(names, scores).equals("tie"))
        {
            System.out.print("\nIt's a tie");
        }
        else
        {
            System.out.print("\n" + findWinner(names, scores) + " wins");
        }


    }

    public static void shuffleNames(String[] names)
    {
        int randomIndex;
        int randomIndex2;
        for (int x  = 0 ; x < 11; x++)
        {
            randomIndex = (int)(Math.random()*names.length);
            randomIndex2 = (int)(Math.random()*names.length);
            String temp = names [randomIndex];
            names [randomIndex] = names[randomIndex2];
            names[randomIndex2] = temp;
        }
    }

    public static String findWinner(String[] names, int[] scores)
    {
        int index = 0;
        int highestScore = 0;
        for (int x = 0; x < scores.length; x++)
        {
            if (scores[x] >= 13)
            {
                highestScore = scores[x];
                index = x;
            }
        }

        for (int x = 0; x < scores.length; x++)
        {
            if (x == index)
            {
                continue;
            }
            else
            {
                if (highestScore == scores[x])
                {
                    return "tie";
                }
            }
        }

        return names[index];
    }
}

