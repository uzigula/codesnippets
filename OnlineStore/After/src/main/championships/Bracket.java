package championships;

public class Bracket {
    private final String player1;
    private final String player2;

    public Bracket(String player1, String player2) {
        this.player1 = player1.replace("*","");
        this.player2 = player2.replace("*","");
    }

    public String getPlayer1() {
        return player1;
    }

    public String getPlayer2() {
        return player2;
    }
}
