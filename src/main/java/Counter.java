import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Counter extends HttpServlet {
    int accesses = 0;

    protected String myParam = null;

  public void init(ServletConfig servletConfig) throws ServletException{
    this.myParam = servletConfig.getInitParameter("myParam");
  }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
         throws IOException, ServletException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        //  System.out.println("Working Directory = " + System.getProperty("user.dir"));
        
        // String[] pathnames;
        // String path = System.getProperty("user.dir") + "\\src\\main\\resources";
        // // Creates a new File instance by converting the given pathname string
        // // into an abstract pathname
        // File f = new File(path);

        // // Populates the array with names of files and directories
        // pathnames = f.list();

        // // For each pathname in the pathnames array
        // for (String pathname : pathnames) {
        //     // Print the names of files and directories
        //     System.out.println(pathname);
        // }
        // String myContextParam =
        // request.getSession()
        //        .getServletContext()
        //        .getInitParameter("myParam");
        String value = System.getProperty("config");
        Map<String, String> env = System.getenv();
        
        // System.out.println(value);
        // System.out.println();
            // System.out.println("NULLLL1");

        InputStream ip = getClass().getClassLoader().getResourceAsStream(value);
            // System.out.println("NULLLL2");
        
        // if ( ip == null )
        // {
        //     System.out.println("NULLLL");
        // }
        //     System.out.println("NULLLL3");

        //FileReader reader=new FileReader(this.myParam);  
        Properties p=new Properties();  
        p.load(ip);
        accesses++;
        String user = env.get("USER");
        if ( user ==  null){
            user = p.getProperty("user");
        }

        // out.print("Number of times this " + System.getProperty("user.dir") + " servlet has been accessed:" + accesses);
        out.print("Number of times this is \t" + user + "\t servlet has been accessed:" + accesses);
        
    }
} 