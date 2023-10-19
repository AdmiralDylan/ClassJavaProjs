import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class App{ //CommingInHot CSV Reader 
    //holding array of processes
    public static String[] processes = new String[]{"Wet Hulling","Washed / Wet","Semi Washed","Pulped natural / honey","Natural / Dry","Honey;Mossto","Double Carbonic Maceration / Natural","Double Anaerobic Washed","Anaerobic 1000h"};

    public static void main(String[] args) throws Exception {

        final int WAIT_TIME = 100;
        //Welcome To Coming in Hot
        while(true){//fake thread
            cls();
            System.out.println("Welcome to coming in hot...");
            System.out.println("We think you deserve the best cup of coffee possible. Lets help find that for you!\n\n\n");
            System.out.println("To use this program please refer to our user guide.\n Type 'man' at anytime to see a full list of commands available to you");
            for(int x = 0; x < 8; x++){
                System.out.print("Loading"+"   \r");
                Thread.sleep(WAIT_TIME);
                System.out.print("Loading"+".\r");
                Thread.sleep(WAIT_TIME);
                System.out.print("Loading"+"..\r");
                Thread.sleep(WAIT_TIME);
                System.out.print("Loading"+"...\r");
                Thread.sleep(WAIT_TIME);
            }
            cls();
            System.out.print("> ");
            break;
        }
        Scanner input = new Scanner(System.in);//initialize input object

        //initialize Arraylist
        ArrayList<Producer> producerDatabase = new ArrayList<Producer>();
        loadArray(producerDatabase);//Load the CSV into the Producer ArrayList database.
        
        String in = input.nextLine();

        while(!(in.equals("exit"))){
            menuOption(in.toLowerCase(),producerDatabase);
            System.out.print("> ");
            in = input.nextLine();
        }
        System.out.println("Thank you!");
        input.close();
    }
    

    public static void cls(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }

    public static ArrayList<Producer> loadArray(ArrayList<Producer> arrList){
        //Loading CSV File into arraylist



        String line; //Var for each CSV line
        
        //Int to give an ID to each Producer
        int ID = 0;//IDs are associated with each line read from CSV

        //loading CSV into bufferedreader object
        try (BufferedReader br = new BufferedReader(new FileReader("ClassJavaProjs-\\ClassJavaProjs\\src\\coffee.csv"))) {
            while((line = br.readLine()) != null){//Reading each line of csv
                
                String[] fields = line.split(","); //splitting csv by comma delimetor, then creating the producer object with fields
                Producer tempProducer = new Producer(ID,
                fields[0],
                fields[1],
                fields[2],
                fields[3],
                Float.parseFloat(fields[4]),
                Float.parseFloat(fields[5]),
                Float.parseFloat(fields[6]),
                Float.parseFloat(fields[7]),
                Float.parseFloat(fields[8]),
                Float.parseFloat(fields[9]),
                Float.parseFloat(fields[10]));
                arrList.add(tempProducer);//adding producer to arr
                ID++;//incrementing ID so every producer has a unique id
                }
                br.close();
            } catch (IOException e) {
            e.printStackTrace();
        }
        
        return arrList;
    }
    
    public static void menuOption(String input,ArrayList<Producer> arrList){
        int j =0;
        cls();
        System.out.println("\n\n\n");
        if(input.equals("all")){
            System.out.println("Presenting all coffee producers\n---------------------------------------------------------");
            printDB(arrList);
        }else if(input.equals("man")){
            System.out.println("Displaying all commands\n--------------------------");
            System.out.println("all : Displays all farms with overall score, country of origin, and ID\n" +
            "from [Country] : Displays all farms from that country with ID, region, and overall score\n" +
            "[ID #] : Displays farm with that ID, name of farm, country of origin, and overall score\n" + 
            "[ID #] -more : displays farm with that user ID, Farm name, region, cherry-processing,\n");
        }else if(input.equals("exit")){
        }else if(input.equals("list processes")){
            for(String a:processes){
                System.out.println(a);
            }
        }else if(input.equals("best coffee")){
            Collections.sort(arrList,new sortByBestCoffee());
            System.out.println("Presenting the 10 best coffees ordered by overall score...\n--------------------------------------------------------------" );
            for(int i = arrList.size()-1; i>arrList.size()-11;i--){
                System.out.println(j + ": {Farm Name : " + arrList.get(i).getFarmName() + "}{ ID : " + arrList.get(i).getID() + "}{ Overall Score : " + arrList.get(i).getOverallScore() + "}{ Country of Origin : " + arrList.get(i).getCountryOrigin()+"}");
                j++;
            }
        }else if(input.equals("best aroma")){
            System.out.println("Presenting the 10 best coffees ordered by aroma score...\n--------------------------------------------------------------" );
            Collections.sort(arrList,new sortByBestAroma());
            for(int i = arrList.size()-1; i>arrList.size()-11;i--){
                System.out.println(j + ": {Farm Name : " + arrList.get(i).getFarmName() + "}{ ID : " + arrList.get(i).getID() + "}{Aroma Score : " + arrList.get(i).getAroma()+ "}{ Overall Score : " + arrList.get(i).getOverallScore() + "}{ Country of Origin : " + arrList.get(i).getCountryOrigin()+"}");
                j++;
            }
        }else if(input.equals("best acidity")){
            System.out.println("Presenting the 10 best coffees ordered by acidity score...\n--------------------------------------------------------------" );
            Collections.sort(arrList,new sortByBestAcidity());
            for(int i = arrList.size()-1; i>arrList.size()-11;i--){
                System.out.println(j + ": {Farm Name : " + arrList.get(i).getFarmName() + "}{ ID : " + arrList.get(i).getID() + "}{Acidity Score : " + arrList.get(i).getAcidity()+ "}{ Overall Score : " + arrList.get(i).getOverallScore() + "}{ Country of Origin : " + arrList.get(i).getCountryOrigin()+"}");
                j++;
            }

        }else if(input.equals("best flavor")){
            System.out.println("Presenting the 10 best coffees ordered by flavor score...\n--------------------------------------------------------------" );
            Collections.sort(arrList,new sortByBestFlavor());
            for(int i = arrList.size()-1; i>arrList.size()-11;i--){
                System.out.println(j + ": {Farm Name : " + arrList.get(i).getFarmName() + "}{ ID : " + arrList.get(i).getID() + "}{Acidity Score : " + arrList.get(i).getFlavor()+ "}{ Overall Score : " + arrList.get(i).getOverallScore() + "}{ Country of Origin : " + arrList.get(i).getCountryOrigin()+"}");
                j++;
            }
        }else if(input.equals("best aftertaste")){
            System.out.println("Presenting the 10 best coffees ordered by aftertaste score...\n--------------------------------------------------------------" );
            Collections.sort(arrList,new sortByBestAftertaste());
            for(int i = arrList.size()-1; i>arrList.size()-11;i--){
                System.out.println(j + ": {Farm Name : " + arrList.get(i).getFarmName() + "}{ ID : " + arrList.get(i).getID() + "}{Acidity Score : " + arrList.get(i).getAftertaste()+ "}{ Overall Score : " + arrList.get(i).getOverallScore() + "}{ Country of Origin : " + arrList.get(i).getCountryOrigin()+"}");
                j++;
            }
        }else if(input.equals("best body")){
            System.out.println("Presenting the 10 best coffees ordered by body score...\n--------------------------------------------------------------" );
            Collections.sort(arrList,new sortByBestBody());
            for(int i = arrList.size()-1; i>arrList.size()-11;i--){
                System.out.println(j + ": {Farm Name : " + arrList.get(i).getFarmName() + "}{ ID : " + arrList.get(i).getID() + "}{Acidity Score : " + arrList.get(i).getBody()+ "}{ Overall Score : " + arrList.get(i).getOverallScore() + "}{ Country of Origin : " + arrList.get(i).getCountryOrigin()+"}");
                j++;
            }
        }else if(input.equals("best balance")){
            System.out.println("Presenting the 10 best coffees ordered by balance score...\n--------------------------------------------------------------" );
            Collections.sort(arrList,new sortByBestBalance());
            for(int i = arrList.size()-1; i>arrList.size()-11;i--){
                System.out.println(j + ": {Farm Name : " + arrList.get(i).getFarmName() + "}{ ID : " + arrList.get(i).getID() + "}{Balance Score : " + arrList.get(i).getBalance()+ "}{ Overall Score : " + arrList.get(i).getOverallScore() + "}{ Country of Origin : " + arrList.get(i).getCountryOrigin()+"}");
                j++;
            }
        }else if(input.contains("from")){ 
            String[] parseInput = input.split("from", 5); //Splitting the 'from' from the input
            String target = parseInput[1].trim();//passing the rest of the text from split string (Expected output to be a country)
            
            ArrayList<Producer> tempProducerList = searchByString(target, arrList);

            if(tempProducerList.get(0).getFarmName() == null && tempProducerList.size() > 1){
                System.out.println("We didn't find exactly what you were looking for. But, we did not come back empty handed.");
                System.out.println("Presenting " + tempProducerList.size() + " results based on your input...\n--------------------------------------------------------------" );
            } else if(tempProducerList.size() == 1){
                System.out.println("We couldn't find what you were looking for \nTry this! \n\n>EX. from Colombia");
            } else {
                System.out.println("Presenting " + tempProducerList.size() + " results based on your input...\n--------------------------------------------------------------" );
            }
            for(Producer a:tempProducerList){
                if(a.getCountryOrigin() != null){
                    System.out.println("{" + a.getCountryOrigin() + "} " + "{Region : " + a.getRegion() + "}" + "{Farm Name : " + a.getFarmName() + "}{ ID : " + a.getID() + "}{ Overall Score : " + a.getOverallScore() + "}");
                }
            }


        }else if(input.contains("-more")){
            String[] parseInput = input.split("-more", 5); //Splitting the 'from' from the input
            int targetID = Integer.parseInt(parseInput[0].trim());
            Producer tempProducer = findByID(targetID, arrList);
            if(tempProducer != null){
                System.out.println(tempProducer.toString());
            }else{
                System.out.println("Specialty coffee producer with that ID does not exist or you might have typed it wrong. \nTry this EX: > 101 -more");
            }
        }else{
            try{
                Producer tempProducer = findByID(Integer.parseInt(input.trim()), arrList);
                if(tempProducer != null){
                    System.out.println("{ID : " + tempProducer.getID() + "}" + "{Farm name : " + tempProducer.getFarmName() + "}" + "{Country of Origin : " + tempProducer.getCountryOrigin() + "}" + "{Overall Score : " + tempProducer.getOverallScore() + "}");
                }else{
                    System.out.println("Specialty coffee producer with that ID does not exist or you might have typed it wrong. \nTry this EX: > 101");
                }
            } catch(Exception e){
                System.out.println("I didn't understand that command. Please refer to our list of commands by typing 'man'");
            }

            

        }

    }

    public static ArrayList<Producer> searchByString(String key,ArrayList<Producer> arrList){
        ArrayList<Producer> filteredArr = new ArrayList<Producer>();
        boolean found = false;

        for(Producer a:arrList){//first trys to find exact case from input
            if(a.getCountryOrigin().toLowerCase().equals(key)){
                filteredArr.add(a);
                found = true;
            }
        }
        if(!found){//predicting that user is a silly and didn't type correctly or made a mistake
            Producer oops = new Producer();
            filteredArr.add(oops);//adding a flag producer to handle during the menu call
            for(Producer a:arrList){
                if(a.getCountryOrigin().toLowerCase().contains(key)){//trys to find anything similar to input
                    filteredArr.add(a);
                }
            }
        }

        return filteredArr;
    }

    public static Producer findByID(int key, ArrayList<Producer> arrList){
        for(Producer a:arrList){
            if(key == a.getID()){
                System.out.println("Flag");
                return a;
            }
        }
        return null;
    }

    public static void printDB(ArrayList<Producer> arraylist){
        for(int i = 0;i<arraylist.size();i++){
            System.out.println(arraylist.get(i));
        }
    }
}
