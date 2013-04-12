package classes;

public class ParaLiczb {

    private double first,second;

    public ParaLiczb (double f, double s) {
        setFirst(f);
        setSecond(s);
    }

    public ParaLiczb () {
    }

    public double getSecond() {
        return second;
    }

    public void setSecond(double second) {
        this.second = second;
    }

    public double getFirst() {
        return first;
    }

    public void setFirst(double first) {
        this.first = first;
    }


}
