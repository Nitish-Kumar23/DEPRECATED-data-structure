package JavaCode;

import java.util.Comparator;

public class AddressComparator implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return o1.getAddress().compareTo(o2.getAddress());
    }
}
