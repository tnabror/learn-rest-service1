package com.learn.app.dao;

import java.util.List;

import com.learn.app.model.Mahasiswa;;

public interface MahasiswaDao {
	List<Mahasiswa> getAllMahasiswa();
	Mahasiswa getByIdMahasiswa(int idMahasiswa);
	void addMahasiswa(Mahasiswa mahasiswa);
	void updateMahasiswa(Mahasiswa mahasiswa);
	void deleteMahasiswa(Mahasiswa mahasiswa);
	boolean mahasiswaExist(Mahasiswa mahasiswa);
}
