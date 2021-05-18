import java.util.Scanner;

public class main {
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        int pezAmount;
        String pezRefill;

        System.out.println("We are making a new PEZ dispenser");

        PezDispenser PD = new PezDispenser("Yoda");
        System.out.println("The dispenser is " + PD.getCharacterName());

        System.out.println("There are only " + PezDispenser.MAX_PEZ +" allowed in every dispenser");

        if(PD.isEmpty()){
            System.out.println("It's currently empty");
            System.out.println("Filling pez dispenser....");
            PD.fill();
        }

        do {
            PD.dispense();
        }while (PD.getPezCount() != 5);

        System.out.println("You currently have " + PD.getPezCount() + ". Do you want to refill?");
        pezRefill = scan.nextLine();

        if(pezRefill.equalsIgnoreCase("yes")){
            System.out.println("How many would you like to refill?");
            String refillAnswer = scan.nextLine();
            pezAmount = Integer.parseInt(refillAnswer);

            if(pezAmount != 0 && pezAmount + PD.getPezCount() <= 12){
                boolean isDone= false;

                do{
                    PD.fill(pezAmount);
                    System.out.println("You now have " + PD.getPezCount());
                    if(PD.getPezCount() != 12){
                        System.out.println("Would you like to add more?");
                        String continueAnswer = scan.nextLine();

                        if(continueAnswer.equalsIgnoreCase("no")){
                            isDone = true;
                        }else{
                            System.out.println("How many more do you want to add?");
                            refillAnswer = scan.nextLine();
                            pezAmount = Integer.parseInt(refillAnswer);
                                if(pezAmount + PD.getPezCount() > 12) {
                                    System.out.println("You can't go over 12 pez");
                                    //System.out.println("You get " + (PD.MAX_PEZ - (pezAmount + PD.getPezCount())) + " extra pez back.");
                                    PD.fill();
                                    isDone = true;
                                }
                        }
                    }else if(pezAmount + PD.getPezCount() > 12){
                        System.out.println("You can't go over 12 pez");
                        //System.out.println("You get " + ((pezAmount + PD.getPezCount())- PezDispenser.MAX_PEZ) + " extra pez back.");
                        PD.fill();
                        isDone = true;
                    }else{
                        isDone = true;
                    }

                }while (!isDone && PD.getPezCount() != 12);

            } else if(pezAmount + PD.getPezCount() > 12){
                System.out.println("Sorry. You can't add more than 12 pez");
                //System.out.println("You get " + (PD.MAX_PEZ - (pezAmount + PD.getPezCount())) + " extra pez back.");
                PD.fill();

            }
        }

    }

}


