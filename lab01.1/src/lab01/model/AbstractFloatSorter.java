package lab01.model;

import java.util.List;
/**
 * Klasa abstrakcyjna do sortowania elementow IntElement dziedziczonych z AbstractIntSorter
 */
public abstract class AbstractFloatSorter extends AbstractIntSorter{

    /**
     * Metoda sortownia liczb typu float
     * @param list lista elementów do posortownia
     * @return posortowana lista
     */
    public abstract List<IElement> solveFloat(List<IElement> list);
}
