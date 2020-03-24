import lab01.logic.CountingSort;
import lab01.logic.InsertSort;
import lab01.logic.QuickSort;
import lab01.model.IElement;
import lab01.model.IntElement;

import java.util.ArrayList;
import java.util.List;

public class SorterApp {

    public static void main(String[] args){

        IntElement m = new IntElement("m",3.1F);
        IntElement a = new IntElement("a",3.2F);
        IntElement r = new IntElement("r",2.2F);
        IntElement c = new IntElement("c",11);
        IntElement i = new IntElement("i",8);
        IntElement n = new IntElement("n",1);

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

        List<IElement> outFloatQS = new QuickSort().solveFloat(listI);
        List<IElement> outFloatIS = new InsertSort().solveFloat(listI);
        List<IntElement> outIntCS = new CountingSort().solveInt(list);
        List<IntElement> outIntQS = new QuickSort().solveInt(list);
        List<IntElement> outIntIS = new InsertSort().solveInt(list);

        System.out.print("\n" + "Quick Sort float: ");
        for (int j =0; j<=listI.size()-1; j++){
            System.out.print(outFloatQS.get(j).getValue() + " " + outFloatQS.get(j).getName());
        }
        System.out.print("\n" + "Insert sort float: ");
        for (int j =0; j<=listI.size()-1; j++){
            System.out.print(outFloatIS.get(j).getValue() + " " + outFloatIS.get(j).getName());
        }
        System.out.print("\n" + "Counting Sort int: ");
        for (int j =0; j<=list.size()-1; j++){
            System.out.print(outIntCS.get(j).getValue() + " " + outIntCS.get(j).getName());
        }
       System.out.print("\n" + "Quick Sort int: ");
        for (int j =0; j<=list.size()-1; j++) {
            System.out.print(outIntQS.get(j).getValue() + " " + outIntQS.get(j).getName());
        }
        System.out.print("\n" + "Insert sort int: ");
        for (int j =0; j<=list.size()-1; j++){
            System.out.print(outIntIS.get(j).getValue() + " " + outIntIS.get(j).getName());
        }
    }
}
