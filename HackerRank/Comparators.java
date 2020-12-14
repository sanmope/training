package HackerRank;


import java.util.*;

class Checker implements Comparator{


    
    @Override
    public int compare(Object arg0, Object arg1) {
        Player p0 = (Player) arg0;
        Player p1 = (Player) arg1;

        if (p0.score > p1.score){
            return -1;
        } else if (p0.score < p1.score){
            return 1;
        } else if (p0.score == p1.score){
            return p0.name.compareToIgnoreCase(p1.name);
        }
        return 0;
    }
    
}

class Player{
    String name;
    int score;
    
    Player(String name, int score){
        this.name = name;
        this.score = score;
    }
}

class Comparators {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();
        
        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();
     
        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}

    
