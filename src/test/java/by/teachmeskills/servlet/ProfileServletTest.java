package by.teachmeskills.servlet;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

class ProfileServletTest extends Mockito {
    @Test
    void WhenCallProfileThenRedirect() throws ServletException, IOException {
        ProfileServlet servlet = new ProfileServlet();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);

        when(request.getRequestDispatcher("/profile.jsp")).thenReturn(dispatcher);

        servlet.doGet(request, response);
        verify(request, times(1)).getRequestDispatcher("/profile.jsp");
        verify(dispatcher).forward(request, response);
    }
}