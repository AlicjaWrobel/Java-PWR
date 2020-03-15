package lab01.model;

/**
 * Klasa implementujaca metody interface IElement
 */
public class FloatElement implements IElement {
    private int value;
    private String name;

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
     * @return float IElementu
     */
    @Override
    public float getValue() {
        return value;
    }
}
