package OTEC.OTEC.Services.Calificaciones;

import OTEC.OTEC.Models.Alumnos.Alumno;
import OTEC.OTEC.Models.Calificaciones.Calificacion;
import OTEC.OTEC.Models.Calificaciones.CrearCalificacion;
import OTEC.OTEC.Models.Calificaciones.ModificarCalificacion;
import OTEC.OTEC.Repositories.Calificaciones.ICalificacionRepository;
import OTEC.OTEC.Services.Alumnos.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CalificacionService implements ICalificacionService<Calificacion> {

    @Autowired
    private ICalificacionRepository iCalificacionRepository;

    @Autowired
    private AlumnoService alumnoService;

    @Override
    public List<Calificacion> findAll() {
        return iCalificacionRepository.findAll();
    }

    @Override
    public Optional<Calificacion> findById(Integer id) {
        return iCalificacionRepository.findById(id);
    }

    @Override
    public Calificacion create(Calificacion calificacion) {
        return iCalificacionRepository.save(calificacion);
    }

    @Override
    public Calificacion update(Calificacion calificacion) {
        return iCalificacionRepository.save(calificacion);
    }

    @Override
    public void delete(Integer id) {
        iCalificacionRepository.deleteById(id);

    }

    public Calificacion crearCalificacion(CrearCalificacion calificacion){
        Calificacion calificacion1 = new Calificacion();


        calificacion1.setNombreCurso(calificacion.nombreCurso());
        calificacion1.setEstadoCalificacion(calificacion.EstadoCalificacion());
        calificacion1.setNota(calificacion.Nota());
        calificacion1.setNombreProfesor(calificacion.Profesor());

        List<Alumno>alumnos = alumnoService.findAll();
        for(int i=0; i<alumnos.size();i++){
            if(alumnos.get(i).getNombres().equals(calificacion.NombreAlumno())){
        calificacion1.setIdAlumno(alumnos.get(i).getIdAlumno());}

        }

        if(calificacion1.getIdAlumno() == null){
            return null;
        }else {
            return iCalificacionRepository.save(calificacion1);

        }

    }

    public Optional<Calificacion> BuscarCalificacionPorNombre(String nombre){
        List<Alumno>alumnos = alumnoService.findAll();

        for(int i =0; i<alumnos.size();i++){
            if(alumnos.get(i).getNombres().equals(nombre)){
            return iCalificacionRepository.findByIdAlumno(alumnos.get(i).getIdAlumno());}
        }
        return null;
    }

    public Optional<Calificacion> BuscarCalificacionPorRut(String rut){
        List<Alumno>alumnos = alumnoService.findAll();

        for(int i =0; i<alumnos.size();i++){
            if(alumnos.get(i).getRut().equals(rut)){
                return iCalificacionRepository.findByIdAlumno(alumnos.get(i).getIdAlumno());}
        }
        return null;
    }


    public Calificacion Modificarcalificacion(ModificarCalificacion modificarCalificacion){
        List<Calificacion> calificacions =iCalificacionRepository.findAll();
        List<Alumno>alumnos = alumnoService.findAll();


        for (int i =0 ; i< alumnos.size();i++){

            if(alumnos.get(i).getNombres().equals(modificarCalificacion.NombreAlumno())){

                for (int a = 0 ; a<calificacions.size();a++){

                    if(calificacions.get(a).getNombreCurso().equals(modificarCalificacion.NombreCurso()) &&
                    calificacions.get(a).getNombreProfesor().equals(modificarCalificacion.Profesor())&&
                    calificacions.get(a).getIdAlumno().equals(alumnos.get(i).getIdAlumno())){

                        Calificacion calificacion = calificacions.get(a);
                        calificacion.setNota(modificarCalificacion.Nota());
                        calificacion.setEstadoCalificacion(modificarCalificacion.Estado());
                       return iCalificacionRepository.save(calificacion);


                    }
                }

            }


        }

        return null;

    }
}
