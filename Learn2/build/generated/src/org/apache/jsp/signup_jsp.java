package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class signup_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Signup</title>\n");
      out.write("         <!-- Compiled and minified CSS -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css\">\n");
      out.write("\n");
      out.write("        <!-- Compiled and minified JavaScript -->\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js\"></script>\n");
      out.write("    </head> \n");
      out.write("    <body style=\"background:url(img/aim.png);background-attachment:fixed;\"> <!-- background-size:cover;-->\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col m-6 offset-m1\" > <!--m3-->   \n");
      out.write("                    <div class=\"card\">\n");
      out.write("                        <div class=\"card-content\">\n");
      out.write("                            <h3 style=\"margin-top:10px;\" class=\"center-align\"> Register Here </h1>\n");
      out.write("                            \n");
      out.write("                            <!h5 id=\"msg\" class=\"center-align\"><!--/h5--> <!-- Additioanlly in ajax for -->\n");
      out.write("                            \n");
      out.write("                            <div class=\"form center-align\">\n");
      out.write("                                <!Creating form>\n");
      out.write("                                <form action=\"Register\" method=\"POST\" id=\"myForm\">\n");
      out.write("                                    <input type=\"text\" placeholder=\"Enter Name\"  name=\"user_name\" />\n");
      out.write("                                    <input type=\"password\" placeholder=\"Enter Password\"  name=\"user_password\" />\n");
      out.write("                                    <input type=\"email\" placeholder=\"Enter Email\"  name=\"user_email\" />\n");
      out.write("                                    \n");
      out.write("                                    <!--div class=\"file-field input-field\">\n");
      out.write("                                        <div class=\"btn\">\n");
      out.write("                                          <span>File</span>\n");
      out.write("                                          <input name=\"image\" type=\"file\">\n");
      out.write("                                        </div>  \n");
      out.write("                                        <div class=\"file-path-wrapper\">\n");
      out.write("                                          <input class=\"file-path validate\" type=\"text\">\n");
      out.write("                                        </div>\n");
      out.write("                                     </div>\n");
      out.write("                                    <!input type=\"file\" name=\"image\" size=\"50\"/></td-->\n");
      out.write("                                    \n");
      out.write("                                    <button type=\"submit\" class=\"btn red\">Submit</button>     \n");
      out.write("                                </form>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"loader center-align\" style=\"margin-top:10px; display:none;\">\n");
      out.write("                                <div class=\"preloader-wrapper big active\">\n");
      out.write("                                    <div class=\"spinner-layer spinner-blue-only\">\n");
      out.write("                                      <div class=\"circle-clipper left\">\n");
      out.write("                                        <div class=\"circle\"></div>\n");
      out.write("                                      </div><div class=\"gap-patch\">\n");
      out.write("                                        <div class=\"circle\"></div>  \n");
      out.write("                                      </div><div class=\"circle-clipper right\">\n");
      out.write("                                        <div class=\"circle\"></div>\n");
      out.write("                                      </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <h5> Please Wait... </h5>\n");
      out.write("                            </div>\n");
      out.write("                            \n");
      out.write("                            \n");
      out.write("                            \n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>   \n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.6.3.min.js\" integrity=\"sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <!--------script> <!--This script is checking jqery is working or not -->\n");
      out.write("            <!---$(document).ready(function(){\n");
      out.write("                console.log(\"Page is Ready...\")\n");
      out.write("                \n");
      out.write("                $(\"#myForm\").on('submit',function(event){\n");
      out.write("                    event.preventDefault();\n");
      out.write("                    var f= $(this).serialize();\n");
      out.write("                    console.log(f);\n");
      out.write("                    \n");
      out.write("                    $.(\".loader\").show();\n");
      out.write("                    $.(\".form\").hide();\n");
      out.write("                    \n");
      out.write("                    $.ajax({\n");
      out.write("                        url: \"Register\",\n");
      out.write("                        data: f,\n");
      out.write("                        type: 'POST',\n");
      out.write("                        success : function(data,textStatus,jqXHR){\n");
      out.write("                            console.log(data);\n");
      out.write("                            console.log(\"success....\");\n");
      out.write("                            $.(\".loader\").show();\n");
      out.write("                            $.(\".form\").hide();\n");
      out.write("                            if(data.trim()==='Done')\n");
      out.write("                            {\n");
      out.write("                                $('msg').html(\"Successfully Registered...\")\n");
      out.write("                                $('msg').addClass('green-text')\n");
      out.write("                                \n");
      out.write("                            }\n");
      out.write("                            else\n");
      out.write("                            {\n");
      out.write("                                $('msg').html(\"Something Went Wrong on Server...\")\n");
      out.write("                            }\n");
      out.write("                            \n");
      out.write("                        },\n");
      out.write("                        error : function(jqXHR,textStatus,errorThrown){\n");
      out.write("                            console.log(data);\n");
      out.write("                            console.log(\"Error....\");\n");
      out.write("                            $.(\".loader\").hide();\n");
      out.write("                            $.(\".form\").show();\n");
      out.write("                            $('msg').html(\"Something Went Wrong on Server...\")\n");
      out.write("                        },\n");
      out.write("                    })\n");
      out.write("                })\n");
      out.write("                \n");
      out.write("            })---------->\n");
      out.write("       \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
