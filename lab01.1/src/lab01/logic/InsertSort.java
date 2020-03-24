package lab01.logic;

import lab01.model.AbstractFloatSorter;
import lab01.model.IElement;
import lab01.model.IntElement;
import java.util.List;

/**
 * Algorytm sortowania przez wstawienie InsertSort
 */
public class InsertSort extends AbstractFloatSorter {
    /**
     * Metoda sortowania InsertSort zmiennych typu float
     * @param list lista elementow do posortownia
     * @return zwraca liste posortowanych elemtow
     */
    @Override
    public List<IElement> solveFloat(List<IElement> list) {
        int size = list.size();
        IntElement selected = new IntElement("", 0);
        for(int i = 1; i < size; ++i){
            //zaczynamy od 1 pozycji listy, pobieramy liczbe do porownan
            selected.setValue(list.get(i).getValue());
            selected.setName(list.get(i).getName());
            //zaczynamy porownanie od
            int j = i -1;
            //jezeli poprzednik wiekszy od poronywanej liczby
            while (j>=0 && list.get(j).getValue() > selected.getValue()){
                //zmienna tymczasowa
                IntElement temp = new IntElement("", 0);
                temp.setValue(selected.getValue());
                temp.setName(selected.getName());
                //poprzednik jest nastepnikiem
                list.set(j+1,list.get(j));
                //i sprawdzamy kolejnych poprzednikow
                j--;
                //po sortowaniu umiesc porownywana liczbe
                list.set(j+1, temp);
            }

        }
        return list;
    }
    /**
     * Metoda sortowania InsertSort zmiennych typu int
     * @param list lista elementow do posortownia
     * @return zwraca liste posortowanych elemtow
     */
    @Override
    public List<IntElement> solveInt(List<IntElement> list) {
        int size = list.size();
        IntElement selected = new IntElement("", 0);
        for(int i = 1; i <size; ++i){
            //zaczynamy od 1 pozycji listy, pobieramy liczbe do porownan
            selected.setValue((int)list.get(i).getValue());
            selected.setName(list.get(i).getName());
            //zaczynamy porownanie od
            int j = i -1;
            //jezeli poprzednik wiekszy od poronywanej liczby
            while(j>=0 && (int)list.get(j).getValue() > (int)selected.getValue()){
                //zmienna tymczasowa
                IntElement temp = new IntElement("", 0);
                temp.setValue(selected.getValue());
                temp.setName(selected.getName());
                //poprzednik jest nastepnikiem
                list.set(j+1,list.get(j));
                //i sprawdzamy kolejnych poprzednikow
                j--;
                //po sortowaniu umiesc porownywana liczbe
                list.set(j+1, temp);
            }
        }
        return list;
    }
    /**
     * Opis metody sortowania danych InsertSort
     * @return zmienna String przechowujaca opis metody
     */
    @Override
    public String description() {
        String desc = new String("Metoda sortowania danych, ktora polega na pobraniu danego elementu i porownywanie go z elementami o nizszym indeksie.");
        return desc;
    }
    /**
     * Czy algorytm InsertSort jest stabilny?
     * @return zwraca informacje czy algorytm jest stabliny
     */
    @Override
    public boolean isStable() {
        return true;
    }
    /**
     * Czy algorytm InsertSort jest algorytmem w miejscu?
     * @return zwraca informacje czy jest to algorytm w miejscu
     */
    @Override
    public boolean isInSitu() {
        return true;
    }
}
