package records;

import records.base.Person;

import java.util.Comparator;

public class LocationComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getRegion().compareTo(o2.getRegion());
    }
}
