package InitProcess;   

import java.awt.EventQueue;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JTextField;

public class View {
	boolean deckpressed = false;
	static Deck deck;
	private URL imageURL;
	private ClassLoader cldr;
	private JFrame frmMilestoneGame;
	private ArrayList<JButton> button = new ArrayList<JButton>();
	static Player p1;
	static Player p2;
	static Controller ka;
	JButton button_29;
	private JTextField Pl2points;
	private JTextField Pl1points;
	private JTextField Player2;
	private JTextField Player1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Controller a = new Controller();
		ka = a;
		Deck l = new Deck(p1, p2);
		deck = l;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View window = new View();
					window.frmMilestoneGame.setVisible(true);
					window.frmMilestoneGame.setResizable(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public View() {
		initialize();
	}

	/**
	 * this function is very important for the overall game it receives button 
	 * and when a button is pressed it recognises what type of card is on this button 
	 * and accordingly moves the card
	 * 
	 */
	public void ifStatements(JButton buttPressed, JButton firstbut,
			JButton secbut, JButton thirdbut, JButton safbut1, JButton safbut2,
			JButton safbut3, JButton safbut4, Player pl, int k, Deck de,
			int lastPos, JButton lastbutt) {
		imageURL = cldr.getClass().getResource(pl.Pile.get(k) + ".jpg");// arxikopoiw to
																// image gia na
																// paei stn nea
																// tou thesh
		boolean beenthere = false;
		if (pl.Pile.get(k).getClass().toString()
				.equals("class CardTypes.Distance")) {
			switch (ka.Distance(pl,ka.points(pl.Pile.get(k)) )) {// uparxei lathos me ta points
			case 0:if(pl.getLimit200()<=2){
				firstbut.setIcon(new ImageIcon(imageURL));// vazei sto pedio
															// maxhs
															// thn karta
				pl.Pile.set(k, pl.Pile.get(lastPos));// vazei stn thesh k to
								// teleftaio xarti
				System.out.println(pl.Pile);
				imageURL = cldr.getClass().getResource(pl.Pile.get(k) + ".jpg");
				pl.Pile.remove(lastPos);// diagrafei to teleftaio xarth
				lastbutt.setIcon(null);
				
				
				buttPressed.setIcon(new ImageIcon(imageURL));
				Pl2points.setText(String.valueOf(p2.PointSum));
				Pl1points.setText(String.valueOf(p1.PointSum));
				if (beenthere == false) {
					lastbutt.setIcon(null);
					deckpressed = false;
					
				}
				}break;
			case 1:Pl2points.setText(String.valueOf(p2.PointSum));
			Pl1points.setText(String.valueOf(p1.PointSum));
				JOptionPane.showMessageDialog(null, "Congrats " + ka.winner
						+ " you won"); 
				break;
			case 2:
				JOptionPane.showMessageDialog(null, pl
						+ " cannot play a/this distance card right now");
				break;
			}
			
		} else if (pl.Pile.get(k).getClass().toString()
				.equals("class CardTypes.Remedy")) {// REMEDY
			switch (ka.Remedy(pl, k)) {
			case 0:
				break;
			case 1:
				secbut.setIcon(new ImageIcon(imageURL));
				pl.Pile.set(k, pl.Pile.get(lastPos));// vazei stn thesh k to
				imageURL = cldr.getClass().getResource(pl.Pile.get(k) + ".jpg");			// teleftaio xarti
				pl.Pile.remove(lastPos);// diagrafei to teleftaio xarth
				buttPressed.setIcon(new ImageIcon(imageURL));
				if (beenthere == false) {
					lastbutt.setIcon(null);
					deckpressed = false;
					break;
				}
			}
		} else if (pl.Pile.get(k).getClass().toString()
				.equals("class CardTypes.Hazard")) {
			if (ka.Hazard(pl,k) == 1) {// ama exei pextei fanari tote mporei
											// na pai3ei kai ama h karta pezetai
				thirdbut.setIcon(new ImageIcon(imageURL));
				pl.Pile.set(k, pl.Pile.get(lastPos));
				imageURL = cldr.getClass().getResource(pl.Pile.get(k) + ".jpg");
				pl.Pile.remove(lastPos);
				buttPressed.setIcon(new ImageIcon(imageURL));
					lastbutt.setIcon(null);
					deckpressed = false;
				System.out.println(pl.Pile);
			}
			else {JOptionPane.showMessageDialog(null, pl
					+ " cannot play a/this Hazard card because no roll is played or right of way or a safety card doesn't allow this");
				playSound("buzz.wav");
			}
		} else if (pl.Pile.get(k).getClass().toString()
				.equals("class CardTypes.Safety")) {
			ka.Safety(pl, k);
			if (safbut1.getIcon() == null) {
				safbut1.setIcon(new ImageIcon(imageURL));
			} else if (safbut2.getIcon() == null) {
				safbut2.setIcon(new ImageIcon(imageURL));
			} else if (safbut3.getIcon() == null) {
				safbut3.setIcon(new ImageIcon(imageURL));
			} else if (safbut4.getIcon() == null) {
				safbut4.setIcon(new ImageIcon(imageURL));

			}
			deckpressed=true;
			pl.Pile.set(k, de.Deck.get(0));
			de.Deck.remove(0);
			imageURL = cldr.getClass().getResource(pl.Pile.get(k) + ".jpg");
			buttPressed.setIcon(new ImageIcon(imageURL));

		}

	}
/*
 * this function plays a sound from the library 
 * precondition the soundname does exist on the library 
 * postcondition plays the sound
 */

	public void playSound(String soundName) {
		try {
			imageURL = cldr.getClass().getResource(soundName);
			AudioInputStream audioInputStream = AudioSystem
					.getAudioInputStream(imageURL);
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch (Exception ex) {
			System.out.println("Error with playing sound.");
			ex.printStackTrace();
		}
	}
/*
 * initializes frame ,buttons and mouselisteners for right and left click and textfileds for score
 */
	private void initialize() {
		cldr = this.getClass().getClassLoader();
		frmMilestoneGame = new JFrame();
		frmMilestoneGame.setTitle("Milestone Game");
		frmMilestoneGame.setResizable(false);
		frmMilestoneGame.getContentPane().setBackground(new Color(0, 51, 0));
		frmMilestoneGame.setBounds(0, 0, 775, 850);
		frmMilestoneGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMilestoneGame.getContentPane().setLayout(null);
		String message = JOptionPane
				.showInputDialog("Enter 1st Player's name:");
		String name2 = JOptionPane.showInputDialog("Enter 2nd Player's name:");
		p1.setName(message);
		p2.setName(name2);
		final JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(10, 611, 98, 140);
		frmMilestoneGame.getContentPane().add(btnNewButton);
		button.add(btnNewButton);

		final JButton button_1 = new JButton("");
		button_1.setBounds(118, 611, 98, 140);
		frmMilestoneGame.getContentPane().add(button_1);
		button.add(button_1);

		final JButton button_2 = new JButton("");
		button_2.setBounds(226, 611, 98, 140);
		frmMilestoneGame.getContentPane().add(button_2);
		button.add(button_2);

		final JButton button_3 = new JButton("");
		button_3.setBounds(334, 611, 98, 140);
		frmMilestoneGame.getContentPane().add(button_3);
		button.add(button_3);
		final JButton button_4 = new JButton("");
		button_4.setBounds(442, 611, 98, 140);
		frmMilestoneGame.getContentPane().add(button_4);
		button.add(button_4);
		final JButton button_5 = new JButton("");
		button_5.setBounds(550, 611, 98, 140);
		frmMilestoneGame.getContentPane().add(button_5);
		button.add(button_5);
		final JButton button_6 = new JButton("");
		button_6.setBounds(658, 611, 98, 140);
		frmMilestoneGame.getContentPane().add(button_6);
		button.add(button_6);
		final JButton button_7 = new JButton("");
		button_7.setBounds(10, 11, 98, 140);
		frmMilestoneGame.getContentPane().add(button_7);
		button.add(button_7);
		final JButton button_8 = new JButton("");
		button_8.setBounds(118, 11, 98, 140);
		frmMilestoneGame.getContentPane().add(button_8);
		button.add(button_8);
		final JButton button_9 = new JButton("");
		button_9.setBounds(226, 11, 98, 140);
		frmMilestoneGame.getContentPane().add(button_9);
		button.add(button_9);
		final JButton button_10 = new JButton("");
		button_10.setBounds(334, 11, 98, 140);
		frmMilestoneGame.getContentPane().add(button_10);
		button.add(button_10);
		final JButton button_11 = new JButton("");
		button_11.setBounds(442, 11, 98, 140);
		frmMilestoneGame.getContentPane().add(button_11);
		button.add(button_11);
		final JButton button_12 = new JButton("");
		button_12.setBounds(550, 11, 98, 140);
		frmMilestoneGame.getContentPane().add(button_12);
		button.add(button_12);
		final JButton button_13 = new JButton("");
		button_13.setBounds(658, 11, 98, 140);
		frmMilestoneGame.getContentPane().add(button_13);
		button.add(button_13);
		final JButton button_14 = new JButton("");
		button_14.setBounds(10, 464, 98, 140);
		frmMilestoneGame.getContentPane().add(button_14);
		final JButton button_15 = new JButton("");
		button_15.setBounds(118, 464, 98, 140);
		frmMilestoneGame.getContentPane().add(button_15);
		final JButton button_16 = new JButton("");
		button_16.setBounds(226, 464, 98, 140);
		frmMilestoneGame.getContentPane().add(button_16);
		final JButton button_17 = new JButton("");
		button_17.setBounds(334, 464, 98, 140);
		frmMilestoneGame.getContentPane().add(button_17);
		final JButton button_18 = new JButton("");
		button_18.setBounds(442, 464, 98, 140);
		frmMilestoneGame.getContentPane().add(button_18);
		final JButton button_19 = new JButton("");
		button_19.setBounds(550, 464, 98, 140);
		frmMilestoneGame.getContentPane().add(button_19);
		JButton button_20 = new JButton("");
		button_20.setBounds(658, 464, 98, 140);
		frmMilestoneGame.getContentPane().add(button_20);
		final JButton button_21 = new JButton("");
		button_21.setBounds(10, 162, 98, 140);
		frmMilestoneGame.getContentPane().add(button_21);
		final JButton button_22 = new JButton("");
		button_22.setBounds(118, 162, 98, 140);
		frmMilestoneGame.getContentPane().add(button_22);
		final JButton button_23 = new JButton("");
		button_23.setBounds(226, 162, 98, 140);
		frmMilestoneGame.getContentPane().add(button_23);
		final JButton button_24 = new JButton("");
		button_24.setBounds(334, 162, 98, 140);
		frmMilestoneGame.getContentPane().add(button_24);
		final JButton button_25 = new JButton("");
		button_25.setBounds(442, 162, 98, 140);
		frmMilestoneGame.getContentPane().add(button_25);
		final JButton button_26 = new JButton("");
		button_26.setBounds(550, 162, 98, 140);
		frmMilestoneGame.getContentPane().add(button_26);
		final JButton button_27 = new JButton("");
		button_27.setBounds(658, 162, 98, 140);
		frmMilestoneGame.getContentPane().add(button_27);
		final JButton button_28 = new JButton("New button");
		button_28.setBounds(334, 313, 98, 140);
		frmMilestoneGame.getContentPane().add(button_28);
		button_29 = new JButton("");
		button_29.setBounds(442, 313, 98, 140);
		frmMilestoneGame.getContentPane().add(button_29);
		for (int j = 0; j < 6; j++) {
		imageURL = cldr.getClass().getResource(p1.Pile.get(j) + ".jpg");
			button.get(j).setIcon(new ImageIcon(imageURL));
		}
		for (int j = 7; j < 13; j++) {
			int k = j - 7;
																																																			
			button.get(j).setIcon(new ImageIcon(imageURL));
		}
		button_28.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Object source = e.getSource();
				switch (e.getModifiers()) {
				case InputEvent.BUTTON1_MASK: {
					if (deckpressed == true) {
						playSound("buzz.wav");
					}// ama patiete to deck 2 fores xwris na exei paikth fullo
						// varaei error
					if (source == button_28) {
						imageURL = cldr.getClass().getResource(deck.Deck.get(0) + ".jpg");
					}
					if (ka.seira == 1 && deckpressed == false) {
						p1.Pile.add(deck.Deck.get(0));
						deck.Deck.remove(0);
						ka.seira++;
						button_6.setIcon(new ImageIcon(imageURL));
						deckpressed = true;

						break;

					}
					if (ka.seira == 2 && deckpressed == false) {
						p2.Pile.add(deck.Deck.get(0));
						deck.Deck.remove(0);
						ka.seira--;
						button_13.setIcon(new ImageIcon(imageURL));
						deckpressed = true;
						System.out.println(p2.Pile);

						break;
					}

				}
				}

			}

		});
		for (int j = 0; j <= 13; j++)
			button.get(j).addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					Object source = e.getSource();
					switch (e.getModifiers()) {
					case InputEvent.BUTTON1_MASK: {
						if (deckpressed == false) {
							playSound("buzz.wav");
							break;
						}
						if (ka.seira == 2) {// if source==ola ta upoloipa
											// koumpia tote na varaei error oti
											// dn mporei na pai3ei duo fulla
							if (source == btnNewButton) {
								ifStatements(btnNewButton, button_18,
										button_19, button_26, button_14,
										button_15, button_16, button_17, p1, 0,
										deck, 6, button_6);
							}
							if (source == button_1) {
								ifStatements(button_1, button_18, button_19,
										button_26, button_14, button_15,
										button_16, button_17, p1, 1, deck, 6,
										button_6);
							}
							if (source == button_2) {
								ifStatements(button_2, button_18, button_19,
										button_26, button_14, button_15,
										button_16, button_17, p1, 2, deck, 6,
										button_6);
							}
							if (source == button_3) {
								ifStatements(button_3, button_18, button_19,
										button_26, button_14, button_15,
										button_16, button_17, p1, 3, deck, 6,
										button_6);
							}
							if (source == button_4) {
								ifStatements(button_4, button_18, button_19,
										button_26, button_14, button_15,
										button_16, button_17, p1, 4, deck, 6,
										button_6);
							}
							if (source == button_5) {
								ifStatements(button_5, button_18, button_19,
										button_26, button_14, button_15,
										button_16, button_17, p1, 5, deck, 6,
										button_6);
							}
							if (source == button_6) {ifStatements(button_6,button_18,
													 button_19, button_26,
								button_14, button_15, button_16, button_17,
								p1, 6,deck,6,button_6); 
							}
							break;
						}
						if (ka.seira == 1) {
							if (source == button_7) {
								ifStatements(button_7, button_25, button_26,
										button_19, button_21, button_22,
										button_23, button_24, p2, 0, deck, 6,
										button_13);
							}
							if (source == button_8) {
								ifStatements(button_8, button_25, button_26,
										button_19, button_21, button_22,
										button_23, button_24, p2, 1, deck, 6,
										button_13);
							}
							if (source == button_9) {
								ifStatements(button_9, button_25, button_26,
										button_19, button_21, button_22,
										button_23, button_24, p2, 2, deck, 6,
										button_13);
							}
							if (source == button_10) {
								ifStatements(button_10, button_25, button_26,
										button_19, button_21, button_22,
										button_23, button_24, p2, 3, deck, 6,
										button_13);
							}
							if (source == button_11) {
								ifStatements(button_11, button_25, button_26,
										button_19, button_21, button_22,
										button_23, button_24, p2, 4, deck, 6,
										button_13);
							}
							if (source == button_12) {
								ifStatements(button_12, button_25, button_26,
										button_19, button_21, button_22,
										button_23, button_24, p2, 5, deck, 6,
										button_13);
							}
							if (source == button_13) {
								ifStatements(button_13, button_25, button_26,
										button_19, button_21, button_22,
										button_23, button_24, p2, 6
										, deck, 6,
										button_13);
							}
						}
						break;
					}
					case InputEvent.BUTTON3_MASK: {//etoima
						URL tempimg;

						if (source == btnNewButton) {
							imageURL = cldr.getClass().getResource(p1.Pile.get(0) + ".jpg");
							deckpressed = false;
							p1.Pile.set(0, p1.Pile.get(6));
							p1.Pile.remove(6);
							button_6.setIcon(null);
							tempimg = cldr.getClass().getResource(p1.Pile.get(0) + ".jpg");
							btnNewButton.setIcon(new ImageIcon(tempimg));
						}
						if (source == button_1) {
							imageURL = cldr.getClass().getResource(p1.Pile.get(1) + ".jpg");
							deckpressed = false;
							p1.Pile.set(1, p1.Pile.get(6));
							p1.Pile.remove(6);
							button_6.setIcon(null);
							tempimg = cldr.getClass().getResource(p1.Pile.get(1) + ".jpg");
							button_1.setIcon(new ImageIcon(tempimg));
						}
						if (source == button_2) {
							imageURL = cldr.getResource(p1.Pile.get(2) + ".jpg");
							deckpressed = false;
							p1.Pile.set(2, p1.Pile.get(6));
							p1.Pile.remove(6);
							button_6.setIcon(null);
							tempimg = cldr.getClass().getResource(p1.Pile.get(2) + ".jpg");
							button_2.setIcon(new ImageIcon(tempimg));
						}
						if (source == button_3) {
							imageURL = cldr.getResource(p1.Pile.get(3) + ".jpg");
							deckpressed = false;
							p1.Pile.set(3, p1.Pile.get(6));
							p1.Pile.remove(6);
							button_6.setIcon(null);
							tempimg = cldr.getClass().getResource(p1.Pile.get(3) + ".jpg");
							button_3.setIcon(new ImageIcon(tempimg));
						}
						if (source == button_4) {
							imageURL = cldr.getResource(p1.Pile.get(4) + ".jpg");
							deckpressed = false;
							p1.Pile.set(4, p1.Pile.get(6));
							p1.Pile.remove(6);
							button_6.setIcon(null);
							tempimg = cldr.getClass().getResource(p1.Pile.get(4) + ".jpg");
							button_4.setIcon(new ImageIcon(tempimg));
						}
						if (source == button_5) {
							imageURL = cldr.getResource(p1.Pile.get(5) + ".jpg");
							deckpressed = false;
							p1.Pile.set(5, p1.Pile.get(6));
							p1.Pile.remove(6);
							button_6.setIcon(null);
							tempimg = cldr.getClass().getResource(p1.Pile.get(5) + ".jpg");
							button_5.setIcon(new ImageIcon(tempimg));
						}
						if (source == button_7) {
							imageURL = cldr.getClass().getResource(p2.Pile.get(0) + ".jpg");
							deckpressed = false;
							p2.Pile.set(0, p2.Pile.get(6));
							p2.Pile.remove(6);
							button_13.setIcon(null);
							tempimg = cldr.getClass().getResource(p2.Pile.get(0) + ".jpg");
							button_7.setIcon(new ImageIcon(tempimg));
						}
						if (source == button_8) {
							imageURL = cldr.getClass().getResource(p2.Pile.get(1) + ".jpg");
							deckpressed = false;
							p2.Pile.set(1, p2.Pile.get(6));
							p2.Pile.remove(6);
							button_13.setIcon(null);
							tempimg = cldr.getClass().getResource(p2.Pile.get(1) + ".jpg");
							button_8.setIcon(new ImageIcon(tempimg));
						}
						if (source == button_9) {
							imageURL = cldr.getClass().getResource(p2.Pile.get(2) + ".jpg");
							deckpressed = false;
							p2.Pile.set(2, p2.Pile.get(6));
							p2.Pile.remove(6);
							button_13.setIcon(null);
							tempimg = cldr.getClass().getResource(p2.Pile.get(2) + ".jpg");
							button_9.setIcon(new ImageIcon(tempimg));
						}
						if (source == button_10) {
							imageURL = cldr.getClass().getResource(p2.Pile.get(3) + ".jpg");
							deckpressed = false;
							p2.Pile.set(3, p2.Pile.get(6));
							p2.Pile.remove(6);
							button_13.setIcon(null);
							tempimg = cldr.getClass().getResource(p2.Pile.get(3) + ".jpg");
							button_10.setIcon(new ImageIcon(tempimg));
						}
						if (source == button_11) {
							imageURL = cldr.getClass().getResource(p2.Pile.get(4) + ".jpg");
							deckpressed = false;
							p2.Pile.set(4, p2.Pile.get(6));
							p2.Pile.remove(6);
							button_13.setIcon(null);
							tempimg = cldr.getClass().getResource(p2.Pile.get(4) + ".jpg");
							button_11.setIcon(new ImageIcon(tempimg));
						}
						if (source == button_12) {
							imageURL = cldr.getClass().getResource(p2.Pile.get(5) + ".jpg");
							deckpressed = false;
							p2.Pile.remove(5);
							button_13.setIcon(null);
							tempimg = cldr.getResource(p2.Pile.get(5) + ".jpg");
							button_12.setIcon(new ImageIcon(tempimg));
							System.out.println(p2.Pile);
							break;
						}
						if (source == button_13) {
							button_13.setIcon(null);
							imageURL = cldr.getClass().getResource(p2.Pile.get(6) + ".jpg");
							deckpressed = false;
							button_29.setIcon(new ImageIcon(imageURL));
							p2.Pile.remove(6);
							break;
							
						}
						if (source == button_6) {
							button_6.setIcon(null);
							imageURL = cldr.getClass().getResource(p1.Pile.get(6) + ".jpg");
							deckpressed = false;
							p1.Pile.remove(6);
						}
						button_29.setIcon(new ImageIcon(imageURL));
						break;

					}
					}
				}
			});

		imageURL = cldr.getResource("images.jpg");
		button_28.setIcon(new ImageIcon(imageURL));

		Pl2points = new JTextField();
		Pl2points.setText(String.valueOf(p2.PointSum));
		Pl2points.setBounds(130, 342, 86, 20);
		frmMilestoneGame.getContentPane().add(Pl2points);
		Pl2points.setColumns(10);

		Pl1points = new JTextField();
		Pl1points.setText(String.valueOf(p1.PointSum));
		Pl1points.setBounds(130, 373, 86, 20);
		frmMilestoneGame.getContentPane().add(Pl1points);
		Pl1points.setColumns(10);

		Player2 = new JTextField();
		Player2.setText(name2);
		Player2.setEditable(false);
		Player2.setBounds(22, 342, 86, 20);
		frmMilestoneGame.getContentPane().add(Player2);
		Player2.setColumns(10);

		Player1 = new JTextField();
		Player1.setEditable(false);
		Player1.setText(message);
		Player1.setBounds(22, 373, 86, 20);
		frmMilestoneGame.getContentPane().add(Player1);
		Player1.setColumns(10);
		playSound("sd.wav");
		try {
			Thread.sleep(800);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}

	}

	public static void send(Player p12, Player p22) {
		p1 = p12;
		p2 = p22;

	}
}
