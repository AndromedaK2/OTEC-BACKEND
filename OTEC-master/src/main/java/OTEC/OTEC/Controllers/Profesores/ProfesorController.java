package OTEC.OTEC.Controllers.Profesores;

import OTEC.OTEC.Services.Profesores.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profesor")
public class ProfesorController {
    @Autowired
    private ProfesorService profesorService;
}
