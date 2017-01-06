import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 * ---
 * Hint: You can use the debug stream to print initialTX and initialTY, if Thor seems not follow your orders.
 **/

class Player {

    private static int x;
    private static int y;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt(); // the X position of the light of power
        int b = in.nextInt(); // the Y position of the light of power
        x = in.nextInt(); // Thor's starting X position
        y = in.nextInt(); // Thor's starting Y position

        // game loop
        while (true) {

            int remainingTurns = in.nextInt();
            // The remaining amount of turns Thor can move. Do not remove this line.
            int distanceX = x - a;
            int distanceY = y - b;
            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
            String action = "";

            if (distanceX < 0 && distanceY < 0) {
                action = "SE";
            }

            if (distanceX > 0 && distanceY > 0) {
                action = "NW";
            }

            if (distanceX > 0 && distanceY < 0) {
                action = "SW";
            }

            if (distanceX < 0 && distanceY > 0) {
                action = "NE";
            }


            if (distanceX == 0) {
                if (distanceY < 0) {
                    action = "S";
                } else {
                    action = "N";
                }
            }

            if (distanceY == 0) {
                if (distanceX < 0) {
                    action = "E";
                } else {
                    action = "W";
                }
            }

            setMove(action);


            System.err.println(x + " " + y  + " " + distanceY);
            // A single line providing the move to be made: N NE E SE S SW W or NW
            System.out.println(action);
        }
    }

    private static void setMove(String move) {
        for (int i = 0; i < move.length(); i++) {
            char letter = move.charAt(i);
            switch (letter) {
                case 'E':
                    x += 1;
                    break;
                case 'N':
                    y -= 1;
                    break;
                case 'W':
                    x -= 1;
                    break;
                case 'S':
                    y += 1;
                    break;
            }
        }
    }
}