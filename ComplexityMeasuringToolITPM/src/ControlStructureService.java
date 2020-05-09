import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ControlStructures;

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

		String value = request.getParameter("ControlId");
		System.out.println(value);

		int WCondition = Integer.parseInt(request.getParameter("condition"));
		int WLoop = Integer.parseInt(request.getParameter("loop"));
		int WSwitch = Integer.parseInt(request.getParameter("switch"));
		int WCase = Integer.parseInt(request.getParameter("case"));

		System.out.println(WCondition);
		System.out.println(WLoop);
		System.out.println(WSwitch);
		System.out.println(WCase);

		String[] values = value.split("\\r?\\n");
		ArrayList<String> list = new ArrayList<String>();

		for (int i = 0; i < values.length; i++) {
		
			list.add(i, values[i]);

		}

		// Function calling

		ArrayList<ControlStructures> NCList = new ArrayList<ControlStructures>();
		NCList = CodeControlStructure.Nc(list, WCondition, WLoop, WSwitch, WCase);

		//function calling ends here................

		request.setAttribute("List", list);
		request.setAttribute("NCList", NCList);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ControlStructure.jsp");
		dispatcher.forward(request, response);

	}

}
