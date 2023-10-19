import java.util.Comparator;

public class sortByBestAcidity implements Comparator<Producer>{

    @Override
    public int compare(Producer a, Producer b) {
        return (int)((a.getAcidity() - b.getAcidity())* 100);
    }
    
}
