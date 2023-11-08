package javaa.RPG.fight;

public class warrior {
    private String Name;
    private int Life;
    private int magic;

    warrior() {

    }

    warrior(String name, int life, int magic) {
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
        if (magic < 10) {
            System.out.println("MP was not enough");
            return 0;
        } else
            magic -= 10;
        return 1;
    }

    public int beAttack(warrior w) {

        Life -= 40;
        // System.out.println(Life);
        return Life;
    }

    public int beAttack(mage m) {

        Life -= 25;
        // System.out.println(Life);
        return Life;
    }
}