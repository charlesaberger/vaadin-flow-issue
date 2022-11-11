package com.example.application.views.about;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("About")
@Route(value = "about", layout = MainLayout.class)
public class AboutView extends VerticalLayout {

    public AboutView() {
        setSpacing(false);

        Checkbox draggable = new Checkbox("Make draggable");
        Checkbox closeOnOutsideClick = new Checkbox("Close on Outside Click");
        Checkbox resizable = new Checkbox("Resizable");
        Button openDialog = new Button("Open Dialog");
        openDialog.addClickListener(event -> new DemoDialog(DialogProperties.builder()
                .draggable(draggable.getValue())
                .closeOnOutsideClick(closeOnOutsideClick.getValue())
                .resizable(resizable.getValue())
                .build()).open());

        add(draggable, closeOnOutsideClick, resizable, openDialog);

        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");
    }

}
