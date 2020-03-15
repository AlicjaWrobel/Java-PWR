package lab01.logic;

import lab01.model.AbstractFloatSorter;
import lab01.model.IElement;
import lab01.model.IntElement;

import java.util.List;

/**
 * Algorytm sortowania szybkiego QuickSort
 */
public class QuickSort extends AbstractFloatSorter {

    /**
     * Metoda sortowania QuickSort zmiennych typu float
     * @param list lista elementow do posortownia
     * @return zwraca liste posortowanych elemtow
     */
    @Override
    public List<IElement> solveFloat(List<IElement> list) {
        int start = 0;
        int end = list.size()-1;
        quickSortFloat(list, start, end);
        return list;
    }
    /**
     * Metoda sortowania QuickSort zmiennych typu int
     * @param list lista elementow do posortownia
     * @return zwraca liste posortowanych elemtow
     */
    @Override
    public List<IntElement> solveInt(List<IntElement> list) {
        int start = 0;
        int end = list.size()-1;
        quickSortInt(list, start, end);
        return list;
    }
    /**
     * Metoda rekurencyjna wywolujaca sortownie wewnatrz podzielonych grup elementow typu int
     * @param list lista elementow do posortownia
     * @param start poczatek listy do sortownia
     * @param end koniec listy do sortowania
     */
    public static void quickSortInt(List<IntElement> list, int start, int end){
        int partition = partitionInt(list,start,end);

        //sortownie mniejszej grupy
        if (partition-1>start){
            quickSortInt(list,start,partition-1);
        }
        //sortownie wiekszej grupy
        if (partition+1<end){
            quickSortInt(list,partition+1,end);
        }
    }
    /**
     * Metoda dzieli liste na grupe mniejszych oraz wiekszych elementow typu int od wybranego elementu (pivot)
     * @param list lista elementow do posortownia
     * @param start poczatek listy do sortownia
     * @param end koniec listy do sortowania
     * @return nowy element startowy sortowania
     */
    public static int partitionInt(List<IntElement> list, int start, int end){
        //ostatni element po ktorym bedziemy dzielic na gupe wieksza i mniejsza
        IntElement pivot = new IntElement("",(int)list.get(end).getValue());
        //jesli mniejsze od pivot zamien start z pozycja aktualna
        for (int i = start; i<end; i++){
            if((int)list.get(i).getValue()<(int)pivot.getValue()){
                IntElement temp = new IntElement("",(int)list.get(start).getValue());
                list.set(start,list.get(i));
                list.set(i,temp);
                start++;
            }
        }
        //pivot dzieli na grupe mniejsza i wieksza od siebie
        IntElement temp = new IntElement("", (int)list.get(start).getValue());
        list.set(start,pivot);
        list.set(end,temp);
        return start;
    }
    /**
     * Metoda rekurencyjna wywolujaca sortownie wewnatrz podzielonych grup elementow typu float
     * @param list lista elementow do posortownia
     * @param start poczatek listy do sortownia
     * @param end koniec listy do sortowania
     */
    public static void quickSortFloat(List<IElement> list, int start, int end){
        int partition = partitionFloat(list,start,end);

        //sortownie mniejszej grupy
        if (partition-1>start){
            quickSortFloat(list,start,partition-1);
        }
        //sortownie wiekszej grupy
        if (partition+1<end){
            quickSortFloat(list,partition+1,end);
        }
    }
    /**
     * Metoda dzieli liste na grupe mniejszych oraz wiekszych elementow typu float od wybranego elementu (pivot)
     * @param list lista elementow do posortownia
     * @param start poczatek listy do sortownia
     * @param end koniec listy do sortowania
     * @return nowy element startowy sortowania
     */
    public static int partitionFloat(List<IElement> list, int start, int end){
        //ostatni element po ktorym bedziemy dzielic na gupe wieksza i mniejsza
        IntElement pivot = new IntElement("",list.get(end).getValue());
        //jesli mniejsze od pivot zamien start z pozycja aktualna
        for (int i = start; i<end; i++){
            if(list.get(i).getValue()<pivot.getValue()){
                IntElement temp = new IntElement("",list.get(start).getValue());
                list.set(start,list.get(i));
                list.set(i,temp);
                start++;
            }
        }
        //pivot dzieli na grupe mniejsza i wieksza od siebie
        IntElement temp = new IntElement("", list.get(start).getValue());
        list.set(start,pivot);
        list.set(end,temp);
        return start;
    }
    /**
     * Opis metody sortowania danych QuickSort
     * @return zmienna String przechowujaca opis metody
     */
    @Override
    public String description() {
        String desc = new String("Metoda sortowania danych, która polega wybieraniu z tablicy elementu rozdzielajacego, po czym tablica jest dzielona na dwa fragmenty:" +
                " do poczatkowego przenoszone są wszystkie elementy nie większe od rozdzielającego, do koncowego wszystkie wieksze. Potem sortuje się osobno początkową i koncową czesc tablicy.");
        return desc;
    }
    /**
     * Czy algorytm QuickSort jest stabilny?
     * @return zwraca informacje czy algorytm jest stabliny
     */
    @Override
    public boolean isStable() {
        return false;
    }
    /**
     * Czy algorytm QuickSort jest algorytmem w miejscu?
     * @return zwraca informacje czy jest to algorytm w miejscu
     */
    @Override
    public boolean isInSitu() {
        return true;
    }
}
