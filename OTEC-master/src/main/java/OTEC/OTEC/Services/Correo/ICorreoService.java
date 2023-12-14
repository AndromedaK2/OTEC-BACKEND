package OTEC.OTEC.Services.Correo;

public interface ICorreoService<T> {
    void EnvioEmail(int idBoleta, int montoPagado, String detalle,String formaPago, String nombres, String email);
}
