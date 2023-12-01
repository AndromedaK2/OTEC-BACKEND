package OTEC.OTEC.Models.EstadosAlumnos;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "estadosalumnos") //estaba alegando porque la tabla se llama user
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstadosAlumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idestadoalumno")
    private Integer idEstadoAlumno;
    @Column(name = "descripcion")
    private String descripcion;
}
