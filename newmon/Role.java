package javaa.RPG.newmon;

public class Role {
    private String Name;
    private int Life;
    private int magic;

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
