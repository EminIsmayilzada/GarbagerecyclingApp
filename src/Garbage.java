
public class Garbage {
    private String name;
    private String type;
    private int size;
    public Garbage(String name, String type, int size) {
        this.name=name;
        this.type=type;
        this.size=size;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {return name+","+type+","+size;}
    public boolean equals(Garbage obj) {
        if (obj==null||!(obj instanceof Garbage)) {
            return false;
        }

        Garbage otherGarbage = (Garbage) obj;


        boolean isEqual = this.name.equals(otherGarbage.name) &&
                this.type.equals(otherGarbage.type) &&
                this.size == otherGarbage.size;

        return isEqual;
    }}


