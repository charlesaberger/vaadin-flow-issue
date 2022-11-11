package com.example.application.views.about;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.radiobutton.RadioGroupVariant;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import lombok.Getter;

public class DemoDialog extends Dialog {

    private final boolean draggable;

    private final boolean closeOnOutsideClick;

    private final boolean resizable;

    private final VerticalLayout mainLayout = new VerticalLayout();

    private final TextField textField1 = new TextField("Text Field 1");

    private final TextArea textArea1 = new TextArea("Text Area 1");

    private final Checkbox showHiddenFields = new Checkbox("Show Hidden Fields");

    private final TextField textField2 = new TextField("Text Field 2");

    private final RadioButtonGroup<RadioOptions> radioOptions = new RadioButtonGroup<>("Choose an Option");

    private final HorizontalLayout buttonLayout = new HorizontalLayout();

    private final Button closeButton = new Button("Close");

    @Deprecated
    public DemoDialog(boolean draggable, boolean closeOnOutsideClick) {
        this.draggable = draggable;
        this.closeOnOutsideClick = closeOnOutsideClick;
        this.resizable = false;
        initialise();
    }

    public DemoDialog(DialogProperties properties) {
        this.draggable = properties.isDraggable();
        this.closeOnOutsideClick = properties.isCloseOnOutsideClick();
        this.resizable = properties.isResizable();
        initialise();
    }

    private void initialise() {
        setDraggable(draggable);
        setCloseOnOutsideClick(closeOnOutsideClick);
        setResizable(resizable);
        setHeaderTitle(String.format("Draggable: %s, Close on Outside Click: %s, Resizable: %s", draggable, closeOnOutsideClick, resizable));

        textArea1.setHeight("200px");
        textArea1.setWidth("500px");

        showHiddenFields.addClickListener(this::showHiddenFieldsClicked);

        textField2.setVisible(false);

        radioOptions.setVisible(false);
        radioOptions.setItems(RadioOptions.values());
        radioOptions.addThemeVariants(RadioGroupVariant.LUMO_VERTICAL);
        radioOptions.setItemLabelGenerator(RadioOptions::getTitle);

        mainLayout.add(textArea1, showHiddenFields, textField2, radioOptions);

        closeButton.addClickListener(event -> this.close());

        buttonLayout.add(closeButton);

        add(mainLayout, buttonLayout);
    }

    private void showHiddenFieldsClicked(ClickEvent<Checkbox> checkboxClickEvent) {
        boolean isChecked = checkboxClickEvent.getSource().getValue();
        textField2.setVisible(isChecked);
        radioOptions.setVisible(isChecked);
    }

    enum RadioOptions {
        OPTION_1("Option 1"),
        OPTION_2("Option 2"),
        OPTION_3("Option 3"),
        OPTION_4("Option 4");

        @Getter
        final String title;

        RadioOptions(String title) {
            this.title = title;
        }
    }

}
