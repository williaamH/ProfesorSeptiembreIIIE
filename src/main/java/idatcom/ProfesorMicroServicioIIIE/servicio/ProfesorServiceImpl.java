package idatcom.ProfesorMicroServicioIIIE.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idatcom.ProfesorMicroServicioIIIE.dto.ProfesorDTO;
import idatcom.ProfesorMicroServicioIIIE.model.Profesor;
import idatcom.ProfesorMicroServicioIIIE.repository.ProfesorRepository;

@Service
public class ProfesorServiceImpl implements ProfesorService {

	@Autowired
	private ProfesorRepository repository;
	
	@Override
	public List<ProfesorDTO> listar() {
		
		List<ProfesorDTO> listadto = new ArrayList<>();
		ProfesorDTO dto = null;
		
		for(Profesor profesor : repository.findAll()) {
			dto = new ProfesorDTO();
			dto.setApe(profesor.getApellido());
			dto.setNom(profesor.getNombre());
			dto.setCod(profesor.getIdProfesor());
			
			listadto.add(dto);
		}
		return listadto;
		
	}

	@Override
	public ProfesorDTO obtener(Integer idProfesor) {
		
		Profesor profesor = repository.findById(idProfesor).orElse(null);
		
		ProfesorDTO dto = new ProfesorDTO();
		dto = new ProfesorDTO();
		dto.setApe(profesor.getApellido());
		dto.setNom(profesor.getNombre());
		dto.setCod(profesor.getIdProfesor());
		
		return dto;
	}

	@Override
	public void guardar(ProfesorDTO profesor) {
		
		Profesor pro = new Profesor();
		pro.setApellido(profesor.getApe());
		pro.setNombre(profesor.getNom());
		pro.setIdProfesor(profesor.getCod());
		repository.save(pro);

	}

	@Override
	public void actualizar(ProfesorDTO profesor) {
		
		Profesor pro = new Profesor();
		pro.setApellido(profesor.getApe());
		pro.setNombre(profesor.getNom());
		pro.setIdProfesor(profesor.getCod());
		repository.saveAndFlush(pro);

	}

	@Override
	public void eliminar(Integer idAlumno) {
		
		repository.deleteById(idAlumno);
		
	}

}
