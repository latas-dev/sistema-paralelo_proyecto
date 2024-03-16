
public class Barras {
	public String perfil;
	private int longitud;
	private int cantidad;
	private int desperdicio;
	
	Public Barras(String perfil) {
		this.perfil = perfil;
		this.longitud = 0;
		this.cantidad = 0;
		this.desperdicio = 0;
	}
	
	public static void addCut(int longitud) {
		if(this.longitud + longitud < 6050) {
			this.longitud += longitud;
		} else if(this.longitud + longitud == 6050) {
			this.longitud = 0;
			this.cantidad++;
		} else {
			this.longitud = 0;
			this.desperdicio += 6050 - this.longitud;
			this.cantidad++;
		}
	}
	
	public void printProperties() {
        System.out.println("Perfil: " + perfil);
        System.out.println("Longitud: " + longitud);
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Desperdicio: " + desperdicio);
        System.out.println();
    }
}
