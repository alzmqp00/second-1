package javaa.RPG.newmonRedDrug;

public abstract class Role {
    private String Name;
    private int Life;
    private int magic;

    public void DrinkD(Drug D) {

        if (D instanceof RedDrug) {
            setLife(getLife() + D.getAdd());
        } else {
            setmagic(getmgic() + D.getAdd());
        }
        System.out.println(getname() + " " + D.getSize());
    }

    Role() {

    }

    Role(String name, int life, int magic) {
        Life = life;
        Name = name;
        this.magic = magic;
    }

    public void setmagic(int a) {
        magic = a;
    }

    public void setLife(int a) {

        Life = a;
    }

    public void setName(String a) {
        Name = a;
    }

    public int getLife() {
        return Life;
    }

    public int getmgic() {
        return magic;
    }

    public String getname() {
        return Name;
    }

    @Override
    public String toString() {
        return getname() + " " + getLife() + " " + getmgic();
    }
}
