package elementarz;

import javax.swing.*;
import java.awt.*;
/**
 * Klasa Images zawierająca zasoby graficzne gry
 * Klasa zawiera obiekty przechowujące typ Images oraz String (ścieżki plików które są 
 * wywyoływane w metodzie zwracającej obiekt klasy ImageIcon)
 * @author Tomek Bojarski
 */

public class Images extends JFrame{
	/**  Zmienna statyczna typu int przechowująca indeks tablicy String[] image  */
	public static int i = 0 ;
	/**  Tablica image typu String przechowująca ścieżki plików graficznych  */
	public static String[] image;
	/**  Obiekt typu Icon przechowujący grafikę przycisku back  */
	public static Icon back;
	/**  Obiekt typu Icon przechowujący grafikę przycisku magentaBtn  */
	public static Icon magenta;
	/**  Obiekt typu Icon przechowujący grafikę przycisku redBtn  */
	public static Icon red;
	/**  Obiekt typu Icon przechowujący grafikę przycisku blueBtn  */
	public static Icon blue;
	/**  Obiekt typu Icon przechowujący grafikę przycisku clearBtn  */
	public static Icon clear;
	/**  Obiekt typu Icon przechowujący grafikę przycisku greenBtn  */
	public static Icon green;
	/**  Obiekt typu Icon przechowujący grafikę przycisku next  */
	public static Icon next;
	/**  Obiekt typu Icon przechowujący grafikę przycisku mode  */
	public static Icon letters;
	/**  Obiekt typu Icon przechowujący grafikę przycisku mode  */
	public static Icon words;
	/**  Obiekt typu Icon przechowujący grafikę przycisku mode  */
	public static Icon sentences;
	
	/**
     * Metoda zawierająca zdefiniowane zasoby graficzne (dla przycisków obiekty typu ImageIcon które są ikonami dla przycisków panelu graficzego
     * oraz tablicę image[] zawierającą ścieżki plików szablonów
     */
public static void loadInitialImages() {
	/**  Obiekt Icon zawierający plik graficzny magentaBtn  */
	magenta= new ImageIcon("images/button_magenta.png");
	/**  Obiekt Icon zawierający plik graficzny back  */
    back = new ImageIcon("images/back.png");
    /**  Obiekt Icon zawierający plik graficzny redBtn  */
    red= new ImageIcon("images/button_czerwony.png");
    /**  Obiekt Icon zawierający plik graficzny blueBtn  */
    blue= new ImageIcon("images/button_niebieski.png");
    /**  Obiekt Icon zawierający plik graficzny clearBtn  */
    clear= new ImageIcon("images/button_x.png");
    /**  Obiekt Icon zawierający plik graficzny greenBtn  */
    green= new ImageIcon("images/button_zielony.png");
    /**  Obiekt Icon zawierający plik graficzny next  */
    next= new ImageIcon("images/next.png");
    /**  Obiekt Icon zawierający plik graficzny mode  */
    letters = new ImageIcon("images/button_litery.png");
    /**  Obiekt Icon zawierający plik graficzny mode  */
    words = new ImageIcon("images/button_wyrazy.png");
    /**  Obiekt Icon zawierający plik graficzny mode  */
    sentences = new ImageIcon("images/button_zdania.png");
    
    /**  Tablica String zawieracąca ścieżki plików graficznych  */
	image= new String[52];
	image[0] = "images/A.jpg";
	image[1] = "images/B.jpg";
	image[2] = "images/C.jpg";
	image[3] = "images/D.jpg";
	image[4] = "images/E.jpg";
	image[5] = "images/F.jpg";
	image[6] = "images/G.jpg";
	image[7] = "images/H.jpg";
	image[8] = "images/I.jpg";
	image[9] = "images/J.jpg";
	image[10] = "images/K.jpg";
	image[11] = "images/L.jpg";
	image[12] = "images/M.jpg";
	image[13] = "images/N.jpg";
	image[14] = "images/O.jpg";
	image[15] = "images/P.jpg";
	image[16] = "images/R.jpg";
	image[17] = "images/S.jpg";
	image[18] = "images/T.jpg";
	image[19] = "images/U.jpg";
	image[20] = "images/W.jpg";
	image[21] = "images/Y.jpg";
	image[22] = "images/Z.jpg";///
	image[23] = "images/Ą.jpg";
	image[24] = "images/Ć.jpg";
	image[25] = "images/Ę.jpg";
	image[26] = "images/Ł.jpg";
	image[27] = "images/Ń.jpg";
	image[28] = "images/Ó.jpg";
	image[29] = "images/Ś.jpg";
	image[30] = "images/Ź.jpg";
	image[31] = "images/Ż.jpg";//
	image[32] = "images/Mama.jpg";
	image[33] = "images/Tata.jpg";
	image[34] = "images/Kotek.jpg";
	image[35] = "images/Dzban.jpg";
	image[36] = "images/Jabłko.jpg";
	image[37] = "images/Ptak.jpg";
	image[38] = "images/Szkoła.jpg";
	image[39] = "images/Sowa.jpg";
	image[40] = "images/Słoń.jpg";
	image[41] = "images/Pies.jpg";//
	image[42] = "images/Studiuję.jpg";
	image[43] = "images/Rano.jpg";
	image[44] = "images/Rodzynki.jpg";
	image[45] = "images/Palenie.jpg";
	image[46] = "images/Pije.jpg";
	image[47] = "images/Tam.jpg";
	image[48] = "images/My.jpg";
	image[49] = "images/Chodzę.jpg";
	image[50] = "images/Chcę.jpg";
	image[51] = "images/Ala.jpg";
    }
/**
 * Metoda zwracająca obiekt klasy ImageIcon. Metoda przyjmuje jako parametr zmienną typu String
 */
public static Image loadImage(String fileName) {
    return new ImageIcon(fileName).getImage();
}
}