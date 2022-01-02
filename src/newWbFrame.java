import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLayeredPane;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Font;

public class newWbFrame  {
	


	///
	private int[] sameCRes;
	
	private int clickRestriction;
	private ArrayList<Integer> whatBox;
	private ArrayList <String> arList = new ArrayList<>();
	private ArrayList <Character> charList;
	private ArrayList<JLabel> whatLabelisThatBox;
	private Random rand;
	///
	private JFrame frmMemoryGame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newWbFrame window = new newWbFrame();
					window.frmMemoryGame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public newWbFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		 
		this.rand = new Random();
		this.whatBox = new ArrayList<>();
		
		
		var mNewC = new mGameClass (rand, arList); // implementation of 4 ran chars - each char max 4 time appearing
		// stored in array with initial flow begging with element at 0 position
		
		 this.arList = mNewC.ranC(rand, arList, charList); // string path to images
		 
		 this.charList = mNewC.getChars(); // chars that are represented
		 
		 this.whatLabelisThatBox = new ArrayList<>(); // what label has the user clicked
		 
		 this.sameCRes = new int[20];
			
			for(int i = 0; i<20; ++i) { 
				sameCRes[i] = 1;  // 1 value to each JLabel mouse event - when event occurs that value will change to 0 at index of the box
			}
		 
		 //////////////////
		 frmMemoryGame = new JFrame();
		 frmMemoryGame.setTitle("Memory Game");
		 frmMemoryGame.setIconImage(Toolkit.getDefaultToolkit().getImage(newWbFrame.class.getResource("/resources/logoX.png")));
		 frmMemoryGame.setSize(new Dimension(580, 700));
		 frmMemoryGame.setResizable(false);
	
