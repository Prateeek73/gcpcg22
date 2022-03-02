package com.trainingapps.schoolps.dao;

import com.trainingapps.schoolps.dao.IStudentDao;
import com.trainingapps.schoolps.entity.Student;
import java.util.*;

public class StudentDaoImpl implements IStudentDao{
	private Map<Integer, Student> store = new HashMap<>();
	@Override
	public void add(Student student){
		store.put(student.getId(), student);
	}
	@Override
	public Student findById(int id){
		Student student = store.get(id);
		return student;
	}
	@Override
	public List<Student> findAll(){
		Collection<Student> values = store.values();
		List<Student> list = new ArrayList<>();
		list.addAll(values);
		return list;
	}
//	@Override
//	public void updateName(int id, String name){
//		Student student = store.get(id);
//		student.setName(name);
//	}
//	@Override
//	public void updateAge(int id, int age){
//		Student student = store.get(id);
//		student.setAge(age);
//	}
//	@Override
//	public void updateNameAndAge(int id, String name, int age){
//		Student student = store.get(id);
//		student.setName(name);
//		student.setAge(age);
//	}
	@Override
	public void deleteById(int id){
		store.remove(id);	
	}
}