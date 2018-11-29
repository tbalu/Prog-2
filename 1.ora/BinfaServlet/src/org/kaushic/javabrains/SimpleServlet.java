package org.kaushic.javabrains;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet(description = "A simple servlet", urlPatterns = { "/SimpleServletPath" })
public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("Hello from get method.");
		PrintWriter writer = response.getWriter();
		try {

			 java.io.FileInputStream beFile =
			         new java.io.FileInputStream(new java.io.File("C:\\Users\\Balu\\JavaProjektek\\SimpleServletProject\\src\\org\\kaushic\\javabrains\\be.txt"));
			 // fejlesztgetjük a forrást: http://progpater.blog.hu/2011/04/17/a_tizedik_tizenegyedik_labor
			         /*
			  * if (!beFile) { std::cout << inFile << " nem letezik..." << std::endl;
			  * usage (); return -3; }
			  */ /*
			  * std::fstream kiFile (*++argv, std::ios_base::out);
			  */
			 java.io.PrintWriter kiFile =
			         new java.io.PrintWriter(
			         new java.io.BufferedWriter(
			         new java.io.FileWriter("C:\\Users\\Balu\\JavaProjektek\\SimpleServletProject\\src\\org\\kaushic\\javabrains\\ki.txt")));

			 /*
			  * unsigned char b;	// ide olvassik majd a bejövő fájl bájtjait
			  *
			  */
			 byte[] b = new byte[1];
			 /*
			  * LZWBinFa binFa;	// s nyomjuk majd be az LZW fa objektumunkba
			  *
			  */
			 LZWBinFa binFa = new LZWBinFa();

			 // a bemenetet binárisan olvassuk, de a kimenő fájlt már karakteresen írjuk, hogy meg tudjuk
			 // majd nézni... :) l. az említett 5. ea. C -> C++ gyökkettes átírási példáit
			/*
			  * while (beFile.read ((char *) &b, sizeof (unsigned char))) if (b ==
			  * 0x0a) break;
			  */
			 /*while (beFile.read(b) != -1) {
			   if (b[0] == 0x0a) {
			     break;
			   }
			 }*/
			 /*
			  * bool kommentben = false;
			  *
			  */
			// boolean kommentben = false;

			 /*
			  * while (beFile.read ((char *) &b, sizeof (unsigned char))) {
			  *
			  * if (b == 0x3e) {	// > karakter kommentben = true; continue; }
			  *
			  * if (b == 0x0a) {	// újsor kommentben = false; continue; }
			  *
			  * if (kommentben) continue;
			  *
			  * if (b == 0x4e)	// N betű continue;
			  *
			  * // egyszerűen a korábbi d.c kódját bemásoljuk // laboron többször
			  * lerajzoltuk ezt a bit-tologatást: // a b-ben lévő bájt bitjeit egyenként
			  * megnézzük for (int i = 0; i < 8; ++i) { // maszkolunk eddig..., most már
			  * simán írjuk az if fejébe a legmagasabb helyiértékű bit vizsgálatát //
			  * csupa 0 lesz benne a végén pedig a vizsgált 0 vagy 1, az if megmondja
			  * melyik: if (b & 0x80) // ha a vizsgált bit 1, akkor az '1' betűt nyomjuk
			  * az LZW fa objektumunkba binFa << '1'; else // különben meg a '0' betűt:
			  * binFa << '0'; b <<= 1; }
			  *
			  * }
			  */
			 while (beFile.read(b) != -1) {

			  /* if (b[0] == 0x3e) {			// > karakter
			     kommentben = true;
			     continue;
			   }

			   if (b[0] == 0x0a) {			// újsor 
			     kommentben = false;
			     continue;
			   }

			   if (kommentben) {
			     continue;
			   }

			   if (b[0] == 0x4e) // N betű
			   {
			     continue;
			   }
			*/
			   // egyszerűen a korábbi d.c kódját bemásoljuk
			   // laboron többször lerajzoltuk ezt a bit-tologatást: 
			   // a b-ben lévő bájt bitjeit egyenként megnézzük
			   for (int i = 0; i < 8; ++i) {
			     // maszkolunk eddig..., most már simán írjuk az if fejébe a legmagasabb helyiértékű bit vizsgálatát
			     // csupa 0 lesz benne a végén pedig a vizsgált 0 vagy 1, az if megmondja melyik:
			     if ((b[0] & 0x80) != 0) // ha a vizsgált bit 1, akkor az '1' betűt nyomjuk az LZW fa objektumunkba
			     {
			       binFa.egyBitFeldolg('1');
			     } else // különben meg a '0' betűt:
			     {
			       binFa.egyBitFeldolg('0');
			     }
			     b[0] <<= 1;
			   }

			 }
			 

			 binFa.kiir(kiFile);
			 System.out.println(binFa.BinfaKep);
			 /*
			  * kiFile << "depth = " << binFa.getMelyseg () << std::endl; kiFile <<
			  * "mean = " << binFa.getAtlag () << std::endl; kiFile << "var = " <<
			  * binFa.getSzoras () << std::endl;
			  */
			 kiFile.println("depth = " + binFa.getMelyseg());
			 kiFile.println("mean = " + binFa.getAtlag());
			 kiFile.println("var = " + binFa.getSzoras());

			 kiFile.close();
			 beFile.close();
			 writer.println("<h3>"+binFa.BinfaKep+"</h3>"+"<p>"+binFa.getMelyseg()+"</p>"+"<p>"+binFa.getAtlag()
			 +"</p>"+"<p>"+binFa.getSzoras()+"</p>");
			} catch (java.io.FileNotFoundException fnfException) {
			 fnfException.printStackTrace();
			} catch (java.io.IOException ioException) {
			 ioException.printStackTrace();
			}

			
		
	}

}
