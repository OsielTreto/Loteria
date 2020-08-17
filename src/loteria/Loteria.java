package loteria;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import sun.awt.resources.awt;

public class Loteria extends JFrame implements ActionListener {

    boolean bandera = false;
    JPanel panel, superior, inferior;
    JButton sacarcarta, barajear, carta1, carta2;
    JLabel salir, abiertas, restan, numero;
    Font fuente;
    JFrame frame;

    int i = 0, cantidad = 54, rango = 54, contadorcartas = 0;
    int arreglodecartas[] = new int[cantidad];

    Random aleatorio = new Random();
    int n, contador = 54, nfinal, contadorarray = 0;

    int can = 16;
    int ran = 54;
    int carta11[] = new int[can];
    int carta22[] = new int[can];
    int cartaspasadas[] = new int[54];
    int cartaspasadas2[] = new int[54];
    boolean tabla1 = false, tabla2 = false;

    int a[] = new int[16];
    int b[] = new int[16];

    JButton uno = new JButton();
    JButton dos = new JButton();
    JButton tres = new JButton();
    JButton cuatro = new JButton();
    JButton cinco = new JButton();
    JButton seis = new JButton();
    JButton siete = new JButton();
    JButton ocho = new JButton();
    JButton nueve = new JButton();
    JButton diez = new JButton();
    JButton once = new JButton();
    JButton doce = new JButton();
    JButton trece = new JButton();
    JButton catorce = new JButton();
    JButton quince = new JButton();
    JButton dieciseis = new JButton();

    JButton uno2 = new JButton();
    JButton dos2 = new JButton();
    JButton tres2 = new JButton();
    JButton cuatro2 = new JButton();
    JButton cinco2 = new JButton();
    JButton seis2 = new JButton();
    JButton siete2 = new JButton();
    JButton ocho2 = new JButton();
    JButton nueve2 = new JButton();
    JButton diez2 = new JButton();
    JButton once2 = new JButton();
    JButton doce2 = new JButton();
    JButton trece2 = new JButton();
    JButton catorce2 = new JButton();
    JButton quince2 = new JButton();
    JButton dieciseis2 = new JButton();

