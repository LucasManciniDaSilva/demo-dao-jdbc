package application;

import java.sql.Connection;
import java.util.Date;

import db.DB;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		Department dep = new Department(1, "jaison mendes");
		
		System.out.println(dep);
		
		Seller sellers = new Seller(1, "Paulo Guina", "PaunoGuina@gmail.com", new Date(), 2000.0, dep);
		
		System.out.println(sellers);
		

	}

}
