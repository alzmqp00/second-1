package javaa.RPG.fight;

public class mage {
    private String Name;
    private int Life;
    private int magic;

    mage() {

    }

    mage(String name, int life, int magic) {
        this.Life = life;
        this.Name = name;
        this.magic = magic;
    }

    public String getname() {
        return Name;
    }

    public int getLife() {
        return Life;
    }

    public int getmgic() {
        return magic;
    }

    public int attack() {
        if (magic < 25) {
            System.out.println("MP was not enough");
            return 0;
        } else
            magic -= 25;
        return 1;
    }

    public int beAttack(mage w) {
        // System.out.println(Life);
        Life -= 60;
        return Life;
    }

    public int beAttack(warrior m) {
        // System.out.println(Life);
        Life -= 40;
        return Life;
    }
}