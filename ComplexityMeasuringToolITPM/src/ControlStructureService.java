import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class ControlStructureService
 */
@WebServlet("/ControlStructureService")
public class ControlStructureService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControlStructureService() {
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
		// TODO Auto-generated method stub

		response.setContentType("text/html");

		String value = request.getParameter("submit");
		/* System.out.println(value); */

		String[] values = value.split("\\r?\\n");
		ArrayList<String> list = new ArrayList<String>();

		for (int i = 0; i < values.length; i++) {
			/* out.print(values[i]); */
			list.add(i, values[i]);

		}
		/*
		 * System.out.println(value); ArrayList list1 = new ArrayList(); list1 =
		 * ControlStructure.Control(list);
		 * 
		 * request.setAttribute("List", list1);
		 */

		// Line number list
		ArrayList<Integer> lineNum = new ArrayList<Integer>();
		lineNum = ControlStructure.LineNum(list);

		// Wtcs list
		ArrayList<Integer> Wtcs = new ArrayList<Integer>();
		Wtcs = ControlStructure.Wtcs(list);

		// Nc list
		ArrayList<Integer> Nc = new ArrayList<Integer>();
		Nc = ControlStructure.Nc(list);

		// Ccspps
		ArrayList<Integer> Ccspps = new ArrayList<Integer>();
		Ccspps = ControlStructure.Ccspps(list, Nc, Wtcs);

		// Ccs
		ArrayList<Integer> Ccs = new ArrayList<Integer>();
		Ccs = ControlStructure.Ccs(list, Nc, Wtcs, Ccspps);

		request.setAttribute("List", list);
		request.setAttribute("lineNum", lineNum);

		request.setAttribute("Wtcs", Wtcs);

		request.setAttribute("Nc", Nc);

		request.setAttribute("Ccspps", Ccspps);

		request.setAttribute("Ccs", Ccs);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ControlStructure.jsp");
		dispatcher.forward(request, response);

	}

}
