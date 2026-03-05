public class Haine extends Produse{
    private String producator;

    public Haine(String id, String titlu,String producator,double cant) {
        super(id,titlu,cant);
        this.producator = producator;
    }
}
