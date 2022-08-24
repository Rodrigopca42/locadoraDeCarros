package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrazilTaxService;
import model.services.RentalService;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner tec = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:ss");
		
		System.out.println("Insira os dados de aluguel");
		System.out.print("Modelo do carro: ");
		String model = tec.nextLine();
		
		System.out.print("Retirada (dd/MM/yyyy hh:mm): ");
		Date start =sdf.parse(tec.nextLine());
		
		System.out.print("Devolução (dd/MM/yyyy hh:mm): ");
		Date finish =sdf.parse(tec.nextLine());
		
		CarRental cr = new CarRental(start, finish, new Vehicle(model));
		
		System.out.print("Insira o preço por hora: ");
		double pricePerHour = tec.nextDouble();
		
		System.out.print("Insira o preço por dia: ");
		double pricePerDay = tec.nextDouble();
		
		RentalService rentalService = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());
		
		rentalService.processInvoice(cr);
		
		System.out.println("FATURA: ");
		System.out.println("Pagamento Básico: R$" + String.format("%.2f", cr.getInvoice().getBasicPayment()));
		System.out.println("Taxa: R$" + String.format("%.2f", cr.getInvoice().getTax()));
		System.out.println("Pagamento Total: R$" + String.format("%.2f", cr.getInvoice().getTotalPayment()));
		
		tec.close();
		

	}

}
