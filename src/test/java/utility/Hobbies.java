package utility;

import java.util.*;

public class Hobbies {

    private final HashMap<String, String[]> hobbies = new HashMap<String, String[]>();

    public void add(String hobbyist, String... hobbies) {
        this.hobbies.put(hobbyist, hobbies);
    }

    public List<String> findAllHobbyists(String hobby) {
        for(int k=0;k<hobbies.size();k++)
        {
            List<Object> arrList1 = new ArrayList<>(Arrays.asList(hobbies.get("Steve")));
            List<Object> arrList2 = new ArrayList<>(Arrays.asList(hobbies.get("Patty")));
            List<Object> arrList3 = new ArrayList<>(Arrays.asList(hobbies.get("Chad")));
            System.out.println(arrList1);
        }
        return new ArrayList<String>();
    }

    public static void main(String[] args) {
        Hobbies hobbies = new Hobbies();
        hobbies.add("Steve", "Fashion", "Piano", "Reading");
        hobbies.add("Patty", "Drama", "Magic", "Pets");
        hobbies.add("Chad", "Puzzles", "Pets", "Yoga");

        System.out.println(Arrays.toString(hobbies.findAllHobbyists("Yoga").toArray()));
    }
}