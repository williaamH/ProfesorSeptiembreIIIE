package idatcom.ProfesorMicroServicioIIIE.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import idatcom.ProfesorMicroServicioIIIE.dto.ProfesorDTO;
import idatcom.ProfesorMicroServicioIIIE.servicio.ProfesorService;

@Controller
@RequestMapping("api/profesor/v1")
public class ProfesorController {
	
	@Autowired
	private ProfesorService service;

	@GetMapping("/hola")
	public @ResponseBody String hola() {
		return "hola querido profesor";
	}
	
	@GetMapping("/listar")
	public @ResponseBody List<ProfesorDTO> listar(){
		return service.listar();
	}
	
	@GetMapping("/listar/{id}")
	public @ResponseBody ProfesorDTO obtenerId(@PathVariable Integer id) {
		return service.obtener(id);
	}
	
	@PostMapping("/guardar")
	public @ResponseBody void guardar(@RequestBody ProfesorDTO dto) {
		service.guardar(dto);
	}
	
	@PutMapping("/actualizar")
	public @ResponseBody void actualizar(@RequestBody ProfesorDTO dto) {
		service.actualizar(dto);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public @ResponseBody void eliminar(@PathVariable Integer id) {
		service.eliminar(id);
	}
}
