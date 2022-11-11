package resources.widgets;

import javax.swing.JComponent;
import javax.swing.JScrollPane;
import static resources.styles.AppColors.appNavyBlue;

/**
 * Klasa AppScrollPane, dziedzicząca po klasie JScrollPane, odpowiedzialna za wygląd suwaków w aplikacji
 */
public class AppScrollPane extends JScrollPane {

    private boolean isNewMessageDisplayed;

    /**
     * Tworzy nowy obiekt typu AppScrollPane
     *
     * @param component komponent objęty obszarem skrolowania
     */
    public AppScrollPane(JComponent component) {
        super(component);
        this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.getVerticalScrollBar().setBackground(appNavyBlue);
        this.getViewport().setOpaque(false);
        this.setOpaque(false);
        this.setBackground(appNavyBlue);
        this.getVerticalScrollBar().addAdjustmentListener(e -> {
            if(isNewMessageDisplayed){
                e.getAdjustable().setValue(e.getAdjustable().getMaximum());
                setNewMessageDisplayed(false);
            }
        });
    }

    /**
     * Setter ustawiający wartość pola isMessageDisplayed. Pole jest ustawiane na true jeśli właśnie wyświetlono nową
     * wiadomość. Wtedy scroll bar ustawia się na samym dole, tak żeby na ekranie zawsze była widoczna najbardziej
     * aktualna wiadomość. W każdej innej sytuacji setter jest ustawiony na wartość false, żeby użytkownik
     * mógł przesuwać zawartość ekranu za pomocą suwaka
     * @param newMessageDisplayed parametr przyjmujący wartość true lub false
     */
    public void setNewMessageDisplayed(boolean newMessageDisplayed) {
        this.isNewMessageDisplayed = newMessageDisplayed;
    }
}
