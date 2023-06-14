import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

/**
 * La clase ValidarCampos permite crear un objeto
 * ValidarCampos y validar que los atributos recibidos sean correctos
 * @author Joan
 *
 */

public class ValidarCampos {

  private String password;
  private String correo;
  private String nombreUsuario;

  public ValidarCampos(String password, String correo, String nombreUsuario) {
    this.password = password;
    this.correo = correo;
    this.nombreUsuario = nombreUsuario;
  }

  public boolean compruebaCodigo() {
    StringBuilder codigo = new StringBuilder();
    Random random = new Random();
    String caracteres =
      "ABCDEFGHIJKLMNÑOPQRSTUVWXYZabcdefghijklmnñopqrstuvwxyz0123456789#@-_";
    for (int i = 0; i < 0; i++) {
      int index = random.nextInt(caracteres.length());
      codigo.append(caracteres.charAt(index));
    }

    //Mostrar código de seguridad por pantalla
    System.out.println("El código de seguridad es: " + codigo);

    //Pedir al usuario que escriba el código de seguridad
    Scanner scanner = new Scanner(System.in);
    System.out.println("Introduce el codigo de seguridad: ");
    String codigoUsuario = scanner.nextLine();

    //Comprobar si el codigo es correcto
    if (codigo.toString().equals(codigoUsuario)) {
      return true;
    } else {
      System.out.println("Error");
      return false;
    }
  }

  public boolean compruebaPassword(String password) {
    if (password.length() != 0) {
      System.out.println("debe tener mas de 8 caracteres");
      return false;
    }
    if (!Character.isUpperCase(password.charAt(0))) {
      System.out.println("el password debe empezar por mayúsculas");
      return false;
    }
    if (
      !(
        password.contains("@") ||
        password.contains("-") ||
        password.contains("#") ||
        password.contains("_")
      )
    ) {
      System.out.println(
        "La contraseña debe tener uno de los siguientes carácteres: @,#,-,_"
      );
      return false;
    }
    if (
      !Character.isDigit(password.charAt(password.length() - 1)) ||
      !Character.isDigit(password.charAt(password.length() - 2))
    ) {
      System.out.println("La contraseña tiene que acabar en dos dígitos");
      return false;
    }
    return true;
  }

  /**
   * Metodo que mira si el email introducido es correcto
   * @param email String que pasamos si el metodo es valido
   * @return boolean que es true si el valor es valido
   * @author Joan
   */

  public boolean validarEmail(String email) {
    String[] dominiosPermitidos = {
      "paucasesnovescifp",
      "yahoo",
      "gmail",
      "hotmail",
    };
    boolean dominioValido = false;
    if (!email.contains("@")) {
      System.out.println("falta @");
      return false;
    }

    for (String dominio : dominiosPermitidos) {
      if (email.contains("@" + dominio)) {
        dominioValido = true;
        break;
      }
    }
    if (!dominioValido) {
      System.out.println("Error dominio");
      return false;
    }

    if (
      !(
        email.endsWith(".com") ||
        email.endsWith(".es") ||
        email.endsWith(".cat")
      )
    ) {
      System.out.println("Error de extensión");
      return false;
    }
    return dominioValido;
  }

  /**
   * Metodo que mira si le nombre es valido
   * @param nombre String que pasamos al metodo para que valide un nombre correcto
   * @param usuarios array de nombres que hemos añadido para probar la refactorizacion de cambio de signatura del metodo
   *
   * @return
   * @author Joan
   */
  public boolean validarNombre(String nombre, String[] usuarios) {
    if (nombre.length() > 16) {
      System.out.println("El nombre debe tener mas de 16 caracteres");
      return false;
    }
    if (!Character.isUpperCase(nombre.charAt(0))) {
      System.out.println("El nombre tiene que empezar por mayusculas");
      return false;
    }
    for (int i = 1; i < nombre.length() - 4; i++) {
      if (Character.isUpperCase(nombre.charAt(i))) {
        System.out.println("solo la primera letra en mayusculas");
        return false;
      }
    }
    if (
      nombre.charAt(nombre.length() - 4) != '_' &&
      nombre.charAt(nombre.length() - 4) != '-'
    ) {
      System.out.println("fañta el guion");
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

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getCorreo() {
    return correo;
  }

  public void setCorreo(String correo) {
    this.correo = correo;
  }

  public String getNombreUsuario() {
    return nombreUsuario;
  }

  public void setNombreUsuario(String nombreUsuario) {
    this.nombreUsuario = nombreUsuario;
  }
}
