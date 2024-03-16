
public class Barras {
	public String perfil;
	private int longitud;
	private int cantidad;
	private int desperdicio;
	
	public Barras(String perfil) {
		this.perfil = perfil;
		this.longitud = 0;
		this.cantidad = 0;
		this.desperdicio = 0;
	}
	
	public void addCut(int longitud) {
		if(this.longitud + longitud < 6050) {
			this.longitud += longitud;
		} else if(this.longitud + longitud == 6050) {
			this.longitud = 0;
			this.cantidad++;
		} else if(this.longitud + longitud > 6050){
			this.desperdicio += 6050 - this.longitud;
			this.longitud = 0;
			this.cantidad++;
		} else {
			this.longitud = 0;
			this.cantidad = 0;
			this.desperdicio = 0;
		}
	}
	
	public void printProperties() {
        System.out.println("Perfil: " + perfil);
        System.out.println("Longitud (Milímetros): " + longitud);
        System.out.println("Cantidad de Barras usadas: " + cantidad);
        System.out.println("Milimetros desperdiciadps: " + desperdicio);
        System.out.println();
    }
}
