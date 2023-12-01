package OTEC.OTEC.Models.Aranceles;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "aranceles") //estaba alegando porque la tabla se llama user
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Arancel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idarancel")
    private Integer idArancel;
    @Column(name = "monto")
    private String monto;
    @Column(name = "fechaarancel")
    private String fechaArancel;
    @Column(name = "idcuro")
    private Integer idCurso;
}
