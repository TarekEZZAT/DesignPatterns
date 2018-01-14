

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Display
 */
@WebServlet("/Display")
public class Display extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Display() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//On récupère un paramètre de la requête
		String nomParam, valeurParam ;
		Enumeration e = request.getParameterNames();

		// flux de sortie
		ServletOutputStream sortie = response.getOutputStream();
		
		// page HTML
		sortie.println("<html>");
		sortie.println("<head>");
		sortie.println("<title> Paramètres récupérés </title>");
		sortie.println("</head>");
		sortie.println("<body>");

		while ( e.hasMoreElements() )
		{
			nomParam =  (String) e.nextElement();
			valeurParam = request.getParameter(nomParam);
			sortie.println("<p> nom du paramètre : " + nomParam + " </p>");
			sortie.println("<p> valeur : " + valeurParam + " </p>");	
		}

		sortie.println("</body>");		
		sortie.println("</html>");
		sortie.close();	
	} 

	

}
