package javaa.RPG.fightcopy;

public class warrior extends Role {

    warrior(String name, int life, int ma) {
        super(name, life, ma);
    }

    /*
     * warrior(String name, int life, int magic) {
     * setLife(life);
     * setName(name);
     * setmagic(magic);
     * }
     */

    public int attack() {
        if (getmgic() < 10) {
            // System.out.println(getmgic());
            System.out.println(getname() + "'s MP was not enough");
            return 0;
        } else {

            setmagic(getmgic() - 10);
        }

        return 1;
    }

    public int beAttack(warrior w) {

        setLife(getLife() - 40);
        // System.out.println(Life);
        return getLife();
    }

    public int beAttack(mage m) {

        setLife(getLife() - 25);
        // System.out.println(Life);
        return getLife();
    }
}