package attempt1;

import java.awt.EventQueue;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Button;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.SystemColor;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;


public class mainframe extends JFrame {
    Clip currentClip;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField BPMfield;
	private JTextField noteblock;
	int currentOctave = 4;
	private javax.swing.Timer metronomeTimer;
	private boolean metronomeRunning = false;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainframe frame = new mainframe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
                    
	/**
	 * Create the frame.
	 */
	public mainframe() {
		setTitle("Mark XVI \"Sandwichinator\" Infinite Sandwich Generator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 974, 396);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblNewLabel = new JLabel(" ");
		lblNewLabel.setBounds(62, 5, 856, 136);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\elijahcobb\\Pictures\\Screenshots\\zepiano.png"));
		contentPane.add(lblNewLabel);
		JButton metronomebutton = new JButton("Metronome");
		metronomebutton.setBackground(Color.BLACK);
		metronomebutton.setForeground(new Color(255, 255, 255));
		metronomebutton.setFont(new Font("Tahoma", Font.PLAIN, 36));
		metronomebutton.setBounds(79, 165, 217, 50);
		contentPane.add(metronomebutton);
		
		BPMfield = new JTextField();
		BPMfield.setBackground(new Color(0, 0, 0));
		BPMfield.setForeground(new Color(255, 255, 255));
		BPMfield.setFont(new Font("Tahoma", Font.PLAIN, 24));
		BPMfield.setText("Enter BPM");
		BPMfield.setToolTipText("Enter BPM");
		BPMfield.setBounds(125, 240, 118, 50);
		contentPane.add(BPMfield);
		BPMfield.setColumns(10);
		metronomebutton.addActionListener(e -> {

		    if (!metronomeRunning) {

		        double bpm = Double.parseDouble(BPMfield.getText());

		        int interval = (int)((60.0 / bpm) * 1000);

		        metronomeTimer = new javax.swing.Timer(interval, event -> {

		            playSound(
		                "C:\\Users\\elijahcobb\\Downloads\\m.wav"
		            );

		        });

		        metronomeTimer.start();

		        metronomeRunning = true;
		        metronomebutton.setText("Stop");

		    } else {

		        metronomeTimer.stop();

		        metronomeRunning = false;
		        metronomebutton.setText("Metronome");
		    }
		});
		int[] whiteDividers = {
			     0,
			    22, 45, 67, 90, 112, 135, 157,
			    179, 202, 224, 246, 269, 291, 313,
			    335, 358, 380, 402, 424, 447, 469,
			    491, 513, 535, 558, 580, 602, 625,
			    647, 669, 691, 714, 736, 758, 781,
			    804
			};
		String[] whiteNotes = {
			    "C2","D2","E2","F2","G2","A2","B2",
			    "C3","D3","E3","F3","G3","A3","B3",
			    "C4","D4","E4","F4","G4","A4","B4",
			    "C5","D5","E5","F5","G5","A5","B5",
			    "C6","D6","E6","F6","G6","A6","B6",
			    "C7"
			};

		int keyboardX = 62;
		int keyboardY = 5;

		for (int i = 0; i < whiteNotes.length; i++) {

		    JButton key = new JButton();

		    key.setName(whiteNotes[i]);

		    key.setBounds(
		        keyboardX + whiteDividers[i],
		        keyboardY,
		        12,
		        136
		    );

		    key.setBorderPainted(true); 

		    contentPane.add(key);
		}
		/*String[] whiteNotes = {
			    "C2","D2","E2","F2","G2","A2","B2",
			    "C3","D3","E3","F3","G3","A3","B3",
			    "C4","D4","E4","F4","G4","A4","B4",
			    "C5","D5","E5","F5","G5","A5","B5",
			    "C6","D6","E6","F6","G6","A6","B6",
			    "C7"
			};

			int x = 10;

			int keyboardX = 62;
			int keyboardY = 5;

			double whiteWidth = 856.0 / 36.0;

			for(int i = 0; i < whiteNotes.length; i++) {

			    JButton key = new JButton();

			    key.setName(whiteNotes[i]);

			    key.setBounds(
			        (int)Math.round(keyboardX + i * whiteWidth),
			        keyboardY,
			        (int)Math.ceil(whiteWidth),
			        136
			    );

			    key.setOpaque(false);
			    key.setContentAreaFilled(false);
			    key.setBorderPainted(true);   

			    contentPane.add(key);
			}*/
			double[] octaveOffsets = {
				    0.68, 1.68,
				    3.68, 4.68, 5.68
				};
			/*String[] blackNotes = {
				    "C#2","D#2","F#2","G#2","A#2",
				    "C#3","D#3","F#3","G#3","A#3",
				    "C#4","D#4","F#4","G#4","A#4",
				    "C#5","D#5","F#5","G#5","A#5",
				    "C#6","D#6","F#6","G#6","A#6"
				};

				int[] blackPositions = {
				    26,50,98,122,146,
				    194,218,266,290,314,
				    362,386,434,458,482,
				    530,554,602,626,650,
				    698,722,770,794,818
				};

				for(int i = 0; i < blackNotes.length; i++) {

				    JButton key = new JButton();

				    key.setName(blackNotes[i]);

				    key.setBounds(
				        blackPositions[i],
				        5,
				        16,
				        80
				    );

				    key.setOpaque(false);
				    key.setContentAreaFilled(false);
				    key.setBorderPainted(false);

				    contentPane.add(key);
				}*/
			int[] blackKeyX = {
				    14,36,
				    81,103,125,

				    171,193,
				    238,260,282,

				    327,349,
				    394,416,438,

				    483,505,
				    550,572,594,

				    639,661,
				    706,728,750
				};
			String[] blackNotes = {
				    "Db2","Eb2","Gb2","Ab2","Bb2",
				    "Db3","Eb3","Gb3","Ab3","Bb3",
				    "Db4","Eb4","Gb4","Ab4","Bb4",
				    "Db5","Eb5","Gb5","Ab5","Bb5",
				    "Db6","Eb6","Gb6","Ab6","Bb6"
				};
			String[] blackNames = {
				    "C#","D#","F#","G#","A#"
				};

				int octaveCount = 5;
				for (int i = 0; i < blackNotes.length; i++) {

				    JButton key = new JButton();

				    key.setName(blackNotes[i]);

				    key.setBounds(
				        62 + blackKeyX[i],
				        5,
				        15,
				        86
				    );

				    key.setBorderPainted(true); // debug

				    contentPane.add(key);
				}
				/*for(int octave = 2; octave <= 6; octave++) {

				    int octaveStart =
				        keyboardX + (int)Math.round((octave - 2) * 7 * whiteWidth);

				    for(int i = 0; i < 5; i++) {

				        JButton key = new JButton();

				        key.setName(
				            blackNames[i] + octave
				        );

				        int blackX =
				            octaveStart +
				            (int)Math.round(
				                octaveOffsets[i] * whiteWidth
				            );

				        key.setBounds(
				            blackX,
				            keyboardY,
				            15,
				            82
				        );

				        key.setOpaque(true);
				        key.setContentAreaFilled(true);
				        key.setBorderPainted(true); // DEBUG
				        key.setBackground(new Color(0,0,255,100));
				        contentPane.add(key);
				    }
				}*/
				String[] scales = {
					    "C Major",
					    "C Minor",
					    "Db Major",
					    "C# Minor",
					    "D Major",
					    "D Minor",
					    "Eb Major",
					    "Eb Minor",
					    "E Major",
					    "E Minor",
					    "F Major",
					    "F Minor",
					    "Gb Major",
					    "F# Minor",
					    "G Major",
					    "G Minor",
					    "Ab Major",
					    "Ab Minor",
					    "A Major",
					    "A Minor",
					    "Bb Major",
					    "Bb Minor",
					    "B Major",
					    "B Minor"
					};
				HashMap<String, String[]> scaleMap = new HashMap<>();

				
				scaleMap.put("C Major",  new String[]{"C","D","E","F","G","A","B"});
				scaleMap.put("Db Major", new String[]{"Db","Eb","F","Gb","Ab","Bb","C"});
				scaleMap.put("D Major",  new String[]{"D","E","F#","G","A","B","C#"});
				scaleMap.put("Eb Major", new String[]{"Eb","F","G","Ab","Bb","C","D"});
				scaleMap.put("E Major",  new String[]{"E","F#","G#","A","B","C#","D#"});
				scaleMap.put("F Major",  new String[]{"F","G","A","Bb","C","D","E"});
				scaleMap.put("Gb Major", new String[]{"Gb","Ab","Bb","B","Db","Eb","F"});
				scaleMap.put("G Major",  new String[]{"G","A","B","C","D","E","F#"});
				scaleMap.put("Ab Major", new String[]{"Ab","Bb","C","Db","Eb","F","G"});
				scaleMap.put("A Major",  new String[]{"A","B","C#","D","E","F#","G#"});
				scaleMap.put("Bb Major", new String[]{"Bb","C","D","Eb","F","G","A"});
				scaleMap.put("B Major",  new String[]{"B","C#","D#","E","F#","G#","A#"});

	
				scaleMap.put("C Minor",  new String[]{"C","D","Eb","F","G","Ab","Bb"});
				scaleMap.put("C# Minor", new String[]{"C#","D#","E","F#","G#","A","B"});
				scaleMap.put("D Minor",  new String[]{"D","E","F","G","A","A#","C"});
				scaleMap.put("Eb Minor", new String[]{"Eb","F","Gb","Ab","Bb","B","Db"});
				scaleMap.put("E Minor",  new String[]{"E","F#","G","A","B","C","D"});
				scaleMap.put("F Minor",  new String[]{"F","G","Ab","Bb","C","Db","Eb"});
				scaleMap.put("F# Minor", new String[]{"F#","G#","A","B","C#","D","E"});
				scaleMap.put("G Minor",  new String[]{"G","A","Bb","C","D","Eb","F"});
				scaleMap.put("Ab Minor", new String[]{"Ab","Bb","B","Db","Eb","E","Gb"});
				scaleMap.put("A Minor",  new String[]{"A","B","C","D","E","F","G"});
				scaleMap.put("Bb Minor", new String[]{"Bb","C","Db","Eb","F","Gb","Ab"});
				scaleMap.put("B Minor",  new String[]{"B","C#","D","E","F#","G","A"});
					JComboBox<String> scaleBox = new JComboBox<>(scales);

					scaleBox.setBounds(350, 165, 200, 40);

					contentPane.add(scaleBox);
					JTextField scaleNotesField = new JTextField();

					scaleNotesField.setEditable(false);
					scaleNotesField.setBounds(570, 165, 300, 40);

					contentPane.add(scaleNotesField);
					
					noteblock = new JTextField();
					noteblock.setFont(new Font("Verdana", Font.PLAIN, 80));
					noteblock.setHorizontalAlignment(SwingConstants.CENTER);
					noteblock.setForeground(Color.WHITE);
					noteblock.setBackground(Color.BLACK);
					noteblock.setBounds(350, 216, 200, 130);
					contentPane.add(noteblock);
					noteblock.setColumns(10);
					scaleBox.addActionListener(new ActionListener() {
					    @Override
					    public void actionPerformed(ActionEvent e) {

					        String selectedScale =
					                (String) scaleBox.getSelectedItem();

					        String[] notes =
					                scaleMap.get(selectedScale);

					        if (notes != null) {

					            StringBuilder sb = new StringBuilder();

					            for (int i = 0; i < notes.length; i++) {

					                sb.append(notes[i]);

					                if (i < notes.length - 1) {
					                    sb.append(" - ");
					                }
					            }

					            scaleNotesField.setText(sb.toString());
					        }
					    }
					});
				
					
				
		for (Component key : contentPane.getComponents()) {
			
			if (key instanceof JButton && ((JButton) key) != metronomebutton) {
				((JButton) key).setOpaque(false);
			       ((JButton) key).setContentAreaFilled(false);
			        ((JButton) key).setBorderPainted(false);
				
				((JButton) key).addMouseListener(new MouseAdapter() {
					@Override
					
					public void mousePressed(MouseEvent e) {
						System.out.println("pressed");
						
						String f = ((JButton) key).getName();
						playSound("C:\\\\Users\\\\elijahcobb\\\\Downloads\\\\piano-mp32\\\\" + f + ".wav");
						noteblock.setText(f);
					}
					@Override
					public void mouseReleased(MouseEvent e) {
						
						System.out.println("released");
						
					 stopSound();
					}
					
				});
				((JButton) key).addMouseListener(new MouseAdapter() {
					
					
				});
				
			}
		}
		bindKey("A");
		bindKey("W");
		bindKey("S");
		bindKey("E");
		bindKey("D");
		bindKey("F");
		bindKey("T");
		bindKey("G");
		bindKey("Y");
		bindKey("H");
		bindKey("U");
		bindKey("J");
		bindKey("K");
		bindKey("O");
		bindKey("L");
		bindKey("P");
		bindKey("SEMICOLON");
		bindKey("QUOTE");
		bindKey("Z");
		bindKey("X");

	}
	public void playSound(String filename) {
        try {
            File soundFile = new File(filename);
            currentClip = AudioSystem.getClip(); // Get a new Clip
            currentClip.open(AudioSystem.getAudioInputStream(soundFile)); // Open the audio stream
            currentClip.start(); // Start playing
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	private void playKeyboardNote(String noteName) {
		
	    String fullNote = noteName + currentOctave;
	    
	    if(noteName.equals("C") ||
	       noteName.equals("C#") ||
	       noteName.equals("D") ||
	       noteName.equals("D#") ||
	       noteName.equals("E") ||
	       noteName.equals("F")) {

	        
	    }

	    String path =
	        "C:\\Users\\elijahcobb\\Downloads\\soundfolder\\"
	        + fullNote
	        + "v11.wav";

	    playSound(path);
	    noteblock.setText(fullNote);
	}
	private void bindKey(String key) {

	    contentPane.getInputMap(
	        JPanel.WHEN_IN_FOCUSED_WINDOW
	    ).put(
	        javax.swing.KeyStroke.getKeyStroke(key),
	        key
	    );

	    contentPane.getActionMap().put(
	        key,
	        new AbstractAction() {

	            @Override
	            public void actionPerformed(ActionEvent e) {

	                if(key.equals("Z")) {

	                    if(currentOctave > 2) {
	                        currentOctave--;
	                    }
	                    //noteblock.setText("Oct " + currentOctave);
	                    return;
	                }																		
	                if(key.equals("X")) {
	                    if(currentOctave < 6) {
	                        currentOctave++;
	                    }

	                    //noteblock.setText("Oct " + currentOctave);
	                    return;
	                }
	                HashMap<String, String> keyMap = new HashMap<>();
	        		keyMap.put("A", "C");
	        		keyMap.put("W", "Db");
	        		keyMap.put("S", "D");
	        		keyMap.put("E", "Eb");
	        		keyMap.put("D", "E");
	        		keyMap.put("F", "F");
	        		keyMap.put("T", "Gb");
	        		keyMap.put("G", "G");
	        		keyMap.put("Y", "Ab");
	        		keyMap.put("H", "A");
	        		keyMap.put("U", "Bb");
	        		keyMap.put("J", "B");
	        		keyMap.put("K", "C");
	        		keyMap.put("O", "Db");
	        		keyMap.put("L", "D");
	        		keyMap.put("P", "Eb");
	        		keyMap.put("SEMICOLON", "E");
	        		keyMap.put("QUOTE", "F");
	        		
	                String note = keyMap.get(key);
	                
	                if(note != null) {

	                    int octave = currentOctave;

	                    
	                    if(key.equals("K") ||
	                       key.equals("O") ||
	                       key.equals("L") ||
	                       key.equals("p") ||
	                       key.equals("SEMICOLON") ||
	                       key.equals("QUOTE")) {

	                        octave++;
	                    }

	                    String fullNote =
	                        note + octave;
	                    
	                    playSound(
	                    		"C:\\\\Users\\\\elijahcobb\\\\Downloads\\\\piano-mp32\\\\" + fullNote + ".wav"
	                    );

	                    noteblock.setText(fullNote);
	                }
	            }
	        }
	    );
	}
	
    public void stopSound() {
        if (currentClip != null && currentClip.isRunning()) {
            currentClip.stop(); // Stop the sound
            currentClip.close(); // Release resources
            currentClip = null; // Clear the reference
        }
    }
}
