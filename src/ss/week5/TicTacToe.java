package ss.week5;

public class TicTacToe {

    public static void main(String[] args) {
        if (args.length == 2) {
            Player one = new HumanPlayer(args[0], Mark.XX);

            Player two;
            if (args[1].equalsIgnoreCase("-N")) {
                two = new ComputerPlayer(Mark.OO, new NaiveStrategy());
            } else if (args[1].equalsIgnoreCase("-S")) {
                two = new ComputerPlayer(Mark.OO, new SmartStrategy());
            } else {
                two = new HumanPlayer(args[1], Mark.OO);
            }

            Game game = new Game(one, two);
            game.start();
        } else {
            System.out.println("Usage: java week5.TicTacToe <player1> <player2>");
        }
    }
}
