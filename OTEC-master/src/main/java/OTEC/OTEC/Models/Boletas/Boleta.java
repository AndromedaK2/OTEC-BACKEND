package OTEC.OTEC.Models.Boletas;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "boletas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Boleta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idboleta")
    private Integer idBoleta;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
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
    private Integer idalumno;

}
