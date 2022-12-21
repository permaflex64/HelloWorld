package polito.paradigmaOO.lez20.university;

public class ExampleApp {

	public ExampleApp() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		String universityName = "Politecnico di Torino";
		
		University poli = new University(universityName);
		
		poli.setRector("Francesco", "Profumo");
		
		System.out.println("" + poli.getName() + " : " 
									+ poli.getRector());
		
		int s1 = poli.enroll("Mario", "Rossi");
		int s2 = poli.enroll("Giuseppe", "Verdi");
		
		System.out.println("Enrolled students " + s1 + ", " + s2);
		System.out.println("s1 = " + poli.studente(s1));
		System.out.println("s2 = " + poli.studente(s2));
		
		int macro = poli.activate("Macro Economics",
				"Paul Krugman");
		int oop = poli.activate("Object Oriented Programming",
				"Marco Tornaro");
		System.out.println("Activated courses " + macro 
							+ " and " + oop);
		System.out.println("c1 = " + poli.course(10));
		
		poli.register(s1, macro);
		poli.register(s2, macro);
		
		System.out.println(poli.listAttenders(macro));
		
	}

}
