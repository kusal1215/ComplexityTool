
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Coupling;
import model.GlobalSet;
import model.Recursive;
import model.Regular;

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

		String value = request.getParameter("weightId");
		System.out.println(value);
		

		// ...............
		// ...............
		int WNr = Integer.parseInt(request.getParameter("row1"));
		int WNmcms = Integer.parseInt(request.getParameter("row2"));
		int WNmcmd = Integer.parseInt(request.getParameter("row3"));
		int WNmcrms = Integer.parseInt(request.getParameter("row4"));
		int WNmcrmd = Integer.parseInt(request.getParameter("row5"));
		int WNrmcrms = Integer.parseInt(request.getParameter("row6"));
		int WNrmcrmd = Integer.parseInt(request.getParameter("row7"));
		int WNrmcms = Integer.parseInt(request.getParameter("row8"));
		int WNrmcmd = Integer.parseInt(request.getParameter("row9"));
		int WNmrgvs = Integer.parseInt(request.getParameter("row10"));
		int WNmrgvd = Integer.parseInt(request.getParameter("row11"));
		int WNrmrgvs = Integer.parseInt(request.getParameter("row12"));
		int WNrmrgvd = Integer.parseInt(request.getParameter("row13"));

		System.out.println(WNrmcrmd);
		System.out.println(WNmrgvd);
		System.out.println(WNrmrgvs);
		System.out.println(WNrmrgvd);
		// ...............
		// ...............

		String[] values = value.split("\\r?\\n");
		ArrayList<String> list = new ArrayList<String>();

		/*
		 * Line Set
		 * 
		 */
		for (int i = 0; i < values.length; i++) {
			list.add(i, values[i]);
		}

		// testingRecursive
		ArrayList<Recursive> RecursiveModelList = new ArrayList<Recursive>();
		RecursiveModelList = CodeCoupling.Recursive(list);

		// testingRegular
		ArrayList<Regular> RegularModelList = new ArrayList<Regular>();
		RegularModelList = CodeCoupling.Regular(list);

		ArrayList<Coupling> couplingList = new ArrayList<Coupling>();
		couplingList = CodeCoupling.Coupling(list);

		ArrayList<Integer> CcpList = new ArrayList<Integer>();
		CcpList = CodeCoupling.Ccp(list, WNr, WNmcms, WNmcmd, WNmcrms, WNmcrmd, WNrmcrms, WNrmcrmd, WNrmcms, WNrmcmd,
				WNmrgvs, WNmrgvd, WNrmrgvs, WNrmrgvd);

		ArrayList<GlobalSet> GlobalList = new ArrayList<GlobalSet>();
		GlobalList = CodeCoupling.GlobalVariable(list);

		
		//ends here.....

		
		request.setAttribute("lines", list);
		request.setAttribute("couplingList", couplingList);
		request.setAttribute("CcpList", CcpList);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Coupling.jsp");
		dispatcher.forward(request, response);

	}

}
