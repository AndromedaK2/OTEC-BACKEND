package OTEC.OTEC.Models.AlumnosCursos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "alumnoscursos") //estaba alegando porque la tabla se llama user
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlumnoCurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idalumnocurso")
    private Integer idAlumnoCurso;
    @Column(name = "idalumno")
    private Integer idAlumno;
    @Column(name = "idcurso")
    private Integer idCurso;

}
