import java.util.Scanner;

/**
 * Esta clase permite utilizar un objeto de la clase vlaidar campos
 * @author Mario
 *
 */
public class registroUsuario {

  public static void main(String[] args) {
    ValidarCampos v = new ValidarCampos(null, null, null);
    init(v);
  }

  /**
   * El metodo init inicia la aplicacion pasando un objeto de la clase validarCampos
   * @param v objeto de la clase ValidarCampos
   * @author Mario
   */
  public static void init(ValidarCampos v) {
    Scanner scanner = new Scanner(System.in);
    Boolean correcto = true;

    do {
      System.out.println("introduce un nombre: ");
      v.setNombreUsuario(scanner.nextLine());
      correcto = v.validarNombre(v.getNombreUsuario(), null);
    } while (!correcto);

    do {
      System.out.println("Introduce un email: ");
      v.setCorreo(scanner.nextLine());
      correcto = v.validarEmail(v.getCorreo());
    } while (!correcto);

    do {
      System.out.println("Introduce un password: ");
      v.setPassword(scanner.nextLine());
      correcto = v.compruebaPassword(v.getPassword());
    } while (!correcto);

    do {
      correcto = v.compruebaCodigo();
    } while (!correcto);

    System.out.println("Correcto");
    System.out.println(
      "[nombre " +
      v.getNombreUsuario() +
      "]  [email: " +
      v.getCorreo() +
      "]   [passwword:  " +
      v.getPassword() +
      "]"
    );
  }
}
