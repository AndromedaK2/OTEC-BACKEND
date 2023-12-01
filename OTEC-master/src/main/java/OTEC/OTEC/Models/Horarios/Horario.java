package OTEC.OTEC.Models.Horarios;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "horarios") //estaba alegando porque la tabla se llama user
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Horario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idhorario")
    private Integer idHorario;
    @Column(name = "rangohora")
    private String rangoHora;
    @Column(name = "rangodia")
    private String rangoDia;
}
