package controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.VocabularyContent;
import DAO.VocabularyContentDAO;
import DB.DBConnection;

@WebServlet("/EditVocabularyContentAudioController")
public class EditVocabularyContentAudioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditVocabularyContentAudioController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getCharacterEncoding() == null) {
			request.setCharacterEncoding("UTF-8");
		}
		System.out.println(request.getParameter("vocabularycontentid"));
		int vocabularycontentid = Integer.parseInt(request.getParameter("vocabularycontentid"));
		String vocabularyaudio = request.getParameter("vocabularyAudio");
		int vocabularyguidelineid = Integer.parseInt(request.getParameter("vocabularyguidelineid"));

		VocabularyContent vocabularyContent = new VocabularyContent();
		vocabularyContent.setVocabularycontentid(vocabularycontentid);
		vocabularyContent.setAudiomp3(vocabularyaudio);
		vocabularyContent.setVocabularyguidelineid(vocabularyguidelineid);

		Connection conn = DBConnection.createConnection();
		
		VocabularyContentDAO.uploadSingleAudio(conn, request, response, vocabularyContent);
	}

}
