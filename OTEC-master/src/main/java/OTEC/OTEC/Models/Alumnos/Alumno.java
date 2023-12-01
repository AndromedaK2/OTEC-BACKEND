package OTEC.OTEC.Models.Alumnos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "alumnos") //estaba alegando porque la tabla se llama user
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idalumno")
    private Integer idAlumno;
    @Column(name = "nombres")
    private String nombres;
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "correo")
    private String correo;
    @Column(name = "sexo")
    private char sexo;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "rut")
    private String rut;
}
