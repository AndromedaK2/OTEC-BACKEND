package OTEC.OTEC.Models.Profesores;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "profesores") //estaba alegando porque la tabla se llama user
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idprofesor")
    private Integer idProfesor;
    @Column(name = "nombres")
    private String nombres;
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "correo")
    private String correo;
    @Column(name = "telefono")
    private Integer telefono;
    @Column(name = "direccion")
    private String direccion;
}
