package com.example.application.views.about;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DialogProperties {

    boolean draggable;

    boolean closeOnOutsideClick;

    boolean resizable;
}
