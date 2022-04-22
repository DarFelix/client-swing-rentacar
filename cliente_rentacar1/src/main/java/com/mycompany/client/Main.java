package com.mycompany.client;

import com.mycompany.dto.Auth;
import com.mycompany.dto.Rol;
import com.mycompany.dto.User;
import java.util.Scanner;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

public class Main {

    private static void createUse(UserClient userClient, Auth auth) {

        User user = new User();

        Scanner ce = new Scanner(System.in);
        Scanner nom = new Scanner(System.in);
        Scanner ape = new Scanner(System.in);
        Scanner ed = new Scanner(System.in);
        Scanner tel = new Scanner(System.in);
        Scanner dir = new Scanner(System.in);
        Scanner bar = new Scanner(System.in);
        Scanner ciu = new Scanner(System.in);
        Scanner fot = new Scanner(System.in);
        Scanner rep = new Scanner(System.in);
        Scanner contr = new Scanner(System.in);
        Scanner idr = new Scanner(System.in);

        System.out.println("****** Por favor digite los siguientes datos ******");

        System.out.println("Cedula");
        user.setCedula(ce.next());

        System.out.println("Nombre");
        user.setNombre(nom.next());

        System.out.println("Apellido");
        user.setApellido(ape.next());

        System.out.println("Edad");
        user.setAge(ed.nextInt());

        System.out.println("Telefono");
        user.setTelefono(tel.next());

        System.out.println("Direccion");
        user.setDireccion(dir.next());

        System.out.println("Barrio");
        user.setBarrio(bar.next());

        System.out.println("Ciudad");
        user.setCiudad(ciu.next());

        System.out.println("Foto");
        user.setFoto(fot.next());

        System.out.println("Reporte");
        user.setReporte(rep.nextBoolean());

        System.out.println("Clave");
        user.setPass(contr.next());

        Rol rol = new Rol();
        System.out.println("Id-Rol:");
        rol.setIdRol(idr.next());
        user.setRol(rol);

        try {
            userClient.createUser(user, auth);
            System.out.println("****** Usuario creado con exito ******");
        } catch (Exception e) {
            escribirMensajeError(e);
        }

    }

    private static void getUsers(UserClient userClient, Auth auth) {

        try {
            System.out.println("****** Listado de usuarios ******");
            for (User user : userClient.getUsers(auth)) {
                System.out.println("=======================");
                System.out.println("Id: " + user.getIdUser());
                System.out.println("cedula: " + user.getCedula());
                System.out.println("Nombre: " + user.getNombre());
                System.out.println("Apellido: " + user.getApellido());
                System.out.println("Edad: " + user.getAge());
                System.out.println("Telefono: " + user.getTelefono());
                System.out.println("Dirección: " + user.getDireccion());
                System.out.println("Barrio: " + user.getBarrio());
                System.out.println("Ciudad: " + user.getCiudad());
                System.out.println("Foto: " + user.getFoto());
                System.out.println("Reporte: " + user.isReporte());
                System.out.println("Clave: " + user.getPass());
                System.out.println("Rol: " + user.getRol().getNombreRol());
                System.out.println("=======================");
            }
            System.out.println("*******************************");
        } catch (Exception e) {
            escribirMensajeError(e);
        }

    }

    private static void getUser(UserClient userClient, Auth auth) {

        System.out.println("Ingrese el id del usuario que quiere buscar:");
        Scanner ident = new Scanner(System.in);
        Integer id = ident.nextInt();
        System.out.println("El id es: " + id);
        System.out.println("--------------- ");

        
        try{
        User user = userClient.getUser(id, auth);
        //"54332","12345"

        System.out.println("Datos del usuario");
        System.out.println("Id: " + user.getIdUser());
        System.out.println("Cedula: " + user.getCedula());
        System.out.println("Nombre: " + user.getNombre());
        System.out.println("Apellido: " + user.getApellido());
        System.out.println("Edad: " + user.getAge());
        System.out.println("Teléfono: " + user.getTelefono());
        System.out.println("Dirección: " + user.getDireccion());
        System.out.println("Barrio: " + user.getBarrio());
        System.out.println("Ciudad: " + user.getCiudad());
        System.out.println("Foto: " + user.getFoto());
        System.out.println("Reporte: " + user.isReporte());
        System.out.println("Password: " + user.getPass());
        System.out.println("Rol: " + user.getRol().getNombreRol());
        System.out.println("----------------------");
        } catch (Exception e) {
            escribirMensajeError(e);
        }
        
    }

