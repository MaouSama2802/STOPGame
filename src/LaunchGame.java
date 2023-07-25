import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class LaunchGame extends JFrame implements ActionListener {
    String[] categoryName = {"Winston", "Devon", "Jarvis", "Giovani", "Susan", "Gina", "Pedro", "Vivian", "Veronica", "Javier", "Caroline", "Coraline", "Donovan", "Yesenia", "Rick", "Richard", "Dick", "Tatiana", "Tati", "Natalie", "Miguel", "Rafael", "Lily", "Liliam", "Maria", "Samantha", "Karen", "Estefania", "Ursula", "Nicole","Daniela", "Carlos", "Ronald","Irvin", "Alex", "Alice", "Ava", "Aiden", "Amelia", "Benjamin", "Charlotte", "Carter", "Chloe", "Daniel", "Ella", "Ethan", "Emma", "Finn", "Grace", "Gavin", "Hannah", "Henry", "Isabella", "Ian", "Julia", "Jackson", "Lily", "Jacob", "Mia", "John", "Nora", "Joseph", "Olivia", "Joshua", "Sophia", "Leo", "Zoe", "Liam", "Aria", "Lucas", "Abigail", "Luke", "Addison", "Mason", "Aurora", "Matthew", "Bella", "Michael", "Camila", "Nathan", "Charlotte", "Noah", "Eleanor", "Oliver", "Elizabeth", "Owen", "Eva", "Ryan", "Evelyn", "Samuel", "Gabriella", "Sebastian", "Hazel", "Thomas", "Isabella", "William", "Layla", "Wyatt", "Madison", "Xavier", "Natalie", "Zachary", "Penelope", "Aaron", "Brooklyn", "Adam", "Clara", "Adrian", "Daisy", "Alan", "Eliza", "Albert", "Faith", "Alfred", "Fiona", "Arthur", "Gianna", "Ashton", "Harper", "Austin", "Isla", "Bentley", "Jasmine", "Blake", "Katherine", "Brady", "Lillian", "Brandon", "Makayla", "Bryson", "Nevaeh", "Calvin", "Olive", "Carson", "Paisley", "Charles", "Quinn", "Christian", "Riley", "Christopher", "Sadie", "Colton", "Violet", "David", "Willow", "Dominic", "Ximena", "Dylan", "Yara", "Eli", "Zara", "Elias", "Aaron", "Elton", "Bianca", "Emmett", "Cassandra", "Eric", "Diana", "Ezekiel", "Eleanor", "Felix", "Francesca", "Finnegan", "Genevieve", "Gabriel", "Giselle", "Gideon", "Hannah", "Graham", "Helena", "Harvey", "Isabelle", "Hector", "Ivy", "Hugo", "Jade", "Hunter", "Kylie", "Ivan", "Leilani", "Iker", "Mariana", "Isaac", "Mila", "Isla", "Nyla", "Israel", "Ophelia", "Jace", "Paulina", "James", "Rose", "Jasper", "Sabrina", "Jason", "Simone", "Jeffrey", "Valentina", "Joel", "Victoria", "Jonah", "Willa", "Jordan", "Yasmin", "Jude", "Zelda", "Julian", "Abby", "Kai", "Alexa", "Kaleb", "Belle", "Kameron", "Cara", "Keegan", "Demi", "Kingston", "Eden", "Kyle", "Faye", "Landon", "Georgia", "Lawrence", "Harmony", "Lincoln", "Irene", "Louis", "Journey", "Luis", "Kadence", "Malcolm", "Leona", "Marco", "Margot", "Mario", "Nadia", "Max", "Octavia", "Miguel", "Primrose", "Nathaniel", "Rosie", "Nicholas", "Sage", "Nolan", "Talia", "Oscar", "Uma", "Parker", "Viola", "Peter", "Wren", "Peyton", "Xanthe", "Phoenix", "Yara", "Preston", "Zahara", "Raymond", "Zuri", "Richard", "Abe", "Riley", "Ace", "Roman", "Adam", "Ronan", "Alden", "Rory", "Andre", "Ryder", "Archer", "Rylan", "Arlo", "Sam", "Arthur", "Sasha", "Austin", "Shane", "Axel", "Simon", "Beckett", "Spencer", "Bennett", "Tate", "Blake", "Theo", "Bradley", "Toby", "Brennan", "Tristan", "Brock", "Tyler", "Brody", "Tyson", "Brooks", "Valentin", "Bryce", "Vance", "Bryant", "Viggo", "Caleb", "Wesley", "Calvin", "Weston", "Cameron", "Wilder", "Casey", "Xander", "Cash", "Xavier", "Casper", "Zach", "Chance", "Zander", "Charlie", "Zane", "Chase", "Zayden", "Christian", "Zion", "Clark", "Zayn", "Cody", "Zeke", "Cole", "Zion", "Colin", "Zoltan", "Colton", "Zephyr", "Conor", "Ziggy", "Cruz", "Ziv", "Damon", "Zuriel", "Daniel", "Zyan", "Dante", "Zyon", "Darius", "Zephyr", "Dashiell", "Zeke", "David", "Zev", "Dawson", "Ziv", "Declan", "Zane", "Dexter", "Zaiden", "Dominic", "Zavier", "Dorian", "Zahir", "Drake", "Zayden", "Drew", "Zion", "Duke", "Zephyr", "Dylan", "Zeus", "Eli", "Zane", "Elias", "Zayn", "Elliot", "Zander", "Emerson", "Zack", "Emmett", "Zephyr", "Enzo", "Zion", "Eric", "Zev", "Ethan", "Ziggy", "Ezekiel", "Zephyr", "Ezra", "Zaiden", "Felix", "Zane", "Finn", "Zahir", "Flynn", "Zavian", "Ford", "Zed", "Forest", "Zephyr", "Foster", "Zev", "Franklin", "Zane", "Gabriel", "Zaire", "Gavin", "Zane", "George", "Zavier", "Graham", "Zayden", "Grant", "Zephyr", "Grayson", "Zev", "Gregory", "Zayn", "Griffin", "Zephyr", "Hank", "Zion", "Harrison", "Zane", "Harvey", "Zayden", "Hayden", "Zephyr", "Heath", "Zev", "Henry", "Zayn", "Holden", "Zion", "Hudson", "Zephyr", "Hunter", "Zane", "Ian", "Zev", "Isaac", "Zayden", "Isaiah", "Zephyr", "Jack", "Zane", "Jackson", "Zion", "Jacob", "Zev", "Jasper", "Zayn", "Jayce", "Zephyr", "Jeremy", "Zane", "Jesse", "Zahir", "Joel", "Zaiden", "John", "Zane", "Jonah", "Zephyr", "Jonathan", "Zev", "Jordan", "Zayn", "Joseph", "Zane", "Joshua", "Zephyr", "Josiah", "Zion", "Julian", "Zaire", "Kai", "Zane", "Kane", "Zayn", "Kasen", "Zephyr", "Kellan", "Zev", "Kenneth", "Zahir", "Kevin", "Zane", "Kieran", "Zayden", "Knox", "Zephyr", "Kyle", "Zion", "Landon", "Zane", "Leo", "Zev", "Leon", "Zayn", "Levi", "Zephyr", "Liam", "Zane", "Lincoln", "Zaire", "Logan", "Zayden", "Lucas", "Zephyr", "Luke", "Zev", "Maddox", "Zahir", "Magnus", "Zane", "Malachi", "Zayn", "Marco", "Zephyr", "Marshall", "Zane", "Mason", "Zayden", "Mateo", "Zephyr", "Matthew", "Zane", "Maverick", "Zahir", "Max", "Zayn", "Maximus", "Zephyr", "Micah", "Zane", "Miles", "Zayden", "Milo", "Zephyr", "Nash", "Zane", "Nathan", "Zayn", "Nathaniel", "Zephyr", "Nolan", "Zane", "Oliver", "Zayden", "Oscar", "Zephyr", "Owen", "Zane", "Parker", "Zayn", "Patrick", "Zephyr", "Paul", "Zane", "Peter", "Zayden", "Phoenix", "Zephyr", "Porter", "Zane", "Preston", "Zayn", "Quentin", "Zephyr", "Raphael", "Zane", "Reid", "Zayden", "Rhett", "Zephyr", "Richard", "Zane", "Riley", "Zayn", "River", "Zephyr", "Robert", "Zane", "Roman", "Zayden", "Ronan", "Zephyr", "Rowan", "Zane", "Royce", "Zayn", "Russell", "Zephyr", "Ryder", "Zane", "Samuel", "Zayden", "Santiago", "Zephyr", "Sawyer", "Zane", "Sebastian", "Zayn", "Shane", "Zephyr", "Silas", "Zane", "Simon", "Zayden", "Spencer", "Zephyr", "Stephen", "Zane", "Tanner", "Zayn", "Theodore", "Zephyr", "Thomas", "Zane", "Timothy", "Travis", "Zephyr", "Trenton", "Zane", "Trevor", "Zayn", "Tristan", "Zephyr", "Tucker", "Zane", "Tyler", "Zayden", "Vance", "Zephyr", "Victor", "Zane", "Vincent", "Zayn", "Walter", "Zephyr", "Warren", "Zane", "Waylon", "Zayden", "Wesley", "Zephyr", "Weston", "Zane", "William", "Zayn", "Wyatt", "Zephyr", "Xander", "Zane", "Zachary", "Zayden", "Zane", "Zephyr"};
    String[] categoryCountry = {"Afghanistan", "Albania", "Algeria", "Andorra", "Angola", "Antigua and Barbuda", "Argentina", "Armenia", "Australia", "Austria", "Azerbaijan", "The Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bhutan", "Bolivia", "Bosnia and Herzegovina", "Botswana", "Brazil", "Brunei", "Bulgaria", "Burkina Faso", "Burundi", "Cabo Verde", "Cambodia", "Cameroon", "Canada", "Chad", "Chile", "China", "Colombia", "Comoros", "Congo", "Costa Rica", "Croatia", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Eswatini", "Ethiopia", "Fiji", "Finland", "France", "Gabon", "The Gambia", "Georgia", "Germany", "Ghana", "Greece", "Grenada", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Honduras", "Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland", "Israel", "Italy", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "North Korea", "South Korea", "Kosovo", "Kuwait", "Kyrgyzstan", "Laos", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Mauritania", "Mauritius", "Mexico", "Micronesia", "Moldova", "Monaco", "Mongolia", "Montenegro", "Morocco", "Mozambique", "Myanmar", "Namibia", "Nauru", "Nepal", "Netherlands", "New Zealand", "Nicaragua", "Niger", "Nigeria", "North Macedonia", "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua", "New Guinea", "Paraguay", "Peru", "Philippines", "Poland", "Portugal", "Qatar", "Romania", "Russia", "Rwanda", "Saint Kitts and Nevis", "Saint Lucia", "Saint Vincent and the Grenadines", "Samoa", "San Marino", "Sao Tome and Principe", "Saudi Arabia", "Senegal", "Serbia", "Seychelles", "Sierra Leone", "Singapore", "Slovakia", "Slovenia", "Solomon", "Islands", "Somalia", "South Africa", "Spain", "Sri Lanka", "Sudan", "Suriname", "Sweden", "Switzerland", "Syria", "Taiwan", "Tajikistan", "Tanzania", "Thailand", "Togo", "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey", "Turkmenistan", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States", "Uruguay", "Uzbekistan", "Vanuatu", "Vatican City", "Venezuela", "Vietnam", "Yemen","Wales", "Zambia", "Zimbabwe"};
    String[] categoryFruit = {"Pumpkin", "Blueberry", "Eggplant", "Cucumber", "Mamey", "Pear", "Coconut", "Guava", "Apple", "Banana", "Cherry", "Dragonfruit", "Elderberry", "Fig", "Grape", "Honeydew Melon", "Indian Gooseberry", "Jackfruit", "Kiwi", "Lemon", "Mango", "Nectarine", "Orange", "Papaya", "Quince", "Raspberry", "Strawberry", "Tomato", "Ugli Fruit", "Valencia Orange", "Watermelon", "Xigua", "Yellow", "Zucchini"};
    String[] categoryAnimal = {"Peacock", "Polar Bear", "Eagle", "bat", "Deer", "Whale", "Ant", "Bear", "Cat", "Dog", "Elephant", "Fox", "Giraffe", "Horse", "Impala", "Jaguar", "Kangaroo", "Lion", "Monkey", "Newt", "Octopus", "Penguin", "Quokka", "Rabbit", "Snake", "Tiger", "Uakari", "Vulture", "Wolf", "Stingray", "Yak", "Zebra"};
    String[] categoryColor = {"Beige", "Amaranth", "Blue", "Black", "Brown", "Crimson", "Dark Green", "Emerald Green", "Fuchsia", "Green", "Honeydew", "Indigo", "Jade", "Khaki", "Lavender", "Magenta", "Navy Blue", "Orange", "Pink", "Quartz", "Red", "Sapphire", "Turquoise", "Ultramarine", "Violet", "White", "Xanadu", "Yellow", "Zaffre" };
    Timer timer;
    int actualRound = 0;
    int totalRounds = 5;
    char currentLetter;
    int userScore = 0;
    int seconds = 0;
    int milliseconds = 0;
    int elapsedTime = 0;
    String secondsString = String.format("%02d", seconds);
    String millisecondsString = String.format("%04d", milliseconds);
    ImageIcon iconStop = new ImageIcon("stop_cartoon.png");
    ImageIcon iconGo = new ImageIcon("go_cartoon.png");
    ImageIcon iconThumbs = new ImageIcon("thumbsUp_cartoon.png");

    int iconStopWidth = iconStop.getIconWidth();
    int iconStopHeight = iconStop.getIconHeight();

    int iconGoWidth = iconGo.getIconWidth();
    int iconGoHeight = iconGo.getIconHeight();

    int iconThumbsWidth = iconThumbs.getIconWidth();
    int iconThumbsHeight = iconThumbs.getIconHeight();

    JLabel categoryNameLabel = new JLabel("<html><u>Name</u></html>");
    JLabel categoryCountryLabel = new JLabel("<html><u>Country</u></html>");
    JLabel categoryFruitLabel = new JLabel("<html><u>Fruit</u></html>");
    JLabel categoryAnimalLabel = new JLabel("<html><u>Animal</u></html>");
    JLabel categoryColorLabel = new JLabel("<html><u>Color</u></html>");
    JLabel timeLabel =new JLabel("Timer " + secondsString + ":" + millisecondsString);

    JLabel roundLabel1 = new JLabel("Round 1:");
    JLabel roundLabel2 = new JLabel("Round 2:");
    JLabel roundLabel3 = new JLabel("Round 3:");
    JLabel roundLabel4 = new JLabel("Round 4:");
    JLabel roundLabel5 = new JLabel("Round 5:");

    JLabel letterLabel = new JLabel();
    JLabel currentLetterLabel = new JLabel();
    JPanel letterPanel = new JPanel();
    JLabel iconLabel = new JLabel();
    JButton letterButton = new JButton("Start Game");
    JButton menuButton = new JButton("Main Menu");
    JButton saveScoreButton = new JButton("Save Scores");
    JTextField userScoreField = new JTextField();

    JTextField nameField = new JTextField();
    JTextField nameField2 = new JTextField();
    JTextField nameField3 = new JTextField();
    JTextField nameField4 = new JTextField();
    JTextField nameField5 = new JTextField();

    JTextField countryField = new JTextField();
    JTextField countryField2 = new JTextField();
    JTextField countryField3 = new JTextField();
    JTextField countryField4 = new JTextField();
    JTextField countryField5 = new JTextField();

    JTextField fruitField = new JTextField();
    JTextField fruitField2 = new JTextField();
    JTextField fruitField3 = new JTextField();
    JTextField fruitField4 = new JTextField();
    JTextField fruitField5 = new JTextField();

    JTextField animalField = new JTextField();
    JTextField animalField2 = new JTextField();
    JTextField animalField3 = new JTextField();
    JTextField animalField4 = new JTextField();
    JTextField animalField5 = new JTextField();

    JTextField colorField = new JTextField();
    JTextField colorField2 = new JTextField();
    JTextField colorField3 = new JTextField();
    JTextField colorField4 = new JTextField();
    JTextField colorField5 = new JTextField();

    LaunchGame() {
        timer = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                elapsedTime += 1;
                seconds = elapsedTime / 1000 ;
                milliseconds = elapsedTime % 1000;
                secondsString = String.format("%02d", seconds);
                millisecondsString = String.format("%03d", milliseconds);
                timeLabel.setText("Timer " + secondsString + ":" + millisecondsString);
                if (seconds == 30 || actualRound==totalRounds+1) {
                    ((Timer) e.getSource()).stop();
                    elapsedTime=0;
                    seconds=0;
                    milliseconds=0;
                    iconGoWidth = 630;
                    iconGoHeight = 750;
                    if(actualRound!=totalRounds+1){
                        Image scaledImage = iconStop.getImage().getScaledInstance(iconStopWidth, iconStopHeight, Image.SCALE_SMOOTH);
                        ImageIcon scaledIcon = new ImageIcon(scaledImage);
                        iconLabel.setIcon(scaledIcon);
                    }
                    timeLabel.setForeground(new Color(204,0,0));

                    nameField.setEditable(false);
                    nameField2.setEditable(false);
                    nameField3.setEditable(false);
                    nameField4.setEditable(false);
                    nameField5.setEditable(false);

                    countryField.setEditable(false);
                    countryField2.setEditable(false);
                    countryField3.setEditable(false);
                    countryField4.setEditable(false);
                    countryField5.setEditable(false);

                    fruitField.setEditable(false);
                    fruitField2.setEditable(false);
                    fruitField3.setEditable(false);
                    fruitField4.setEditable(false);
                    fruitField5.setEditable(false);

                    animalField.setEditable(false);
                    animalField2.setEditable(false);
                    animalField3.setEditable(false);
                    animalField4.setEditable(false);
                    animalField5.setEditable(false);

                    colorField.setEditable(false);
                    colorField2.setEditable(false);
                    colorField3.setEditable(false);
                    colorField4.setEditable(false);
                    colorField5.setEditable(false);
                }
            }
        });
        timeLabel.setBounds(700, 10, 400, 80);
        timeLabel.setOpaque(true);
        timeLabel.setForeground(Color.green);
        timeLabel.setBackground(Color.white);
        timeLabel.setFont(new Font("Arial",Font.BOLD,50));
        iconStopWidth = 630;
        iconStopHeight = 750;
        Image goScaled = iconGo.getImage().getScaledInstance(iconStopWidth, iconStopHeight, Image.SCALE_SMOOTH);
        ImageIcon goImage = new ImageIcon(goScaled);
        letterButton.addActionListener(this);
        menuButton.addActionListener(this);
        saveScoreButton.addActionListener(this);
        saveScoreButton.setBounds(1300,100,120,80);
        menuButton.setBounds(1300,10,120,80);
        letterButton.setBounds(100,10,120,40);
        letterPanel.setBounds(100,100,150,50);
        iconLabel.setBounds(800,120,630,750);
        currentLetterLabel.setBounds(265,95,100,50);
        userScoreField.setText("Score: " + userScore);
        userScoreField.setEditable(false);
        userScoreField.setBounds(700,100,115,50);
        userScoreField.setFont(new Font("Arial",Font.PLAIN,20));
        userScoreField.setBackground(Color.white);
        userScoreField.setForeground(Color.black);

        nameField.setBounds(100,285,100,40);
        nameField.setEditable(false);
        nameField.setBackground(Color.white);
        nameField.setForeground(Color.black);
        nameField.setCaretColor(Color.black);

        nameField2.setBounds(100,385,100,40);
        nameField2.setEditable(false);
        nameField2.setBackground(Color.white);
        nameField2.setForeground(Color.black);
        nameField2.setCaretColor(Color.black);

        nameField3.setBounds(100,485,100,40);
        nameField3.setEditable(false);
        nameField3.setBackground(Color.white);
        nameField3.setForeground(Color.black);
        nameField3.setCaretColor(Color.black);

        nameField4.setBounds(100,585,100,40);
        nameField4.setEditable(false);
        nameField4.setBackground(Color.white);
        nameField4.setForeground(Color.black);
        nameField4.setCaretColor(Color.black);

        nameField5.setBounds(100,685,100,40);
        nameField5.setEditable(false);
        nameField5.setBackground(Color.white);
        nameField5.setForeground(Color.black);
        nameField5.setCaretColor(Color.black);

        countryField.setBounds(250,285,100,40);
        countryField.setEditable(false);
        countryField.setBackground(Color.white);
        countryField.setForeground(Color.black);
        countryField.setCaretColor(Color.black);

        countryField2.setBounds(250,385,100,40);
        countryField2.setEditable(false);
        countryField2.setBackground(Color.white);
        countryField2.setForeground(Color.black);
        countryField2.setCaretColor(Color.black);

        countryField3.setBounds(250,485,100,40);
        countryField3.setEditable(false);
        countryField3.setBackground(Color.white);
        countryField3.setForeground(Color.black);
        countryField3.setCaretColor(Color.black);

        countryField4.setBounds(250,585,100,40);
        countryField4.setEditable(false);
        countryField4.setBackground(Color.white);
        countryField4.setForeground(Color.black);
        countryField4.setCaretColor(Color.black);

        countryField5.setBounds(250,685,100,40);
        countryField5.setEditable(false);
        countryField5.setBackground(Color.white);
        countryField5.setForeground(Color.black);
        countryField5.setCaretColor(Color.black);

        fruitField.setBounds(400,285,100,40);
        fruitField.setEditable(false);
        fruitField.setBackground(Color.white);
        fruitField.setForeground(Color.black);
        fruitField.setCaretColor(Color.black);

        fruitField2.setBounds(400,385,100,40);
        fruitField2.setEditable(false);
        fruitField2.setBackground(Color.white);
        fruitField2.setForeground(Color.black);
        fruitField2.setCaretColor(Color.black);

        fruitField3.setBounds(400,485,100,40);
        fruitField3.setEditable(false);
        fruitField3.setBackground(Color.white);
        fruitField3.setForeground(Color.black);
        fruitField3.setCaretColor(Color.black);

        fruitField4.setBounds(400,585,100,40);
        fruitField4.setEditable(false);
        fruitField4.setBackground(Color.white);
        fruitField4.setForeground(Color.black);
        fruitField4.setCaretColor(Color.black);

        fruitField5.setBounds(400,685,100,40);
        fruitField5.setEditable(false);
        fruitField5.setBackground(Color.white);
        fruitField5.setForeground(Color.black);
        fruitField5.setCaretColor(Color.black);

        animalField.setBounds(550,285,100,40);
        animalField.setEditable(false);
        animalField.setBackground(Color.white);
        animalField.setForeground(Color.black);
        animalField.setCaretColor(Color.black);

        animalField2.setBounds(550,385,100,40);
        animalField2.setEditable(false);
        animalField2.setBackground(Color.white);
        animalField2.setForeground(Color.black);
        animalField2.setCaretColor(Color.black);

        animalField3.setBounds(550,485,100,40);
        animalField3.setEditable(false);
        animalField3.setBackground(Color.white);
        animalField3.setForeground(Color.black);
        animalField3.setCaretColor(Color.black);

        animalField4.setBounds(550,585,100,40);
        animalField4.setEditable(false);
        animalField4.setBackground(Color.white);
        animalField4.setForeground(Color.black);
        animalField4.setCaretColor(Color.black);

        animalField5.setBounds(550,685,100,40);
        animalField5.setEditable(false);
        animalField5.setBackground(Color.white);
        animalField5.setForeground(Color.black);
        animalField5.setCaretColor(Color.black);

        colorField.setBounds(700,285,100,40);
        colorField.setEditable(false);
        colorField.setBackground(Color.white);
        colorField.setForeground(Color.black);
        colorField.setCaretColor(Color.black);

        colorField2.setBounds(700,385,100,40);
        colorField2.setEditable(false);
        colorField2.setBackground(Color.white);
        colorField2.setForeground(Color.black);
        colorField2.setCaretColor(Color.black);

        colorField3.setBounds(700,485,100,40);
        colorField3.setEditable(false);
        colorField3.setBackground(Color.white);
        colorField3.setForeground(Color.black);
        colorField3.setCaretColor(Color.black);

        colorField4.setBounds(700,585,100,40);
        colorField4.setEditable(false);
        colorField4.setBackground(Color.white);
        colorField4.setForeground(Color.black);
        colorField4.setCaretColor(Color.black);

        colorField5.setBounds(700,685,100,40);
        colorField5.setEditable(false);
        colorField5.setBackground(Color.white);
        colorField5.setForeground(Color.black);
        colorField5.setCaretColor(Color.black);

        letterPanel.add(letterLabel);
        letterPanel.setBackground(new Color(204,0,0));
        iconLabel.setIcon(goImage);

        categoryNameLabel.setBounds(110,220,100,50);
        categoryNameLabel.setBackground(new Color(204,0,0));
        categoryNameLabel.setForeground(Color.white);
        categoryNameLabel.setFont(new Font("Arial",Font.BOLD,26));
        categoryNameLabel.setOpaque(true);

        categoryCountryLabel.setBounds(255,220,100,50);
        categoryCountryLabel.setBackground(new Color(204,0,0));
        categoryCountryLabel.setForeground(Color.white);
        categoryCountryLabel.setFont(new Font("Arial",Font.BOLD,26));
        categoryCountryLabel.setOpaque(true);

        categoryFruitLabel.setBounds(420,220,100,50);
        categoryFruitLabel.setBackground(new Color(204,0,0));
        categoryFruitLabel.setForeground(Color.white);
        categoryFruitLabel.setFont(new Font("Arial",Font.BOLD,26));
        categoryFruitLabel.setOpaque(true);

        categoryAnimalLabel.setBounds(560,220,100,50);
        categoryAnimalLabel.setBackground(new Color(204,0,0));
        categoryAnimalLabel.setForeground(Color.white);
        categoryAnimalLabel.setFont(new Font("Arial",Font.BOLD,26));
        categoryAnimalLabel.setOpaque(true);

        categoryColorLabel.setBounds(715,220,100,50);
        categoryColorLabel.setBackground(new Color(204,0,0));
        categoryColorLabel.setForeground(Color.white);
        categoryColorLabel.setFont(new Font("Arial",Font.BOLD,26));
        categoryColorLabel.setOpaque(true);

        roundLabel1.setBounds(20,280,70,50);
        roundLabel1.setBackground(new Color(204,0,0));
        roundLabel1.setForeground(Color.white);
        roundLabel1.setFont(new Font("Arial",Font.ITALIC,16));
        roundLabel1.setOpaque(true);

        roundLabel2.setBounds(20,380,70,50);
        roundLabel2.setBackground(new Color(204,0,0));
        roundLabel2.setForeground(Color.white);
        roundLabel2.setFont(new Font("Arial",Font.ITALIC,16));
        roundLabel2.setOpaque(true);

        roundLabel3.setBounds(20,480,70,50);
        roundLabel3.setBackground(new Color(204,0,0));
        roundLabel3.setForeground(Color.white);
        roundLabel3.setFont(new Font("Arial",Font.ITALIC,16));
        roundLabel3.setOpaque(true);

        roundLabel4.setBounds(20,580,70,50);
        roundLabel4.setBackground(new Color(204,0,0));
        roundLabel4.setForeground(Color.white);
        roundLabel4.setFont(new Font("Arial",Font.ITALIC,16));
        roundLabel4.setOpaque(true);

        roundLabel5.setBounds(20,680,70,50);
        roundLabel5.setBackground(new Color(204,0,0));
        roundLabel5.setForeground(Color.white);
        roundLabel5.setFont(new Font("Arial",Font.ITALIC,16));
        roundLabel5.setOpaque(true);

        this.add(userScoreField);
        this.add(categoryNameLabel);
        this.add(categoryCountryLabel);
        this.add(categoryFruitLabel);
        this.add(categoryAnimalLabel);
        this.add(categoryColorLabel);

        this.add(currentLetterLabel);
        this.add(nameField);
        this.add(nameField2);
        this.add(nameField3);
        this.add(nameField4);
        this.add(nameField5);

        this.add(countryField);
        this.add(countryField2);
        this.add(countryField3);
        this.add(countryField4);
        this.add(countryField5);

        this.add(fruitField);
        this.add(fruitField2);
        this.add(fruitField3);
        this.add(fruitField4);
        this.add(fruitField5);

        this.add(animalField);
        this.add(animalField2);
        this.add(animalField3);
        this.add(animalField4);
        this.add(animalField5);

        this.add(colorField);
        this.add(colorField2);
        this.add(colorField3);
        this.add(colorField4);
        this.add(colorField5);

        this.add(roundLabel1);
        this.add(roundLabel2);
        this.add(roundLabel3);
        this.add(roundLabel4);
        this.add(roundLabel5);

        this.add(saveScoreButton);
        saveScoreButton.setVisible(false);

        this.add(timeLabel);
        this.add(letterButton);
        this.add(menuButton);
        this.add(letterPanel);
        this.add(iconLabel);
        this.getContentPane().setBackground(new Color(204,0,0));
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLayout(null);
        this.setTitle("STOP");
        this.setVisible(true);
    }

    private void generateRandomLetter() {
        Random random = new Random();
        char tempLetter;
        tempLetter = currentLetter;
        while (tempLetter==currentLetter){
            currentLetter = (char) (random.nextInt(26) + 'A');
        }
        letterLabel.setText("Round's letter: ");
        currentLetterLabel.setText(String.valueOf(currentLetter));
        letterLabel.setForeground(Color.white);
        currentLetterLabel.setForeground(Color.white);
        letterLabel.setFont(new Font("Arial",Font.BOLD,20));
        currentLetterLabel.setFont(new Font("Arial",Font.BOLD,35));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==saveScoreButton && actualRound==totalRounds+1){
            iconGoWidth = 270;
            iconGoHeight = 300;
            Image goScaled = iconGo.getImage().getScaledInstance(iconGoWidth, iconGoHeight, Image.SCALE_SMOOTH);
            ImageIcon goImage = new ImageIcon(goScaled);
            String playerName = (String) JOptionPane.showInputDialog(null,"Enter your name","User's Name",JOptionPane.PLAIN_MESSAGE, goImage,null,"Your Name");
            if(playerName == null){
                playerName = "Unknown Player";
            }
            try {
                BufferedWriter saveScores = new BufferedWriter(new FileWriter("Player's Scores.txt",true));
                CharSequence csq =("Player: " + playerName + " scored " +userScore + " points.");
                saveScores.append(csq);
                saveScores.newLine();
                saveScores.close();
            } catch (IOException f) {
                throw new RuntimeException(f);
            }
        }
        if(e.getSource()==menuButton){
            this.dispose();
            new Main_Menu();
        }
        if(e.getSource()==letterButton){
            timer.stop();
            timeLabel.setForeground(Color.green);
            iconStopWidth = 630;
            iconStopHeight = 750;
            Image goScaled = iconGo.getImage().getScaledInstance(iconStopWidth, iconStopHeight, Image.SCALE_SMOOTH);
            ImageIcon goImage = new ImageIcon(goScaled);
            iconLabel.setIcon(goImage);
            letterButton.setText("Next Round");
            nameField.setEditable(true);
            countryField.setEditable(true);
            fruitField.setEditable(true);
            animalField.setEditable(true);
            colorField.setEditable(true);
            actualRound++;
            elapsedTime=0;
            seconds=0;
            milliseconds=0;
            timer.start();
            if(actualRound==1){
                generateRandomLetter();
            }
            if(actualRound==totalRounds+1){
                iconThumbsWidth = 630;
                iconThumbsHeight = 750;
                Image another = iconThumbs.getImage().getScaledInstance(iconThumbsWidth, iconThumbsHeight, Image.SCALE_SMOOTH);
                ImageIcon thumb = new ImageIcon(another);
                iconLabel.setIcon(thumb);
                timer.stop();
                saveScoreButton.setVisible(true);
                timeLabel.setVisible(false);
                letterLabel.setVisible(false);
                currentLetterLabel.setVisible(false);
                letterButton.setText("Finish Game");
            }
            if(actualRound==totalRounds+2){
                if(e.getSource()==letterButton){
                    this.dispose();
                    new Main_Menu();
                }
            }
            if(actualRound==1 || actualRound==2) {
                int tempScore;
                tempScore=userScore;
                correctAnswer(nameField.getText());
                if(tempScore==userScore && actualRound==1)nameField.setBackground(Color.white);
                else if(tempScore<userScore)nameField.setBackground(Color.green);
                else nameField.setBackground(Color.red);
                userScoreField.setText("Score: " + userScore);
            }
            if(actualRound==6){
                int tempScore;
                tempScore=userScore;
                correctAnswer(nameField5.getText());
                if(tempScore==userScore && actualRound==1)nameField5.setBackground(Color.white);
                else if(tempScore<userScore)nameField5.setBackground(Color.green);
                else nameField5.setBackground(Color.red);
                userScoreField.setText("Score: " + userScore);
                nameField5.setEditable(false);
            }
            if(actualRound==5){
                int tempScore;
                tempScore=userScore;
                nameField4.setEditable(false);
                correctAnswer(nameField4.getText());
                if(tempScore==userScore && actualRound==1)nameField4.setBackground(Color.white);
                else if(tempScore<userScore)nameField4.setBackground(Color.green);
                else nameField4.setBackground(Color.red);
                userScoreField.setText("Score: " + userScore);
                nameField5.setEditable(true);
            }
            if(actualRound==4) {
                int tempScore;
                tempScore=userScore;
                nameField3.setEditable(false);
                correctAnswer(nameField3.getText());
                if(tempScore==userScore && actualRound==1)nameField3.setBackground(Color.white);
                else if(tempScore<userScore)nameField3.setBackground(Color.green);
                else nameField3.setBackground(Color.red);
                userScoreField.setText("Score: " + userScore);
                nameField4.setEditable(true);
            }
            if(actualRound==3) {
                int tempScore;
                tempScore=userScore;
                nameField2.setEditable(false);
                correctAnswer(nameField2.getText());
                if(tempScore==userScore && actualRound==1)nameField2.setBackground(Color.white);
                else if(tempScore<userScore)nameField2.setBackground(Color.green);
                else nameField2.setBackground(Color.red);
                userScoreField.setText("Score: " + userScore);
                nameField3.setEditable(true);
            }
            if(actualRound==2){
                nameField.setEditable(false);
                nameField2.setEditable(true);
            }
            if(actualRound==1 || actualRound==2) {
                int tempScore;
                tempScore=userScore;
                correctAnswer(countryField.getText());
                if(tempScore==userScore && actualRound==1)countryField.setBackground(Color.white);
                else if(tempScore<userScore)countryField.setBackground(Color.green);
                else countryField.setBackground(Color.red);
                userScoreField.setText("Score: " + userScore);
            }
            if(actualRound==6){
                int tempScore;
                tempScore=userScore;
                correctAnswer(countryField5.getText());
                if(tempScore==userScore && actualRound==1)countryField5.setBackground(Color.white);
                else if(tempScore<userScore)countryField5.setBackground(Color.green);
                else countryField5.setBackground(Color.red);
                userScoreField.setText("Score: " + userScore);
                countryField5.setEditable(false);
            }
            if(actualRound==5){
                int tempScore;
                tempScore=userScore;
                countryField4.setEditable(false);
                correctAnswer(countryField4.getText());
                if(tempScore==userScore && actualRound==1)countryField4.setBackground(Color.white);
                else if(tempScore<userScore)countryField4.setBackground(Color.green);
                else countryField4.setBackground(Color.red);
                userScoreField.setText("Score: " + userScore);
                countryField5.setEditable(true);
            }
            if(actualRound==4) {
                int tempScore;
                tempScore=userScore;
                countryField3.setEditable(false);
                correctAnswer(countryField3.getText());
                if(tempScore==userScore && actualRound==1)countryField3.setBackground(Color.white);
                else if(tempScore<userScore)countryField3.setBackground(Color.green);
                else countryField3.setBackground(Color.red);
                userScoreField.setText("Score: " + userScore);
                countryField4.setEditable(true);
            }
            if(actualRound==3) {
                int tempScore;
                tempScore=userScore;
                countryField2.setEditable(false);
                correctAnswer(countryField2.getText());
                if(tempScore==userScore && actualRound==1)countryField2.setBackground(Color.white);
                else if(tempScore<userScore)countryField2.setBackground(Color.green);
                else countryField2.setBackground(Color.red);
                userScoreField.setText("Score: " + userScore);
                countryField3.setEditable(true);
            }
            if(actualRound==2){
                countryField2.setEditable(true);
                countryField.setEditable(false);
            }
            if(actualRound==1 || actualRound==2) {
                int tempScore;
                tempScore=userScore;
                correctAnswer(fruitField.getText());
                if(tempScore==userScore && actualRound==1)fruitField.setBackground(Color.white);
                else if(tempScore<userScore)fruitField.setBackground(Color.green);
                else fruitField.setBackground(Color.red);
                userScoreField.setText("Score: " + userScore);
            }
            if(actualRound==6){
                int tempScore;
                tempScore=userScore;
                correctAnswer(fruitField5.getText());
                if(tempScore==userScore && actualRound==1)fruitField5.setBackground(Color.white);
                else if(tempScore<userScore)fruitField5.setBackground(Color.green);
                else fruitField5.setBackground(Color.red);
                userScoreField.setText("Score: " + userScore);
                fruitField5.setEditable(false);
            }
            if(actualRound==5){
                int tempScore;
                tempScore=userScore;
                fruitField4.setEditable(false);
                correctAnswer(fruitField4.getText());
                if(tempScore==userScore && actualRound==1)fruitField4.setBackground(Color.white);
                else if(tempScore<userScore)fruitField4.setBackground(Color.green);
                else fruitField4.setBackground(Color.red);
                userScoreField.setText("Score: " + userScore);
                fruitField5.setEditable(true);
            }
            if(actualRound==4) {
                int tempScore;
                tempScore=userScore;
                fruitField3.setEditable(false);
                correctAnswer(fruitField3.getText());
                if(tempScore==userScore && actualRound==1)fruitField3.setBackground(Color.white);
                else if(tempScore<userScore)fruitField3.setBackground(Color.green);
                else fruitField3.setBackground(Color.red);
                userScoreField.setText("Score: " + userScore);
                fruitField4.setEditable(true);
            }
            if(actualRound==3) {
                int tempScore;
                tempScore=userScore;
                fruitField2.setEditable(false);
                correctAnswer(fruitField2.getText());
                if(tempScore==userScore && actualRound==1)fruitField2.setBackground(Color.white);
                else if(tempScore<userScore)fruitField2.setBackground(Color.green);
                else fruitField2.setBackground(Color.red);
                userScoreField.setText("Score: " + userScore);
                fruitField3.setEditable(true);
            }
            if(actualRound==2){
                fruitField2.setEditable(true);
                fruitField.setEditable(false);
            }
            if(actualRound==1 || actualRound==2) {
                int tempScore;
                tempScore=userScore;
                correctAnswer(animalField.getText());
                if(tempScore==userScore && actualRound==1)animalField.setBackground(Color.white);
                else if(tempScore<userScore)animalField.setBackground(Color.green);
                else animalField.setBackground(Color.red);
                userScoreField.setText("Score: " + userScore);
            }
            if(actualRound==6){
                int tempScore;
                tempScore=userScore;
                correctAnswer(animalField5.getText());
                if(tempScore==userScore && actualRound==1)animalField5.setBackground(Color.white);
                else if(tempScore<userScore)animalField5.setBackground(Color.green);
                else animalField5.setBackground(Color.red);
                userScoreField.setText("Score: " + userScore);
                animalField5.setEditable(false);
            }
            if(actualRound==5){
                int tempScore;
                tempScore=userScore;
                animalField4.setEditable(false);
                correctAnswer(animalField4.getText());
                if(tempScore==userScore && actualRound==1)animalField4.setBackground(Color.white);
                else if(tempScore<userScore)animalField4.setBackground(Color.green);
                else animalField4.setBackground(Color.red);
                userScoreField.setText("Score: " + userScore);
                animalField5.setEditable(true);
            }
            if(actualRound==4) {
                int tempScore;
                tempScore=userScore;
                animalField3.setEditable(false);
                correctAnswer(animalField3.getText());
                if(tempScore==userScore && actualRound==1)animalField3.setBackground(Color.white);
                else if(tempScore<userScore)animalField3.setBackground(Color.green);
                else animalField3.setBackground(Color.red);
                userScoreField.setText("Score: " + userScore);
                animalField4.setEditable(true);
            }
            if(actualRound==3) {
                int tempScore;
                tempScore=userScore;
                animalField2.setEditable(false);
                correctAnswer(animalField2.getText());
                if(tempScore==userScore && actualRound==1)animalField2.setBackground(Color.white);
                else if(tempScore<userScore)animalField2.setBackground(Color.green);
                else animalField2.setBackground(Color.red);
                userScoreField.setText("Score: " + userScore);
                animalField3.setEditable(true);
            }
            if(actualRound==2){
                animalField2.setEditable(true);
                animalField.setEditable(false);
            }
            if(actualRound==1 || actualRound==2) {
                int tempScore;
                tempScore=userScore;
                correctAnswer(colorField.getText());
                if(tempScore==userScore && actualRound==1)colorField.setBackground(Color.white);
                else if(tempScore<userScore)colorField.setBackground(Color.green);
                else colorField.setBackground(Color.red);
                userScoreField.setText("Score: " + userScore);
            }
            if(actualRound==6){
                int tempScore;
                tempScore=userScore;
                correctAnswer(colorField5.getText());
                if(tempScore==userScore && actualRound==1)colorField5.setBackground(Color.white);
                else if(tempScore<userScore)colorField5.setBackground(Color.green);
                else colorField5.setBackground(Color.red);
                userScoreField.setText("Score: " + userScore);
                colorField5.setEditable(false);
            }
            if(actualRound==5){
                int tempScore;
                tempScore=userScore;
                colorField4.setEditable(false);
                correctAnswer(colorField4.getText());
                if(tempScore==userScore && actualRound==1)colorField4.setBackground(Color.white);
                else if(tempScore<userScore)colorField4.setBackground(Color.green);
                else colorField4.setBackground(Color.red);
                userScoreField.setText("Score: " + userScore);
                colorField5.setEditable(true);
            }
            if(actualRound==4) {
                int tempScore;
                tempScore=userScore;
                colorField3.setEditable(false);
                correctAnswer(colorField3.getText());
                if(tempScore==userScore && actualRound==1)colorField3.setBackground(Color.white);
                else if(tempScore<userScore)colorField3.setBackground(Color.green);
                else colorField3.setBackground(Color.red);
                userScoreField.setText("Score: " + userScore);
                colorField4.setEditable(true);
            }
            if(actualRound==3) {
                int tempScore;
                tempScore=userScore;
                colorField2.setEditable(false);
                correctAnswer(colorField2.getText());
                if(tempScore==userScore && actualRound==1)colorField2.setBackground(Color.white);
                else if(tempScore<userScore)colorField2.setBackground(Color.green);
                else colorField2.setBackground(Color.red);
                userScoreField.setText("Score: " + userScore);
                colorField3.setEditable(true);
            }
            if(actualRound==2){
                colorField2.setEditable(true);
                colorField.setEditable(false);
            }
            generateRandomLetter();
        }
    }

    @SuppressWarnings("ForLoopReplaceableByForEach")
    public void correctAnswer(String category) {
        //noinspection ResultOfMethodCallIgnored
        category.trim();
        //noinspection ForLoopReplaceableByForEach
        for (int i = 0; i < categoryName.length; i++) {
            if (categoryName[i].equalsIgnoreCase(category) && category.substring(0,1).equalsIgnoreCase(String.valueOf(currentLetter))){
                userScore+=10;
                break;
            }
        }
        for (int i = 0; i < categoryCountry.length; i++) {
            if (categoryCountry[i].equalsIgnoreCase(category) && category.substring(0,1).equalsIgnoreCase(String.valueOf(currentLetter))){
                userScore+=10;
                break;
            }
        }
        for (int i = 0; i < categoryFruit.length; i++) {
            if (categoryFruit[i].equalsIgnoreCase(category) && category.substring(0,1).equalsIgnoreCase(String.valueOf(currentLetter))){
                userScore+=10;
                break;
            }
        }
        for (int i = 0; i < categoryAnimal.length; i++) {
            if (categoryAnimal[i].equalsIgnoreCase(category) && category.substring(0,1).equalsIgnoreCase(String.valueOf(currentLetter))){
                userScore+=10;
                break;
            }
        }
        for (int i = 0; i < categoryColor.length; i++) {
            if (categoryColor[i].equalsIgnoreCase(category) && category.substring(0,1).equalsIgnoreCase(String.valueOf(currentLetter))){
                userScore+=10;
                break;
            }
        }
    }
}