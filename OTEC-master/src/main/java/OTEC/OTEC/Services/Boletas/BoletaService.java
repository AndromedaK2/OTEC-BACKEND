package OTEC.OTEC.Services.Boletas;

import OTEC.OTEC.Models.Alumnos.Alumno;
import OTEC.OTEC.Models.AlumnosCursos.AlumnoCurso;
import OTEC.OTEC.Models.AlumnosEstados.AlumnoEstado;
import OTEC.OTEC.Models.Aranceles.Arancel;
import OTEC.OTEC.Models.Boletas.Boleta;
import OTEC.OTEC.Models.Cursos.Curso;
import OTEC.OTEC.Repositories.Alumnos.IAlumnoRepository;
import OTEC.OTEC.Repositories.AlumnosCursos.IAlumnoCursoRepository;
import OTEC.OTEC.Repositories.AlumnosEstados.IAlumnoEstadoRepository;
import OTEC.OTEC.Repositories.Aranceles.IArancelRepository;
import OTEC.OTEC.Repositories.Boletas.IBoletaRepository;
import OTEC.OTEC.Repositories.Cursos.ICursoRepository;
import OTEC.OTEC.Services.AlumnosEstados.IAlumnoEstadoService;
import OTEC.OTEC.Services.Aranceles.IArancelService;
import OTEC.OTEC.Services.Correo.ICorreoService;
import OTEC.OTEC.Services.Cursos.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class BoletaService implements IBoletaService<Boleta> {
    @Autowired
    private IBoletaRepository iBoletaRepository;
    @Autowired
    private IAlumnoRepository iAlumnoRepository;
    @Autowired
    private IAlumnoCursoRepository iAlumnoCursoRepository;
    @Autowired
    private ICursoRepository iCursoRepository;
    @Autowired
    private IArancelRepository iArancelRepository;
    @Autowired
    private ICorreoService iCorreoService;
    @Autowired
    private IAlumnoEstadoRepository iAlumnoEstadoRepository;
    @Override
    public List<Boleta> findAll() {
        return iBoletaRepository.findAll();
    }

    @Override
    public Optional<Boleta> findById(Integer id) {
        return iBoletaRepository.findById(id);
    }

    @Override
    public Boleta findByIdEstudiante(Integer id) {
        List<Boleta> boletas = iBoletaRepository.findAll();
        for (var boleta : boletas) {
            if (Objects.equals(boleta.getIdalumno(), id)){
                return boleta;
            }
        }
        return null;
    }

    @Override
    public Boleta create(Boleta boleta) {
        Boleta boletaGenerada = iBoletaRepository.save(boleta);
        List<AlumnoCurso> alumnoCurso = iAlumnoCursoRepository.findAll().stream().filter(x -> x.getIdAlumno().equals(boleta.getIdalumno())).collect(Collectors.toList());;
        Alumno alumno = iAlumnoRepository.findAll().stream().filter(x -> x.getIdAlumno().equals(boleta.getIdalumno())).findAny()
                .orElse(null);
        Optional<AlumnoCurso> alumnoCurso1 = alumnoCurso.stream()
                .max(Comparator.comparingInt(AlumnoCurso::getIdAlumnoCurso));
        if (alumnoCurso1.isPresent()) {
            AlumnoCurso ultimoCursoAlumno = alumnoCurso1.get();
            Curso curso = iCursoRepository.findAll().stream().filter(x -> x.getIdcurso().equals(ultimoCursoAlumno.getIdCurso())).findAny()
                    .orElse(null);
            if(boleta.getDescripcion().toLowerCase().trim().contains("matricula")) {
                if(Objects.equals(curso.getValor(), boleta.getMonto())){
                    //enviar correo de pago completo
                    AlumnoEstado alumnoEstado = new AlumnoEstado();
                    alumnoEstado.setIdEstadoAlumno(2);
                    alumnoEstado.setFecha(new Date());
                    alumnoEstado.setIdAlumno(boleta.getIdalumno());
                    var alumnoEstadoRsp = iAlumnoEstadoRepository.save(alumnoEstado);

                    iCorreoService.EnvioEmail(boletaGenerada.getIdBoleta(), boleta.getMonto(), boleta.getDescripcion(), boleta.getMetodoPago(), alumno.getNombres()+" "+alumno.getApellidos());
                } else if (boleta.getMonto() < curso.getValor()) {
                    //pago parcial
                    int valor = curso.getValor();
                }
            }
            if(boleta.getDescripcion().toLowerCase().trim().contains("arancel")) {
                List<Arancel> aranceles = iArancelRepository.findAll();
                Arancel arancelDelCurso = null;
                for (Arancel  arancel :aranceles) {
                   if(arancel.getIdCurso().equals(curso.getIdcurso())){
                       arancelDelCurso = arancel;
                   }
                }
                if(arancelDelCurso != null){
                    if(Objects.equals(Integer.parseInt(arancelDelCurso.getMonto()), boleta.getMonto())){
                        //enviar correo de pago completo
                        iCorreoService.EnvioEmail(boletaGenerada.getIdBoleta(), boleta.getMonto(), boleta.getDescripcion(), boleta.getMetodoPago(), alumno.getNombres()+" "+alumno.getApellidos());
                    } else if (boleta.getMonto() < curso.getValor()) {
                        //pago parcial
                    }
                }else{
                    //no existe arancel para el curso
                }
            }
        } else {
            // No se encontraron elementos en la lista filtrada
        }
        return boletaGenerada;
    }

    @Override
    public Boleta update(Boleta boleta) {
        return iBoletaRepository.save(boleta);
    }

    @Override
    public void delete(Integer id) {
        iBoletaRepository.deleteById(id);

    }
}
