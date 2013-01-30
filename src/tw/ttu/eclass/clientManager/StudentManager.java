package tw.ttu.eclass.clientManager;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import entity.Student;

import tw.ttu.eclass.rmi.interfaces.StudentService;


public class StudentManager {
	StudentService studentService;
	public StudentManager() {
		try {
			Registry registry = LocateRegistry.getRegistry("140.129.19.238");
			studentService = (StudentService) registry.lookup("studentService");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	
	public Student getStudentByStudentId(int studentId){
		try {
			return studentService.getStudentByStudentId(studentId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	public Student getStudentByAccount(String account){
		try {
			return studentService.getStudentByAccount(account);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public String getStudentNameByStudentId(int studentId){
		try {
			return studentService.getStudentNameByStudentId(studentId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	public byte[] getStudentPhotoByStudentId(int studentId){
		try {
			return studentService.getStudentPhotoByStudentId(studentId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
}
