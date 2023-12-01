package OTEC.OTEC.Controllers.Roles;

import OTEC.OTEC.Services.Roles.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rol")
public class RolController {

    @Autowired
    private RolService rolService;
}
