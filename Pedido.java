import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

public class Pedido {
	public String firstProfile;
	public String secondProfile;
	public int firstLength;
	public int secondLength;
	
	public Pedido(String profile1, String profile2, int length1, int length2) {
		this.firstProfile = profile1;
		this.secondProfile = profile2;
		this.firstLength = length1;
		this.secondLength = length2;
	}

    public Map<String, List<Integer>> getLengthsByProfile() {
        Map<String, List<Integer>> lengthsByProfile = new HashMap<>();
        addLengthToProfile(lengthsByProfile, firstProfile, firstLength);
        addLengthToProfile(lengthsByProfile, secondProfile, secondLength);
        return lengthsByProfile;
    }

    public void addLengthToProfile(Map<String, List<Integer>> lengthsByProfile, String profile, int length) {
        if (!lengthsByProfile.containsKey(profile)) {
            lengthsByProfile.put(profile, new ArrayList<Integer>());
        }
        lengthsByProfile.get(profile).add(length);
    }

}
