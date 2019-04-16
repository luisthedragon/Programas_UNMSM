
package newpackage;

public class REGTASPRIM {
    private String nombre;
    private String tipo;
    private double valor;

    public REGTASPRIM() {
    }

    public REGTASPRIM(String nombre, String tipo, double valor) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
}
