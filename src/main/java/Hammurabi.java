import java.io.IOException;
import java.util.Scanner;
import java.util.Random;
public class Hammurabi {

    public static void main(String[] args) throws IOException {
        new Hammurabi().playGame();

    }















    // VARIABLES TO USE

    static boolean playing = true;
    static int year = 0;        // Current Year
    static boolean plague = false;          // If there is a plague or not
    Scanner input = new Scanner(System.in); // Scanner to take in user input

    public Random rand = new Random();
    // People
    static int totalDeaths = 0; // Total number of deaths from starvation
    static int population = 95; // Current population
    static int percentDied = 0; // Percent of people who died?????
    static int immigrants = 5;  // Number of new people to add to the population
    static int deaths;          // ?????????????????????

    // Bushels
    static int stores = 2800;   // total number of Bushels
    static int harvest = 3000;  // number of bushels harvested

    // Land
    static int acres = 1000;    // total number of acres
    static int yield;           // yield = ???????
    static int landPrice;       // landPrice = land price in bushels

    // Other fields
    int temp;                   // Temporary value to hold input from user


    static int eaten = harvest - stores;
    static int fullPeople;



    final static String FINK = "DUE TO THIS EXTREME MISMANAGEMENT YOU HAVE NOT ONLY\n" +
            "BEEN IMPEACHED AND THROWN OUT OF OFFICE BUT YOU HAVE\n" +
            "ALSO BEEN DECLARED PERSONA NON GRATA!!\n";


    public void playGame(){
        System.out.println("\t\t\t\tHAMURABI\n\t       CREATIVE COMPUTING MORRISTOWN, NEW JERSEY\n\n" +
                "TRY YOUR HAND AT GOVERNING ANCIENT SUMERIA\nSUCCESSFULLY FOR A TEN-YEAR TERM OF OFFICE.");
        while (playing){
            newYear();
        }
    }

    // UPDATE TO NEW YEAR METHODS
    private void newYear(){
        // New Year has begun. year is updated
        year += 1;

        // Update population by adding immigrants and subtracting totalDeaths
        // TODO update immigrants to be immigrants()
        // TODO update totalDeaths to be combo of plagueDeaths() and starvationDeaths()
        population += immigrants(population,acres,stores) - totalDeaths;

        // Update land price
        landPrice = newCostOfLand();
    }

    // Function to calculate number of immigrants
    // TODO OLAMIDE
    public int immigrants(int population, int acresOwned, int grainInStorage){
        int numOfImmigrants;
       numOfImmigrants = (20 * acresOwned + grainInStorage) / (100 * population) +1;

        return numOfImmigrants;
    }

    // Function to determine new cost of land
    // TODO OLAMIDE
    public int newCostOfLand() {

        int price = (int) (rand.nextInt(7) + 17);

        return price;
    }


    // METHODS TO TAKE IN USER INPUT
    public int askHowManyAcresToBuy(int price, int bushels){
        do {
            System.out.print("HOW MANY ACRES DO YOU WISH TO BUY?  ");
            temp = input.nextInt();
            if (temp < 0) {
                epicFail(0);
            }
            if (temp * price > bushels){
                System.out.println("HAMMURABI:  THINK AGAIN. YOU HAVE ONLY\n" +
                        bushels + " BUSHELS OF GRAIN. NOW THEN,");
            }
        } while (temp * price > bushels);

        return temp;
    }

    public int askHowManyAcresToSell(int acresOwned){
        do {
            System.out.print("HOW MANY ACRES DO YOU WISH TO SELL?  ");
            temp = input.nextInt();
            if (temp < 0)
                epicFail(0);
            if (temp > acresOwned)
                System.out.println("HAMMURABI:  THINK AGAIN. YOU OWN ONLY " + acresOwned + " ACRES. NOW THEN,");
        } while (temp > acresOwned);

        return temp;
    }
    public int askHowMuchGrainToFeedPeople(int bushels){
        do {
            System.out.print("\nHOW MANY BUSHELS DO YOU WISH TO FEED YOUR PEOPLE?  ");
            temp = input.nextInt();
            if (temp < 0)
                epicFail(0);
            if (temp > bushels)
                System.out.println("HAMMURABI:  THINK AGAIN. YOU HAVE ONLY\n" +
                        bushels + " BUSHELS OF GRAIN. NOW THEN,");
        } while (temp > bushels);
        return temp;
    }
    public int askHowManyAcresToPlant(int acresOwned, int population, int bushels){
        do {
            System.out.print("\nHOW MANY ACRES DO YOU WISH TO PLANT WITH SEED?  ");
            temp = input.nextInt();
            if (temp < 0)
                epicFail(0);
            if (temp > acresOwned)
                System.out.println("HAMURABI:  THINK AGAIN. YOU OWN ONLY " + acresOwned + " ACRES. NOW THEN,");
            if (temp / 2 > bushels)
                System.out.println("HAMURABI:  THINK AGAIN. YOU HAVE ONLY\n" +
                        bushels + " BUSHELS OF GRAIN. NOW THEN,");
            if (temp > population * 10)
                System.out.println("BUT YOU HAVE ONLY" + population + "PEOPLE TO TEND THE FIELDS. NOW THEN,");
        } while (temp > acresOwned || temp / 2 > bushels || temp > population * 10);

        return temp;
    }


