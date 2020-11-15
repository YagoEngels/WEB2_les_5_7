package ui.controler;
import model.db.DatabaseStudent;
import model.domain.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.http.HttpRequest;
import java.util.ArrayList;

@WebServlet("/servlet")
public class servlet extends HttpServlet {

    DatabaseStudent databaseStudent = new DatabaseStudent();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        giverOfTasks(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        giverOfTasks(request,response);
    }

    private void giverOfTasks(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        String task = "home";
        if (request.getParameter("task") != null){
            task = request.getParameter("task");
            System.out.println(task);
        }

        String a = "";
        switch (task){
            case "home":
                a = home(request,response);
                break;
            case "overview":
                a = overview(request,response);
                break;
            case "find":
                a = find(request,response);
                break;
            case "add":
                a = add(request,response);
                break;
        }
        request.getRequestDispatcher(a).forward(request, response);
    }

    private String home (HttpServletRequest request, HttpServletResponse response){
        return "index.html";
    }
    private String overview (HttpServletRequest request, HttpServletResponse response){
        request.setAttribute("db",databaseStudent.getStudents());
        return "studentInfoOverzicht.jsp";
    }
    private String find (HttpServletRequest request, HttpServletResponse response){
        String naam = request.getParameter("naam");
        String achternaam = request.getParameter("achternaam");

        String abc = databaseStudent.getleeftijdEnRichting(achternaam,naam);
        if (abc.trim().isEmpty()){
            abc = "er is geen informatie over deze student probeer een anderen student";
        }
        request.setAttribute("TheOneString", abc);
        return ("studentGet.jsp");
    }

    private String add(HttpServletRequest request,HttpServletResponse response){
        ArrayList<String> error = new ArrayList<>();

        Student student = new Student();

        setNaam(student,request,error);
        setVoorNaam(student,request,error);
        setStudieRichting(student,request,error);
        setLeeftijd(student,request,error);

        if (error.size() == 0){
            try {
                databaseStudent.addToDb(student);
                return overview(request,response);
            } catch (IllegalArgumentException exception){
                error.add(exception.getMessage());
            }
        }
        request.setAttribute("errors",error);
        return "add.jsp";
    }



    private void setVoorNaam(Student student, HttpServletRequest request, ArrayList<String>errors){
        String voornaam = request.getParameter("naam");
        try {
            student.setVoornaam(voornaam);
            request.setAttribute("voornaamIsSafe",voornaam);
        } catch (IllegalArgumentException illegalArgumentException){
            errors.add(illegalArgumentException.getMessage());
        }
    }

    private void setNaam(Student student, HttpServletRequest request, ArrayList<String>errors){
        String naam = request.getParameter("achternaam");
        try {
            student.setNaam(naam);
            request.setAttribute("naamIsSafe",naam);
        } catch (IllegalArgumentException illegalArgumentException){
            errors.add(illegalArgumentException.getMessage());
        }
    }

    private void setLeeftijd(Student student, HttpServletRequest request, ArrayList<String>errors){
        String leeftijd = request.getParameter("leeftijd");
        try {
            student.setLeeftijd(Integer.parseInt(leeftijd));
            request.setAttribute("leeftijdIsSafe",leeftijd);
        } catch (IllegalArgumentException illegalArgumentException){
            errors.add(illegalArgumentException.getMessage());
        }
    }

    private void setStudieRichting(Student student, HttpServletRequest request, ArrayList<String>errors){
        String richting = request.getParameter("richting");
        try {
            student.setStudierichting(richting);
            request.setAttribute("studieRichtingIsSafe",richting);
        } catch (IllegalArgumentException illegalArgumentException){
            errors.add(illegalArgumentException.getMessage());
        }
    }

}
