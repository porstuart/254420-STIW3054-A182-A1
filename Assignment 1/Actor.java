public class Actor{  

    private int [] actor = new int[3];
    private int actorPoint;
    
    public Actor(int simple, int average, int complex) {
        actor[0] = simple;
        actor[1] = average;
        actor[2] = complex;
    }

    public int getActorPoint() {
        actorPoint = 1*actor[0] + 2*actor[1] + 3*actor[2];
        return actorPoint;
    } //calculate Total Actor Point
}