    // Display Methods
    private static String report() {
        String answer = "\nHAMURABI:  I BEG TO REPORT TO YOU,\n" +
                "IN YEAR " + year + ", " + deaths + " PEOPLE STARVED, " + immigrants + " CAME TO THE CITY.\n";
        if (plague) {
            population = population / 2;
            answer += "A HORRIBLE PLAGUE STRUCK!  HALF THE PEOPLE DIED.\n";
        }
        answer += "POPULATION IS NOW " + population + ".\n" +
                "THE CITY NOW OWNS " + acres + " ACRES.\n" +
                "YOU HARVESTED " + yield + " BUSHELS PER ACRE.\n" +
                "RATS ATE " + eaten + " BUSHELS.\n" +
                "YOU NOW HAVE " + stores + " BUSHELS IN STORE\n\n" +
                "LAND IS TRADING AT " + landPrice + " BUSHELS PER ACRE.";
        return answer;
    }





    // OLD CODE TO REFERENCE BUT *NOT* USE
    private void newYear1() {

        year += 1; //
        population += immigrants; //
        landPrice = (int) (10 * Math.random() + 17); //
        System.out.println(report());
        // USER UPDATING ACRES
        /*
        do {
            System.out.print("HOW MANY ACRES DO YOU WISH TO BUY?  ");
            temp = input.nextInt();
            if (temp < 0)
                epicFail(0);
            if (temp * landPrice > stores)
                System.out.println("HAMURABI:  THINK AGAIN. YOU HAVE ONLY\n" +
                        stores + " BUSHELS OF GRAIN. NOW THEN,");
        } while (temp * landPrice > stores);
         */
        acres += temp;
        stores -= temp * landPrice;
        /*
        do {
            System.out.print("HOW MANY ACRES DO YOU WISH TO SELL?  ");
            temp = input.nextInt();
            if (temp < 0)
                epicFail(0);
            if (temp > acres)
                System.out.println("HAMURABI:  THINK AGAIN. YOU OWN ONLY " + acres + " ACRES. NOW THEN,");
        } while (temp > acres);

         */
        stores += temp * landPrice;
        acres -= temp;

        // USER FEEDING PEOPLE
        /*
        do {
            System.out.print("\nHOW MANY BUSHELS DO YOU WISH TO FEED YOUR PEOPLE?  ");
            temp = input.nextInt();
            if (temp < 0)
                epicFail(0);
            if (temp > stores)
                System.out.println("HAMURABI:  THINK AGAIN. YOU HAVE ONLY\n" +
                        stores + " BUSHELS OF GRAIN. NOW THEN,");
        } while (temp > stores);

         */
        fullPeople = temp / 20;
        stores -= temp;

        // USER PLANTING SEED
        /*
        do {
            System.out.print("\nHOW MANY ACRES DO YOU WISH TO PLANT WITH SEED?  ");
            temp = input.nextInt();
            if (temp < 0)
                epicFail(0);
            if (temp > acres)
                System.out.println("HAMURABI:  THINK AGAIN. YOU OWN ONLY " + acres + " ACRES. NOW THEN,");
            if (temp / 2 > stores)
                System.out.println("HAMURABI:  THINK AGAIN. YOU HAVE ONLY\n" +
                        stores + " BUSHELS OF GRAIN. NOW THEN,");
            if (temp > population * 10)
                System.out.println("BUT YOU HAVE ONLY" + population + "PEOPLE TO TEND THE FIELDS. NOW THEN,");
        } while (temp > acres || temp / 2 > stores || temp > population * 10);

         */
        stores -= temp / 2;
        yield = (int) (Math.random() * 5 + 1);
        harvest = temp * yield;
        temp = (int) (Math.random() * 5 + 1);
        if (temp % 2 != 1)
            eaten = (stores / temp);
        else
            eaten = 0;
        stores += (harvest - eaten);

        /*
        // CALCULATING IMMIGRANTS
        immigrants = (int) (Math.random() * 5 + 1) *
                (20 * acres + stores) / population / 100 + 1;
        if (population > fullPeople) {
            deaths = population - fullPeople;
            if (deaths > .45 * population)
                epicFail(1);
            percentDied = ((year - 1) * percentDied + deaths * 100 / population) / year;
            population = fullPeople;
            totalDeaths += deaths;
        }


        // DETERMINING PLAGUE
        if (20 * Math.random() >= 17)
            plague = true;
        plague = false;
   */

    private static String report() {
        String answer = "\nHAMURABI:  I BEG TO REPORT TO YOU,\n" +
                "IN YEAR " + year + ", " + deaths + " PEOPLE STARVED, " + immigrants + " CAME TO THE CITY.\n";
        if (plague) {
            population = population / 2;
            answer += "A HORRIBLE PLAGUE STRUCK!  HALF THE PEOPLE DIED.\n";
        }
        answer += "POPULATION IS NOW " + population + ".\n" +
                "THE CITY NOW OWNS " + acres + " ACRES.\n" +
                "YOU HARVESTED " + yield + " BUSHELS PER ACRE.\n" +
                "RATS ATE " + eaten + " BUSHELS.\n" +
                "YOU NOW HAVE " + stores + " BUSHELS IN STORE\n\n" +
                "LAND IS TRADING AT " + landPrice + " BUSHELS PER ACRE.";
        return answer;
      
      

    }




    private static void epicFail(int x) {
        String reason = "";
        switch (x) {
            case 0: reason = "HAMURABI:  I CANNOT DO WHAT YOU WISH.\n" +
                    "GET YOURSELF ANOTHER STEWARD!!!!!"; break;
            case 1: reason = "YOU STARVED " + deaths + " PEOPLE IN ONE YEAR!!!\n" +
                    FINK; break;
        }
        System.out.println(reason);
        System.exit(0);
    }

    private void finished() {
        String answer = "IN YOUR 10-YEAR TERM OF OFFICE, " + percentDied + " PERCENT OF THE\n" +
                "POPULATION STARVED PER YEAR ON AVERAGE, I.E., A TOTAL OF\n" +
                totalDeaths + " PEOPLE DIED!!\n" +
                "YOU STARTED WITH 10 ACRES PER PERSON AND ENDED WITH\n" +
                acres / population + " ACRES PER PERSON\n\n";
        if (percentDied > 33 || acres / population < 7)
            answer += FINK;
        else if (percentDied > 10 || acres / population < 9)
            answer += "YOUR HEAVY-HANDED PERFORMANCE SMACKS OF NERO AND IVAN IV.\n" +
                    "THE PEOPLE (REMAINING) FIND YOU AN UNPLEASANT RULER, AND,\n" +
                    "FRANKLY, HATE YOUR GUTS!";
        else if (percentDied > 3 || acres / population < 10)
            answer += "YOUR PERFORMANCE COULD HAVE BEEN SOMEWHAT BETTER, BUT\n" +
                    "REALLY WASN'T TOO BAD AT ALL.\n" +
                    Math.random() * population * .8 + " PEOPLE WOULD" +
                    "DEARLY LIKE TO SEE YOU ASSASSINATED BUT WE ALL HAVE OUR" +
                    "TRIVIAL PROBLEMS";
        else
            answer += "A FANTASTIC PERFORMANCE!!!  CHARLEMANGE, DISRAELI, AND\n" +
                    "JEFFERSON COMBINED COULD NOT HAVE DONE BETTER!";
        answer += "\n\n\n\n\n\n\n\n\n\nSo long for now.";
        System.out.println(answer);
    }

    public int plagueDeaths(int population){
        int chance = rand.nextInt(100);
        if (chance < 15 ) {
            return population / 2;
        } else {

            return 0;
        }
    }

    public int starvationDeaths(int population, int bushelsFedToPeople){
        int starving = population - (bushelsFedToPeople / 20);

        if (bushelsFedToPeople >= (population * 20)) {
            return 0;
        } else {

            return starving;
        }

    }

    public boolean uprising(int population, int howManyPeopleStarved){
        if (howManyPeopleStarved > (0.45 * population)) {
            return true;
        } else {

            return false;
        }
    }



    public int harvest(int acres){
        int yield = rand.nextInt(6) + 1;
        int harvested = yield * acres;

        return harvested;
    }

    public int grainEatenByRats(int bushels){
        int chance = rand.nextInt(100);

        if (chance < 40) {
            double percentEatenByRats = (rand.nextDouble() /5 + 0.1);
            double bushelsEatenByRats = bushels * (percentEatenByRats);
            return (int) bushelsEatenByRats;
        } else {
            return 0;
        }

    }



    public void printSummary(){
    }

    public void finalSummary(){
    }




}
