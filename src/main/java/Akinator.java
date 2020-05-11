import java.util.Scanner;

public class Akinator {

    public static void main(String[] args) throws InterruptedException {
           AkiDriver akiDriver = new AkiDriver();
           Scanner in = new Scanner(System.in);
           int answer;
           System.out.println("Hello!\nThis is an Akinator, please guess a person and answer the question\n Enter any number to continue");
           answer = in.nextInt();
           while(true)
           {
               System.out.println(akiDriver.getQuestion());
               System.out.println("1-да\n2-нет\n3-я не знаю\n4-возможно частично\n5-cкорее нет, не совсем\n");
               answer = in.nextInt();
               akiDriver.sendAnswer(answer);

               if(akiDriver.checkProposal())
               {
                   System.out.println(akiDriver.getProposal());
                   System.out.println("1-да\n2-нет");
                   answer = in.nextInt();
                   akiDriver.sendProposalAnswer(answer);
                   if(akiDriver.checkWin())
                   {
                       System.out.println("Это конец");
                       break;
                   }
                   System.out.println(akiDriver.getProposal());
                   System.out.println("1-да\n2-нет");
                   answer = in.nextInt();
                   akiDriver.sendContinueAnswer(answer);
                   if(akiDriver.checkContinue())
                   {
                       System.out.println("Это конец");
                       break;
                   }
               }
           }
           akiDriver.off();
    }
}
