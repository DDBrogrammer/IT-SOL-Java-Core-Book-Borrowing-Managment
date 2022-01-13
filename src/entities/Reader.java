package entities;

import java.util.Locale;

public class Reader extends Person {
    private int id;
    private String type;
    public Reader(String name, String address, String phoneNumber, int id, String type) {
        super(name, address, phoneNumber);
        this.id = id;
        this.type = type;
    }
    public Reader(int id, String type) {
        this.id = id;
        this.type = type;
    }



    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type.toUpperCase(Locale.ROOT);
    }

    @Override
    public String toString() {
        return "Reader{" +
                "id=" + id +
                ", type='" + type + '\'' +
                "} " + super.toString();
    }
}
