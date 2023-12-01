package OTEC.OTEC.Models.Cursos;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "cursos") //estaba alegando porque la tabla se llama user
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcurso")
    private Integer idcurso;
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "fechainicio")
    private Date fechaInicio;
    @Column(name = "fechafin")
    private Date fechaFin;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "nivel")
    private Integer nivel;
    @Column(name = "modalidad")
    private String modalidad;
    @Column(name = "valor")
    private Integer valor;
    @Column(name = "activo")
    private Boolean activo;
    @Column(name = "idhorario")
    private Integer idHorario;
    @Column(name = "idprofesor")
    private Integer idProfesor;
    @Column(name = "idcategoria")
    private Integer idCategoria;
}
