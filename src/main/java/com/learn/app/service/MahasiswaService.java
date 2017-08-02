package com.learn.app.service;

import java.util.List;

import com.learn.app.model.Mahasiswa;

public interface MahasiswaService {
	List<Mahasiswa> getAllMahasiswa();
	Mahasiswa getByIdMahasiswa(int idMahasiswa);
	boolean addMahasiswa(Mahasiswa mahasiswa);
	void updateMahasiswa(Mahasiswa mahasiswa);
	void deleteMahasiswa(Mahasiswa mahasiswa);
}
