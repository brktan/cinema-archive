package com.buraktan.app.views.movie;

import com.buraktan.app.views.MainLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("Movie")
@Route(value = "movie", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class MovieView extends HorizontalLayout {

    public MovieView() {

    }
}
