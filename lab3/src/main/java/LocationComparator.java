import java.util.Comparator;

public class LocationComparator implements Comparator<Header>{
    @Override
    public int compare(Header o1, Header o2) {
        return o1.getRegion().compareTo(o2.getRegion());
    }
}