		frmMemoryGame.getContentPane().setBackground(Color.PINK);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setForeground(Color.ORANGE);
		GroupLayout groupLayout = new GroupLayout(frmMemoryGame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(layeredPane, GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(layeredPane, GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE)
					.addContainerGap())
		);
		/////
		this.clickRestriction = 0;
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() { 
			int marking = 0;
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if( clickRestriction < 4 && sameCRes[0] == 1) {
					++clickRestriction;
					sameCRes[0] = 0;
					
					lblNewLabel.setIcon(new ImageIcon(newWbFrame.class.getResource(arList.get(0))));
					System.out.println(charList); // LEFT FOR TESTING - console print
					whatBoxIsSelected(marking, lblNewLabel);
					
					isEqual();
					
				}
			}			
		});
		lblNewLabel.setIcon(new ImageIcon(newWbFrame.class.getResource("/resources/logoX.png")));
		lblNewLabel.setBounds(26, 11, 106, 105);
		layeredPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			int marking = 1;
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if( clickRestriction < 4 && sameCRes[1] == 1) {
					++clickRestriction;
					sameCRes[1] = 0;
				
					lblNewLabel_1.setIcon(new ImageIcon(newWbFrame.class.getResource(arList.get(1))));
					whatBoxIsSelected(marking, lblNewLabel_1);
				
					isEqual();
				
				}
			}
		});
		lblNewLabel_1.setIcon(new ImageIcon(newWbFrame.class.getResource("/resources/logoX.png")));
		lblNewLabel_1.setBounds(159, 11, 106, 105);
		layeredPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			int marking = 2;
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if( clickRestriction < 4 && sameCRes[2] == 1) {
				++clickRestriction;
				sameCRes[2] = 0;;
				
				lblNewLabel_2.setIcon(new ImageIcon(newWbFrame.class.getResource(arList.get(2))));
				whatBoxIsSelected(marking, lblNewLabel_2);
				
				isEqual();
				
				}
			}
		});
		lblNewLabel_2.setIcon(new ImageIcon(newWbFrame.class.getResource("/resources/logoX.png")));
		lblNewLabel_2.setBounds(293, 11, 106, 105);
		layeredPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			int marking = 3;
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if( clickRestriction < 4 && sameCRes[3] == 1) {
				++clickRestriction;
				sameCRes[3] = 0;

				lblNewLabel_3.setIcon(new ImageIcon(newWbFrame.class.getResource(arList.get(3))));
				whatBoxIsSelected(marking, lblNewLabel_3);
				
				isEqual();
				
				}
			}
		});
		lblNewLabel_3.setIcon(new ImageIcon(newWbFrame.class.getResource("/resources/logoX.png")));
		lblNewLabel_3.setBounds(423, 11, 106, 105);
		layeredPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			int marking = 4;
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if( clickRestriction < 4 && sameCRes[4] == 1) {
				++clickRestriction;
				sameCRes[4] = 0;
				
				lblNewLabel_4.setIcon(new ImageIcon(newWbFrame.class.getResource(arList.get(4))));
				whatBoxIsSelected(marking, lblNewLabel_4);
			
				isEqual();
				
				}
			}
		});
		lblNewLabel_4.setIcon(new ImageIcon(newWbFrame.class.getResource("/resources/logoX.png")));
		lblNewLabel_4.setBounds(26, 127, 106, 105);
		layeredPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			int marking = 5;
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if( clickRestriction < 4 && sameCRes[5] == 1) {
				++clickRestriction;
				sameCRes[5] = 0;
				
				lblNewLabel_5.setIcon(new ImageIcon(newWbFrame.class.getResource(arList.get(5))));
				whatBoxIsSelected(marking, lblNewLabel_5);
				
				isEqual();
				
				}
			}
		});
		lblNewLabel_5.setIcon(new ImageIcon(newWbFrame.class.getResource("/resources/logoX.png")));
		lblNewLabel_5.setBounds(159, 127, 106, 105);
		layeredPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.addMouseListener(new MouseAdapter() {
			int marking = 6;
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if( clickRestriction < 4 && sameCRes[6] == 1) {
				++clickRestriction;
				sameCRes[6] = 0;
				
				lblNewLabel_6.setIcon(new ImageIcon(newWbFrame.class.getResource(arList.get(6))));
				whatBoxIsSelected(marking, lblNewLabel_6);
				
				isEqual();
				
				}
			}
		});
		lblNewLabel_6.setIcon(new ImageIcon(newWbFrame.class.getResource("/resources/logoX.png")));
		lblNewLabel_6.setBounds(293, 127, 106, 105);
		layeredPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.addMouseListener(new MouseAdapter() {
			int marking = 7;
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if( clickRestriction < 4 && sameCRes[7] == 1) {
				++clickRestriction;
				sameCRes[7] = 0;;
				
				lblNewLabel_7.setIcon(new ImageIcon(newWbFrame.class.getResource(arList.get(7))));
				whatBoxIsSelected(marking, lblNewLabel_7);
				
				isEqual();
				
				}
			}
		});
		lblNewLabel_7.setIcon(new ImageIcon(newWbFrame.class.getResource("/resources/logoX.png")));
		lblNewLabel_7.setBounds(423, 127, 106, 105);
		layeredPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.addMouseListener(new MouseAdapter() {
			int marking = 8;
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if( clickRestriction < 4 && sameCRes[8] == 1) {
				
				++clickRestriction;
				sameCRes[8] = 0;
				
				lblNewLabel_8.setIcon(new ImageIcon(newWbFrame.class.getResource(arList.get(8))));
				whatBoxIsSelected(marking, lblNewLabel_8);
				
				isEqual();
				
				}
			}
		});
		lblNewLabel_8.setIcon(new ImageIcon(newWbFrame.class.getResource("/resources/logoX.png")));
		lblNewLabel_8.setBounds(26, 243, 106, 105);
		layeredPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.addMouseListener(new MouseAdapter() {
			int marking = 9;
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if( clickRestriction < 4 && sameCRes[9] == 1) {
				++clickRestriction;
				sameCRes[9] = 0;
				
				lblNewLabel_9.setIcon(new ImageIcon(newWbFrame.class.getResource(arList.get(9))));
				whatBoxIsSelected(marking, lblNewLabel_9);
				
				isEqual();
				
				}
			}
		});
		lblNewLabel_9.setIcon(new ImageIcon(newWbFrame.class.getResource("/resources/logoX.png")));
		lblNewLabel_9.setBounds(159, 243, 106, 105);
		layeredPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.addMouseListener(new MouseAdapter() {
			int marking = 10;
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if( clickRestriction < 4 && sameCRes[10] == 1) {
				++clickRestriction;
				sameCRes[10] = 0;
				
				lblNewLabel_10.setIcon(new ImageIcon(newWbFrame.class.getResource(arList.get(10))));
				whatBoxIsSelected(marking, lblNewLabel_10);
				
				isEqual();
				
				}
			}
		});
		lblNewLabel_10.setIcon(new ImageIcon(newWbFrame.class.getResource("/resources/logoX.png")));
		lblNewLabel_10.setBounds(293, 243, 106, 105);
		layeredPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.addMouseListener(new MouseAdapter() {
			int marking = 11;
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if( clickRestriction < 4 && sameCRes[11] == 1) {
				++clickRestriction;
				sameCRes[11] = 0;
				
				lblNewLabel_11.setIcon(new ImageIcon(newWbFrame.class.getResource(arList.get(11))));
				whatBoxIsSelected(marking, lblNewLabel_11);
				
				isEqual();
				
				}
			}
		});
		lblNewLabel_11.setIcon(new ImageIcon(newWbFrame.class.getResource("/resources/logoX.png")));
		lblNewLabel_11.setBounds(423, 243, 106, 105);
		layeredPane.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.addMouseListener(new MouseAdapter() {
			int marking = 12;
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if( clickRestriction < 4 && sameCRes[12] == 1) {
				++clickRestriction;
				sameCRes[12] = 0;
				
				lblNewLabel_12.setIcon(new ImageIcon(newWbFrame.class.getResource(arList.get(12))));
				whatBoxIsSelected(marking, lblNewLabel_12);
				
				isEqual();
				
				}
			}
		});
		lblNewLabel_12.setIcon(new ImageIcon(newWbFrame.class.getResource("/resources/logoX.png")));
		lblNewLabel_12.setBounds(26, 359, 106, 105);
		layeredPane.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("");
		lblNewLabel_13.addMouseListener(new MouseAdapter()  {
			int marking = 13;
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if( clickRestriction < 4 && sameCRes[13] == 1) {
				++clickRestriction;
				sameCRes[13] = 0;
				
				lblNewLabel_13.setIcon(new ImageIcon(newWbFrame.class.getResource(arList.get(13))));
				whatBoxIsSelected(marking, lblNewLabel_13);
				
				isEqual();
				
				}
			}
		});
		lblNewLabel_13.setIcon(new ImageIcon(newWbFrame.class.getResource("/resources/logoX.png")));
		lblNewLabel_13.setBounds(159, 359, 106, 105);
		layeredPane.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("");
		lblNewLabel_14.addMouseListener(new MouseAdapter() {
			int marking = 14;
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if( clickRestriction < 4 && sameCRes[14] == 1) {
				++clickRestriction;
				sameCRes[14] = 0;
				
				lblNewLabel_14.setIcon(new ImageIcon(newWbFrame.class.getResource(arList.get(14))));
				whatBoxIsSelected(marking, lblNewLabel_14);
				
				isEqual();
				
			    }
			}
		});
		lblNewLabel_14.setIcon(new ImageIcon(newWbFrame.class.getResource("/resources/logoX.png")));
		lblNewLabel_14.setBounds(293, 359, 106, 105);
		layeredPane.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("");
		lblNewLabel_15.addMouseListener(new MouseAdapter() {
			int marking = 15;
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if( clickRestriction < 4 && sameCRes[15] == 1) {
				++clickRestriction;
				sameCRes[15] = 0;
				
				lblNewLabel_15.setIcon(new ImageIcon(newWbFrame.class.getResource(arList.get(15))));
				whatBoxIsSelected(marking, lblNewLabel_15);
				
				isEqual();
				
				}
			}
		});
		lblNewLabel_15.setIcon(new ImageIcon(newWbFrame.class.getResource("/resources/logoX.png")));
		lblNewLabel_15.setBounds(423, 359, 106, 105);
		layeredPane.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("");
		lblNewLabel_16.addMouseListener(new MouseAdapter() {
			int marking = 16;
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if( clickRestriction < 4 && sameCRes[16] == 1) {
				++clickRestriction;
				sameCRes[16] = 0;
				
				lblNewLabel_16.setIcon(new ImageIcon(newWbFrame.class.getResource(arList.get(16))));
				whatBoxIsSelected(marking, lblNewLabel_16);
				
				isEqual();
				
				}
			}
		});
		lblNewLabel_16.setIcon(new ImageIcon(newWbFrame.class.getResource("/resources/logoX.png")));
		lblNewLabel_16.setBounds(26, 475, 106, 105);
		layeredPane.add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("");
		lblNewLabel_17.addMouseListener(new MouseAdapter() {
			int marking = 17;
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if( clickRestriction < 4 && sameCRes[17] == 1) {
				++clickRestriction;
				sameCRes[17] = 0;
				
				lblNewLabel_17.setIcon(new ImageIcon(newWbFrame.class.getResource(arList.get(17))));
				whatBoxIsSelected(marking, lblNewLabel_17);
				
				isEqual();;
				
				}
			}
		});
		lblNewLabel_17.setIcon(new ImageIcon(newWbFrame.class.getResource("/resources/logoX.png")));
		lblNewLabel_17.setBounds(159, 475, 106, 105);
		layeredPane.add(lblNewLabel_17);
		
		JLabel lblNewLabel_18 = new JLabel("");
		lblNewLabel_18.addMouseListener(new MouseAdapter() {
			int marking = 18;
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if( clickRestriction < 4 && sameCRes[18] == 1) {
				++clickRestriction;
				sameCRes[18] = 0;
				
				lblNewLabel_18.setIcon(new ImageIcon(newWbFrame.class.getResource(arList.get(18))));
				whatBoxIsSelected(marking, lblNewLabel_18);
				
				isEqual();
				
				}
			}
		});
		lblNewLabel_18.setIcon(new ImageIcon(newWbFrame.class.getResource("/resources/logoX.png")));
		lblNewLabel_18.setBounds(293, 475, 106, 105);
		layeredPane.add(lblNewLabel_18);
	
		JLabel lblNewLabel_19 = new JLabel("");
		lblNewLabel_19.addMouseListener(new MouseAdapter() {
			int marking = 19;
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if( clickRestriction < 4 && sameCRes[19] == 1) {
				++clickRestriction;
				sameCRes[19] = 0;
				
				lblNewLabel_19.setIcon(new ImageIcon(newWbFrame.class.getResource(arList.get(19))));
				whatBoxIsSelected(marking, lblNewLabel_19);
			
				isEqual();
				
				}
				
			}
		});
		lblNewLabel_19.setIcon(new ImageIcon(newWbFrame.class.getResource("/resources/logoX.png")));
		lblNewLabel_19.setBounds(423, 475, 106, 105);
		layeredPane.add(lblNewLabel_19);
		
		JLabel nameLabel = new JLabel("Guess four combination of same images");
		nameLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 21));
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setBounds(85, 616, 409, 44);
		layeredPane.add(nameLabel);
	}

	public void whatBoxIsSelected (int marking, JLabel lab) { // check what box hase been clicked // what is all selected with click
		
		whatBox.add(marking); // Array from private  
		whatLabelisThatBox.add(lab); 
	}
	
	public void isEqual () {
		
		//this implementation of timer class will help us to have some time before open boxes are closed,
		Timer t = new Timer();
		TimerTask task = new Helper();
		TimerTask task1 = new Helper2();
		ArrayList<Character> charArr = new ArrayList<>();
		
		if(whatBox.size() > 3) { //from 0 to 3 = 4// if 4 boxes are open, begin the check for equal process
	
			for(int e : whatBox) {
				charArr.add(charList.get(e)); // convert box number to corresponding char
			}
			
			if(charArr.get(0) == charArr.get(1) && charArr.get(2) == charArr.get(3)){
				t.schedule(task, 1000);
				
				
			}
			else
				t.schedule(task1, 3000);
			
		}
	}

	public void ifNotEqual() {
		whatLabelisThatBox.get(0).setIcon(new ImageIcon(newWbFrame.class.getResource("/resources/logoX.png")));
		whatLabelisThatBox.get(1).setIcon(new ImageIcon(newWbFrame.class.getResource("/resources/logoX.png")));
		whatLabelisThatBox.get(2).setIcon(new ImageIcon(newWbFrame.class.getResource("/resources/logoX.png")));
		whatLabelisThatBox.get(3).setIcon(new ImageIcon(newWbFrame.class.getResource("/resources/logoX.png")));
		
		clickRestriction = 0;
		
		for(int i=0; i<whatBox.size(); ++i) {
		sameCRes[whatBox.get(i)] = 1;
		
		}
		
		whatBox.clear();
		whatLabelisThatBox.clear();
	}

	public void ifEqual() {
		whatLabelisThatBox.get(0).setIcon(new ImageIcon(""));
		whatLabelisThatBox.get(1).setIcon(new ImageIcon(""));
		whatLabelisThatBox.get(2).setIcon(new ImageIcon(""));
		whatLabelisThatBox.get(3).setIcon(new ImageIcon(""));
		
		clickRestriction = 0;
		
		for(int i=0; i<whatBox.size(); ++i) {
		sameCRes[whatBox.get(i)] = 1;
		
		}
		
		whatBox.clear();
		whatLabelisThatBox.clear();
	}
	public class Helper extends TimerTask { // helper0 - if all boxes are equal

		@Override
		public void run() {
			ifEqual();

		}

	}
	public class Helper2 extends TimerTask { // helper2 - if  !equal

		@Override
		public void run() {
			ifNotEqual();

		}

	}
}
