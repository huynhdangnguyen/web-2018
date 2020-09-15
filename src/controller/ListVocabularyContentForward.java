package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.VocabularyContent;
import DAO.VocabularyContentDAO;

@WebServlet("/ListVocabularyContentForward")
public class ListVocabularyContentForward extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListVocabularyContentForward() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int vocabularyguidelineid = Integer.parseInt(request.getParameter("vocabularyguidelineid"));
		
		VocabularyContent vocabularyContent = new VocabularyContent();
		vocabularyContent.setVocabularyguidelineid(vocabularyguidelineid);
		
		request.setAttribute("vocabularyguidelineid", vocabularyguidelineid);
		
		VocabularyContentDAO.getVocabularyContent(vocabularyContent);
		
		request.setAttribute("vocabularyContentList", VocabularyContentDAO.vocabularyContentList);
		
		RequestDispatcher rd = request.getRequestDispatcher("View/Admin/listVocabularyContent.jsp");
		rd.forward(request, response);
	}

}
