package by.teachmeskills.servlet;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.http.HttpClient;


class RegistrationServletTest extends Mockito {
    @Test
    public void testServlet() throws Exception {
        RegistrationServlet registration = new RegistrationServlet();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);

        when(request.getRequestDispatcher("/registration.jsp")).thenReturn(dispatcher);

        registration.doGet(request, response);
        verify(request, times(1)).getRequestDispatcher("/registration.jsp");
        verify(dispatcher).forward(request, response);
        registration.doPost(request, response);


    }
}