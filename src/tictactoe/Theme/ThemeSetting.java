package tictactoe.Theme;
import javafx.scene.control.RadioButton;

public class ThemeSetting {

    public Theme currentTheme(RadioButton theme){
        switch (theme.getText()) {
            case "High Contrast":
                return new HighContrast();
            case "Forrest":
                return new ForrestTheme();
            default:
                return new ClassicTheme();
        }
    }
}

