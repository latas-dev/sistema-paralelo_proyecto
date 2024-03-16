import java.util.Vector;
import java.util.Map;
import java.util.List;
import java.util.HashMap;

public class Cortes {
	public static void main(String[] args) {
		// Perfiles de corte disponibles 
		String[] profileSizes = {"4545F", "4580F", "4590F"};
		
		Vector<Pedido> orden = new Vector<Pedido>();
		
		// Ejemplos de Pedidos
		orden.add(new Pedido(profileSizes[0], profileSizes[0], 1650, 1100));
		orden.add(new Pedido(profileSizes[2], profileSizes[0], 480, 870));
		orden.add(new Pedido(profileSizes[2], profileSizes[2], 2040, 750));
		orden.add(new Pedido(profileSizes[0], profileSizes[2], 1000, 540));
		orden.add(new Pedido(profileSizes[2], profileSizes[0], 480, 729));
		orden.add(new Pedido(profileSizes[2], profileSizes[0], 1100, 1170));
		orden.add(new Pedido(profileSizes[2], profileSizes[0], 568, 468));
		orden.add(new Pedido(profileSizes[2], profileSizes[0], 568, 280));
		
		printOrden(orden);
		System.out.println("");
		
		// Se crea una HashMap con una lista de longitudes de barra organizada por perfil
		Map<String, List<Integer>> lengthsByProfile = new HashMap<>();
        for (Pedido pedido : orden) {
            pedido.addLengthToProfile(lengthsByProfile, pedido.firstProfile, pedido.firstLength);
            pedido.addLengthToProfile(lengthsByProfile, pedido.secondProfile, pedido.secondLength);
        }

        // Imprime las longitudes por perfil
        for (Map.Entry<String, List<Integer>> entry : lengthsByProfile.entrySet()) {
            String profile = entry.getKey();
            List<Integer> lengths = entry.getValue();
            System.out.println("Profile: " + profile);
            System.out.println("Lengths: " + lengths);
        }
        
        Vector<Barras> resultados = cortar(lengthsByProfile);
        
        // Imprime la cantidad de barras de 6050mm usadas.
        // Imprime la cantidad de milimetros desperdiciados.
        // Imprime el nombre de perfil y la última suma de longitudes.
        System.out.println("");
        for(Barras barra : resultados) {
        	barra.printProperties();
        }
	}
	
	public static void printOrden(Vector<Pedido> orden) {
		for(Pedido pedido : orden) {
			System.out.println(pedido.firstProfile + " " + pedido.firstLength + "mm + " + pedido.secondProfile + " " + pedido.secondLength + "mm");
		}
	}
	
	private static Vector<Barras> cortar(Map<String, List<Integer>> lengthsByProfile) {
        Vector<Barras> barrasVector = new Vector<Barras>();
        for (Map.Entry<String, List<Integer>> entry : lengthsByProfile.entrySet()) {
            String profile = entry.getKey();
            List<Integer> lengths = entry.getValue();
            
            Barras barras = new Barras(profile);
            for (int length : lengths) {
                barras.addCut(length);
            }
            barrasVector.add(barras);
        }
        return barrasVector;
    }
}
