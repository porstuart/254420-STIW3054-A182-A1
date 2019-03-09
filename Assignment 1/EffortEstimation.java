import java.util.*;

public class EffortEstimation{

    public static void main(String [] args){
        calculation();
    }

    public static void calculation(){
        /*Declaration*/
        Scanner scan = new Scanner(System.in); 
        int index, count = 0;  
        int [] actorType = new int[3];
        int [] useCaseType = new int[3];
        int uucp; //Unadjusted Use Case Points
        int [] technicalFactor = new int[13];
        double tFactor; //Technical Factor
        double tcf; //Technical Complexity Factor
        double SzUC; //Size of Software (Use Case)
        int [] experienceFactor = new int[8];
        double eFactor; //EFactor
        double ucp; //Use Case Points
        int effortRate = 0;
        double manHours;
        double riskCoefficient = 0;
        double adjManHours; //Adjusted Man-Hours
        int [] reportType = new int[3];
        int reportManHours;
        double totalManHours;

        try{
            /*Calculation of Actor Points*/
            System.out.println();
            System.out.println("1. Actors");
            System.out.println("-------------------------------------------------------------------------");
            System.out.println("| Actor Type |               Description                | Weight Factor |");
            System.out.println("-------------------------------------------------------------------------");
            System.out.println("|   Simple   |               Defined API                |       1       |");
            System.out.println("|   Average  | Interactive or Protocol driven interface |       2       |");
            System.out.println("|   Complex  |          Graphical User Interface        |       3       |");
            System.out.println("-------------------------------------------------------------------------");

            System.out.print("Please input the quantity of Simple Actor : ");
            actorType[0] = scan.nextInt();
            System.out.print("Please input the quantity of Average Actor: ");
            actorType[1] = scan.nextInt();
            System.out.print("Please input the quantity of Complex Actor: ");
            actorType[2] = scan.nextInt();
            System.out.println();
            Actor actor = new Actor(actorType[0], actorType[1], actorType[2]);
            System.out.println("Total Actor Points: " +actor.getActorPoint());
            System.out.println();

            /*Calculation of Use Case*/
            System.out.println("2. Weighting Use Cases");
            System.out.println("---------------------------------------------------------------");
            System.out.println("| Use Case Type |         Description         | Weight Factor |");
            System.out.println("---------------------------------------------------------------");
            System.out.println("|    Simple     |   3 or fewer transactions   |        5      |");
            System.out.println("|    Average    |     4 to 7 transactions     |       10      |");
            System.out.println("|    Complex    | Greater than 7 transactions |       15      |");
            System.out.println("---------------------------------------------------------------");

            System.out.print("Please input the quantity of Simple Use Case : ");
            useCaseType[0] = scan.nextInt();
            System.out.print("Please input the quantity of Average Use Case: ");
            useCaseType[1] = scan.nextInt();
            System.out.print("Please input the quantity of Complex Use Case: ");
            useCaseType[2] = scan.nextInt();
            System.out.println();

            UseCase useCase = new UseCase(useCaseType[0], useCaseType[1], useCaseType[2]);
            System.out.println("Total Use Case: " +useCase.getUseCase());
            uucp = actor.getActorPoint() + useCase.getUseCase(); //calculate Unadjusted Use Case Point
            System.out.println("Unadjusted Use Case Points(UUCP)= " +uucp);
            System.out.println();

            /*Calculation of Technical Factors*/
            System.out.println("3. Weighting Technical Factors");
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.println("| Techinal Factor |             Technical Description               | Weight Factor |");
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.println("|        T1       |         Must have a distributed solution        |       2       |");
            System.out.println("|        T2       | Must respond to specific performance objectives |       1       |");
            System.out.println("|        T3       |       Must meet end-user efficiency desires     |       1       |");
            System.out.println("|        T4       |           Complex internal processing           |       1       |");
            System.out.println("|        T5       |              Code must be reusable              |       1       |");
            System.out.println("|        T6       |             Must be easy to install             |      .5       |");
            System.out.println("|        T7       |               Must be easy to use               |      .5       |");
            System.out.println("|        T8       |                Must be portable                 |       2       |");
            System.out.println("|        T9       |              Must be easy to change             |       1       |");
            System.out.println("|       T10       |           Must allow concurrent users           |       1       |");
            System.out.println("|       T11       |        Includes special security features       |       1       |");
            System.out.println("|       T12       |    Must provide direct access for 3rd parties   |       1       |");
            System.out.println("|       T13       |    Requires special user training  facilities   |       1       |");
            System.out.println("-------------------------------------------------------------------------------------");

            System.out.print("PLease input the rating of T1 : ");
            technicalFactor[0] = scan.nextInt();
            System.out.print("PLease input the rating of T2 : ");
            technicalFactor[1] = scan.nextInt();
            System.out.print("PLease input the rating of T3 : ");
            technicalFactor[2] = scan.nextInt();
            System.out.print("PLease input the rating of T4 : ");
            technicalFactor[3] = scan.nextInt();
            System.out.print("PLease input the rating of T5 : ");
            technicalFactor[4] = scan.nextInt();
            System.out.print("PLease input the rating of T6 : ");
            technicalFactor[5] = scan.nextInt();
            System.out.print("PLease input the rating of T7 : ");
            technicalFactor[6] = scan.nextInt();
            System.out.print("PLease input the rating of T8 : ");
            technicalFactor[7] = scan.nextInt();
            System.out.print("PLease input the rating of T9 : ");
            technicalFactor[8] = scan.nextInt();
            System.out.print("PLease input the rating of T10: ");
            technicalFactor[9] = scan.nextInt();
            System.out.print("PLease input the rating of T11: ");
            technicalFactor[10] = scan.nextInt();
            System.out.print("PLease input the rating of T12: ");
            technicalFactor[11] = scan.nextInt();
            System.out.print("PLease input the rating of T13: ");
            technicalFactor[12] = scan.nextInt();
            System.out.println();

            TechnicalFactor techFactor = new TechnicalFactor(technicalFactor[0], technicalFactor[1], technicalFactor[2], 
                                                             technicalFactor[3], technicalFactor[4], technicalFactor[5], 
                                                             technicalFactor[6], technicalFactor[7], technicalFactor[8], 
                                                             technicalFactor[9], technicalFactor[10], technicalFactor[11], 
                                                             technicalFactor[12]);
            tFactor = techFactor.getTechFactor();
            System.out.println("\nTotal TFactor= " +tFactor);
            tcf = (0.01 * tFactor) + 0.6; //calculate Technical Complexity Factor
            System.out.println("Technical Compelxity Factor(TCF)= " +tcf);
            SzUC = uucp * tcf; //calculate Size of Software
            System.out.println("Size of Software(SzUC)= " +SzUC);
            System.out.println();

            /*Calculation of Experience Factor*/
            System.out.println("4. Weighting Experience Factors");
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("| Experience Factor |         Factor Description         | Weight Factor |");
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("|         E1        | Familiar with FPT software process |       1       |");
            System.out.println("|         E2        |       Application experience       |      .5       |");
            System.out.println("|         E3        |      Paradigm experience (OO)      |       1       |");
            System.out.println("|         E4        |       Lead analyst capability      |      .5       |");
            System.out.println("|         E5        |             Motivation             |       0       |");
            System.out.println("|         E6        |         Stable requirements        |       2       |");
            System.out.println("|         E7        |          Part-time workers         |      -1       |");
            System.out.println("|         E8        | Difficulty of programming language |      -1       |");
            System.out.println("--------------------------------------------------------------------------");

            System.out.print("Please input the rating of E1: ");
            experienceFactor[0] = scan.nextInt();
            System.out.print("Please input the rating of E2: ");
            experienceFactor[1] = scan.nextInt();
            System.out.print("Please input the rating of E3: ");
            experienceFactor[2] = scan.nextInt();
            System.out.print("Please input the rating of E4: ");
            experienceFactor[3] = scan.nextInt();
            System.out.print("Please input the rating of E5: ");
            experienceFactor[4] = scan.nextInt();
            System.out.print("Please input the rating of E6: ");
            experienceFactor[5] = scan.nextInt();
            System.out.print("Please input the rating of E7: ");
            experienceFactor[6] = scan.nextInt();
            System.out.print("Please input the rating of E8: ");
            experienceFactor[7] = scan.nextInt();
            System.out.println();

            for(index = 0; index < 6; index++){
                if(experienceFactor[index] < 3)
                    count++;
            } //Count the number of factor rating E1-E6

            for(index = 6; index < 8; index++){
                if(experienceFactor[index] > 3)
                    count++;
            } //Count the number of factor rating E7-E8

            if(count >= 0 && count <= 2)
                effortRate = 20;

            else if(count >=3 && count <=4)
                effortRate = 28;

            else{
                System.out.println("Please restructuring the project team." 
                                +"This project is at significant risk of failure with this team.");
                System.exit(0);
            }

            ExperienceFactor expFactor = new ExperienceFactor(experienceFactor[0],experienceFactor[1],experienceFactor[2], 
                                                            experienceFactor[3],experienceFactor[4],experienceFactor[5], 
                                                            experienceFactor[6], experienceFactor[7]);
            eFactor = expFactor.getEFactor();
            System.out.println("Total EFactor= " +eFactor);
            expFactor.setExpFactor(eFactor);
            System.out.println("Experience Factor(EF)= " +expFactor.getExpFactor());
            ucp = SzUC * expFactor.getExpFactor(); //calculate Use Case Points
            System.out.println("Use Case Points(UCP)= " +ucp);
            manHours = effortRate * ucp; //calculate Total Man-Hours
            System.out.println("\n");

            /*Calculation of Man-Hours*/
            System.out.println("5. Calculating Man-Hours from UCP");
            System.out.println("Total Man-Hours= " +manHours);
            System.out.println();

            /*Calculation of Adjusted Man-Hours*/
            System.out.println("6. Adjusting Man-Hours for Risk");
            System.out.print("Please input the Risk Coefficients: ");
            riskCoefficient = scan.nextDouble();
            riskCoefficient = riskCoefficient/100;
            adjManHours = (1.0 + riskCoefficient) * manHours;
            System.out.printf("Adjusted Man-Hours: %.3f\n\n", adjManHours);

            /*Calculation of Total Man-Hours*/
            System.out.println("7. Estimating for Reports");
            System.out.println("-----------------------------------");
            System.out.println("| Report Type | Average Man-Hours |");
            System.out.println("-----------------------------------");
            System.out.println("|   Simple    |         12        |");
            System.out.println("|   Average   |         20        |");
            System.out.println("|   Complex   |         40        |");
            System.out.println("-----------------------------------");

            System.out.print("Please input the quantity of Simple Complexity : ");
            reportType[0] = scan.nextInt();
            System.out.print("Please input the quantity of Average Complexity: ");
            reportType[1] = scan.nextInt();
            System.out.print("Please input the quantity of Complex Complexity: ");
            reportType[2] = scan.nextInt();

            reportManHours = reportType[0]*12 + reportType[1]*20 + reportType[2]*40;
            System.out.println();
            totalManHours = adjManHours + reportManHours;
            System.out.println("Total Man-Hours= " +totalManHours);
        
        }catch(Exception e){
            System.out.println("Please input numbers ONLY!\n");
            calculation();
        }
    scan.close();
    } //End of Main Method
} //End of EffortEstimation class