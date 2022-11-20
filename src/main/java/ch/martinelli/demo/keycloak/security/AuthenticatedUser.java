package ch.martinelli.demo.keycloak.security;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.server.VaadinServletRequest;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuthenticatedUser {

    private final LogoutHandler logoutHandler;

    public AuthenticatedUser(LogoutHandler logoutHandler) {
        this.logoutHandler = logoutHandler;
    }

    private Optional<Authentication> getAuthentication() {
        SecurityContext context = SecurityContextHolder.getContext();
        return Optional.ofNullable(context.getAuthentication())
                .filter(authentication -> !(authentication instanceof AnonymousAuthenticationToken));
    }

    public void logout() {
        logoutHandler.logout(VaadinServletRequest.getCurrent().getHttpServletRequest(), null,
                SecurityContextHolder.getContext().getAuthentication());
        UI.getCurrent().getPage().setLocation(SecurityConfiguration.LOGOUT_URL);
    }

}
