package records;

import records.base.Person;

import java.util.Comparator;

public class SexComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getSex().compareTo(o2.getSex());
    }
}
