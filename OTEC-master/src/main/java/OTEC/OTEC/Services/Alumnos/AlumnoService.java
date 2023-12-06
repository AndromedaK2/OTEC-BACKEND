package OTEC.OTEC.Services.Alumnos;

import OTEC.OTEC.Models.Alumnos.Alumno;
import OTEC.OTEC.Models.Alumnos.CrearAlumno;
import OTEC.OTEC.Repositories.Alumnos.IAlumnoRepository;
import OTEC.OTEC.Services.Alumnos.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AlumnoService implements IAlumnoService<Alumno> {

    @Autowired
    private IAlumnoRepository iAlumnoRepository;
    @Override
    public List<Alumno> findAll() {
        return iAlumnoRepository.findAll();
    }

    @Override
    public Optional<Alumno> findById(Integer id) {
        return iAlumnoRepository.findById(id);
    }

    @Override
    public Alumno create(Alumno alumno) {
        return iAlumnoRepository.save(alumno);
    }

    @Override
    public Alumno update(Alumno alumno) {
        return iAlumnoRepository.save(alumno);
    }

    @Override
    public void delete(Integer id) {
        iAlumnoRepository.deleteById(id);

    }

    public Alumno crearAlumno(CrearAlumno crearAlumno){
        Alumno alumno = new Alumno();

        alumno.setNombres(crearAlumno.nombres());
        alumno.setApellidos(crearAlumno.apellidos());
        alumno.setRut(crearAlumno.rut());
        alumno.setCorreo(crearAlumno.correo());
        alumno.setSexo(crearAlumno.sexo());
        alumno.setDireccion(crearAlumno.direccion());


        return iAlumnoRepository.save(alumno);
    }

   public Optional<Alumno> BuscarPornombre(String nombres){


        return iAlumnoRepository.findByNombres(nombres);
   }
    public Optional<Alumno> BuscarPorRut(String rut){


        return iAlumnoRepository.findByRut(rut);
    }


}
