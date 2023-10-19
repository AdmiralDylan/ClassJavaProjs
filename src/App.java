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


        //Welcome To Coming in Hot
        while(true){//fake thread
            cls();
            System.out.println("Welcome to coming in hot...");
            System.out.println("We think you deserve the best cup of coffee possible. Lets help find that for you!\n\n\n");
            System.out.println("To use this program please refer to our user guide.\n Type 'man' at anytime to see a full list of commands available to you");
            for(int x = 0; x < 8; x++){
                System.out.print("Loading"+"   \r");
                Thread.sleep(500);
                System.out.print("Loading"+".\r");
                Thread.sleep(500);
                System.out.print("Loading"+"..\r");
                Thread.sleep(500);
                System.out.print("Loading"+"...\r");
                Thread.sleep(500);
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
        
        if(input.equals("all")){
            cls();
            printDB(arrList);
        }else if(input.equals("man")){

        }else if(input.equals("exit")){
           
        }else if(input.equals("list processes")){
            for(String a:processes){
                System.out.println(a);
            }
        }else if(input.equals("best coffee")){
            Collections.sort(arrList,new sortByBestCoffee());
            cls();
            System.out.println("Presenting the 10 best coffees ordered by overall score...\n--------------------------------------------------------------" );
            for(int i = 0; i<10;i++){
                System.out.println(i + ": {Farm Name : " + arrList.get(i).getFarmName() + "}{ ID : " + arrList.get(i).getID() + "}{ Overall Score : " + arrList.get(i).getOverallScore() + "}{ Country of Origin : " + arrList.get(i).getCountryOrigin()+"}");
            }
        }else if(input.equals("best aroma")){
            cls();
            System.out.println("Presenting the 10 best coffees ordered by aroma score...\n--------------------------------------------------------------" );
            Collections.sort(arrList,new sortByBestAroma());
            for(int i = 0; i<10;i++){
                System.out.println(i + ": {Farm Name : " + arrList.get(i).getFarmName() + "}{ ID : " + arrList.get(i).getID() + "}{Aroma Score : " + arrList.get(i).getAroma()+ "}{ Overall Score : " + arrList.get(i).getOverallScore() + "}{ Country of Origin : " + arrList.get(i).getCountryOrigin()+"}");
            }
        }else if(input.equals("best acidity")){
            cls();
            System.out.println("Presenting the 10 best coffees ordered by acidity score...\n--------------------------------------------------------------" );
            Collections.sort(arrList,new sortByBestAcidity());
            for(int i = 0; i<10;i++){
                System.out.println(i + ": {Farm Name : " + arrList.get(i).getFarmName() + "}{ ID : " + arrList.get(i).getID() + "}{Acidity Score : " + arrList.get(i).getAcidity()+ "}{ Overall Score : " + arrList.get(i).getOverallScore() + "}{ Country of Origin : " + arrList.get(i).getCountryOrigin()+"}");
            }

        }else if(input.equals("best flavor")){
            cls();
            System.out.println("Presenting the 10 best coffees ordered by flavor score...\n--------------------------------------------------------------" );
            Collections.sort(arrList,new sortByBestFlavor());
            for(int i = 0; i<10;i++){
                System.out.println(i + ": {Farm Name : " + arrList.get(i).getFarmName() + "}{ ID : " + arrList.get(i).getID() + "}{Acidity Score : " + arrList.get(i).getFlavor()+ "}{ Overall Score : " + arrList.get(i).getOverallScore() + "}{ Country of Origin : " + arrList.get(i).getCountryOrigin()+"}");
            }
        }else if(input.equals("best aftertaste")){
            cls();
            System.out.println("Presenting the 10 best coffees ordered by aftertaste score...\n--------------------------------------------------------------" );
            Collections.sort(arrList,new sortByBestAftertaste());
            for(int i = 0; i<10;i++){
                System.out.println(i + ": {Farm Name : " + arrList.get(i).getFarmName() + "}{ ID : " + arrList.get(i).getID() + "}{Acidity Score : " + arrList.get(i).getAftertaste()+ "}{ Overall Score : " + arrList.get(i).getOverallScore() + "}{ Country of Origin : " + arrList.get(i).getCountryOrigin()+"}");
            }
        }else if(input.equals("best body")){
            cls();
            System.out.println("Presenting the 10 best coffees ordered by body score...\n--------------------------------------------------------------" );
            Collections.sort(arrList,new sortByBestBody());
            for(int i = 0; i<10;i++){
                System.out.println(i + ": {Farm Name : " + arrList.get(i).getFarmName() + "}{ ID : " + arrList.get(i).getID() + "}{Acidity Score : " + arrList.get(i).getBody()+ "}{ Overall Score : " + arrList.get(i).getOverallScore() + "}{ Country of Origin : " + arrList.get(i).getCountryOrigin()+"}");
            }
        }else if(input.equals("best balance")){
            cls();
            System.out.println("Presenting the 10 best coffees ordered by balance score...\n--------------------------------------------------------------" );
            Collections.sort(arrList,new sortByBestBalance());
            for(int i = 0; i<10;i++){
                System.out.println(i + ": {Farm Name : " + arrList.get(i).getFarmName() + "}{ ID : " + arrList.get(i).getID() + "}{Balance Score : " + arrList.get(i).getBalance()+ "}{ Overall Score : " + arrList.get(i).getOverallScore() + "}{ Country of Origin : " + arrList.get(i).getCountryOrigin()+"}");
            }
        }else if(input.contains("from")){
            String[] parseInput = input.split("from", 5);
            String target = parseInput[1];
            
        }else if(input.contains("-more")){

        }else{
            try{
                Integer.parseInt(input);
                //call get elemend id
            } catch(Exception e){
                System.out.println("I didn't understand that command. Please refer to our list of commands by typing 'man'");
            }

            

        }

    }

    public static ArrayList<Producer> searchByString(String a,ArrayList<Producer> b){
        ArrayList<Producer> filteredArr = 

        return 
    }

    public static void printDB(ArrayList<Producer> arraylist){
        for(int i = 0;i<arraylist.size();i++){
            System.out.println(arraylist.get(i));
        }
    }
}
