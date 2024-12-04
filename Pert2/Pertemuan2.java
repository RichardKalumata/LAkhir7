package RPL2;

class Hewan {
    private String nama;
    
    public Hewan(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }
    
    public void bersuara() {
        System.out.println("Hewan ini bersuara.");
    }
}


class Kucing extends Hewan {
    
    public Kucing(String nama) {
        super(nama);
    }
    
    @Override
    public void bersuara() {
        System.out.println(getNama() + " berkata: Meow!");
    }
}

class Anjing extends Hewan {
    public Anjing(String nama) {
        super(nama);
    }
    
    @Override
    public void bersuara() {
        System.out.println(getNama() + " berkata: Bark!");
    }
}


public class Pertemuan2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Hewan kucing = new Kucing("Kitty");
        Hewan anjing = new Anjing("Buddy");
        
        kucing.bersuara();
        anjing.bersuara();
    }
    
}


