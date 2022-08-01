package records;

import java.util.Comparator;

public class SexComparator implements Comparator<Header> {
    @Override
    public int compare(Header o1, Header o2) {
        return o1.getSex().compareTo(o2.getSex());
    }
}
