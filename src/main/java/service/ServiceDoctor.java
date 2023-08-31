package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import entity.Doctor;
import jakarta.persistence.EntityNotFoundException;
import repository.DoctorRepository;


@Service
public class ServiceDoctor {
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	public Doctor createDoctor(Doctor doctor) {
		
		return doctorRepository.save(doctor);
	}
	public void deleteDoctor(Long IdDoctor) {
		
		doctorRepository.deleteById(IdDoctor);
	}
	public List <Doctor> listDoctor(){
		
		return doctorRepository.findAll();
	}
	public Doctor findDoctorById(Long idDoctor) {
		
		return doctorRepository.findById(idDoctor)
				.orElseThrow(()-> new EntityNotFoundException("Doutor não esxiste"));	
	}
	public Doctor updateDoctor(Long idDoctor, Doctor updatedDoctor) {
		
		Doctor doctor = findDoctorById(idDoctor);
		doctor.setName(updatedDoctor.getName());
		doctor.setCrm(updatedDoctor.getCrm());
		doctor.setSpecialty(updatedDoctor.getSpecialty());
		return doctorRepository.save(doctor);
		
	}
}
