import Exceptions.LawException;
import Laws.GeometricLaw;
import Laws.UniformLaw;
import org.junit.Test;
import tools.Calculation;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Créé avec les rares archives du ds précédent
 */
public class DS2Test {
    double delta = Calculation.DELTA;
    @Test
    public void question12(){

        System.out.println("\n"+this.getClass().getSimpleName()+" question12");
        System.out.println("On tire une valeur de T selon une loi unifome (discrete) sur [-9;5]");
        System.out.println("Pour quelle valeur de X a-t'on P(T<X)= 0.25 ?");
        assertEquals(-5.5, computeForQuestion12(), delta);
    }

    private double computeForQuestion12(){
        int borneInf = -9, borneSupp = 5;
        UniformLaw law = new UniformLaw(borneInf, borneSupp);
        double res =0;
        for(double i=-9.0; i<5.0; i+=0.1){
            res=law.density(-9., (double) i);
            if(res<=0.25+delta && res>=0.25-delta){
                System.out.println("pour i = " + i+" on obient res = " +res);
                return i;
            }
            System.out.println("res = " + res);
        }
        return 0.;
    }

    @Test
    public void question10(){
        System.out.println("On tire une valeur de T selon une loi unifome sur [-7;7]");
        System.out.println(this.getClass().getSimpleName()+" question10");
        System.out.println("Pour quelle valeur de X a-t'on P(T>X)= 0.20 ?");
        assertEquals(-4.2, computeForQuestion10(), delta);
    }

    private double computeForQuestion10(){

        int borneInf = -7, borneSupp = 7;
        UniformLaw law = new UniformLaw(borneInf, borneSupp);
        double res =0;
        for(double i=borneInf; i<borneSupp; i+=0.01){
            res=1-law.density(i, borneSupp);//on veut la partie droite de la courbe
            if(res<=0.20+delta && res>=0.20-delta){
                System.out.println("pour i = " + i +" on obient res = " + res);
                return i;
            }
            System.out.println("res = " + res);
        }
        return 0.;
    }
    @Test
    public void question1() throws LawException {
        System.out.println("\nDS2 question 1");
        System.out.println("La taille des carrotes de la ferme suit une loi uniforme sur l'intervalle [67;128]\n"
                +"Quelle est la proportion de carrotes de grande taille, soit dans la catégorie [83;144] ?");
        UniformLaw uniformeLaw = new UniformLaw(67.,128.);
        double res = uniformeLaw.density(83.,144.);
        System.out.println("res = uniformeLaw.density(83.,144.) = " + res);
        assertEquals(45./61., res, Calculation.DELTA);
    }

    @Test
    public void question2() throws LawException {
        System.out.println("\nDS2 question 2");
        System.out.println("Les clients arrievent de manière uniforme entre H ouverture et H fermeture du magasin\n"
                + "1/3 des clients passent avant midi et 1/2 avant 13h30\n"
                + "Quel est l'horaire d'ouverture ?");

        System.out.println("Résolution : P(X<MIDI) = 1/3 et P(X<13H30)= 1/2");
        System.out.println("La loi est uniforme, on peut en déduire P(X<Houverture+1h30) = 1/6");
        System.out.println("Ainsi la plage horaire est de 6x1H30 soit 9 h, et comme on sait que les clients sont répartis");
        System.out.println("de maniere homogene on sait que 13H30-9H/2 = Houverture");
        System.out.println("on peut aussi le calculer :");
        /*SOLUTION
        double res = -1;
        UniformLaw uniformLaw = new UniformLaw(9., 18 );
        assertEquals(13.5,uniformLaw.getEsperance(), Calculation.DELTA);
        assertEquals(1./3, uniformLaw.density(12), Calculation.DELTA);
        */
        for(double i=0.; i<6.; i+=0.5){
            UniformLaw uniformLaw = new UniformLaw(13.5-i, 13.5 +i);
            if(uniformLaw.density(12)==1./3. && uniformLaw.density(13.5)==1./2.){
                System.out.println("tatonnement :On trouve l'heure d'ouverture a "+(double)(13.5-i)+"h" );
            }
        }
    }
}