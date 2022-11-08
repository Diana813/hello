package resources.layouts.panels;

import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import static resources.styles.AppColors.transparent;

/**
 * Panel jest klasą dziedziczącą po klasie JPanel, a jej zadaniem jest zapobieganie powstawaniu artefaktów spowodowanych
 * używaniem transparentnego tła. Wywołanie metody setOpaque(false) powoduje, że RepaintManager musi
 * znaleźć nieprzejrzystego przodka danego komponentu. Gdy to zrobi, ponownie maluje przodka i wszystkie
 * jego dzieci. Jeśli jednak tło użyte w komponencie będzie w jakimś stopniu przeźroczyste,
 * wywołanie metody setOpaque(false) spowoduje, że zarówno przodek jak i dzieci zostaną pomalowane,
 * ale tło składników nie, więc efekt przźroczystości zostanie utracony.
 * Również wywołanie metody setOpaque(true) nie jest dobrym rozwiązaniem, ponieważ spowoduje,
 * że wszystkie piksele zostaną przemalowane, ale ponieważ są przezroczyste, mogą pojawić się nieoczekiwane
 * artefakty malarskie. Klasa Panel rozwiązuje ten problem poprzez malowanie przodka
 * komponentu najpierw, a później tła komponentu. Zostało to zrealizowane poprzez wywołanie metody
 * setOpaque(false) i nadpisanie metody paintComponent(). Ponieważ aplikacja używa tła o różnej przeźroczystości
 * dla wszystkich komponentów, to wszystkie one będą dziedziczyły po klasie Panel.
 */
public class Panel extends JPanel {

    /**
     * Konstruktor klasy Panel, który tworzy nowy obiekt Panel o przeźroczystym tle i marginesach o szrokości 2 piseli
     */
    public Panel() {
        this.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        this.setOpaque(false);
        this.setBackground(transparent);
    }

    /**
     * Nadpisuje metodę paintComponent() klasy JComponent() w celu zapewnienia odpowiedniej kolejności malowania tła.
     */
    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }

}
