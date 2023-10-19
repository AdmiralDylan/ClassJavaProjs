import java.util.Comparator;

public class sortByBestCoffee implements Comparator<Producer>{

    @Override
    public int compare(Producer a, Producer b) {
        return (int)((a.getOverallScore() - b.getOverallScore())* 100);
    }
    
}
