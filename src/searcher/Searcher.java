package searcher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspApplicationContext;

import org.json.JSONArray;
import org.json.JSONObject;



/**
 * Servlet implementation class Searcher
 */
@WebServlet("/Searcher")
public class Searcher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Searcher() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String query = request.getParameter("query");
		String url = "http://api.nytimes.com/svc/search/v2/articlesearch.json?q="+query+"&api-key=b345a67a98634b2fba2c03b14c4ec7b1";
		try {
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer json = new StringBuffer();
			while((inputLine=in.readLine())!=null) {
				json.append(inputLine);
			}
			in.close();
			
			ArrayList<Article> articles=new ArrayList<Article>();
			JSONObject results= new JSONObject(json.toString());
			JSONObject responses= new JSONObject(results.getJSONObject("response").toString());
			JSONArray docs=(JSONArray)responses.get("docs");
			for(int i=0;i<docs.length();i++) {
				JSONObject doc= new JSONObject(docs.get(i).toString());
				
				String docUrl=doc.getString("web_url");
				JSONObject docHeadline=new JSONObject(doc.getJSONObject("headline").toString());
				String docHead=docHeadline.getString("main");
				
				String docSnip=doc.getString("snippet");
				articles.add(new Article(docUrl,docHead,docSnip));
				
				Mysql.SavetoSql(docUrl, docHead, docSnip);
			}
			request.setAttribute("articles", articles);
			request.getRequestDispatcher("SearchResult.jsp").forward(request, response);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
