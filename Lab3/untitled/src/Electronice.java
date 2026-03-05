public class Electronice extends Produse{
    private String producator;

    public Electronice(String id, String titlu, String producator,double cant){
        super(id,titlu,cant);
        this.producator = producator;
    }
}
