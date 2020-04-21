
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CouplingService
 */
@WebServlet("/CouplingService")
public class CouplingService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CouplingService() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		String value = request.getParameter("submit");

		String[] values = value.split("\\r?\\n");
		ArrayList<String> list = new ArrayList<String>();

		/*
		 * Access lines
		 * 
		 */
		for (int i = 0; i < values.length; i++) {
			/* out.print(values[i]); */
			list.add(i, values[i]);
		}

		/*
		 * Access line numbers
		 * 
		 */
		ArrayList<Integer> lineNum = new ArrayList<Integer>();
		lineNum = coupling.LineNumber(list);

		/*
		 * 
		 * Call Nr method in the coupling class
		 * 
		 */
		ArrayList<Integer> Nr = new ArrayList<Integer>();
		Nr = coupling.Nr(list);
		System.out.println("Size of the Nr list" + Nr.size());

		ArrayList<Integer> Wr = new ArrayList<Integer>();
		Wr = coupling.Wr(Nr);

		/*
		 * 
		 * Call Nmcms method in the ReguarMethods class
		 * 
		 */
		ArrayList<Integer> Nmcms = new ArrayList<Integer>();
		Nmcms = RegularMethods.Nmcms(list);
		System.out.println("Size of the Nr list" + Nmcms.size());

		ArrayList<Integer> Wmcms = new ArrayList<Integer>();
		Wmcms = RegularMethods.Wmcms(Nmcms);

		/*
		 * 
		 * Call Nrmcms method in the Regular Methods class
		 * 
		 */
		ArrayList<Integer> Nrmcms = new ArrayList<Integer>();
		Nrmcms = RecursiveMethods.Nrmcms(list);
		System.out.println("Size of the Nr list" + Nrmcms.size());

		ArrayList<Integer> Wrmcms = new ArrayList<Integer>();
		Wrmcms = RecursiveMethods.Wrmcms(Nrmcms);

		/*
		 * 
		 * Call Nrmcrms method in the Recursive Methods class
		 * 
		 */
		ArrayList<Integer> Nrmcrms = new ArrayList<Integer>();
		Nrmcrms = RecursiveMethods.Nrmcrms(list);
		System.out.println("Size of the Nr list" + Nrmcrms.size());

		ArrayList<Integer> Wrmcrms = new ArrayList<Integer>();
		Wrmcrms = RecursiveMethods.Wrmcrms(Nrmcrms);

		/*
		 * 
		 * Call Nmcrms method in the Recursive Methods class
		 * 
		 */
		ArrayList<Integer> Nmcrms = new ArrayList<Integer>();
		Nmcrms = RegularMethods.Nmcrms(list);
		System.out.println("Size of the Nr list" + Nmcrms.size());

		ArrayList<Integer> Wmcrms = new ArrayList<Integer>();
		Wmcrms = RegularMethods.Wmcrms(Nmcrms);

		/*		
		*
		* Different Files
		*
		*/
		ArrayList<String> Nmcrmd = new ArrayList<String>();
		Nmcrmd = RecursiveMethods.Nrmcmd(list);
		
		
		
		
		request.setAttribute("num", lineNum);
		request.setAttribute("lines", list);

		request.setAttribute("Nr", Nr);
		request.setAttribute("Wr", Wr);

		request.setAttribute("Nmcms", Nmcms);
		request.setAttribute("Wmcms", Wmcms);

		request.setAttribute("Nrmcms", Nrmcms);
		request.setAttribute("Wrmcms", Wrmcms);

		request.setAttribute("Nrmcrms", Nrmcrms);
		request.setAttribute("Wrmcrms", Wrmcrms);

		request.setAttribute("Nmcrms", Nmcrms);
		request.setAttribute("Wmcrms", Wmcrms);
		
		request.setAttribute("Different", Nmcrmd);

		// request.setAttribute("List", list);

		// RequestDispatcher dispatcher =
		// getServletContext().getRequestDispatcher("/output.jsp");
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Coupling.jsp");
		dispatcher.forward(request, response);

	}

}
