import java.util.Comparator;

public class sortByBestFlavor implements Comparator<Producer>{

    @Override
    public int compare(Producer a, Producer b) {
        return (int)((a.getFlavor() - b.getFlavor())* 100);
    }
    
}
