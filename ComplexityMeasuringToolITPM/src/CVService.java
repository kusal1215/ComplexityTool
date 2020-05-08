

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CVService
 */
@WebServlet("/CVService")
public class CVService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CVService() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");

		String value = request.getParameter("userId");
		System.out.println(value);
		System.out.println("xxxxxxxxxxxxxxxxxxx");
		
		int Globalvariable = Integer.parseInt(request.getParameter("Globalvariable"));
		int Localvariable = Integer.parseInt(request.getParameter("Localvariable"));
		int Primitivedatatypevariable = Integer.parseInt(request.getParameter("Primitivedatatypevariable"));
		int Compositedatatypevariable = Integer.parseInt(request.getParameter("Compositedatatypevariable"));
		
		
		System.out.println(Globalvariable);
		System.out.println(Localvariable);
		System.out.println(Primitivedatatypevariable);
		System.out.println(Compositedatatypevariable);
		
		
		String[] values = value.split("\\r?\\n");
		ArrayList list = new ArrayList();
		
		for (int i = 0; i < values.length; i++) {
			/* out.print(values[i]); */
			list.add(i, values[i]);

		}
		
		
		
		  ArrayList<Integer> list1 = new ArrayList<Integer>(); 
		  list1 =  Cv.variable(list,Globalvariable,Localvariable,Primitivedatatypevariable,Compositedatatypevariable);
		 
		request.setAttribute("List", list1);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Variables.jsp");
		dispatcher.forward(request, response);
	}

}
