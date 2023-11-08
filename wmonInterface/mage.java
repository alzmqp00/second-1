package javaa.RPG.wmonInterface;

import javaa.RPG.wmonInterface.Role.MagicRecoverable;

public class mage extends Role implements MagicRecoverable {

    mage() {
    }

    mage(String name, int life, int magic) {
        super(name, life, magic);
    }

    public void DrinkD(Drug D) {

        if (D instanceof RedDrug) {
            setLife(getLife() + D.getAdd());
        } else {
            setmagic(getmgic() + D.getAdd());
        }
        System.out.println(getname() + " " + D.getSize());

    }

    public int SmallFire(Role beAttackedRole) {
        // System.out.println(getLife() + 280);
        if (getmgic() < 25) {
            System.out.println(getname() + "'s MP was not enough");
            return 0;
        } else {
            setmagic(getmgic() - 25);
            if (beAttackedRole instanceof warrior)
                beAttackedRole.setLife(beAttackedRole.getLife() - 40);
            else
                beAttackedRole.setLife(beAttackedRole.getLife() - 60);
        }

        return 1;
    }

    public double recoverMagic() {
        setmagic((int) (getmgic() + 200 * MAGICRATE / 100));
        return 200 * MAGICRATE / 100;
    }

    /*
     * public int beAttack(mage w) {
     * // System.out.println(Life);
     * setLife(getLife() - 60);
     * // System.out.println(getLife());
     * return getLife();
     * }
     * 
     * public int beAttack(warrior m) {
     * // System.out.println(Life);
     * setLife(getLife() - 40);
     * // System.out.println(getLife());
     * return getLife();
     * }
     */
}