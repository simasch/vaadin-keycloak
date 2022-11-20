package ch.martinelli.demo.keycloak.views.admin;

import ch.martinelli.demo.keycloak.views.MainLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.annotation.security.RolesAllowed;

@PageTitle("Admin")
@Route(value = "admin", layout = MainLayout.class)
@RolesAllowed("ADMIN")
public class AdminView extends HorizontalLayout {

    public AdminView() {
        setPadding(true);

        add(new H1("Admin"));
    }

}
