package OTEC.OTEC.Controllers.Horarios;

import OTEC.OTEC.Services.Horarios.HorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/horario")
public class HorarioController {
    @Autowired
    private HorarioService horarioService;
}
