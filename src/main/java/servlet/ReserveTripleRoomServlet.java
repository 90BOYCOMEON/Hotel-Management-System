package servlet;

import db.Reserve;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class ReserveTripleRoomServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        this.doPost(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/json;charset=UTF-8");
        PrintWriter out=resp.getWriter();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",0);
        jsonObject.put("msg","");
        jsonObject.put("count",100);
        JSONArray result = null;
        Reserve re = new Reserve();
        result = JSONArray.fromObject( re.availableRoom("三人间"));
        jsonObject.put("data",result);
        out.println(jsonObject.toString());
        out.flush();
        out.close();
    }
}
