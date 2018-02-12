
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Bienvenidos
 */
public class Aplicacion_Agenda {

    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        Calendar fecha;
        int opcion;
        Agenda agenda;
        Pagina pagina;
        Cita cita;
        int hora, minutos, dia, mes, año;
        String texto, titulo;

        System.out.println("En que año estara ubicada la agenda?");
        año = teclado.nextInt();
        agenda = new Agenda(año);
        System.out.println("\n\n" + "*********CITAS****DEL****" + agenda.getAño() + "*********");

        int elec;
        do {
            verMenu();
            elec = teclado.nextInt();

            switch (elec) {
                case 1:
                    System.out.print("Introduce dia: ");
                    dia = teclado.nextInt();
                    System.out.print("Introduce mes: ");
                    mes = teclado.nextInt();
                    if (validarCita(dia, mes)) {
                        agenda.abierta = agenda.buscarPagina(dia, mes);
                        System.out.println("La pagina seleccionada es: " + agenda.abierta.getDia() + " del mes " + agenda.abierta.getMes());
                    } else {
                        System.out.println("La fecha es erronea.");
                    }

                    break;
                case 2:
                    System.out.print("Introduca hora: ");
                    hora = teclado.nextInt();
                    System.out.print("Introduce minutos: ");
                    minutos = teclado.nextInt();
                    if (validarHora(hora, minutos)) {
                        System.out.print("Introduce titulo: ");
                        titulo = teclado.next();
                        System.out.println("Introduce texto: ");
                        texto = teclado.next();
                        if (agenda.abierta.agendaLibre(hora, minutos)) {
                            cita = new Cita(hora, minutos, titulo, texto);
                            agenda.abierta.añadirCita(cita);
                            agenda.abierta.leerPagina();
                        } else {
                            System.out.println("Su agenda ya esta ocupada a esa hora");
                        }
                    } else {
                        System.out.println("La hora introducida no es correcta.");
                    }

                    break;
                case 3:
                    System.out.println("Que hora tiene la cita?");
                    hora= teclado.nextInt();
                    System.out.println("Que minutos tiene la cita?");
                    minutos=teclado.nextInt();
                    if(agenda.abierta.agendaLibre(hora, minutos)){
                        System.out.println("No tiene ninguna cita a esa hora.");
                    }else{
                        agenda.abierta.borrarAgenda(hora, minutos);
                        System.out.println("Cita borrada.");
                    }
                    break;
                case 4:
                    System.out.println("Que hora tiene la cita?");
                    hora= teclado.nextInt();
                    System.out.println("Que minutos tiene la cita?");
                    minutos=teclado.nextInt();
                    if(agenda.abierta.agendaLibre(hora, minutos)){
                        System.out.println("No tiene ninguna cita a esa hora.");
                    }else{
                        agenda.abierta.buscarCita(hora, minutos);
                        agenda.abierta.leerCitaEspecifica(hora, minutos);
                    }
                    
                    break;
                default:
                    break;
            }
        } while (elec != 0);
    }

    public static void verMenu() {
        System.out.println("****************MENU****************");
        System.out.println("1. Selecciona una página");
        System.out.println("2. Crea una cita");
        System.out.println("3. Borrar cita");
        System.out.println("4. Buscar cita");

        System.out.println("0. Salir");
        System.out.println("************************************");
    }

    public static boolean validarCita(int d, int m) {

        if (0 < m && m <= 12) {
            if (m == 2) {
                if (d <= 29) {
                    return true;
                }
            } else if (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12) {
                if (d <= 31) {
                    return true;
                }
            } else {
                if (d <= 30) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean validarHora(int h, int m) {

        if (h < 24) {
            if (m < 60) {
                return true;
            }
        }

        return false;
    }

}
