package OTEC.OTEC.Controllers.Boletas;

import OTEC.OTEC.Services.Boletas.BoletaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/boleta")
public class BoletaController {
    @Autowired
    private BoletaService boletaService;
}
