import Exceptions.CalculationException;
import Exceptions.LawException;
import Laws.BinomialeLaw;
import Laws.GeometricLaw;
import Laws.UniformLaw;
import org.junit.Ignore;
import org.junit.Test;
import tools.Calculation;

import static org.junit.Assert.assertEquals;

/**
 * Created by max on 07/03/17.
 */
public class DS1Test {
    double delta =0.1;
    @Test
    public void Question2DS1Test() throws Exception, LawException {
        System.out.println("\nQuestion2DS1Test");
        double psucess = 1./9.;
        System.out.println("quelles est le nombre minimal de lancer d'un dé équillibré a 9 faces\n"+
                "pour avoir au moins 60% de chance d'obtenir au moins une fois la valeur du premier lancers");
        GeometricLaw geoLaw = new GeometricLaw(psucess);

        double proba =0.;
        int i;
        for(i=1; proba<0.6;i++) {
            proba += geoLaw.getProbabiliteDeX(i);
            System.out.println("proba = " + proba + "au "+ i+"+1 eme lancer");

        }

        System.out.println("au bout de " + (i-1)+ " lancers on a 60% d'avoir une valeur déterminée a l'avance du dé, on aura lancé "+ (int)(i)+ " fois le dé" );

        assertEquals(9, i);
        System.out.println("\n");
    }
    @Test
    public void Question3DS1Test() throws Exception, LawException, CalculationException {
        double res = 0;
        System.out.println("\nQuestion3DS1Test");
        System.out.println("Jeu de carte a 3 couleurs, 30 cartes, à valeur entre 1 et 10\n"+
        "On tire 5 cartes quelle est la proba d'obtenir trois cartes de même valeur ?");
        System.out.println("kParmisN(3,5)*premiere*deuxieme*troisieme*quatrieme*ciquieme");
        double premiere=1.;
        System.out.println("premiere = " + premiere);
        double deuxieme= 2./29.;
        System.out.println("deuxieme = " + deuxieme);
        double troisieme= 1./28.;//avoir 3 cartes identiques en 1 tirage
        System.out.println("troisieme = " + troisieme);
        System.out.println("les autres sont faciles");

        double quatrieme=1;
        double ciquieme=1;//osef
        res= Calculation.kParmisN(3,5)*premiere*deuxieme*troisieme*quatrieme*ciquieme;
        System.out.println("P(X=3) = " + res);
        assertEquals(68./2639., res,delta);

    }
    @Test
    public void Question5DS1Test() throws Exception, LawException, CalculationException {
        System.out.println("\nQuestion5DS1Test");
        System.out.println("on a une piece avec P(faire pile)=2/12");
        System.out.println("quelle est la proba d'avoir P(X<=1) sur 5 essai? ");
        BinomialeLaw law = new BinomialeLaw(2./12., 5);
        double res = law.getProbabiliteDeX(1)+law.getProbabiliteDeX(0);
        System.out.println("law.getProbabiliteDeX(1)+law.getProbabiliteDeX(0) = " + res);
        assertEquals(3215./3888.,res, delta);
    }

    @Test
    public void TD1exercice39() throws LawException {
        System.out.println("\nTD1exercice39");
        System.out.println("on lance un dé a 6 face jusqu'à obtenir un 1, quel est le nombre moyen de lancers ?\n"+
        "Quelle est la proba d'obtenir un 1 en moins de 6 lancers ?");
        GeometricLaw law = new GeometricLaw(1./6.);
        double res = 1. - Math.pow(5./6., 6.);
        //Note, java fait des approximations quand on lui donne des formules
        // préférer 5./6. à 1.-5./6.
        System.out.println("le nombre moyen de lancer vaut "+res);

        System.out.println("law.getProbabiliteDeX(6) = " + res);

        assertEquals(0.5981, res ,delta);

    }


}