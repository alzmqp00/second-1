package javaa.RPG.fightcopy;

public class mage extends Role {

    mage() {

    }

    mage(String name, int life, int magic) {
        super(name, life, magic);
    }

    public int attack() {
        // System.out.println(getLife() + 280);
        if (getmgic() < 25) {
            System.out.println(getname() + "'s MP was not enough");
            return 0;
        } else
            setmagic(getmgic() - 25);

        return 1;
    }

    public int beAttack(mage w) {
        // System.out.println(Life);
        setLife(getLife() - 60);
        // System.out.println(getLife());
        return getLife();
    }

    public int beAttack(warrior m) {
        // System.out.println(Life);
        setLife(getLife() - 40);
        // System.out.println(getLife());
        return getLife();
    }
}