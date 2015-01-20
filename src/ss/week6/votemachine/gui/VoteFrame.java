package ss.week6.voteMachine.gui;

import java.awt.Button;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;


public class VoteFrame extends Frame  {


	// Grafische componenten
	private Choice partyChoice;
	private Button okButton;
	private Label messageLabel;

	protected VoteGUIView view;

	/**
	 * Construeert een StemFrame voor een aangegeven Uitslag.
	 * @require uitslag != null
	 */
	public VoteFrame(VoteGUIView view) {

		
		// Initialisatie grafische componenten
		super("Voting");
		
		this.view = view;
		setLayout(new FlowLayout());

		
		messageLabel = new Label("Make your choice");
		add(messageLabel);

		partyChoice = new Choice();
		add(partyChoice);

		okButton = new Button("OK");
		okButton.setEnabled(false);
		add(okButton);

		setSize(250, 100);


		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
            partyChoice.addItemListener(new ItemListener() {
                
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if (partyChoice.getSelectedIndex() > 0) {
                        messageLabel.setText("Change your choice or press \"OK\"");
                        okButton.setEnabled(true);
                    } else {
                        messageLabel.setText("Make your choice");
                        okButton.setEnabled(false);
                    }
                }
            });
            okButton.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    VoteFrame.this.view.getVoteMachine().vote(partyChoice.getSelectedItem());
                    partyChoice.select(0);
                    messageLabel.setText("Make your choice");
                    okButton.setEnabled(false);
                }
            });
	}


	/**
	 * Ververst de lijst partijen in de <code>Choice</code>
	 * op basis van de waargenomen verandering in de <code>Uitslag</code>
	 */
	public void update(List<String> parties) {
		partyChoice.setEnabled(false);
		partyChoice.removeAll();
		partyChoice.add("(Choose a party)");
		for (String party : parties)
			partyChoice.add(party);
		partyChoice.setEnabled(true);
	}
}
