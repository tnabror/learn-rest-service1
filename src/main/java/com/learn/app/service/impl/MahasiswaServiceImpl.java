package com.learn.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.app.dao.MahasiswaDao;
import com.learn.app.model.Mahasiswa;
import com.learn.app.service.MahasiswaService;
@Service
public class MahasiswaServiceImpl implements MahasiswaService{

	@Autowired
	private MahasiswaDao mahasiswaDao;
	
	@Override
	public List<Mahasiswa> getAllMahasiswa() {
		return mahasiswaDao.getAllMahasiswa();
	}

	@Override
	public Mahasiswa getByIdMahasiswa(int idMahasiswa) {
		return mahasiswaDao.getByIdMahasiswa(idMahasiswa);
	}

	@Override
	public synchronized boolean addMahasiswa(Mahasiswa mahasiswa) {
		if(mahasiswaDao.mahasiswaExist(mahasiswa)){
			return false;
		}else{
			mahasiswaDao.addMahasiswa(mahasiswa);
			return true;
		}
	}

	@Override
	public void updateMahasiswa(Mahasiswa mahasiswa) {
		mahasiswaDao.updateMahasiswa(mahasiswa);
	}

	@Override
	public void deleteMahasiswa(Mahasiswa mahasiswa) {
		mahasiswaDao.deleteMahasiswa(mahasiswa);
		
	}

}