    public Loteria() {
        super();
        configurarVentana();
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        tabla1();
        tabla2();

        i = 0;
        fuente = new Font("Arial", 0, 25);
        carta1 = new JButton();
        carta2 = new JButton();

        sacarcarta = new JButton("Sacar carta");
        barajear = new JButton("Barajear");
        salir = new JLabel("Por salir");
        abiertas = new JLabel("Abiertas");
        restan = new JLabel("Restan");
        numero = new JLabel("54");

        salir.setBounds(90, 20, 100, 20);
        salir.setFont(fuente);

        abiertas.setBounds(410, 20, 100, 20);
        abiertas.setFont(fuente);

        restan.setBounds(255, 100, 100, 20);
        restan.setFont(fuente);
        numero.setBounds(280, 130, 50, 50);
        numero.setFont(fuente);

        sacarcarta.setBounds(40, 370, 191, 50);
        barajear.setBounds(360, 370, 191, 50);

        carta1.setBounds(40, 50, 191, 300);

        carta1.setIcon(new ImageIcon(getClass().getResource("/archivos/atras.jpg")));
        carta2.setBounds(360, 50, 191, 300);
        carta2.setIcon(new ImageIcon(getClass().getResource("/archivos/fondo.jpg")));

        arreglodecartas[i] = (int) (Math.random() * rango);
        for (i = 1; i < cantidad; i++) {
            arreglodecartas[i] = (int) (Math.random() * rango);
            for (int j = 0; j < i; j++) {
                if (arreglodecartas[i] == arreglodecartas[j]) {
                    i--;
                }
            }
        }
        sacarcarta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (contador <= 0) {
                    sacarcarta.setText("Ya no hay cartas");
                    carta1.setIcon(new ImageIcon(getClass().getResource("/archivos/fondo.jpg")));
                } else {

                    n = arreglodecartas[contadorarray];
                    contadorarray++;
                    nfinal = n + 1;
                    carta2.setIcon(new ImageIcon(getClass().getResource("/archivos/" + nfinal + ".jpg")));
                    contador--;
                    numero.setText("" + contador);

                    if (n == carta11[0]) {
                        uno.setIcon(new ImageIcon(getClass().getResource("/tapas/" + (carta11[0] + 1) + ".jpg")));
                        a[0] = 1;
                    }
                    if (n == carta11[1]) {
                        dos.setIcon(new ImageIcon(getClass().getResource("/tapas/" + (carta11[1] + 1) + ".jpg")));
                        a[1] = 1;
                    }
                    if (n == carta11[2]) {
                        tres.setIcon(new ImageIcon(getClass().getResource("/tapas/" + (carta11[2] + 1) + ".jpg")));
                        a[2] = 1;
                    }
                    if (n == carta11[3]) {
                        cuatro.setIcon(new ImageIcon(getClass().getResource("/tapas/" + (carta11[3] + 1) + ".jpg")));
                        a[3] = 1;
                    }
                    if (n == carta11[4]) {
                        cinco.setIcon(new ImageIcon(getClass().getResource("/tapas/" + (carta11[4] + 1) + ".jpg")));
                        a[4] = 1;
                    }
                    if (n == carta11[5]) {
                        seis.setIcon(new ImageIcon(getClass().getResource("/tapas/" + (carta11[5] + 1) + ".jpg")));
                        a[5] = 1;
                    }
                    if (n == carta11[6]) {
                        siete.setIcon(new ImageIcon(getClass().getResource("/tapas/" + (carta11[6] + 1) + ".jpg")));
                        a[6] = 1;
                    }
                    if (n == carta11[7]) {
                        ocho.setIcon(new ImageIcon(getClass().getResource("/tapas/" + (carta11[7] + 1) + ".jpg")));
                        a[7] = 1;
                    }
                    if (n == carta11[8]) {
                        nueve.setIcon(new ImageIcon(getClass().getResource("/tapas/" + (carta11[8] + 1) + ".jpg")));
                        a[8] = 1;
                    }
                    if (n == carta11[9]) {
                        diez.setIcon(new ImageIcon(getClass().getResource("/tapas/" + (carta11[9] + 1) + ".jpg")));
                        a[9] = 1;
                    }
                    if (n == carta11[10]) {
                        once.setIcon(new ImageIcon(getClass().getResource("/tapas/" + (carta11[10] + 1) + ".jpg")));
                        a[10] = 1;
                    }
                    if (n == carta11[11]) {
                        doce.setIcon(new ImageIcon(getClass().getResource("/tapas/" + (carta11[11] + 1) + ".jpg")));
                        a[11] = 1;
                    }
                    if (n == carta11[12]) {
                        trece.setIcon(new ImageIcon(getClass().getResource("/tapas/" + (carta11[12] + 1) + ".jpg")));
                        a[12] = 1;
                    }
                    if (n == carta11[13]) {
                        catorce.setIcon(new ImageIcon(getClass().getResource("/tapas/" + (carta11[13] + 1) + ".jpg")));
                        a[13] = 1;
                    }
                    if (n == carta11[14]) {
                        quince.setIcon(new ImageIcon(getClass().getResource("/tapas/" + (carta11[14] + 1) + ".jpg")));
                        a[14] = 1;
                    }
                    if (n == carta11[15]) {
                        dieciseis.setIcon(new ImageIcon(getClass().getResource("/tapas/" + (carta11[15] + 1) + ".jpg")));
                        a[15] = 1;
                    }
                    //----------------------------TABLA 2-----------------------
                    if (n == carta22[0]) {
                        uno2.setIcon(new ImageIcon(getClass().getResource("/tapas/" + (carta22[0] + 1) + ".jpg")));
                        b[0] = 1;
                    }
                    if (n == carta22[1]) {
                        dos2.setIcon(new ImageIcon(getClass().getResource("/tapas/" + (carta22[1] + 1) + ".jpg")));
                        b[1] = 1;
                    }
                    if (n == carta22[2]) {
                        tres2.setIcon(new ImageIcon(getClass().getResource("/tapas/" + (carta22[2] + 1) + ".jpg")));
                        b[2] = 1;
                    }
                    if (n == carta22[3]) {
                        cuatro2.setIcon(new ImageIcon(getClass().getResource("/tapas/" + (carta22[3] + 1) + ".jpg")));
                        b[3] = 1;
                    }
                    if (n == carta22[4]) {
                        cinco2.setIcon(new ImageIcon(getClass().getResource("/tapas/" + (carta22[4] + 1) + ".jpg")));
                        b[4] = 1;
                    }
                    if (n == carta22[5]) {
                        seis2.setIcon(new ImageIcon(getClass().getResource("/tapas/" + (carta22[5] + 1) + ".jpg")));
                        b[5] = 1;
                    }
                    if (n == carta22[6]) {
                        siete2.setIcon(new ImageIcon(getClass().getResource("/tapas/" + (carta22[6] + 1) + ".jpg")));
                        b[6] = 1;
                    }
                    if (n == carta22[7]) {
                        ocho2.setIcon(new ImageIcon(getClass().getResource("/tapas/" + (carta22[7] + 1) + ".jpg")));
                        b[7] = 1;
                    }
                    if (n == carta22[8]) {
                        nueve2.setIcon(new ImageIcon(getClass().getResource("/tapas/" + (carta22[8] + 1) + ".jpg")));
                        b[8] = 1;
                    }
                    if (n == carta22[9]) {
                        diez2.setIcon(new ImageIcon(getClass().getResource("/tapas/" + (carta22[9] + 1) + ".jpg")));
                        b[9] = 1;
                    }
                    if (n == carta22[10]) {
                        once2.setIcon(new ImageIcon(getClass().getResource("/tapas/" + (carta22[10] + 1) + ".jpg")));
                        b[10] = 1;
                    }
                    if (n == carta22[11]) {
                        doce2.setIcon(new ImageIcon(getClass().getResource("/tapas/" + (carta22[11] + 1) + ".jpg")));
                        b[11] = 1;
                    }
                    if (n == carta22[12]) {
                        trece2.setIcon(new ImageIcon(getClass().getResource("/tapas/" + (carta22[12] + 1) + ".jpg")));
                        b[12] = 1;
                    }
                    if (n == carta22[13]) {
                        catorce2.setIcon(new ImageIcon(getClass().getResource("/tapas/" + (carta22[13] + 1) + ".jpg")));
                        b[13] = 1;
                    }
                    if (n == carta22[14]) {
                        quince2.setIcon(new ImageIcon(getClass().getResource("/tapas/" + (carta22[14] + 1) + ".jpg")));
                        b[14] = 1;
                    }
                    if (n == carta22[15]) {
                        dieciseis2.setIcon(new ImageIcon(getClass().getResource("/tapas/" + (carta22[15] + 1) + ".jpg")));
                        b[15] = 1;
                    }
                    //horizontal

                    if (a[0] == 1 && a[1] == 1 && a[2] == 1 && a[3] == 1
                            || a[4] == 1 && a[5] == 1 && a[6] == 1 && a[7] == 1
                            || a[8] == 1 && a[9] == 1 && a[10] == 1 && a[11] == 1
                            || a[12] == 1 && a[13] == 1 && a[14] == 1 && a[15] == 1
                            //vertical
                            || a[0] == 1 && a[4] == 1 && a[8] == 1 && a[12] == 1
                            || a[1] == 1 && a[5] == 1 && a[9] == 1 && a[13] == 1
                            || a[2] == 1 && a[6] == 1 && a[10] == 1 && a[14] == 1
                            || a[3] == 1 && a[7] == 1 && a[11] == 1 && a[15] == 1
                            //diagonal
                            || a[0] == 1 && a[5] == 1 && a[10] == 1 && a[15] == 1
                            || a[3] == 1 && a[6] == 1 && a[9] == 1 && a[12] == 1
                            //cruz
                            || a[1] == 1 && a[4] == 1 && a[6] == 1 && a[9] == 1
                            || a[2] == 1 && a[5] == 1 && a[7] == 1 && a[10] == 1
                            || a[5] == 1 && a[8] == 1 && a[10] == 1 && a[13] == 1
                            || a[6] == 1 && a[9] == 1 && a[14] == 1 && a[11] == 1
                            //cuadro
                            || a[0] == 1 && a[1] == 1 && a[4] == 1 && a[5] == 1
                            || a[1] == 1 && a[2] == 1 && a[5] == 1 && a[6] == 1
                            || a[2] == 1 && a[3] == 1 && a[6] == 1 && a[7] == 1
                            || a[4] == 1 && a[5] == 1 && a[8] == 1 && a[9] == 1
                            || a[5] == 1 && a[6] == 1 && a[9] == 1 && a[10] == 1
                            || a[6] == 1 && a[7] == 1 && a[10] == 1 && a[11] == 1
                            || a[8] == 1 && a[9] == 1 && a[12] == 1 && a[13] == 1
                            || a[9] == 1 && a[10] == 1 && a[13] == 1 && a[14] == 1
                            || a[10] == 1 && a[11] == 1 && a[14] == 1 && a[15] == 1
                            //esquina
                            || a[0] == 1 && a[3] == 1 && a[12] == 1 && a[15] == 1) {
                        tabla1 = true;
                    }
                    //----------TABLA2-----------
                    if (b[0] == 1 && b[1] == 1 && b[2] == 1 && b[3] == 1
                            || b[4] == 1 && b[5] == 1 && b[6] == 1 && b[7] == 1
                            || b[8] == 1 && b[9] == 1 && b[10] == 1 && b[11] == 1
                            || b[12] == 1 && b[13] == 1 && b[14] == 1 && b[15] == 1
                            //vertical
                            || b[0] == 1 && b[4] == 1 && b[8] == 1 && b[12] == 1
                            || b[1] == 1 && b[5] == 1 && b[9] == 1 && b[13] == 1
                            || b[2] == 1 && b[6] == 1 && b[10] == 1 && b[14] == 1
                            || b[3] == 1 && b[7] == 1 && b[11] == 1 && b[15] == 1
                            //diagonal
                            || b[0] == 1 && b[5] == 1 && b[10] == 1 && b[15] == 1
                            || b[3] == 1 && b[6] == 1 && b[9] == 1 && b[12] == 1
                            //cruz
                            || b[1] == 1 && b[4] == 1 && b[6] == 1 && b[9] == 1
                            || b[2] == 1 && b[5] == 1 && b[7] == 1 && b[10] == 1
                            || b[5] == 1 && b[8] == 1 && b[10] == 1 && b[13] == 1
                            || b[6] == 1 && b[9] == 1 && b[14] == 1 && b[11] == 1
                            //cuadro
                            || b[0] == 1 && b[1] == 1 && b[4] == 1 && b[5] == 1
                            || b[1] == 1 && b[2] == 1 && b[5] == 1 && b[6] == 1
                            || b[2] == 1 && b[3] == 1 && b[6] == 1 && b[7] == 1
                            || b[4] == 1 && b[5] == 1 && b[8] == 1 && b[9] == 1
                            || b[5] == 1 && b[6] == 1 && b[9] == 1 && b[10] == 1
                            || b[6] == 1 && b[7] == 1 && b[10] == 1 && b[11] == 1
                            || b[8] == 1 && b[9] == 1 && b[12] == 1 && b[13] == 1
                            || b[9] == 1 && b[10] == 1 && b[13] == 1 && b[14] == 1
                            || b[10] == 1 && b[11] == 1 && b[14] == 1 && b[15] == 1
                            //esquina
                            || b[0] == 1 && b[3] == 1 && b[12] == 1 && b[15] == 1) {
                        tabla2 = true;
                    }

                    if (tabla1 == true && tabla2 == true) {
                        JOptionPane.showMessageDialog(null, "Empate!!!");
                        sacarcarta.setEnabled(false);

                    }
                    if (tabla1 == true && tabla2 == false) {
                        JOptionPane.showMessageDialog(null, "Buenas!!!! Gana jugador 1");
                        sacarcarta.setEnabled(false);

                    }
                    if (tabla1 == false && tabla2 == true) {
                        JOptionPane.showMessageDialog(null, "Buenas!!!! Gana jugador 2");
                        sacarcarta.setEnabled(false);

                    }
                }
            }
        });

        barajear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                sacarcarta.setEnabled(true);
                tabla1 = false;
                tabla2 = false;
                for (int j = 0; j < 16; j++) {
                    a[j] = 0;
                    b[j] = 0;
                }

                int i = 0, cantidad = 54, rango = 54;
                int arregloaux[] = new int[cantidad];

                uno.setIcon(new ImageIcon(getClass().getResource("/tabla/" + (carta11[0] + 1) + ".jpg")));
                dos.setIcon(new ImageIcon(getClass().getResource("/tabla/" + (carta11[1] + 1) + ".jpg")));
                tres.setIcon(new ImageIcon(getClass().getResource("/tabla/" + (carta11[2] + 1) + ".jpg")));
                cuatro.setIcon(new ImageIcon(getClass().getResource("/tabla/" + (carta11[3] + 1) + ".jpg")));
                cinco.setIcon(new ImageIcon(getClass().getResource("/tabla/" + (carta11[4] + 1) + ".jpg")));
                seis.setIcon(new ImageIcon(getClass().getResource("/tabla/" + (carta11[5] + 1) + ".jpg")));
                siete.setIcon(new ImageIcon(getClass().getResource("/tabla/" + (carta11[6] + 1) + ".jpg")));
                ocho.setIcon(new ImageIcon(getClass().getResource("/tabla/" + (carta11[7] + 1) + ".jpg")));
                nueve.setIcon(new ImageIcon(getClass().getResource("/tabla/" + (carta11[8] + 1) + ".jpg")));
                diez.setIcon(new ImageIcon(getClass().getResource("/tabla/" + (carta11[9] + 1) + ".jpg")));
                once.setIcon(new ImageIcon(getClass().getResource("/tabla/" + (carta11[10] + 1) + ".jpg")));
                doce.setIcon(new ImageIcon(getClass().getResource("/tabla/" + (carta11[11] + 1) + ".jpg")));
                trece.setIcon(new ImageIcon(getClass().getResource("/tabla/" + (carta11[12] + 1) + ".jpg")));
                catorce.setIcon(new ImageIcon(getClass().getResource("/tabla/" + (carta11[13] + 1) + ".jpg")));
                quince.setIcon(new ImageIcon(getClass().getResource("/tabla/" + (carta11[14] + 1) + ".jpg")));
                dieciseis.setIcon(new ImageIcon(getClass().getResource("/tabla/" + (carta11[15] + 1) + ".jpg")));

                uno2.setIcon(new ImageIcon(getClass().getResource("/tabla2/" + (carta22[0] + 1) + ".jpg")));
                dos2.setIcon(new ImageIcon(getClass().getResource("/tabla2/" + (carta22[1] + 1) + ".jpg")));
                tres2.setIcon(new ImageIcon(getClass().getResource("/tabla2/" + (carta22[2] + 1) + ".jpg")));
                cuatro2.setIcon(new ImageIcon(getClass().getResource("/tabla2/" + (carta22[3] + 1) + ".jpg")));
                cinco2.setIcon(new ImageIcon(getClass().getResource("/tabla2/" + (carta22[4] + 1) + ".jpg")));
                seis2.setIcon(new ImageIcon(getClass().getResource("/tabla2/" + (carta22[5] + 1) + ".jpg")));
                siete2.setIcon(new ImageIcon(getClass().getResource("/tabla2/" + (carta22[6] + 1) + ".jpg")));
                ocho2.setIcon(new ImageIcon(getClass().getResource("/tabla2/" + (carta22[7] + 1) + ".jpg")));
                nueve2.setIcon(new ImageIcon(getClass().getResource("/tabla2/" + (carta22[8] + 1) + ".jpg")));
                diez2.setIcon(new ImageIcon(getClass().getResource("/tabla2/" + (carta22[9] + 1) + ".jpg")));
                once2.setIcon(new ImageIcon(getClass().getResource("/tabla2/" + (carta22[10] + 1) + ".jpg")));
                doce2.setIcon(new ImageIcon(getClass().getResource("/tabla2/" + (carta22[11] + 1) + ".jpg")));
                trece2.setIcon(new ImageIcon(getClass().getResource("/tabla2/" + (carta22[12] + 1) + ".jpg")));
                catorce2.setIcon(new ImageIcon(getClass().getResource("/tabla2/" + (carta22[13] + 1) + ".jpg")));
                quince2.setIcon(new ImageIcon(getClass().getResource("/tabla2/" + (carta22[14] + 1) + ".jpg")));
                dieciseis2.setIcon(new ImageIcon(getClass().getResource("/tabla2/" + (carta22[15] + 1) + ".jpg")));

                contador = 54;
                contadorarray = 0;

                numero.setText("" + contador);
                carta1.setIcon(new ImageIcon(getClass().getResource("/archivos/atras.jpg")));
                carta2.setIcon(new ImageIcon(getClass().getResource("/archivos/fondo.jpg")));

                arregloaux[i] = (int) (Math.random() * rango);
                for (i = 1; i < cantidad; i++) {
                    arregloaux[i] = (int) (Math.random() * rango);
                    for (int j = 0; j < i; j++) {
                        if (arregloaux[i] == arregloaux[j]) {
                            i--;
                        }
                    }
                }

                for (int j = 0; j < cantidad; j++) {
                    arreglodecartas[j] = arregloaux[j];
                }

            }
        });

        add(carta1);
        add(carta2);
        add(sacarcarta);
        add(barajear);
        add(salir);
        add(abiertas);
        add(restan);
        add(numero);

    }

    private void configurarVentana() {
        setTitle("Loteria");
        setLayout(null);
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        setSize(600, 500);
        this.setResizable(false);
        Container contenedor = getContentPane();
        contenedor.setBackground(new Color(255, 255, 255));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void tabla1() {
        i = 0;
        int can = 16;
        int ran = 54;

        carta11[i] = (int) (Math.random() * ran);
        for (i = 1; i < can; i++) {
            carta11[i] = (int) (Math.random() * ran);
            for (int j = 0; j < i; j++) {
                if (carta11[i] == carta11[j]) {
                    i--;
                }
            }
        }
        System.out.println("\nTabla 1");

        for (int k = 0; k < can; k++) {
            System.out.print((k + 1) + ".- " + carta11[k] + "\n");
        }

        uno.setIcon(new ImageIcon(getClass().getResource("/tabla/" + (carta11[0] + 1) + ".jpg")));
        dos.setIcon(new ImageIcon(getClass().getResource("/tabla/" + (carta11[1] + 1) + ".jpg")));
        tres.setIcon(new ImageIcon(getClass().getResource("/tabla/" + (carta11[2] + 1) + ".jpg")));
        cuatro.setIcon(new ImageIcon(getClass().getResource("/tabla/" + (carta11[3] + 1) + ".jpg")));
        cinco.setIcon(new ImageIcon(getClass().getResource("/tabla/" + (carta11[4] + 1) + ".jpg")));
        seis.setIcon(new ImageIcon(getClass().getResource("/tabla/" + (carta11[5] + 1) + ".jpg")));
        siete.setIcon(new ImageIcon(getClass().getResource("/tabla/" + (carta11[6] + 1) + ".jpg")));
        ocho.setIcon(new ImageIcon(getClass().getResource("/tabla/" + (carta11[7] + 1) + ".jpg")));
        nueve.setIcon(new ImageIcon(getClass().getResource("/tabla/" + (carta11[8] + 1) + ".jpg")));
        diez.setIcon(new ImageIcon(getClass().getResource("/tabla/" + (carta11[9] + 1) + ".jpg")));
        once.setIcon(new ImageIcon(getClass().getResource("/tabla/" + (carta11[10] + 1) + ".jpg")));
        doce.setIcon(new ImageIcon(getClass().getResource("/tabla/" + (carta11[11] + 1) + ".jpg")));
        trece.setIcon(new ImageIcon(getClass().getResource("/tabla/" + (carta11[12] + 1) + ".jpg")));
        catorce.setIcon(new ImageIcon(getClass().getResource("/tabla/" + (carta11[13] + 1) + ".jpg")));
        quince.setIcon(new ImageIcon(getClass().getResource("/tabla/" + (carta11[14] + 1) + ".jpg")));
        dieciseis.setIcon(new ImageIcon(getClass().getResource("/tabla/" + (carta11[15] + 1) + ".jpg")));

        if (rootPaneCheckingEnabled) {

        }

        superior = new JPanel();

        superior.add(uno);
        superior.add(dos);
        superior.add(tres);
        superior.add(cuatro);
        superior.add(cinco);
        superior.add(seis);
        superior.add(siete);
        superior.add(ocho);
        superior.add(nueve);
        superior.add(diez);
        superior.add(once);
        superior.add(doce);
        superior.add(trece);
        superior.add(catorce);
        superior.add(quince);
        superior.add(dieciseis);

        superior.setLayout(new GridLayout(4, 4, 4, 4));

        frame = new JFrame("Carta 1");

        frame.add(superior, BorderLayout.NORTH);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);

    }

    public void tabla2() {
        int m = 0, n = 0;
        int can2 = 16;
        int ran2 = 54;
        /*
         carta22[m] = (int) (Math.random() * ran2);
         for (m = 1; m < can2; m++) {
         carta22[m] = (int) (Math.random() * ran2);
         for (int j = 0; j < m; j++) {
         if (carta22[m] == carta22[j]) {
         i--;
         }
         }
         }*/
        carta22[m] = (int) (Math.random() * ran2);
        for (n = 1; n < can2; n++) {
            carta22[n] = (int) (Math.random() * ran2);
            for (int j = 0; j < n; j++) {
                if (carta22[n] == carta22[j]) {
                    n--;
                }
            }
        }

        System.out.println("\nTabla 2");
        for (int k = 0; k < can2; k++) {
            System.out.print((k + 1) + ".- " + carta22[k] + "\n");
        }

        uno2.setIcon(new ImageIcon(getClass().getResource("/tabla2/" + (carta22[0] + 1) + ".jpg")));
        dos2.setIcon(new ImageIcon(getClass().getResource("/tabla2/" + (carta22[1] + 1) + ".jpg")));
        tres2.setIcon(new ImageIcon(getClass().getResource("/tabla2/" + (carta22[2] + 1) + ".jpg")));
        cuatro2.setIcon(new ImageIcon(getClass().getResource("/tabla2/" + (carta22[3] + 1) + ".jpg")));
        cinco2.setIcon(new ImageIcon(getClass().getResource("/tabla2/" + (carta22[4] + 1) + ".jpg")));
        seis2.setIcon(new ImageIcon(getClass().getResource("/tabla2/" + (carta22[5] + 1) + ".jpg")));
        siete2.setIcon(new ImageIcon(getClass().getResource("/tabla2/" + (carta22[6] + 1) + ".jpg")));
        ocho2.setIcon(new ImageIcon(getClass().getResource("/tabla2/" + (carta22[7] + 1) + ".jpg")));
        nueve2.setIcon(new ImageIcon(getClass().getResource("/tabla2/" + (carta22[8] + 1) + ".jpg")));
        diez2.setIcon(new ImageIcon(getClass().getResource("/tabla2/" + (carta22[9] + 1) + ".jpg")));
        once2.setIcon(new ImageIcon(getClass().getResource("/tabla2/" + (carta22[10] + 1) + ".jpg")));
        doce2.setIcon(new ImageIcon(getClass().getResource("/tabla2/" + (carta22[11] + 1) + ".jpg")));
        trece2.setIcon(new ImageIcon(getClass().getResource("/tabla2/" + (carta22[12] + 1) + ".jpg")));
        catorce2.setIcon(new ImageIcon(getClass().getResource("/tabla2/" + (carta22[13] + 1) + ".jpg")));
        quince2.setIcon(new ImageIcon(getClass().getResource("/tabla2/" + (carta22[14] + 1) + ".jpg")));
        dieciseis2.setIcon(new ImageIcon(getClass().getResource("/tabla2/" + (carta22[15] + 1) + ".jpg")));

        inferior = new JPanel();

        inferior.add(uno2);
        inferior.add(dos2);
        inferior.add(tres2);
        inferior.add(cuatro2);
        inferior.add(cinco2);
        inferior.add(seis2);
        inferior.add(siete2);
        inferior.add(ocho2);
        inferior.add(nueve2);
        inferior.add(diez2);
        inferior.add(once2);
        inferior.add(doce2);
        inferior.add(trece2);
        inferior.add(catorce2);
        inferior.add(quince2);
        inferior.add(dieciseis2);

        inferior.setLayout(new GridLayout(4, 4, 4, 4));
        frame = new JFrame("Carta 2");

        frame.add(inferior, BorderLayout.NORTH);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        Loteria obj = new Loteria();
        obj.setVisible(true);
        //new Loteria();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
