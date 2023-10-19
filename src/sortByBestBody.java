import java.util.Comparator;

public class sortByBestBody implements Comparator<Producer>{

    @Override
    public int compare(Producer a, Producer b) {
        return (int)((a.getBody() - b.getBody())* 100);
    }
    
}
