import java.util.Scanner;

public class PezDispenser {

        final private String characterName;
        public final static int MAX_PEZ = 12;
        private int pezCount;
        public int pezAmount;

        Scanner scan = new Scanner(System.in);

        public PezDispenser(String characterName){
            this.characterName = characterName;
            pezCount=0;
        }

        public void fill(){
            pezCount = MAX_PEZ;
            System.out.println("Dispenser is now full");
        }

        public int getAmount(){
            System.out.println("How many do you want to add");
            String refillAnswer = scan.nextLine();
            pezAmount = Integer.parseInt(refillAnswer);
            return this.pezAmount;
        }

        public void eat(){
            dispense();
        }
        public void fill(int pezAmount){
            pezAmount = this.pezAmount;
            int newAmount = pezCount + pezAmount;
            if(newAmount > MAX_PEZ){
                throw new IllegalArgumentException("That is too many Pez! You can only add " + MAX_PEZ + ".");
            }
            pezCount = newAmount;
        }


        public boolean dispense(){
            boolean wasDispensed = false;

            if (!isEmpty()){
                pezCount--;
                wasDispensed = true;
                System.out.println("You have " + pezCount + " pez remaining...");
            }

            return wasDispensed;
        }

        public boolean isEmpty(){

            return pezCount == 0;
        }

        public int getPezCount(){
            return pezCount;
        }
        public String getCharacterName(){
            return characterName;
        }
    }

