package by.teachmeskills.servlet;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


class RegistrationServletTest extends Mockito {
    @Test
    public void testServlet() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        when(request.getParameter("name")).thenReturn("ivan");
        when(request.getParameter("surname")).thenReturn("ivanov");
        when(request.getParameter("email")).thenReturn("hhhh@hh.ru");
        when(request.getParameter("password")).thenReturn("111");




        new RegistrationServlet().doPost(request, response);


    }
}