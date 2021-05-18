import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int pezAmount;
        String pezRefill;

        System.out.println("We are making a new PEZ dispenser");

        PezDispenser PD = new PezDispenser("Yoda");
        System.out.println("The dispenser is " + PD.getCharacterName());

        System.out.println("There are only " + PezDispenser.MAX_PEZ + " pez candies allowed in every dispenser");

        if (PD.isEmpty()) {
            System.out.println("It's currently empty");
            System.out.println("Filling pez dispenser....");
            PD.fill();
        }
        System.out.println("Do you want to eat some pez?");
        String eatPez = scan.nextLine();

        if(eatPez.equalsIgnoreCase("yes")){
            System.out.println("Enter number of pez to eat: ");
            int amountToEat = Integer.parseInt(scan.nextLine());

            int eaten = 0;
            while(eaten != amountToEat){
                PD.eat();
                eaten++;
            }

            System.out.println("You currently have " + PD.getPezCount() + ". Do you want to refill?");
            pezRefill = scan.nextLine();

            if (pezRefill.equalsIgnoreCase("yes") /*&& PD.getAmount() != 0*/) {
                boolean isDone = false;
                //PD.getAmount();
                while(!isDone) {

                    try {
                        PD.fill(PD.getAmount());
                        System.out.println("You now have " + PD.getPezCount());
                        System.out.println("All set?");
                        String allSet = scan.nextLine();
                        if(allSet.equalsIgnoreCase("yes"))
                        {
                            isDone = true;
                        }else{
                            PD.fill(PD.getAmount());
                        }
                        if (PD.getPezCount() == 12) {
                            System.out.println("You now have the max " + PD.getPezCount() + ". Enjoy!");
                            isDone = true;
                        } else {
                            PD.fill(PD.getAmount());
                        }

                    } catch (IllegalArgumentException iae) {
                        System.out.println("Oh my!");
                        System.out.println(iae.getMessage());
                        isDone = true;
                    }


                }
            }else{
                System.out.println("Okay, Refill when you're ready! Goodbye!");
            }

        }else{
            System.out.println("Come back when you're ready!");
        }

    }

}


