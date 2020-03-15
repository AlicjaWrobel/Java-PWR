package lab01.model;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa abstrakcyjna do sortowania elementow IntElement
 */
public abstract class AbstractIntSorter{

    /**
     * Lista składjąca się z IntElementow do posrtowania
     * @param list lista elementów do posortownia
     * @return posortowana lista
     */
    public abstract List<IntElement> solveInt(List<IntElement> list);
    /**
     * Opis metody sortowania danych
     * @return zmienna String przechowujaca opis metody
     */
    public abstract String description();
    /**
     * Czy algorytm stabilny?
     * @return zwraca informacje czy algorytm jest stabliny
     */
    public abstract boolean isStable();
    /**
     * Czy algorytm sortowania w miejscu?
     * @return zwraca informacje czy algorytm jest algorytmem w miejscu
     */
    public abstract boolean isInSitu();
}
