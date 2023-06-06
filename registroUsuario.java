import java.util.Scanner;

public class registroUsuario {
    public static void main(String[] args) {
        Scanner teclat = new Scanner(System.in);
        String usuario;
        String correo;
        String password;
        boolean correcto;

        do {
            System.out.println("Introduce nombre");
            usuario = teclat.next();
            System.out.println("Introduce correo");
            correo = teclat.next();
            System.out.println("Introduce password");
            password = teclat.next();
            correcto = ValidarCampos.validarCampos(usuario, correo, password);
        } while (!correcto);
        System.out.println("usuario:" + usuario + "correo:" + correo + "password" + password);
        System.out.println("El registro se ha realizado con éxito");
        teclat.close();
    }
}
