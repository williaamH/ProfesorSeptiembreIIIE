package idatcom.ProfesorMicroServicioIIIE.servicio;

import java.util.List;

import idatcom.ProfesorMicroServicioIIIE.dto.ProfesorDTO;

public interface ProfesorService {
	
	List<ProfesorDTO> listar();
	ProfesorDTO obtener(Integer idProfesor);
	void guardar(ProfesorDTO profesor);
	void actualizar(ProfesorDTO profesor);
	void eliminar(Integer idProfesor);

}
