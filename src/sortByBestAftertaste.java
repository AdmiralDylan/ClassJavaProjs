import java.util.Comparator;

public class sortByBestAftertaste implements Comparator<Producer>{

    @Override
    public int compare(Producer a, Producer b) {
        return (int)((a.getAftertaste() - b.getAftertaste())* 100);
    }
    
}
