package com.learn.app.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.learn.app.dao.MahasiswaDao;
import com.learn.app.model.Mahasiswa;

@Transactional
@Repository
public class MahasiswaDaoImpl implements MahasiswaDao {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Mahasiswa> getAllMahasiswa() {
		try {
			String hql = "FROM Mahasiswa as mhs ORDER BY mhs.id";
			return (List<Mahasiswa>) entityManager.createQuery(hql).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Mahasiswa getByIdMahasiswa(int idMahasiswa) {
		try {
			return entityManager.find(Mahasiswa.class, idMahasiswa);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void addMahasiswa(Mahasiswa mahasiswa) {
		try {
			entityManager.persist(mahasiswa);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateMahasiswa(Mahasiswa mahasiswa) {
		try {
			Mahasiswa mhs = getByIdMahasiswa(mahasiswa.getId());
			mhs.setNama(mahasiswa.getNama());
			mhs.setNip(mahasiswa.getNip());
			mhs.setAsal(mahasiswa.getAsal());
			entityManager.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteMahasiswa(Mahasiswa mahasiswa) {
		try {
			entityManager.remove(getByIdMahasiswa(mahasiswa.getId()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean mahasiswaExist(Mahasiswa mahasiswa) {
		try {
			String hql = "FROM Mahasiswa as mhs WHERE mhs.nama = ? AND mhs.nip = ? AND mhs.asal = ?";
			int count = entityManager.createQuery(hql).setParameter(1, mahasiswa.getNama())
					.setParameter(2, mahasiswa.getNip()).setParameter(3, mahasiswa.getAsal()).getResultList().size();
			return count > 0 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
