import java.util.Vector;
import java.util.Map;
import java.util.List;
import java.util.HashMap;

public class Cortes {
	public static void main(String[] args) {
		String[] profileSizes = {"4545F", "4580F", "4590F"};

		Vector<Pedido> orden = new Vector<Pedido>();
		
		orden.add(new Pedido(profileSizes[0], profileSizes[0], 1650, 1100));
		orden.add(new Pedido(profileSizes[2], profileSizes[0], 480, 870));
		orden.add(new Pedido(profileSizes[2], profileSizes[2], 2040, 750));
		orden.add(new Pedido(profileSizes[0], profileSizes[2], 1000, 540));
		
		printOrden(orden);
		
		Map<String, List<Integer>> lengthsByProfile = new HashMap<>();
        for (Pedido pedido : orden) {
            pedido.addLengthToProfile(lengthsByProfile, pedido.firstProfile, pedido.firstLength);
            pedido.addLengthToProfile(lengthsByProfile, pedido.secondProfile, pedido.secondLength);
        }

        // Print the lengths for each profile
        for (Map.Entry<String, List<Integer>> entry : lengthsByProfile.entrySet()) {
            String profile = entry.getKey();
            List<Integer> lengths = entry.getValue();
            System.out.println("Profile: " + profile);
            System.out.println("Lengths: " + lengths);
        }
		
	}
	
	public static void printOrden(Vector<Pedido> orden) {
		for(Pedido pedido : orden) {
			System.out.println(pedido.firstProfile + " " + pedido.firstLength + "mm + " + pedido.secondProfile + " " + pedido.secondLength + "mm");
		}
	}
}
