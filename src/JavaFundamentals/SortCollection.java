package JavaFundamentals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SortCollection {
    public static void main(String[] args) {
        //sort arraylist of integers
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,3,55,22,19,7));
        System.out.println(list);
        sortCollection(list);
        
        //sort arraylist of objects having multiple fields
        ArrayList<User> userList = new ArrayList<>();
        userList.add(new User(1,"david","MO",36));
        userList.add(new User(56,"john","Ohio",27));
        userList.add(new User(3,"Miz","CZ",12));
        System.out.println(userList);
        sortObjectCollectionV2(userList);
    }

    /**
    //sort on single field using comparable
    private static void sortObjectCollection(ArrayList<User> userList) {
        Collections.sort(userList);
        System.out.println(userList);
    }
     **/

    private static void sortCollection(ArrayList<Integer> list) {
         Collections.sort(list);
         System.out.println(list);
    }

    //sort collections on multiple fields - use comparator
    private static void sortObjectCollectionV2(ArrayList<User> userList) {
        ArrayList<User> list = new ArrayList<>(userList);
        Collections.sort(list,new IdComparator());
        System.out.println(list);
        Collections.sort(list,new AgeComparator());
        System.out.println(list);
        Collections.sort(list,new AddressComparator());
        System.out.println(list);
    }
}
