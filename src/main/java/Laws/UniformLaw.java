package Laws;

import Laws.functions.ContinuousLaw;
import Laws.functions.Law;
import tools.Displayable;


public class UniformLaw implements Law, ContinuousLaw, Displayable {
    private double supp;
    private double inf;

    private static final int MAX_EVAL=10;

    public UniformLaw(double inf, double supp) {
        this.inf = inf;
        this.supp = supp;

    }

    public double f(double a, double b) {
        return f(b) - f(a);
    }

    @Override
    public double f(double a) {
        if(a>=supp) return 1;
        if(a<=0) return 0;
        return (a-inf)/(supp-inf);
    }

    @Override
    public double F(double x_inferieur_a_y, double x_superieur_a_y) {
        return (x_superieur_a_y-x_inferieur_a_y)*getEsperance();
    }

    @Override
    public double F_de_p_superieur_a(double b) {
        if(supp-b>0) return (supp - b)*getEsperance();
        return -1;
    }

    @Override
    public double F_de_p_inferieur_a(double b) {
       if(b-inf>0) return (b-inf)*getEsperance();
       return -1;
    }

    @Override
    public double getEsperance() {

        return (inf+supp)/2;
    }

    @Override
    public double getVariance() {
        double base = 12;
        double num = Math.pow(supp-inf, 2);

        return num/base;
    }

    @Override
    public String getName() {

        return "Uniform Laws.functions.Law ";
    }

    @Override
    public String display() {

        display();//for debug
        return Displayable.title_prefix+getName()+Displayable.closure+"\n"+getParameters();
    }

    @Override
    public String getParameters() {
        return "borne inf:"+inf+"; borne supp:"+supp;

    }

}
