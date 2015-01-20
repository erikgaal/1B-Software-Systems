package ss.week6.voteMachine;

import ss.week6.voteMachine.gui.VoteGUIView;

public class VoteMachine {

    PartyList parties;
    VoteList votes;

    VoteView view;

    public VoteMachine() {
        parties = new PartyList();
        votes = new VoteList();
        view = new VoteGUIView(this);

        parties.addObserver(view);
        votes.addObserver(view);
    }

    public void start() {
        view.start();
    }

    public void getParties() {
        view.showParties(parties.getParties());
    }

    public void getVotes() {
        view.showVotes(votes.getVotes());
    }

    public void addParty(String party) {
        parties.addParty(party);
    }

    public void vote(String party) {
        votes.vote(party);
    }

    public static void main(String[] args) {
        new VoteMachine().start();
    }
}
