package OTEC.OTEC.Models.AlumnosEstados;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "alumnosestados") //estaba alegando porque la tabla se llama user
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlumnoEstado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idalumnoestado")
    private Integer idAlumnoCurso;
    @Column(name = "fecha")
    private Date fecha;
    @Column(name = "idalumno")
    private Integer idAlumno;
    @Column(name = "idestadoalumno")
    private Integer idEstadoAlumno;
}
