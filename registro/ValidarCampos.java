import java.util.Random;
import java.util.Scanner;

public class ValidarCampos {

    public static boolean validarCampos(String nombre, String email, String password) {
        ValidarNombre(nombre);


        CompruebaEmail(email);


        CompruebaPassword(password);

        return GenerarCodigoSeguridad(); 



    }

	public static boolean GenerarCodigoSeguridad(String codigoGenerado) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el codigo de seguridad: ");
        String codigoUsuario = scanner.nextLine();
        if (codigoGenerado.equals(codigoUsuario)) {
            return true;
        } else {
            System.out.println("error");
            return false;
        }
    }
		
	public static boolean CompruebaPassword(String password) {
		if (password.length() != 8) {
            System.out.println("Introduce una contraseña de al menos 8 carácteres");
            return false;
        }
        if (!Character.isUpperCase(password.charAt(0))) {
            System.out.println("La contraseña debe empezar por mayúsculas");
            return false;
        }
        if (!(password.contains("@") || password.contains("-") || password.contains("#") || password.contains("_"))) {
            System.out.println("La contraseña debe tener uno de los siguientes carácteres: @,#,-,_");
            return false;
        }
        if (!Character.isDigit(password.charAt(password.length() - 1)) || !Character.isDigit(password.charAt(password.length() - 2))) {
            System.out.println("La contraseña tiene que acabar en dos dígitos");
            return false;
        }
        return true;

	}

	public static boolean CompruebaEmail(String email) {
		String[] dominiosPermitidos = {"paucasesnovescifp", "yahoo", "gmail", "hotmail"};
        boolean dominioValido = false;
        if (!email.contains("@")) {
            System.out.println("Falta poner el arroba, @");
            return false;
        }
        for(String dominio : dominiosPermitidos) {
            if (email.contains("@" + dominio)) {
                dominioValido = true;
                break;
            }
        }
        if (!dominioValido) {
            System.out.println("Error de dominio");
            return false;
        }
        if (!(email.endsWith(".com") ||email.endsWith(".es") || email.endsWith(".cat"))) {
            System.out.println("Error de extensión");
            return false;
        }
        return dominioValido;
	}

	public static boolean ValidarNombre(String nombre) {
		if (nombre.length() > 16) {
            System.out.println("El nombre no puede tener más de 16 carácteres");
            return false;
        }
        if (!Character.isUpperCase(nombre.charAt(0))) {
            System.out.println("El nombre tiene que empezar por mayúsculas");
            return false;
        }
        for (int i = 1; i < nombre.length() - 4; i++) {
            if (Character.isUpperCase(nombre.charAt(i))) {
                System.out.println("Solo la primera letra del nombre tiene que estar en mayúsculas");
                return false;
            }
        }
        if (nombre.charAt(nombre.length() - 4) != '_' &&
            nombre.charAt(nombre.length() - 4) != '-') {
                System.out.println("Falta el guión o no está en la cuarta posición contando desde el final");
                return false;
        }
        for (int i = nombre.length() - 3; i < nombre.length(); i++) {
            if (!Character.isDigit(nombre.charAt(i))) {
                System.out.println("El nombre tiene que terminar con tres dígitos");
                return false;
            }
            
        }
        return true;
	}

}

