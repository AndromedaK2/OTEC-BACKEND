package OTEC.OTEC.Controllers.Aranceles;

import OTEC.OTEC.Services.Aranceles.ArancelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/arancel")
public class ArancelController {
    @Autowired
    private ArancelService arancelService;
}
