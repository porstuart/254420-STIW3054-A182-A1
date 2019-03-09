public class TechnicalFactor{

    private int [] technicalFactor = new int[13];
    private double [] weightFactor = {2, 1, 1, 1, 1, 0.5, 0.5, 2, 1, 1, 1, 1, 1};
    private double totalTechFactor = 0;

    public TechnicalFactor(int techFactor1, int techFactor2, int techFactor3, int techFactor4, int techFactor5, 
                           int techFactor6, int techFactor7, int techFactor8, int techFactor9, int techFactor10, 
                           int techFactor11, int techFactor12, int techFactor13){
        technicalFactor[0] = techFactor1;
        technicalFactor[1] = techFactor2;
        technicalFactor[2] = techFactor3;
        technicalFactor[3] = techFactor4;
        technicalFactor[4] = techFactor5;
        technicalFactor[5] = techFactor6;
        technicalFactor[6] = techFactor7;
        technicalFactor[7] = techFactor8;
        technicalFactor[8] = techFactor9;
        technicalFactor[9] = techFactor10;
        technicalFactor[10] = techFactor11;
        technicalFactor[11] = techFactor12;
        technicalFactor[12] = techFactor13;
    }

    public double getTechFactor(){
        for(int index = 0; index < 13; index++){
            totalTechFactor = totalTechFactor + (technicalFactor[index] *weightFactor[index]);
        }
        return totalTechFactor;
    } //calculate Total Technical Factor
}