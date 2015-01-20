package ss.week6.voteMachine;

import java.util.*;

public class VoteTUIView implements VoteView {

    boolean running = true;
    VoteMachine controller;

    public VoteTUIView(VoteMachine controller) {
        this.controller = controller;
    }

    public void start() {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine() && running) {
            String line = in.nextLine();
            String[] words = line.split(" ");
            if (words[0].equalsIgnoreCase("VOTE")) {
                if (words[1] != null) {
                    controller.vote(words[1]);
                }
            } else if (words[0].equalsIgnoreCase("ADDPARTY")) {
                if (words[1] != null) {
                    controller.addParty(words[1]);
                }
            } else if (words[0].equalsIgnoreCase("VOTES")) {
                controller.getVotes();
            } else if (words[0].equalsIgnoreCase("PARTIES")) {
                controller.getParties();
            } else if (words[0].equalsIgnoreCase("EXIT")) {
                running = false;
            } else if (words[0].equalsIgnoreCase("HELP")) {
                System.out.printf(
                        "VOTE <PARTY>\n" +
                                "VOTES\n" +
                                "ADDPARTY <PARTY>\n" +
                                "PARTIES\n" +
                                "EXIT\n" +
                                "HELP\n");
            } else {
                System.out.println("Cannot find command " + words[0] + ", see HELP for help.");
            }
        }
    }

    public void showVotes(Map<String, Integer> votes) {
        for (String vote : votes.keySet()) {
            System.out.println(vote + ": " + votes.get(vote));
        }
    }

    public void showParties(List<String> parties) {
        for (String party : parties) {
            System.out.print(party);
        }
    }

    public void showError(String message) {
        System.err.println("[ERROR]: " + message);
    }

    public void update(Observable o, Object arg) {
        System.out.println("[NOTIFY]: " + arg + " has changed.");
    }
}
