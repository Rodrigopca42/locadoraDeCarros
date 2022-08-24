package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.CarRental;
import model.entities.Vehicle;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner tec = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:ss");
		
		System.out.println("Insira os dados de aluguel");
		System.out.print("Modelo do carro: ");
		String model = tec.nextLine();
		
		System.out.print("Retirada (dd/MM/yyyy hh:mm): ");
		Date start =sdf.parse(tec.next());
		
		System.out.print("Devolução (dd/MM/yyyy hh:mm): ");
		Date finish =sdf.parse(tec.next());
		
		CarRental cr = new CarRental(start, finish, new Vehicle(model));
		
		
		
		tec.close();
		

	}

}
