import java.util.Scanner;
    class Main {
        public static Scanner keyboard = new Scanner(System.in);
        public static void main(String[] args) {
    /*Menu option   Display                 Expected Outcome
        1         keep Counting                 Yes
        2         number conversion Tool        Yes
        3         UPC calculator                Yes
        4         UPC Checker                   Yes
        9         finishes program              Yes*/
            //looping game choice
            boolean interested = true;
            while(interested)
            {
                System.out.println("P4CS Mini Applications\n----------------------\n1) Keep Counting Game\n2) Number Conversion Tool\n3) Universal Product Code (UPC) Calculator\n4) Universal Product Code (UPC) Checker\n9) Quit\nPlease Enter Option:");
                //choosing a game to play
                int gameChoice = keyboard.nextInt();
                switch(gameChoice)
                {
                    case 1:
                        keepCounting();
                        break;
                    case 2:
                        numberConversionTool();
                        break;
                    case 3:
                        universalProductCodeGenerator();
                        break;
                    case 4:
                        universalProductCodeChecker();
                        break;
                    case 9:
                        System.out.println("Bye...");
                        interested = false;
                        break;
                    default:
                        System.out.println("That was not a valid option please try again.");
                }
            }
        }

        private static void keepCounting()
        {
    /*Question     correct answer                    incorrect answer                           Expected Outcome
        9-9        (0)next question                        N/A                                        Yes
        0+7        (7)next question                        N/A                                        Yes
        7+3        (10)next question                       N/A                                        Yes
        10+5       (15)next question                       N/A                                        Yes
        15+7       (22)next question                       N/A                                        Yes
        22-10      (12)next question                       N/A                                        Yes
        12-9       (3)next question                        N/A                                        Yes
        3+5        (8)Questions complete in 22 seconds     N/A                                        Yes
        6-2               N/A               (40)That was incorrect the answer was 4                   Yes
        5+6               N/A               (90)That was incorrect the answer was 11                  Yes
        3+2               N/A               (40)That was incorrect the answer was 5                   Yes*/
            //first random number
            int randomOneInt;
            String randomOneString;

            //second random number
            int randomTwoInt;
            String randomTwoString;

            //answer for user to guess
            int answer;

            //input from user
            int userAnswer;

            //game rules
            System.out.println("Keep Counting\n-------------\nYou will be presented with 8 addition questions.\nAfter the first question, the left-hand operand is the result of the previous addition\nPress enter to start...");

            //timer
            double beginning;
            double end;
            int time;
            beginning = System.currentTimeMillis();

            //question 1
            System.out.println("Question 1:");
            randomOneInt = randomNumberGenerator();
            randomTwoInt = randomNumberGenerator();
            randomOneString = String.valueOf(randomOneInt);
            randomTwoString = String.valueOf(randomTwoInt);

            //random plus or minus
            int randomForOperator = (int) ((Math.random()*2)+1);
            if (randomForOperator == 1)
            {
                answer = randomOneInt - randomTwoInt;
                System.out.println(randomOneString + " - " + randomTwoString + " =");
            }
            else
            {
                answer = randomOneInt + randomTwoInt;
                System.out.println(randomOneString + " + " + randomTwoString + " =");
            }

            userAnswer = keyboard.nextInt();

            if (userAnswer != answer)
            {
                System.out.println("That was incorrect the answer was " + answer);
                return;
            }

            //looping 7 times
            for (int i = 2; i<= 8; i++)
            {
                System.out.println("Question " + i + ":");

                //assigning random numbers
                randomOneInt = answer;
                randomTwoInt = randomNumberGenerator();
                randomOneString = String.valueOf(answer);
                randomTwoString = String.valueOf(randomTwoInt);

                //to randomise plus and minus
                int randomForOperator2 = (int) ((Math.random()*2)+1);
                if (randomForOperator2 == 1)
                {
                    answer = randomOneInt - randomTwoInt;
                    System.out.println(randomOneString + " - " + randomTwoString + " =");
                }
                else
                {
                    answer = randomOneInt + randomTwoInt;
                    System.out.println(randomOneString + " + " + randomTwoString + " =");
                }

                //input from user
                userAnswer = keyboard.nextInt();

                //incorrect answer
                if (userAnswer != answer)
                {
                    System.out.println("That was incorrect the answer was " + answer);
                    return;
                }
            }

            //display time
            end = System.currentTimeMillis();
            time = (int) (end - beginning)/1000;
            System.out.println("Questions complete in " + time + " seconds");

        }

        private static void numberConversionTool()
        {
    /*Base 10      Base 2                Base 16
        113       1110001                  71
        123456   11110001001000000        1E240
        0            0                      0
        -5        That was not a positive base-10 number returns to Menu*/
            //base 10 number
            int baseTenNumber;
            //base 10 number
            int baseTenNumber2;
            //the remainder of division by 2
            int binaryRemainder;
            //the remainder of division by 16
            int hexRemainder;
            //binary number
            String baseTwoNumber = "";
            //hex number
            String baseSixteenNumber = "";
            //character array to display correct letter past 9
            char hexCharacters[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E','F'};
            //to display binary and hex numbers
            int display = 0;
            //rules of the game
            System.out.println("Number Conversion Tool\nPlease enter a positive base-10 number:");
            //getting base 10 number from user
            baseTenNumber = keyboard.nextInt();
            baseTenNumber2 = baseTenNumber;
            //making sure base 10 number 0 displays a binary value of 0
            if (baseTenNumber == 0)
            {
                baseTwoNumber = "0";
                baseSixteenNumber = "0";
            }

            else if (baseTenNumber >  0)
            {
                //binary calculation
                while(baseTenNumber > 0)
                {
                    //gets the remainder of the base 10 number divided by 2
                    binaryRemainder = baseTenNumber % 2;
                    //adding numbers to the string
                    baseTwoNumber = binaryRemainder + baseTwoNumber;
                    //dividing the base 10 number by 2 so the next loop finds the next remainder
                    baseTenNumber = baseTenNumber / 2;
                }
                //hex calculation
                while(baseTenNumber2 > 0)
                {
                    //gets the remainder of the base 10 number divided by 16
                    hexRemainder = baseTenNumber2 % 16;
                    //adds the remainder to the string as an array and changes to the corresponding letter if the number is above 9
                    baseSixteenNumber = hexCharacters[hexRemainder] + baseSixteenNumber;
                    //dividing the base 10 number by 2 so the next loop find the next remainder
                    baseTenNumber2 = baseTenNumber2 / 16;
                }
            }
            //non valid base 10 number
            else
            {
                System.out.println("That was not a positive base-10 number");
                display  = 1;
            }

            //displaying binary and hex numbers
            if (display == 0)
            {
                System.out.println("Binary: " + baseTwoNumber);
                System.out.println("Hex: " + baseSixteenNumber);
            }
        }


        private static void universalProductCodeGenerator()
        {
    /*6-digit code      UPC            Expected Outcome
      123456           1234561             Yes
      5                55                  Yes
      67               675                 Yes
      349              3496                Yes
      2785             27858               Yes
      78563            785633              Yes
      0          Invalid please try again  Yes
      9879878    Invalid please try again  Yes
      -765       Invalid please try again  Yes
      999999           9999992             Yes
      1000000    Invalid please try again  Yes
      1                19                  Yes*/
            //boolean value for loop
            boolean interest = true;
            //six-digit product code
            int productCode;
            //position of numbers
            int position1;
            int position2;
            int position3;
            int position4;
            int position5;
            int position6;
            //UPC calculation
            int UPCMATHS;
            //UPC separate
            int UPC;
            //conversion
            String productCodeString;
            String UPCString;
            String codeAndUPCString;
            //actual UPC value
            int finalUPC;
            //game rules
            System.out.println("Universal Product Code (UPC) calculator\n---------------------------------------\nThis calculator will take a six-digit product code and generate a trailing 7th check digit to produce the final 7-digit UPC.\nPlease enter a six-digit code to generate the final UPC code:");
            //loop
            while(interest)
            {
                //six-digit code
                productCode = keyboard.nextInt();
                //error if 7 digits
                if (productCode > 999999 || productCode < 1)
                {
                    System.out.println("Invalid please try again:");
                    interest = true;
                }
                else
                {
                    //separating characters
                    position6 = (productCode / 1) % 10;
                    position5 = (productCode / 10) % 10;
                    position4 = (productCode / 100) % 10;
                    position3 = (productCode / 1000) % 10;
                    position2 = (productCode / 10000) % 10;
                    position1 = (productCode / 100000) % 10;

                    //calculation UPC
                    UPCMATHS = (((position1 + position3 + position5) * 3) + position2 + position4 + position6) % 10;

                    if (UPCMATHS == 0)
                        UPC = 0;
                    else
                        UPC = 10 - UPCMATHS;

                    //converting
                    productCodeString = String.valueOf(productCode);
                    UPCString = String.valueOf(UPC);
                    codeAndUPCString = productCodeString + UPCString;
                    finalUPC = Integer.parseInt(codeAndUPCString);
                    System.out.println("The 7-digit final UPC is: " + finalUPC);
                    interest = false;
                }
            }
        }


        private static void universalProductCodeChecker()
        {
    /*7-digit code    6-digit code        Expected Outcome
      1234561    The UPC is valid           Yes
      0          The UPC is not valid       Yes
      -6         The UPC is not valid       Yes
      56756756   The UPC is not valid       Yes
      1230       The UPC is valid           Yes
      1          The UPC is valid           Yes
      55         The UPC is valid           Yes
      675        The UPC is valid           Yes
      785633     The UPC is valid           Yes*/
            //UPC code
            int sevenDigitCode;
            //position of numbers
            int position1;
            int position2;
            int position3;
            int position4;
            int position5;
            int position6;
            int position7;
            //UPC calculation
            int UPCMATHS;
            int UPC;

            System.out.println("Universal Product Code (UPC) Checker\n------------------------------------\nPlease enter 7-digit UPC to check:");
            sevenDigitCode = keyboard.nextInt();

            if (sevenDigitCode < 10000000 && sevenDigitCode > 0)
            {
                //separating characters
                position7 = (sevenDigitCode / 1) % 10;
                position6 = (sevenDigitCode / 10) % 10;
                position5 = (sevenDigitCode / 100) % 10;
                position4 = (sevenDigitCode / 1000) % 10;
                position3 = (sevenDigitCode / 10000) % 10;
                position2 = (sevenDigitCode / 100000) % 10;
                position1 = (sevenDigitCode / 1000000) % 10;

                //checking UPC
                UPCMATHS = (((position1 + position3 + position5) * 3) + position2 + position4 + position6) % 10;

                if (UPCMATHS == 0)
                    UPC = 0;
                else
                    UPC = 10 - UPCMATHS;

                if (UPC == position7)
                    System.out.println("The UPC is valid");
                else
                    System.out.println("The UPC is not valid");
            }

            else
                System.out.println("The UPC is not valid");

        }

        public static int randomNumberGenerator()
        {
            //generates a random number
            int randomNumber = (int) ((Math.random()*10)+1);
            return randomNumber;
        }
    }


