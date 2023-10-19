import java.util.Comparator;

public class sortByBestBalance implements Comparator<Producer>{

    @Override
    public int compare(Producer a, Producer b) {
        return (int)((a.getBalance() - b.getBalance())* 100);
    }
    
}