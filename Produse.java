import javax.management.ConstructorParameters;

public abstract class Produse {
    protected String id;
    protected String nume;
    protected boolean disponibil=true;


    public Produse(String id, String nume) {
        this.id = id;
        this.nume = nume;
    }

    public String getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }

    public boolean isDisponibil() {
        return disponibil;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setDisponibil(boolean disponibil) {
        this.disponibil = disponibil;
    }

    public void addInCart(){
        disponibil=false;
    }

    public void removeFromCart(){
        disponibil=true;
    }
}