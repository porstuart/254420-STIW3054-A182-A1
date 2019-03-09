public class UseCase{

    private int simple, average, complex;
    private int useCase;

    public UseCase(int simple, int average, int complex){
        this.simple = simple;
        this.average = average;
        this.complex = complex;
    }

    public int getUseCase(){
        useCase = simple*5 + average*10 + complex*15;
        return useCase;
    } //calculate Total Use Case
}