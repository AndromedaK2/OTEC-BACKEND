package OTEC.OTEC.Models.Usuarios;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario")
    private Integer idUsuario;
    @Column(name = "nombreusuario")
    private String nombreUsuario;
    @Column(name = "pass")
    private String pass;
    @Column(name = "correo")
    private String correo;
    @Column(name = "telefono")
    private Integer telefono;
    @Column(name = "rut")
    private String rut;
    @Column(name = "idrol")
    private Integer idRol;
}
