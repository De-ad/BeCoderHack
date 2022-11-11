package objects;


public class Boat {
    static private int currentId = 1;
    private Integer id;
    private int area;
    private boolean hasFence;
    private String material;
    private boolean stabilization;
    private boolean doorWidth;
    private String power;
    private boolean humanCapacity;
    private int efficiency;

    public Boat(int area, boolean hasFence, String material, boolean stabilization, boolean doorWidth, String power, boolean humanCapacity) {
        this.id = currentId;
        currentId++;
        this.area = area;
        this.hasFence = hasFence;
        this.material = material;
        this.stabilization = stabilization;
        this.doorWidth = doorWidth;
        this.power = power;
        this.humanCapacity = humanCapacity;
    }

    @Override
    public String toString() {
        return "Boat{" +
                "id=" + id +
                ", area=" + area +
                ", hasFence=" + hasFence +
                ", material='" + material + '\'' +
                ", stabilization=" + stabilization +
                ", doorWidth=" + doorWidth +
                ", power='" + power + '\'' +
                ", humanCapacity=" + humanCapacity +
                ", efficiency=" + efficiency +
                '}';
    }

    //Убрал у Id final и сделал метод который генерит id для тех объектов, у кого это поле null
    public void generateId() {
         id = currentId++;
    }

    public int getId() {
        return id;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public boolean isHasFence() {
        return hasFence;
    }

    public void setHasFence(boolean hasFence) {
        this.hasFence = hasFence;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public boolean isStabilization() {
        return stabilization;
    }

    public void setStabilization(boolean stabilization) {
        this.stabilization = stabilization;
    }

    public boolean isDoorWidth() {
        return doorWidth;
    }

    public void setDoorWidth(boolean doorWidth) {
        this.doorWidth = doorWidth;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public boolean isHumanCapacity() {
        return humanCapacity;
    }

    public void setHumanCapacity(boolean humanCapacity) {
        this.humanCapacity = humanCapacity;
    }

    public int getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(int efficiency) {
        this.efficiency = efficiency;
    }

    public int getArea(){
        return area;
    }

}
