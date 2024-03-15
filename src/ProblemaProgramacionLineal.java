import org.apache.commons.math3.optim.linear.LinearConstraint;
import org.apache.commons.math3.optim.linear.LinearObjectiveFunction;
import org.apache.commons.math3.optim.linear.Relationship;
import org.apache.commons.math3.optim.linear.SimplexSolver;
import org.apache.commons.math3.optim.MaxIter;
import org.apache.commons.math3.optim.OptimizationData;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;

// Descripcion del problema
/* Tenemos una f�brica de marcos de acero, la cual puede crear tres tama�os de marcos de acero: Chico (2m x 4m) 
 * con un precio de 3500 pesos, Mediano (4m x 8m) con un costo de 7000 pessos y Grande (6m x 12m) con un costo de 10500 pesos; 
 * estas medidas obviamente implican el doble de una medida horizontal y el doble de la medida vertical pues si hici�ramos 
 * un marco chico (2m x 4m) se gastar�an 12 metros en total de acero ya que son 2x2m para el lado horizontal y 2x4m para 
 * el lado vertical. 
 * La producci�n se organiza en base a la cantidad de pedidos que se realizan cada semana, es decir, cu�ntos y qu� tipos de 
 * marcos se necesitan hacer. El material usado para los marcos de acero es una barra de acero est�ndar de 20m de largo, �sta 
 * tiene que adaptarse a los marcos que se van a construir; aparte, las �rdenes de las barras de acero son est�ndares y solo se 
 * pueden realizar una vez a la semana, podemos hacer la cantidad de �rdenes que queramos, las cuales constan �nicamente de 
 * 10 barras de acero con un costo de $50000 pesos por orden, pero solo podemos ordenar una vez por semana.
 * 
 El punto del problema es maximizar las ganancias pidiendo la menor cantidad posible de �rdenes y desperdiciando la menor 
 cantidad de barras posibles, ya que si cortamos una barra y nos sobra 2m de una barra y ocupamos 4m para un lado, tendremos 
 que usar una barra completamente nueva y cortarla para usar los 4m, desperdiciando otros 6m restantes, lo que nos dar�a un 
 total de 8m desperdiciados. Supongamos que se realizan una cantidad de pedidos en un tiempo de 4 semanas. Se quiere maximizar las ganancias. */

public class ProblemaProgramacionLineal {
    public static void main(String[] args) {
    	// Funcion objetivo para maximizar las ganancias
        LinearObjectiveFunction funcionObjetivo = new LinearObjectiveFunction(new double[]{3500, 7000, 10500, -50000}, 0);

        // Restricciones
        LinearConstraint restriccionProduccion = new LinearConstraint(new double[]{2, 4, 6, -20}, Relationship.LEQ, 0);
        LinearConstraint restriccionMinimaOrdenes = new LinearConstraint(new double[]{0, 0, 0, 1}, Relationship.GEQ, 1);
        LinearConstraint restriccionMaximaOrdenes = new LinearConstraint(new double[]{0, 0, 0, 1}, Relationship.LEQ, 4);

        SimplexSolver solver = new SimplexSolver();
        OptimizationData[] datos = {new MaxIter(1000)};
        org.apache.commons.math3.optim.PointValuePair solucion = solver.optimize(funcionObjetivo, new LinearConstraint[]{restriccionProduccion, restriccionMinimaOrdenes, restriccionMaximaOrdenes}, GoalType.MAXIMIZE, datos);

        System.out.println("Cantidad de marcos chicos a producir: " + Math.round(solucion.getPoint()[0]));
        System.out.println("Cantidad de marcos medianos a producir: " + Math.round(solucion.getPoint()[1]));
        System.out.println("Cantidad de marcos grandes a producir: " + Math.round(solucion.getPoint()[2]));
        System.out.println("Cantidad de �rdenes de barras de acero a realizar: " + Math.round(solucion.getPoint()[3]));

        // Falta por arreglar
        System.out.println("Ganancias totales: $" + Math.round(solucion.getValue()));
    }
}
