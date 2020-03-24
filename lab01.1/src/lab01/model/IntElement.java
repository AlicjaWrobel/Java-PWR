package lab01.model;
import lab01.model.IElement;

/**
 * Klasa implementujaca metody interface IElement
 */
public class IntElement implements IElement {
    private String name;
    private float value;

    /**
     * Zwraca nazwe String
     * @return nazwa String
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Zwraca wartosc float IElementu
     * @return float float IElementu
     */
    @Override
    public float getValue() {
        return value;
    }

    /**
     * Ustawia wartosc float IElementu
     * @param value value Ielementu
     */
    public void setValue(float value){
        this.value = value;
    }

    public void setName(String name){this.name = name; }

    /**
     * Konstruktor IntElement
     * @param name nazwa String
     * @param value wartosc float
     */
    public IntElement(String name, float value){
        this.name = name;
        this.value = value;
    }

}
