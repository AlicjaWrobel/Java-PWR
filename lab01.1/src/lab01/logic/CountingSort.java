package lab01.logic;

import lab01.model.AbstractIntSorter;
import lab01.model.IntElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Algorytm sortowania przez zliczanie CountingSort
 */
public class CountingSort extends AbstractIntSorter {

    /**
     * Metoda sortowania CountingSort wartosci typu int
     * @param list lista elementow do posortownia
     * @return posortowana lista
     */
    @Override
    public List<IntElement> solveInt(List<IntElement> list) {
        int size = list.size();
        List<IntElement> out_list = new ArrayList<>();
        int count[] = new int[256];

        for(int i=0; i<256; i++){
            out_list.add(null);
        }
        //poczatkowo ustaw ilosc wystapien danej cyfry na 0
        for(int i=0; i<256; i++){
            count[i] = 0;
        }
        //zlicz ile razy dana cyfra sie powtarza
        for(int i=0; i<size; i++){
            ++count[(int) list.get(i).getValue()];
        }
        //sumuj ze soba ilosc wystapien z poprzednikami
        for(int i =1; i<=255; i++){
            count[i] += count[i-1];
        }
        //sortowanie
        for(int i = size-1; i>=0; i--){
            out_list.set(count[(int) list.get(i).getValue()], list.get(i));
            --count[(int)list.get(i).getValue()];
        }
        for (int i = 0; i<size; i++){
            list.set(i, out_list.get(i+1));
        }

        return list;
    }
    /**
     * Opis metody sortowania danych CountingSort
     * @return zmienna String przechowujaca opis metody
     */
    @Override
    public String description() {
        String desc = new String("Metoda sortowania danych, ktora polega na sprawdzeniu ile wystapien kluczy mniejszych od danego wystepuje w sortowanej tablicy.");
        return desc;
    }
    /**
     * Czy algorytm CountingSort jest stabilny?
     * @return zwraca informacje czy algorytm jest stabliny
     */
    @Override
    public boolean isStable() {
        return true;
    }
    /**
     * Czy algorytm CountingSort jest algorytmem w miejscu?
     * @return zwraca informacje czy jest to algorytm w miejscu
     */
    @Override
    public boolean isInSitu() {
        return false;
    }
}
