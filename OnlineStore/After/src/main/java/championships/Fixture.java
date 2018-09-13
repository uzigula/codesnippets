package championships;

import java.util.ArrayList;
import java.util.List;

public class Fixture {
    private final String name;
    private int stages;
    private List<Bracket> brackets;
    private boolean isEven;
    private int totalByes;
    private final int  MAX_PLAYERS = 64;

    public Fixture(String name) {
        this.name = name;
    }

    public static Fixture called(String name) { return new Fixture(name);}

    public String getName() {
        return name;
    }

    public int getStages() {
        return stages;
    }

    public void generate(List<String> players) {
        brackets = new ArrayList<Bracket>();
        getFirstStateOfFixture(players.size());
        int localByes = totalByes;

        for(int i=0; i< players.size(); i++){
            if (isEven) {
                brackets.add(new Bracket(players.get(i), players.get(i + 1)));
                i++;
            }
            else {
                //players.get(i).contains("*") &&
                if ((localByes>0)){
                    brackets.add(new Bracket(players.get(i), "Bye"));
                    localByes--;
                }
                else {
                    brackets.add(new Bracket(players.get(i), players.get(i + 1)));
                    i++;
                }
            }
        }
    }

    private void getFirstStateOfFixture(int size) {
        if (size>MAX_PLAYERS) size=MAX_PLAYERS;

        switch (size){
            case 2:
                isEven = true;
                break;
            case 4:
                isEven = true;
                break;
            case 8:
                isEven = true;
                break;
            case 16:
                isEven = true;
                break;
            case 32:
                isEven = true;
                break;
            case 64:
                isEven = true;
                break;
            default:
                isEven = false;
                break;
        }

        totalByes = 0;
        if (size>32){
            totalByes = 64 -size;
        }
        else
            if (size>16){
            totalByes = 32 -size;
            }
            else if(size>8){
                totalByes = 16 -size;
                }
                else if(size>4){
                    totalByes = 8 -size;
                }
                else if(size>0){
                    totalByes = 4 -size;
                    }

    }

    public Bracket Key(int index) {
        if (brackets == null) return new Bracket("Error","Error");
       return brackets.get(index);
    }

    public boolean getIsEven() {
        return isEven;
    }

    public int getByes() {
        return totalByes;
    }
}
