package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <link rel = \"stylesheet\" href=\"Css/login.css\">\n");
      out.write("        <script src=\"https://kit.fontawesome.com/ff55557564.js\" crossorigin=\"anonymous\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <header>\n");
      out.write("            <div class=\"main-header\">\n");
      out.write("                <a href=\"HomeController\">\n");
      out.write("                    <img class=\"logo\" src=\"Resource/Thumbnail/logo.png\">\n");
      out.write("                </a>\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("        </header>\n");
      out.write("        <form action=\"LoginController\" method=\"post\">\n");
      out.write("            <div class=\"main-view\">\n");
      out.write("                <div class=\"card\">\n");
      out.write("                    <h1>Login</h1>\n");
      out.write("                    <p class=\"accountState\"> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${accountState}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" </p>\n");
      out.write("                    <p>Username</p>\n");
      out.write("                    <div class=\"inputInfo\">\n");
      out.write("                        <i class=\"fas fa-user fa-color\"></i>\n");
      out.write("                        <input type=\"text\" name=\"username\" placeholder=\"Enter Username...\" >\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <p>Password</p>\n");
      out.write("\n");
      out.write("                    <div class=\"inputInfo\">\n");
      out.write("                        <i class=\"fas fa-lock fa-color\"></i>\n");
      out.write("                        <input type=\"password\" name=\"password\" placeholder=\"Enter Password...\"><br>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <a href=\"#\" class=\"forgotPass\"><p>Forgot password?</p></a><br>\n");
      out.write("                    <input type=\"submit\" value=\"Login\"><br>\n");
      out.write("\n");
      out.write("                    <p class=\"loginWith\">Or Login With</p><br>\n");
      out.write("                    <div class=\"loginWithIcon\">\n");
      out.write("                        <i class=\"fab fa-facebook fa-2x\"></i>\n");
      out.write("                        <i class=\"fab fa-twitter fa-2x\"></i>\n");
      out.write("                        <i class=\"fab fa-google fa-2x\"></i>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"signUp\">\n");
      out.write("                        <a href=\"SignUpServlet\">SIGN UP</a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </form>\n");
      out.write("        \n");
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
