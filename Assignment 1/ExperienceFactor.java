public class ExperienceFactor{

    private int [] experienceFactor = new int[13];
    private double [] weightFactor = {1, 0.5, 1, 0.5, 0, 2, -1, -1};
    private double totalEFactor = 0;
    private double totalExpFactor = 0;
    
    public ExperienceFactor(int eFactor1, int eFactor2, int eFactor3, int eFactor4, int eFactor5, 
                            int eFactor6, int eFactor7, int eFactor8){
        experienceFactor[0] = eFactor1;
        experienceFactor[1] = eFactor2;
        experienceFactor[2] = eFactor3;
        experienceFactor[3] = eFactor4;
        experienceFactor[4] = eFactor5;
        experienceFactor[5] = eFactor6;
        experienceFactor[6] = eFactor7;
        experienceFactor[7] = eFactor8;
    }

    public ExperienceFactor(int totalEFactor){
        this.totalEFactor = totalEFactor;
    }

    public double getEFactor(){
        for(int index = 0; index < 8; index++){
            totalEFactor = totalEFactor + (experienceFactor[index] *weightFactor[index]);
        }
        return totalEFactor;
    } //calculate Total EFactor

    public double getExpFactor(){
        totalExpFactor = (-0.03 * totalEFactor) + 1.4;
        return totalExpFactor;
    } //calculate Experience Factor

    public void setExpFactor(double totalEFactor){
        this.totalEFactor = totalEFactor;
    }
}