import java.util.Comparator;

public class sortByBestAroma implements Comparator<Producer>{

    @Override
    public int compare(Producer a, Producer b) {
        return (int)((a.getAroma() - b.getAroma())* 100);
    }
    
}
