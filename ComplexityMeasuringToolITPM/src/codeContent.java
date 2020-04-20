

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 * Servlet implementation class codeContent
 */
@WebServlet("/codeContent")
@MultipartConfig
public class codeContent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public codeContent() {
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

		HttpSession hs = request.getSession();

		String description = request.getParameter("description"); // Retrieves <input type="text" name="description">
		Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
		String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
		InputStream fileContent = filePart.getInputStream();

		String value = ReadCode.getValue(filePart);

		/*
		 * 
		 * 
		 * String[] values = value.split("\\r?\\n"); ArrayList list = new ArrayList();
		 * 
		 * for(int i = 0; i < values.length; i++){ out.print(values[i]); list.add(i,
		 * values[i]);
		 * 
		 * }
		 * 
		 * request.setAttribute("List",list);
		 */

		request.setAttribute("Value", value);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/UserPanel.jsp");
		dispatcher.forward(request, response);
	
		
	}

}
