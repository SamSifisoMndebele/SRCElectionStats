import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.io.Serial;
import java.text.NumberFormat;

public class SRCElectionStats extends JFrame {
	@Serial
	private static final long serialVersionUID = 1L;
	
	private static int totalVotes;
	private static final int[] partiesVotes = new int[3];
	
	private static final JLabel totalVotesLabel = new JLabel();
	private static final JLabel party1Votes = new JLabel();
	private static final JLabel party2Votes = new JLabel();
	private static final JLabel party3Votes = new JLabel();
	private static final JLabel party1Percentage = new JLabel();
	private static final JLabel party2Percentage = new JLabel();
	private static final JLabel party3Percentage = new JLabel();

	@NotNull
	private static JPanel getInputPanel() {
		JPanel inputPanel = new JPanel(new GridBagLayout());
		inputPanel.setOpaque(false);
		inputPanel.setFocusable(true);
		
		JLabel party1 = new JLabel("Party 1 :-");
		JLabel party2 = new JLabel("Party 2 :-");
		JLabel party3 = new JLabel("Party 3 :-");
		JLabel nameLabel1 = new JLabel("Name : ");
		JLabel votesLabel1 = new JLabel("Number Of Votes : ");
		JLabel nameLabel2 = new JLabel("Name : ");
		JLabel votesLabel2 = new JLabel("Number Of Votes : ");
		JLabel nameLabel3 = new JLabel("Name : ");
		JLabel votesLabel3 = new JLabel("Number Of Votes : ");
	
		JTextField party1Field = new JTextField(20);
		JTextField party2Field = new JTextField(20);
		JTextField party3Field = new JTextField(20);
		JTextField party1VotesField = new JTextField(10);
		JTextField party2VotesField = new JTextField(10);
		JTextField party3VotesField = new JTextField(10);
		JButton button = new JButton("Display Results");

		GridBagConstraints inputConstraints = new GridBagConstraints();
		inputConstraints.anchor = GridBagConstraints.WEST;
		inputConstraints.insets = new Insets(16, 8, 0, 8);

		inputConstraints.gridx = 0;
		inputConstraints.gridy = 0;
		inputPanel.add(party1, inputConstraints);
		inputConstraints.insets = new Insets(4, 8, 0, 8);
		inputConstraints.gridy = 1;
		inputPanel.add(nameLabel1, inputConstraints);
		inputConstraints.gridx = 1;
		inputPanel.add(party1Field, inputConstraints);
		inputConstraints.gridx = 0;
		inputConstraints.gridy = 2;
		inputPanel.add(votesLabel1, inputConstraints);
		inputConstraints.gridx = 1;
		inputPanel.add(party1VotesField, inputConstraints);
		
		inputConstraints.insets = new Insets(16, 8, 0, 8); 
		inputConstraints.gridx = 0;
		inputConstraints.gridy = 3;
		inputPanel.add(party2, inputConstraints);
		inputConstraints.insets = new Insets(4, 8, 0, 8);
		inputConstraints.gridy = 4;
		inputPanel.add(nameLabel2, inputConstraints);
		inputConstraints.gridx = 1;
		inputPanel.add(party2Field, inputConstraints);
		inputConstraints.gridx = 0;
		inputConstraints.gridy = 5;
		inputPanel.add(votesLabel2, inputConstraints);
		inputConstraints.gridx = 1;
		inputPanel.add(party2VotesField, inputConstraints);
		
		inputConstraints.insets = new Insets(16, 8, 0, 8); 
		inputConstraints.gridx = 0;
		inputConstraints.gridy = 6;
		inputPanel.add(party3, inputConstraints);
		inputConstraints.insets = new Insets(4, 8, 0, 8);
		inputConstraints.gridy = 7;
		inputPanel.add(nameLabel3, inputConstraints);
		inputConstraints.gridx = 1;
		inputPanel.add(party3Field, inputConstraints);
		inputConstraints.gridx = 0;
		inputConstraints.gridy = 8;
		inputPanel.add(votesLabel3, inputConstraints);
		inputConstraints.gridx = 1;
		inputPanel.add(party3VotesField, inputConstraints);

		inputConstraints.insets = new Insets(16, 8, 8, 8); 
		inputConstraints.gridx = 0;
		inputConstraints.gridy = 9; 
		inputConstraints.gridwidth = 4;
		inputConstraints.anchor = GridBagConstraints.CENTER;
		inputPanel.add(button, inputConstraints);

		inputPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
				"Enter names of the 3 parties and votes for each below"));
		inputPanel.setPreferredSize(new Dimension(360,360));
		
		//This listener will wait for user to enter the display button and run the code within actionPerformed
		button.addActionListener(_ -> {
            String party1NameText = party1Field.getText().trim();
            String party2NameText = party2Field.getText().trim();
            String party3NameText = party3Field.getText().trim();
            String party1VotesText = party1VotesField.getText().trim();
            String party2VotesText = party2VotesField.getText().trim();
            String party3VotesText = party3VotesField.getText().trim();
            //Validate panties fields and Validate votes fields and Get Number of votes
            //Validate party 1
            if(party1NameText.isEmpty()) {
                new JOptionPane("Type a party name in the Name field." , JOptionPane.WARNING_MESSAGE)
                .createDialog(party1Field, "Party 1 Name is empty").setVisible(true);
                return;
            }
            if(!party1VotesText.isEmpty()) {
                try {
                    int votes = Integer.parseInt(party1VotesText);
                    if (votes < 0) throw new NumberFormatException();
                    partiesVotes[0] = votes;
                } catch(NumberFormatException ex) {
                    ex.printStackTrace();
                    new JOptionPane("Please enter a positive integer" , JOptionPane.WARNING_MESSAGE)
                    .createDialog(party1Field, STR."\{party1NameText}(Party 1) Number of Votes are invalid").setVisible(true);
                    return;
                }
            } else {
                new JOptionPane("Type the party Number of Votes in the field." , JOptionPane.WARNING_MESSAGE)
                .createDialog(party1Field, STR."\{party1NameText}(Party 1) Number of Votes are empty").setVisible(true);
                return;
            }

            //Validate party 2
            if(party2NameText.isEmpty()) {
                new JOptionPane("Type a party name in the Name field." , JOptionPane.WARNING_MESSAGE)
                .createDialog(party2Field, "Party 2 Name is empty").setVisible(true);
                return;
            }
            if(!party2VotesText.isEmpty()) {
                try {
                    int votes = Integer.parseInt(party2VotesText);
                    if (votes < 0) throw new NumberFormatException();
                    partiesVotes[1] = votes;
                } catch(NumberFormatException ex) {
                    ex.printStackTrace();
                    new JOptionPane("Please enter a positive integer" , JOptionPane.WARNING_MESSAGE)
                    .createDialog(party2Field, STR."\{party2NameText}(Party 2) Number of Votes are invalid").setVisible(true);
                    return;
                }
            } else {
                new JOptionPane("Type the party Number of Votes in the field." , JOptionPane.WARNING_MESSAGE)
                .createDialog(party2Field, STR."\{party2NameText}(Party 2) Number of Votes are empty").setVisible(true);
                return;
            }

            //Validate party 3
            if(party3NameText.isEmpty()) {
                new JOptionPane("Type a party name in the Name field." , JOptionPane.WARNING_MESSAGE)
                .createDialog(party3Field, "Party 3 Name is empty").setVisible(true);
                return;
            }
            if(!party3VotesText.isEmpty()) {
                try {
                    int votes = Integer.parseInt(party3VotesText);
                    if (votes < 0) throw new NumberFormatException();
                    partiesVotes[2] = votes;
                } catch(NumberFormatException ex) {
                    ex.printStackTrace();
                    new JOptionPane("Please enter a positive integer" , JOptionPane.WARNING_MESSAGE)
                    .createDialog(party3Field, STR."\{party3NameText}(Party 3) Number of Votes are invalid").setVisible(true);
                    return;
                }
            } else {
                new JOptionPane("Type the party Number of Votes in the field." , JOptionPane.WARNING_MESSAGE)
                .createDialog(party3Field, STR."\{party3NameText}(Party 3) Number of Votes are empty").setVisible(true);
                return;
            }

            //Add all the number of students voted
            totalVotes = 0;
            for(int votes : partiesVotes) {
                totalVotes += votes;
            }

            //Show the total in totalVotes JLabels
            totalVotesLabel.setText(STR."Total Number of Votes : \{totalVotes}");

            //Show the Names of the parties and votes in party1Votes, party2Votes and party3Votes JLabels
            party1Votes.setText(STR."\{party1NameText} Votes : \{party1VotesText}");
            party2Votes.setText(STR."\{party2NameText} Votes : \{party2VotesText}");
            party3Votes.setText(STR."\{party3NameText} Votes : \{party3VotesText}");

            //A number formatter that will round of to nearest 2 decimal places
            NumberFormat nFormat = NumberFormat.getInstance();
            nFormat.setMaximumFractionDigits(2);
            //double roundedPercentage = nFormat.format(percentage);
            //Show the Percentages of the parties in party1Percentage, party2Percentage and party3Percentage JLabels
            party1Percentage.setText(STR."Percentage: \{nFormat.format(partiesVotes[0] * 100.0 / totalVotes)}%");
            party2Percentage.setText(STR."Percentage: \{nFormat.format(partiesVotes[1] * 100.0 / totalVotes)}%");
            party3Percentage.setText(STR."Percentage: \{nFormat.format(partiesVotes[2] * 100.0 / totalVotes)}%");
        });
		
		return inputPanel;
	}

	private static JPanel getResultsPanel() {
		JPanel resultsPanel = new JPanel(new GridBagLayout());
		resultsPanel.setOpaque(false);
		resultsPanel.setFocusable(true);

		GridBagConstraints resultsConstraints = new GridBagConstraints();
		resultsConstraints.anchor = GridBagConstraints.WEST;
		resultsConstraints.gridx = 0;

		resultsConstraints.insets = new Insets(16, 8, 0, 8);
		resultsConstraints.gridy = 0;
		resultsPanel.add(totalVotesLabel, resultsConstraints);
		
		resultsConstraints.insets = new Insets(16, 8, 0, 8);
		resultsConstraints.gridy = 1;
		resultsPanel.add(party1Votes, resultsConstraints);
		resultsConstraints.insets = new Insets(4, 8, 0, 8);
		resultsConstraints.gridy = 2;
		resultsPanel.add(party1Percentage, resultsConstraints);
		
		resultsConstraints.insets = new Insets(32, 8, 0, 8); 
		resultsConstraints.gridy = 3;
		resultsPanel.add(party2Votes, resultsConstraints);
		resultsConstraints.insets = new Insets(4, 8, 0, 8);
		resultsConstraints.gridy = 4;
		resultsPanel.add(party2Percentage, resultsConstraints);
		
		resultsConstraints.insets = new Insets(32, 8, 0, 8); 
		resultsConstraints.gridy = 5;
		resultsPanel.add(party3Votes, resultsConstraints);
		resultsConstraints.insets = new Insets(4, 8, 16, 8);
		resultsConstraints.gridy = 6;
		resultsPanel.add(party3Percentage, resultsConstraints);
		
		resultsPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
				"Results Display"));
		resultsPanel.setPreferredSize(new Dimension(280,360));
		
		//Show the total in totalVotes JLabels
		totalVotesLabel.setText("Total Number of Votes : 0" );
		
		//Show the Names of the parties and votes in party1Votes, party2Votes and party3Votes JLabels
		party1Votes.setText("Party 1 Votes : 0");
		party2Votes.setText("Party 2 Votes : 0");
		party3Votes.setText("Party 3 Votes : 0");

		//Show the Percentages of the parties in party1Percentage, party2Percentage and party3Percentage JLabels
		party1Percentage.setText("Percentage: 0%");
		party2Percentage.setText("Percentage: 0%");
		party3Percentage.setText("Percentage: 0%");
		
		return resultsPanel;
	}
	
	SRCElectionStats() {
		JPanel inputPanel = getInputPanel();
		JPanel resultsPanel = getResultsPanel();
	
		JPanel panels = new JPanel(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.gridx = 0;
		constraints.gridy = 0;
		panels.add(inputPanel, constraints);
		constraints.gridx = 1;
		panels.add(resultsPanel, constraints);
		
		add(panels);
		setTitle("SRC Election Stats");
		setResizable(false);
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
	}
	   
	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		new SRCElectionStats();
	}
}
