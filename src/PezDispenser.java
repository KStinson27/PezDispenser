public class PezDispenser {

        final private String characterName;
        public final static int MAX_PEZ = 12;
        private int pezCount;

        public PezDispenser(String characterName){
            this.characterName = characterName;
            pezCount=0;
        }

        public void fill(){
            pezCount = MAX_PEZ;
            System.out.println("Dispenser is now full");
        }

        public void fill(int pezAmount){
            pezCount += pezAmount;
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

