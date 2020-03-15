import lab01.logic.CountingSort;
import lab01.logic.InsertSort;
import lab01.logic.QuickSort;
import lab01.model.IElement;
import lab01.model.IntElement;

import java.util.ArrayList;
import java.util.List;

public class SorterApp {

    public static void main(String[] args){

        IntElement m = new IntElement(" ",3.1F);
        IntElement a = new IntElement(" ",3.2F);
        IntElement r = new IntElement(" ",2.2F);
        IntElement c = new IntElement(" ",11);
        IntElement i = new IntElement(" ",8);
        IntElement n = new IntElement(" ",1);

        List<IntElement> list = new ArrayList<>();
        list.add(m);
        list.add(a);
        list.add(r);
        list.add(c);
        list.add(i);
        list.add(n);

        List<IElement> listI = new ArrayList<>();
        listI.add(m);
        listI.add(a);
        listI.add(r);
        listI.add(c);
        listI.add(i);
        listI.add(n);

        System.out.print("List: ");
        for (int j =0; j<=list.size()-1; j++){
            System.out.print(list.get(j).getValue() + " ");
        }

        List<IElement> outFloatQS = new InsertSort().solveFloat(listI);
        List<IElement> outFloatIS = new InsertSort().solveFloat(listI);
        List<IntElement> outIntCS = new CountingSort().solveInt(list);
        List<IntElement> outIntQS = new QuickSort().solveInt(list);
        List<IntElement> outIntIS = new InsertSort().solveInt(list);

        System.out.print("\n" + "Quick Sort float: ");
        for (int j =0; j<=listI.size()-1; j++){
            System.out.print(outFloatQS.get(j).getValue() + " ");
        }
        System.out.print("\n" + "Insert sort float: ");
        for (int j =0; j<=listI.size()-1; j++){
            System.out.print(outFloatIS.get(j).getValue() + " ");
        }
        System.out.print("\n" + "Counting Sort int: ");
        for (int j =0; j<=list.size()-1; j++){
            System.out.print(outIntCS.get(j).getValue() + " ");
        }
       System.out.print("\n" + "Quick Sort int: ");
        for (int j =0; j<=list.size()-1; j++) {
            System.out.print(outIntQS.get(j).getValue() + " ");
        }
        System.out.print("\n" + "Insert sort int: ");
        for (int j =0; j<=list.size()-1; j++){
            System.out.print(outIntIS.get(j).getValue() + " ");
        }
    }
}
