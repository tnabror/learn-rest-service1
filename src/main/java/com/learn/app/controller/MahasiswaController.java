package com.learn.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.learn.app.model.Mahasiswa;
import com.learn.app.service.MahasiswaService;

@Controller
@RequestMapping("user")
public class MahasiswaController {
	@Autowired
	private MahasiswaService mahasiswaService;
	
	@GetMapping("mahasiswas")
	public ResponseEntity<List<Mahasiswa>> getAllMahasiswa(){
		List<Mahasiswa> listMahasiswa = mahasiswaService.getAllMahasiswa();
		return new ResponseEntity<List<Mahasiswa>>(listMahasiswa, HttpStatus.OK);
	}
	
	@GetMapping("mahasiswa/{id}")
	public ResponseEntity<Mahasiswa> getMahasiswa(@PathVariable("id") Integer id){
		Mahasiswa mhs = mahasiswaService.getByIdMahasiswa(id);
		return new ResponseEntity<Mahasiswa>(mhs, HttpStatus.OK);
	}
	
	@PostMapping("mahasiswa")
	public ResponseEntity<Void> addMahasiswa(@RequestBody Mahasiswa mahasiswa, UriComponentsBuilder builder){
		boolean flag = mahasiswaService.addMahasiswa(mahasiswa);
		if(flag == false){
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/mahasiswa/{id}").buildAndExpand(mahasiswa.getId()).toUri());
		
		return new ResponseEntity<>(headers,HttpStatus.CREATED);
	}
	
	@PutMapping("mahasiswa")
	public ResponseEntity<Void> updateMahasiswa(@RequestBody Mahasiswa mahasiswa){
		mahasiswaService.updateMahasiswa(mahasiswa);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping("mahasiswa/{id}")
	public ResponseEntity<Void> deleteMahasiswa(@PathVariable("id") Integer id ){
		Mahasiswa mhs = mahasiswaService.getByIdMahasiswa(id);
		mahasiswaService.deleteMahasiswa(mhs);
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
}
