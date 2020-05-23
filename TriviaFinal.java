package GUITest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TriviaFinal {

	JFrame window;
	Container con;
	JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, questionPanel;
	JButton startButton, choice1, choice2, choice3, choice4;
	JLabel titleNameLabel, questionTracker;
	JTextArea mainTextArea;

	int questionCount = 0;
	int streak = 0;
	int maxStreak = 0;
	int points = 0;
	float correct = 0;
	float incorrect = 0;
	String position;
	String[] presidents = { "George Washington", "John Adams", "Thomas Jefferson", "James Madison", "James Monroe",
			"John Quincy Adams", "Andrew Jackson", "Martin Van Buren", "William H. Harrison", "John Tyler",
			"James K. Polk", "Zachary Taylor", "Millard Fillmore", "Franklin Pierce", "James Buchanan",
			"Abraham Lincoln", "Andrew Johnson", "Ulysses S. Grant", "Rutherford B. Hayes", "James Garfield",
			"Chester A. Arthur", "Grover Cleveland", "Benjamin Harrison", "William McKinley", "Theodore Roosevelt",
			"William Howard Taft", "Woodrow Wilson", "Warren G. Harding", "Calvin Coolidge", "Herbet Hoover",
			"Franklin D. Roosevelt", "Harry S. Truman", "Dwight D. Eisenhower", "John F. Kennedy", "Lyndon B. Johnson",
			"Richard M. Nixon", "Gerald R. Ford", "James Carter", "Ronald Reagan", "George H.W. Bush",
			"William J. Clinton", "George W. Bush", "Barack Obama", "Donald J. Trump" };
	String[][] easyQuestions = {
            {"Which president was the first to hold a televised\nnews conference?\n", "Dwight D. Eisenhower"},
            {"Which president once got stuck in a bathtub?\n\n", "William Howard Taft"},
            {"Who was the first president to appoint an African\nAmerican to the Supreme Court?\n",
                    "Lyndon B. Johnson"},
            {"Who was the first president to be born an American\ncitizen?\n", "Martin Van Buren"},
            {"Which president did not live in the White House?\n\n", "George Washington"},
            {"Who was the first president to ride a railroad train?\n\n", "Andrew Jackson"},
            {"Which president was a head cheerleader in\nhigh school?\n", "George W. Bush"},
            {"Which president was involved in a scandal during his term?\n", "Richard M. Nixon"},
            {"Which of these men did not serve as president of the\nUnited States?\n", "Alexander Hamilton"},
            {"Which president received a medical deferment for\n\"Bad Feet\" to avoid the Vietnam War?\n",
                    "Donald J. Trump"},
            {"Which president delivered a speech after being shot?\n\n", "Theodore Roosevelt"},
            {"Which president was not associated with a\npolitical party?\n", "George Washington"},
            {"Which president served in both WW1 and WW2?\n\n", "Dwight D. Eisenhower"},
            {"Which president served for more than two\nconsecutive terms?\n", "Franklin D. Roosevelt"},
            {"Who was the tallest standing president at 6'4?\n\n", "Abraham Lincoln"},
            {"Which president was born in the state of Hawaii?\n\n", "Barack Obama"},
            {"Which president was originally a famous American\nactor?\n", "Ronald Reagan"},
            {"Who was the oldest elected president?\n\n", "Donald J. Trump"},
            {"Who was the only unanimously elected president by\nthe Electoral College?\n", "George Washington"},
            {"Which presidential candidate earned a Nobel Peace\nPrize for his work in climate change activism?\n",
                    "Al Gore"}};
    String[][] mediumQuestions = {
            {"Who was the first president to be married in the\nWhite House?\n", "Grover Cleveland"},
            {"Which president purchased Alaska from Russia?\n\n", "Andrew Johnson"},
            {"Which president won the Nobel Peace Prize in 2002?\n\n", "James Carter"},
            {"Who was the first president to pay off the entire\nnational debt?\n", "Andrew Jackson"},
            {"Which president served two non-consecutive terms?\n\n", "Grover Cleveland"},
            {"Who was the shortest standing president at 5'4?\n\n", "James Madison"},
            {"Which president once worked as a fashion model?\n\n", "Gerald R. Ford"},
            {"Which president had 15 children?\n\n", "John Tyler"},
            {"Who had the nickname of Young Hickory?\n\n", "James K. Polk"},
            {"Which president is in the Golf Hall of Fame?\n\n", "Dwight D. Eisenhower"},
            {"Which president was obsessed with James Bond?\n\n", "John F. Kennedy"},
            {"Who was awarded the Most Nearly Perfect\nHuman Body in 1940?\n", "Ronald Reagan"},
            {"Who was the first president to talk on the\nphone?\n", "James Garfield"},
            {"Who was the first president to be elected who had\nbeen previously divorced?\n", "Ronald Reagan"},
            {"Which president is pictured on the $50 bill?\n\n", "Ulysses S. Grant"},
            {"Who was the first president to be inaugurated\nin the White House?\n", "Thomas Jefferson"},
            {"Which president was in office during the women's\nsuffrage movement and passing of the 19th\nAmendment?",
                    "Woodrow Wilson"},
            {"The capital of Liberia is named after which\npresident?\n", "James Monroe"},
            {"Which president signed legislation creating\nMedicare?\n", "Lyndon B. Johnson"},
            {"Which president oversaw the acquisition of the\nLouisana Purchase?\n", "Thomas Jefferson"}};
    String[][] hardQuestions = {
            {"Which president adopted the log cabin and hard\ncider as their campaign symbols?\n",
                    "William H. Harrison"},
            {"Who was the last president that did not graduate from\ncollege?\n", "Harry S. Truman"},
            {"Which president won a Pulitzer Prize for his book\n\"Profiles in Courage\"?\n", "John F. Kennedy"},
            {"Who is the only U.S. president to hold a patent?\n\n", "Abraham Lincoln"},
            {"Which president's nickname was Old Kinderhook?\n\n", "Martin Van Buren"},
            {"Which president held the longest inauguration?\n\n", "William H. Harrison"},
            {"Which president died from consuming cherries and\na glass of milk?\n", "Zachary Taylor"},
            {"Who was the first president to make it in the\nWrestling Hall of Fame?\n", "Abraham Lincoln"},
            {"Which president is featured on the dime?\n\n", "Franklin D. Roosevelt"},
            {"Which president owned and used a pair of\nstilts often?\n", "Theodore Roosevelt"},
            {"Which president has a family of plants\nnamed after him?\n", "Thomas Jefferson"},
            {"Which president was responsible for the building\nof the Panama Canal?\n", "Theodore Roosevelt"},
            {"Which president married his teacher?\n\n", "Millard Fillmore"},
            {"Which president spoke fluently in Mandarin\nChinese?\n", "Herbet Hoover"},
            {"Which president abolished alcohol from the\nWhite House?\n", "Rutherford B. Hayes"},
            {"Who was the last Civil War General to serve as\npresident?\n", "Benjamin Harrison"},
            {"Who's presidency was the shortest in U.S. history?\n\n", "William H. Harrison"},
            {"Which U.S. president accidentally referred to\nthemselves as a jelly doughnut when saying \"Ich bin\nein Berliner\" during a speech in Germany?",
                    "John F. Kennedy"},
            {"Walt Whitman's poem \"Oh Captain, My Captain\"\nwas written about which president?\n",
                    "Abraham Lincoln"},
            {"Who was the first president to ask Congress for a\nDeclaration of War?\n", "James Madison"}};
	String[][] questions;
	String[][] highScores = { { "Easy", "0" }, { "Medium", "0" }, { "Hard", "0" } };

	String question = "";
	String answer = "";
	String highScoreMessage = "";

	TitleScreenHandler tsHandler = new TitleScreenHandler();
	ChoiceHandler choiceHandler = new ChoiceHandler();
	Random rand = new Random();

	Font titleFont = new Font("Times New Roman", Font.PLAIN, 48);
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);

	/*
	 * Method: main(), Input: String[], Output: Void
	 * 
	 * The main method starts the trivia game by creating an instance of the
	 * TriviaFinal() class.
	 */
	public static void main(String args[]) {
		new TriviaFinal();
	}

	/*
	 * Method: TriviaFinal(), Input: Void, Output: Void
	 * 
	 * The TriviaFinal() method is the constructor for the TriviaFinal() class. It
	 * creates the initial "Start Game" screen which then waits for an ActionEvent.
	 */
	public TriviaFinal() {

		/* Create the JFrame for the trivia game elements. */
		window = new JFrame("Presidential Trivia");
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		window.setVisible(true);
		con = window.getContentPane();

		/* Creates JPanel element to the top to hold the "Presidential Trivia" label. */
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(100, 100, 600, 150);
		titleNamePanel.setBackground(Color.black);
		titleNameLabel = new JLabel("Presidential Trivia");
		titleNameLabel.setFont(titleFont);
		titleNameLabel.setForeground(Color.white);

		/* Creates JPanel element to hold the "Start Game" button. */
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(300, 400, 200, 100);
		startButtonPanel.setBackground(Color.black);

		/* Creates a JButton with the text "Start Game" and adds it to the JPanel. */
		startButton = new JButton("Start Game");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		startButton.setFont(normalFont);
		startButton.addActionListener(tsHandler);

		/* Gets rid of visible lines that you hover over. */
		startButton.setFocusPainted(false);

		/* Adds JLabel titleNameLabel to the JPanel titleNamePane1 */
		titleNamePanel.add(titleNameLabel);

		/* Adds JButton startButton to the JPanel startButtonPanel */
		startButtonPanel.add(startButton);

		/* Adds both JLabels to the Content Pane */
		con.add(titleNamePanel);
		con.add(startButtonPanel);

	}

	/*
	 * Class: TitleScreenHandler
	 * 
	 * The class TitleScreenHandler is responsible for handling input on the Title
	 * Screen. It implements ActionListener and calls the createGameScreen() method
	 * when the user clicks the "Start Game" button.
	 */
	public class TitleScreenHandler implements ActionListener {

		/*
		 * Waits for user to press the JButton startButton then calls createGameScreen()
		 */
		@Override
		public void actionPerformed(ActionEvent event) {

			createGameScreen();
		}
	}

	/*
	 * Method: createGameScreen(), Input: Void, Output: Void
	 * 
	 * The method createGameScreen() adds the GUI elements which will be used for
	 * asking questions during the trivia game. It then calls difficultySelect() to
	 * prompt the user to choose the difficulty level of the game.
	 */
	public void createGameScreen() {

		/*
		 * Removes the two JPanel elements created in TriviaFinal() by changing their
		 * visibility, this does not delete the JLabels.
		 */
		titleNamePanel.setVisible(false);
		startButtonPanel.setVisible(false);

		/*
		 * Creates new JPanel mainTextPanel to be used to hold JTextArea mainTextArea
		 * and adds it the content pane.
		 */
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(100, 100, 600, 250);
		mainTextPanel.setBackground(Color.black);

		/*
		 * Creates JTextArea mainTextArea to hold question text and adds it to the
		 * JPanel mainTextPanel.
		 */
		mainTextArea = new JTextArea("Main Text Area");
		mainTextArea.setBounds(100, 100, 600, 250);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextPanel.add(mainTextArea);

		/*
		 * Creates new JPanel choiceButtonPanel to be used to hold JButtons: choice1,
		 * choice2, choice3, and choice4.
		 */
		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(250, 350, 300, 150);
		choiceButtonPanel.setBackground(Color.black);
		choiceButtonPanel.setLayout(new GridLayout(4, 1));

		/* Creates new JButton choice1 and adds it to JPanel choiceButtonPanel. */
		choice1 = new JButton("Choice 1");
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.white);
		choice1.setFont(normalFont);
		choice1.setFocusPainted(false);
		choice1.addActionListener(choiceHandler);
		choice1.setActionCommand("a1");
		choiceButtonPanel.add(choice1);

		/* Creates new JButton choice2 and adds it to JPanel choiceButtonPanel. */
		choice2 = new JButton("Choice 2");
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.white);
		choice2.setFont(normalFont);
		choice2.setFocusPainted(false);
		choice2.addActionListener(choiceHandler);
		choice2.setActionCommand("a2");
		choiceButtonPanel.add(choice2);

		/* Creates new JButton choice3 and adds it to JPanel choiceButtonPanel. */
		choice3 = new JButton("Choice 3");
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.white);
		choice3.setFont(normalFont);
		choice3.setFocusPainted(false);
		choice3.addActionListener(choiceHandler);
		choice3.setActionCommand("a3");
		choiceButtonPanel.add(choice3);

		/* Creates new JButton choice4 and adds it to JPanel choiceButtonPanel. */
		choice4 = new JButton("Choice 4");
		choice4.setBackground(Color.black);
		choice4.setForeground(Color.white);
		choice4.setFont(normalFont);
		choice4.setFocusPainted(false);
		choice4.addActionListener(choiceHandler);
		choice4.setActionCommand("a4");
		choiceButtonPanel.add(choice4);

		/*
		 * Creates a new JPanel questionPanel to be used to hold JLabel questionOn and
		 * JLabel questionTracker which will display the current question number.
		 */
		questionPanel = new JPanel();
		questionPanel.setBounds(100, 15, 600, 50);
		questionPanel.setBackground(Color.black);
		questionPanel.setForeground(Color.white);

		/*
		 * Creates JLabel questionTracker to display current question number and adds it
		 * to JPanel questionPanel.
		 */
		questionTracker = new JLabel();
		questionTracker.setFont(normalFont);
		questionTracker.setForeground(Color.white);
		questionPanel.add(questionTracker);

		/*
		 * Adds the JPanel's choiceButtonPanel, mainTextPanel, and questionPanel to the
		 * Content Pane.
		 */
		con.add(choiceButtonPanel);
		con.add(mainTextPanel);
		con.add(questionPanel);

		/* Calls method difficultySelect() to prompt user to select difficultyLevel. */
		difficultySelect();
	}

	/*
	 * Method: difficultSelect(), Input: Void, Output: Void
	 * 
	 * The method difficultySelect() prompts the user to select from the trivia game
	 * difficulty levels: "Easy", "Medium", and "Hard".
	 */
	public void difficultySelect() {
		/*
		 * Prompts user to Select Difficulty in the JLabel questionTracker and changes
		 * the JButtons' text.
		 */
		questionTracker.setText("Select Difficulty");
		mainTextArea.setText("");
		choice1.setText("Easy");
		choice2.setText("Medium");
		choice3.setText("Hard");

		/*
		 * JButton choice4 is set invisible because there are only three difficulty
		 * levels.
		 */
		choice4.setVisible(false);

		/* Changes String position to indicate what screen the game is on. */
		position = "DifficultySelect";
	}

	/*
	 * Method: ending(), Input: Void, Output: Void
	 * 
	 * The method ending() is used to display the score screen to the user after
	 * having completed all the questions. It updates the GUI to display: score,
	 * longest streak, number of correct questions, number of incorrect questions,
	 * and the high score. Then, it prompts the user to "Start New Game".
	 */
	public void ending() {

		/*
		 * Checks if the user set a high score in their difficulty level. If the user
		 * set a new high score it updates the highScores[][] and appends
		 * "New High Score" in the highScoreMessage.
		 */
		String pointsString = String.valueOf(points);
		if (position.equals("easyQuestions")) {
			questionTracker.setText("Score Screen (Difficulty: Easy)");
			if (points > Integer.parseInt(highScores[0][1])) {
				highScores[0][1] = pointsString;
				highScoreMessage = "High Score:\t" + highScores[0][1] + "\tNew High Score!";
			} else {
				highScoreMessage = "High Score:\t" + highScores[0][1];
			}
		} else if (position.equals("mediumQuestions")) {
			questionTracker.setText("Score Screen (Difficulty: Medium)");
			if (points > Integer.parseInt(highScores[1][1])) {
				highScores[1][1] = pointsString;
				highScoreMessage = "High Score:\t" + highScores[1][1] + "\tNew High Score!";
			} else {
				highScoreMessage = "High Score:\t" + highScores[1][1];
			}
		} else {
			questionTracker.setText("Score Screen (Difficulty: Hard)");
			if (points > Integer.parseInt(highScores[2][1])) {
				highScores[2][1] = pointsString;
				highScoreMessage = "High Score:\t" + highScores[2][1] + "\tNew High Score!";
			} else {
				highScoreMessage = "High Score:\t" + highScores[2][1];
			}
		}

		/*
		 * Displays the final score, longest streak, number of questions correct, number
		 * of questions incorrect, high score, and the appended "New High Score"
		 * message.
		 */
		mainTextArea.setText("Final Score:\t\t" + points + "\nLongest Streak:\t" + maxStreak + "\n\nNumber Correct:\t"
				+ (int) correct + "\nNumber Incorrect:\t" + (int) incorrect + "\n\n" + highScoreMessage);

		/* Makes all but one button invisible */
		choice1.setVisible(false);
		choice2.setVisible(false);
		choice3.setVisible(false);

		/* Prompts user to "Start New Game" in only visible button. */
		choice4.setText("Start New Game");

		/* Updates position for when the user clicks choice4. */
		position = "ending";
	}

	/*
	 * Method: getRandomPresidents(), Input: String blackList, Output: String[]
	 * 
	 * The method getRandomPresidents() will return an array of 4 presidents' names
	 * from presidents[] to be used as random answers. This method takes the
	 * parameter String blackList (the answer to the question) and uses it to
	 * generate distinct presidents' names.
	 */
	public String[] getRandomPresidents(String blackList) {
		String randomPresidents[] = new String[4];

		/*
		 * Repeatedly generates a random index of the presidents[] array until it finds
		 * a unique president. It appends unique presidents to the randomPresidents[]
		 * array.
		 */
		int randomIndex = rand.nextInt(presidents.length);
		while (presidents[randomIndex].equals(blackList)) {
			randomIndex = rand.nextInt(presidents.length);
		}
		randomPresidents[0] = presidents[randomIndex];

		while (presidents[randomIndex].equals(blackList) || presidents[randomIndex].equals(randomPresidents[0])) {
			randomIndex = rand.nextInt(presidents.length);
		}
		randomPresidents[1] = presidents[randomIndex];

		while (presidents[randomIndex].equals(blackList) || presidents[randomIndex].equals(randomPresidents[0])
				|| presidents[randomIndex].equals(randomPresidents[1])) {
			randomIndex = rand.nextInt(presidents.length);
		}
		randomPresidents[2] = presidents[randomIndex];

		while (presidents[randomIndex].equals(blackList) || presidents[randomIndex].equals(randomPresidents[0])
				|| presidents[randomIndex].equals(randomPresidents[1])
				|| presidents[randomIndex].equals(randomPresidents[2])) {
			randomIndex = rand.nextInt(presidents.length);
		}
		randomPresidents[3] = presidents[randomIndex];

		/*
		 * Returns an array of 4 unique president names which do not match the answer.
		 */
		return randomPresidents;
	}

	/*
	 * Class: ChoiceHandler
	 * 
	 * The class ChoiceHandler is responsible for handling input on the Select
	 * Difficulty Screen, Score Screen, and Question Screens. It implements
	 * ActionListener and updates the GUI when a user clicks a button.
	 */
	public class ChoiceHandler implements ActionListener {

		String yourChoice = "";

		@Override
		public synchronized void actionPerformed(ActionEvent event) {

			yourChoice = event.getActionCommand();

			/*
			 * This checks if the game has reached the end and that the user is currently on
			 * the score screen. It resets all values being displayed and updates the GUI
			 * back to the "Select Difficulty" screen.
			 */
			if (position.equals("ending")) {
				difficultySelect();
				choice1.setVisible(true);
				choice2.setVisible(true);
				choice3.setVisible(true);
				questionCount = 0;
				streak = 0;
				maxStreak = 0;
				points = 0;
				correct = 0;
				incorrect = 0;
				return;
			}

			/*
			 * Checks to see what difficulty the user selected from the "Select Difficulty"
			 * screen. Based on the difficulty, it assigns either easyQuestions,
			 * mediumQuestions, or hardQuestions to the questions array.
			 * 
			 */
			if (position.equals("DifficultySelect")) {
				if (yourChoice.equals("a1")) {
					questions = easyQuestions;
					position = "easyQuestions";
				} else if (yourChoice.equals("a2")) {
					questions = mediumQuestions;
					position = "mediumQuestions";
				} else {
					questions = hardQuestions;
					position = "hardQuestions";
				}
				choice4.setVisible(true);
			} else {
				/*
				 * Checks to see if the answer is correct. If correct, it increases the number
				 * of questions correct, score, and the current streak.
				 */
				questionCount++;
				if ((yourChoice.equals("a1") && choice1.getText().equals(answer))
						|| (yourChoice.equals("a2") && choice2.getText().equals(answer))
						|| (yourChoice.equals("a3") && choice3.getText().equals(answer))
						|| (yourChoice.equals("a4") && choice4.getText().equals(answer))) {
					correct++;
					points += (streak + 1);
					streak++;
					if (streak > maxStreak) {
						maxStreak = streak;
					}
					/* Displays a pop-up JOptionPane with "Correct!" if correct. */
					JOptionPane.showMessageDialog(null, "Correct!\n\nCORRECT ANSWERS: " + (int) correct
							+ "\nINCORRECT ANSWERS: " + (int) incorrect); 
				} else {
					/*
					 * Iterate the number of incorrect questions and reset the streak to 0 if
					 * question is incorrect.
					 */
					incorrect++;
					streak = 0;
					/* Displays a pop-up with "Incorrect" and the correct answer */
					JOptionPane.showMessageDialog(null, "Incorrect! The correct answer was: " + answer
							+ "\n\nCORRECT ANSWERS: " + (int) correct + "\nINCORRECT ANSWERS: " + (int) incorrect);
				}
			}

			/*
			 * Checks to see if there are questions remaining. If there are no questions
			 * remaining it calls the ending() method.
			 */
			if (questionCount < 20) {
				question = questions[questionCount][0];
				answer = questions[questionCount][1];
			} else {
				ending();
				return;
			}

			/*
			 * Displays the current question number out of 20 in the JLabel questionTracker
			 */
			questionTracker.setText("Question: " + (questionCount + 1) + " out of 20!");

			/*
			 * Displays the question, score, and current streak.
			 */
			mainTextArea.setText(question + "\n\nPoints: " + points + "\nStreak: " + streak);

			/* Assigns random answers to each button. */
			String[] randomAnswers = getRandomPresidents(answer);

			choice1.setText(randomAnswers[0]);
			choice2.setText(randomAnswers[1]);
			choice3.setText(randomAnswers[2]);
			choice4.setText(randomAnswers[3]);

			int randomAnswer = rand.nextInt(4);
			if (randomAnswer == 0) {
				choice1.setText(answer);
			} else if (randomAnswer == 1) {
				choice2.setText(answer);
			} else if (randomAnswer == 2) {
				choice3.setText(answer);
			} else {
				choice4.setText(answer);
			}

		}

	}
}