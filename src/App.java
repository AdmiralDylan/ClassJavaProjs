import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class App{ //CommingInHot CSV Reader 
    public static void main(String[] args) throws Exception {

        //Init Arraylist

        ArrayList<Producer> producerDatabase = new ArrayList<Producer>();
        

        //Loading CSV File into arraylist

        String line = "";
        
        //Int to give an ID to each Producer
        int ID = 0;

        try{
            BufferedReader br = new BufferedReader(new FileReader("df_arabica_clean_New.csv"));
            while((line = br.readLine()) != null){
                
                String[] fields = line.split(",");
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

                producerDatabase.add(tempProducer);

            }
        }
    
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
