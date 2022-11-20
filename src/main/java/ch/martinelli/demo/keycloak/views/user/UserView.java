package ch.martinelli.demo.keycloak.views.user;

import ch.martinelli.demo.keycloak.views.MainLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.annotation.security.RolesAllowed;

@PageTitle("User")
@Route(value = "user", layout = MainLayout.class)
@RolesAllowed("USER")
public class UserView extends HorizontalLayout {

    public UserView() {
        setPadding(true);

        add(new H1("User"));
    }

}
