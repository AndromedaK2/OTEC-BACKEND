package OTEC.OTEC.Models.Boletas;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "boletas") //estaba alegando porque la tabla se llama user
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Boleta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idboleta")
    private Integer idBoleta;
    @Column(name = "fecha")
    private Date fecha;
    @Column(name = "monto")
    private Integer monto;
    @Column(name = "metodopago")
    private String metodoPago;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "folio")
    private Integer folio;
    @Column(name = "idalumno")
    private Integer idAlumno;

}
