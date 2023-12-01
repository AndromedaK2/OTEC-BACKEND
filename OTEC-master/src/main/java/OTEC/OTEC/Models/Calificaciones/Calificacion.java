package OTEC.OTEC.Models.Calificaciones;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "calificaciones") //estaba alegando porque la tabla se llama user
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Calificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcalificacion")
    private Integer idCalificacion;
    @Column(name = "nombrecurso")
    private String nombreCurso;
    @Column(name = "nota")
    private Integer nota;
    @Column(name = "nombreprofesor")
    private String nombreProfesor;
    @Column(name = "estadocalificacion")
    private String estadoCalificacion;
    @Column(name = "idalumno")
    private Integer idAlumno;
}
