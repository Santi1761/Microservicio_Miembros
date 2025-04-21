package co.analisys.gimnasio.miembros.dto;

public class PagoDTO {
    private String idMiembro;
    private double monto;

    public PagoDTO() {}

    public PagoDTO(String idMiembro, double monto) {
        this.idMiembro = idMiembro;
        this.monto = monto;
    }

    public String getIdMiembro() { return idMiembro; }
    public void setIdMiembro(String idMiembro) { this.idMiembro = idMiembro; }

    public double getMonto() { return monto; }
    public void setMonto(double monto) { this.monto = monto; }
}
