package classes;

public class Trojmian {

    static public ParaLiczb licz (double a, double b, double c) throws DeltaException {
        double epsilon = 0.0000000001;
        //throw new UnsupportedOperationException();
        if ( a >= ( 0 - epsilon ) && a <= ( 0 + epsilon )) {
            throw new DeltaException();
        }
        double delta = b*b - 4*a*c;
        ParaLiczb para;
        if (delta < 0) {
            throw new DeltaException("Brak pierwiastków");
        } else {
            para = new ParaLiczb(((-b - Math.sqrt(delta))/2*a), ((-b + Math.sqrt(delta))/2*a));
        }
        return para;
    }
}
