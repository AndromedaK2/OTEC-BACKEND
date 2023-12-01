package OTEC.OTEC.Controllers.Calificaciones;

import OTEC.OTEC.Services.Calificaciones.CalificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calificaciones")
public class CalificacionController {
    @Autowired
    private CalificacionService calificacionServicel;
}
