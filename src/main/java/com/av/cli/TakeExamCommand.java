package com.av.cli;


import com.av.services.ScreeningService;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class TakeExamCommand {

    private final ScreeningService screeningService;

    public TakeExamCommand(ScreeningService screeningService) {
        this.screeningService = screeningService;
    }

    @ShellMethod("Take exam and report generate")
    public void exam() {
        screeningService.startScreening();
    }

    @ShellMethod("Hello World")
    public void hello() {
        System.out.println("Hello Spring Shell!!");
    }
}
