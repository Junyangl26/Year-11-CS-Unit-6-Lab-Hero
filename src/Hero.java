import java.util.Random;
public class Hero {
    String name;
    int hitPoints;
    public Hero (String a) {
        hitPoints = 100;
        name = a;
    }
    public String getName () {
        return name;
    }
    public int getHitPoints (){
        return hitPoints;
    }
    public String toString () {
        return "Hero{name=" + "'" + name + "', " + "hitPoints=" + hitPoints+"}";
    }
    public void attack (Hero opponent) {
        double random = Math.random();
        if (random < 0.5) {
            opponent.hitPoints = opponent.hitPoints - 10;
        }
    }
    public void senzuBean () {
        hitPoints = 100;
    }
    private void fightUntilTheDeathHelper (Hero opponent) {
        while (hitPoints > 0 && opponent.hitPoints > 0) {
            attack (opponent);
        }
    }
    public String fightUntilTheDeath (Hero opponent) {
        senzuBean();
        opponent.senzuBean ();
        fightUntilTheDeathHelper (opponent);
        return name + ": " + hitPoints + opponent.name + ": " + opponent.hitPoints;
    }
    private int[] nFightsToTheDeathHelper (Hero opponent, int n) {
        int wins = 0;
        int loss = 0;
        for(int i=n;i>0;i--) {
            senzuBean();
            fightUntilTheDeathHelper(opponent);
            if (hitPoints ==0) {
                loss ++;
            }
            else if (opponent.hitPoints ==0){
                wins ++;
            }
        }
        return new int[] {wins, loss};
    }
    public String nFightsToTheDeath (Hero opponent, int n) {
        String output = "";
        int [] out = nFightsToTheDeathHelper(opponent,n);
        if (out[0] > out[1]) {
            output = "Andrew Tate Wins!";
        }
        else if (out[1] > out[0]) {
            output = "Taylor Swift Wins!";
        }
        else {
            output = "OMG! It was actually a draw!";
        }
        return "Andrew Tate: " + out[0] +" wins\n" + "Taylor Swift: " + out[1] + "wins\n" + output;
    }
    public void dramaticFightToTheDeath (Hero opponent) throws InterruptedException {
        System.out.println("Andrew Tate: " + hitPoints +"\t" + "Taylor Swift: " + opponent.hitPoints);
        Thread.sleep(1000);
    }
}
