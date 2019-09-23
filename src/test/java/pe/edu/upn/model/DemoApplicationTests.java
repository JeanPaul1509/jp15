package pe.edu.upn.model;

import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import pe.edu.upn.model.entity.Consultorio;
import pe.edu.upn.model.entity.Especialidad;
import pe.edu.upn.model.entity.Medico;
import pe.edu.upn.model.entity.Paciente;
import pe.edu.upn.model.repository.ConsultorioRepository;
import pe.edu.upn.model.repository.EspecialidadRepository;
import pe.edu.upn.model.repository.MedicoRepository;
import pe.edu.upn.model.repository.PacienteRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	@Autowired
	private MedicoRepository medicoRepository;
	@Autowired
	private PacienteRepository pacienteRepository;
	@Autowired
	private EspecialidadRepository especialidadRepository;
	@Autowired
	private ConsultorioRepository consultorioRepository;

	@Test
	public void contextLoads() {
		//paciente 
		//Recupereando un paciente antiguo
	Paciente antiguo = null;	
	Optional<Paciente>	caja= pacienteRepository.findById("N01");
	if(caja.isPresent());	
	antiguo = caja.get();
	
Paciente carlos = new Paciente();
carlos.setCodigo("N02");
carlos.setNombre("Jesus Mendoza");
carlos.setDireccion("jr. Breña");
carlos.setTelefono(12345646);
carlos.setFechaNacimiento(new Date(2019,9,9));


Paciente jose = new Paciente();
carlos.setCodigo("N03");
carlos.setNombre("Jose  nazares");
carlos.setDireccion("jr. Breña");
carlos.setTelefono(12345784);
carlos.setFechaNacimiento(new Date(2019,9,9));

//medicos

Medico medico1 = new Medico();
medico1.setNombre("medico 1");

Medico medico2 = new Medico();
medico2.setNombre("medico 2");

Medico medico3 = new Medico();
medico3.setNombre("medico 3");

//Especialidad

Especialidad cirujano = new Especialidad();
cirujano.setCodigo("E01");
cirujano.setNombre("cirujano");

Especialidad cardiologo = new Especialidad();
cardiologo.setCodigo("E02");
cardiologo.setNombre("cardiologo");

Especialidad ginecologo = new Especialidad();
ginecologo.setCodigo("E02");
ginecologo.setNombre("ginecologo");

//CONSULTORIO
Consultorio consultorio1 = new Consultorio();
consultorio1.setNombre("consultorio1");

Consultorio consultorio2 = new Consultorio();
consultorio2.setNombre("consultorio2");

Consultorio consultorio3 = new Consultorio();
consultorio3.setNombre("consultorio3");

//Relaciones pacientes-*medicos
antiguo.setMedico(medico1);
carlos.setMedico(medico1);

//Relaciones medicos-pacientes
medico3.addPaciente(jose);

//RELACION MEDIO-ESPECIALIDAD
medico1.setEspecialidad(ginecologo);
medico2.setEspecialidad(ginecologo);

//relacion especialidad-medico
cardiologo.addMedico(medico3);



Paciente paciente= pacienteRepository.save(antiguo);
assertTrue(paciente.getCodigo().equals("nª1"));
	
	}

}
