package BacoProject;

import java.util.ArrayList;

public class Game {
    ArrayList<Card> cards = new ArrayList<Card>();
    ArrayList<Player> players = new ArrayList<Player>();
    private int numRound;
    private int numTurn;


    public Game() {

    }

    private boolean exitSelected;

    public void start() {
        exitSelected = false;
        System.out.println("Game started!");
        Player player1 = new Player();
        player1.setAttack(true);
        Player player2 = new Player();
        player2.setAttack(false);
        players.add(player1);
        players.add(player2);
        giveInitialCards();
        numRound = 0;
        numTurn = 0;


        while (!exitSelected) {
            if(numTurn == 0){
                getCard();
            }
            incrementMana();
            drawBoard();
            readInput();
            updateBoard();
            numTurn++;
            if (numTurn > 10) {
                nextRound();
            }
        }
        System.out.println("Game terminated. Bye!");
    }

    private void incrementMana() {
        for(Player i : players){
            i.incrementMana(numTurn);
        }
    }

    private void drawBoard() {

    }

    private void readInput() {

    }

    private void updateBoard() {

    }

    private void switchCards() {
        for (int i = 0; i < 40; i++) {
            Card card = new Card();
            cards.add(card);
        }
    }

    void giveMana(Player player) {
        if (player.getMana() + numRound < 10) {
            player.addMana(numRound);
        } else {
            player.addMana(10 - player.getMana());
        }
    }

    private void giveInitialCards() {
        for (Player i : players) {
            i.giveInitialCards();
        }
    }

    private void nextRound() {
        numTurn = 0;
        for(Player i : players) {

            i.switchAttacker();

            if(i.getMana() > 3){
                i.incrementMana(3-i.getMana());
            }
        }
    }

    private void getCard(){
        for(Player i : players){
            i.getCard();
        }
    }

    private void initBattle() {
        Player atackPlayer = null;
        Player defensePlayer = null;
        if(player1.getAttack()){
            atackPlayer = player1;
            defensePlayer = player2;
        }else{
            atackPlayer = player2;
            defensePlayer = player2;
        }
        System.out.println(atackPlayer.toString()+", deseja entrar em batalha? Digite 1 para sim, 2 para não");
        Scanner sc = new Scanner(System.in);
        int atack = sc.nextInt();
        if(atack==1){
            System.out.println("Selecione a carta que deseja enviar para a batalha(Digite o id)");
            int n = 1;
            for (Card card : atackPlayer.getEvockedUnits()) {
                System.out.println(n + ": " + card.toString());
                 n++;
            }
            //colocar no battlefield
            System.out.println(defensePlayer.toString()+", selecione as cartas que você deseja usar para defender")
            for (Card card : defensePlayer.getEvockedUnits()) {
                System.out.println(n + ": " + card.toString());
                //percorrer battlefield ataque e perguntar "quem vc quer defender com essa carta"

                //evocar essa carta no battlefield defesa no mesmo indice do battlefield ataque
                n++;
            }
            int select = sc.nextInt();

        }
    }




}