    private static void updateUser(UserClient userClient, Auth auth) {

        System.out.println("Ingrese el id del usuario que quiere actualizar:");
        Scanner ident = new Scanner(System.in);
        int id = ident.nextInt();
        System.out.println("El id es: " + id);
        System.out.println("--------------- ");

        System.out.println("Ingrese los nuevos datos:");

        User updatedUser = new User();

        Scanner nm = new Scanner(System.in);
        Scanner nom = new Scanner(System.in);
        Scanner ape = new Scanner(System.in);
        Scanner ed = new Scanner(System.in);
        Scanner tel = new Scanner(System.in);
        Scanner dir = new Scanner(System.in);
        Scanner bar = new Scanner(System.in);
        Scanner ciu = new Scanner(System.in);
        Scanner fot = new Scanner(System.in);
        Scanner rep = new Scanner(System.in);
        Scanner pas = new Scanner(System.in);
        Scanner idr = new Scanner(System.in);

        System.out.println("Digite la cédula: ");
        String cedula = nm.nextLine();
        System.out.println("La cédula es: " + cedula);
        System.out.println("--------------- ");

        System.out.println("Digite el nombre: ");
        String nombre = nom.nextLine();
        System.out.println("El apellido es: " + nombre);
        System.out.println("--------------- ");

        System.out.println("Digite el apellido: ");
        String apellido = ape.nextLine();
        System.out.println("El apellido es: " + apellido);
        System.out.println("--------------- ");

        System.out.println("Digite la edad: ");
        int edad = ed.nextInt();
        System.out.println("La edad es: " + edad);
        System.out.println("--------------- ");

        System.out.println("Digite la telefono: ");
        String telefono = tel.nextLine();
        System.out.println("El telefono es: " + telefono);
        System.out.println("--------------- ");

        System.out.println("Digite la direccion: ");
        String direccion = dir.nextLine();
        System.out.println("La direccion es: " + direccion);
        System.out.println("--------------- ");

        System.out.println("Digite el barrio: ");
        String barrio = bar.nextLine();
        System.out.println("El barrio es: " + barrio);
        System.out.println("--------------- ");

        System.out.println("Digite la ciudad: ");
        String ciudad = ciu.nextLine();
        System.out.println("La ciudad es: " + ciudad);
        System.out.println("--------------- ");

        System.out.println("Ingrese la url de la foto: ");
        String url = fot.nextLine();
        System.out.println("La URL es: " + url);
        System.out.println("--------------- ");

        System.out.println("Confirme si esta reportado (true-false): ");
        boolean reporte = rep.nextBoolean();
        System.out.println("El reporte es: " + reporte);
        System.out.println("--------------- ");

        System.out.println("Ingrese la contraseña: ");
        String contr = pas.nextLine();
        System.out.println("La clave es: " + contr);
        System.out.println("--------------- ");

        System.out.println("Ingrese el rol del usuario ");
        String role = idr.nextLine();
        System.out.println("La rol es: " + role);
        System.out.println("--------------- ");

        updatedUser.setCedula(cedula);
        updatedUser.setNombre(nombre);
        updatedUser.setApellido(apellido);
        updatedUser.setAge(edad);
        updatedUser.setTelefono(telefono);
        updatedUser.setDireccion(direccion);
        updatedUser.setBarrio(barrio);
        updatedUser.setCiudad(ciudad);
        updatedUser.setFoto(url);
        updatedUser.setReporte(reporte);
        updatedUser.setPass(contr);

        Rol rol = new Rol();
        rol.setIdRol(role);
        updatedUser.setRol(rol);

        try {
            userClient.updateUse(id, updatedUser, auth);
            System.out.println("****** Usuario actualizado con éxito ******");
        } catch (Exception e) {
            escribirMensajeError(e);
        }

    }

    private static void deleteUser(UserClient userClient, Auth auth) {

        System.out.println("Ingrese el id del usuario que quiere borrar:");
        Scanner ident = new Scanner(System.in);
        int id = ident.nextInt();
        System.out.println("El id es: " + id);
        System.out.println("--------------- ");

        try {
            userClient.deleteUse(id, auth);
            System.out.println("Usuario borrado con éxito");
        } catch (Exception e) {
            escribirMensajeError(e);
        }

    }

    private static void escribirMensajeError(Exception e) {

        if (e.getMessage().toUpperCase().contains("CONNECTION")) {

            System.out.println("Error en conexión");

        } else if (e instanceof HttpClientErrorException) {

            HttpClientErrorException clientErrorException = (HttpClientErrorException) e;

            if (clientErrorException.getStatusCode().equals(HttpStatus.BAD_REQUEST)) {
                System.out.println(clientErrorException.getResponseBodyAsString());
            } else {
                System.out.println("Error en el servidor");
            }

        } else {
            System.out.println(e.getMessage());
        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        UserClient userClient = new UserClient();
        AuthClient authClient = new AuthClient();

       
        
        System.out.println("Ingrese sus datos de autenticación:");

        Scanner nm = new Scanner(System.in);
        Scanner cla = new Scanner(System.in);
        System.out.println("Digite la cédula: ");
        String cedula = nm.nextLine();
        System.out.println("Digite la clave: ");
        String clave = cla.nextLine();

            Auth auth = authClient.getAuth(cedula, clave);

            if (auth.getError() != null) {
                System.out.println(auth.getError());
            } else {
                System.out.println("********************");
                System.out.println("--Ingreso exitoso--");
                System.out.println("********************");

                boolean isRunning = true;
                while (isRunning) {

                    System.out.println("------------------------------------------");

                    System.out.println("Digite una opción: ");
                    System.out.println("1. Crear usuario");
                    System.out.println("2. Listar usuarios");
                    System.out.println("3. Usuario por id");
                    System.out.println("4. Actualizar usuario");
                    System.out.println("5. Borrar usuario");
                    System.out.println("6. Salir");

                    System.out.println("------------------------------------------");

                    int option = sc.nextInt();

                    switch (option) {
                        case 1:
                            createUse(userClient, auth);
                            break;
                        case 2:
                            getUsers(userClient, auth);
                            break;
                        case 3:
                            getUser(userClient, auth);
                            break;
                        case 4:
                            updateUser(userClient, auth);
                            break;
                        case 5:
                            deleteUser(userClient, auth);
                            break;
                        case 6:
                            System.out.println("Ha salido del sistema");
                            isRunning = false;
                            break;

                        default:
                            System.out.println("Opción no valida");
                            break;
                    }

                }

            }

        }

            
}
