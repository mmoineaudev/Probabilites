import Exceptions.LawException;
import tools.Calculation;

import java.lang.reflect.Parameter;

/**
 * Created by maxime on 09/03/17.
 */
public class BinomialeLaw implements Law, Displayable {
    private double p;
    private int n;
    public BinomialeLaw(double p,int n) throws LawException {
        this.p = p;
        this.n = n;
        if(!(p>0 && p<1 && n>0)) throw new LawException("Invalid parameters p="+p+" n="+n);
    }

    @Override
    public double compute(int x_egal_i) {
        return Calculation.kParmisN(x_egal_i, this.n)*Math.pow(p,x_egal_i)*Math.pow(1.0-p, n-x_egal_i);
    }

    @Override
    public double getEsperance() {
        return n*p;
    }

    @Override
    public double getVariance() {
        return n*p*(1-p);
    }

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public String getParameters() {
        return "B(n="+n+" p="+p+")";
    }
}
