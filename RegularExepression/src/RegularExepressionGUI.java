import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextPane;

public class RegularExepressionGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		RegularExpression RE=new RegularExpression();
		String file1 = "/Users/Asma/Desktop/AUTOMATA/dataset/data_hw1_Q1,2,3,5.txt";
		String file2 = "/Users/Asma/Desktop/AUTOMATA/dataset/data_hw1_Q4.txt";
		String file3 = "/Users/Asma/Desktop/AUTOMATA/dataset/data_hw1_Q6.txt";
		String file4 = "/Users/Asma/Desktop/AUTOMATA/dataset/data_hw1_Q7.txt";

		String dataset1 = null;
		String dataset2 = null;
		String dataset3 = null;
		String dataset4 = null;

		try {
			FileReader fileReader1 = new FileReader(file1);
			FileReader fileReader2 = new FileReader(file2);
			FileReader fileReader3 = new FileReader(file3);
			FileReader fileReader4 = new FileReader(file4);

			BufferedReader bufferedReader1 = new BufferedReader(fileReader1);
			BufferedReader bufferedReader2 = new BufferedReader(fileReader2);
			BufferedReader bufferedReader3 = new BufferedReader(fileReader3);
			BufferedReader bufferedReader4 = new BufferedReader(fileReader4);

			dataset1 = bufferedReader1.readLine();
			dataset2 = bufferedReader2.readLine();
			dataset3 = bufferedReader3.readLine();
			dataset4 = bufferedReader4.readLine();

			System.out.println("1. Words with two consonants next to each other:");
			RE.question1(dataset1);

			System.out.println("\n2. Words of length 5 or more that starts and ends with a vowel:");
			RE.question2(dataset1);

			System.out.println("\n3. Words of length 7 or more that starts with a consonant and ends with a vowel:");
			RE.question3(dataset1);

			System.out.println("\n4. All dates of form: dd-mm-yyyy:");
			RE.question4(dataset2);

			System.out.println("\n5. All words that have the same letter repeated (next to each other):");
			RE.question5(dataset1);

			System.out.println("\n6. The text after the abbreviation of 2-3 words that all start with a capital letter:");
			RE.question6(dataset3);

			System.out.println("\n7. All the words in a given a string written in camel case:");
			RE.question7(dataset4);

			bufferedReader1.close();
			bufferedReader2.close();
			bufferedReader3.close();
			bufferedReader4.close();

		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file");
		} catch (IOException ex) {
			System.out.println("Error reading file");
		}
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegularExepressionGUI window = new RegularExepressionGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RegularExepressionGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTextPane txtpnRegularExepression = new JTextPane();
		txtpnRegularExepression.setText("Regular Exepression");
		frame.getContentPane().add(txtpnRegularExepression, BorderLayout.NORTH);
	}

}
