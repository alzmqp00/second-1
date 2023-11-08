package javaa.RPG.wmonInterface;

import javaa.RPG.wmonInterface.Role.LifeRecoverable;

public class warrior extends Role implements LifeRecoverable {

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
    public void DrinkD(Drug D) {

        if (D instanceof RedDrug) {
            setLife(getLife() + D.getAdd());
        } else {
            setmagic(getmgic() + D.getAdd());
        }
        System.out.println(getname() + " " + D.getSize());

    }

    public int NewMoon(Role beAttackedRole) {
        // System.out.print("2");
        if (getmgic() < 10) {

            // System.out.println(getmgic());
            System.out.println(getname() + "'s MP was not enough");

            return 0;
        } else {
            setmagic(getmgic() - 10);
            if (beAttackedRole instanceof warrior)
                beAttackedRole.setLife(beAttackedRole.getLife() - 25);
            else
                beAttackedRole.setLife(beAttackedRole.getLife() - 40);
        }

        return 1;
    }

    public double recoverLife() {
        setLife((int) (getLife() + 400 * LIFERATE / 100));
        return 400 * LIFERATE / 100;
    }
    /*
     * public int NewMoon(mage m) {
     * if (getmgic() < 10) {
     * // System.out.println(getmgic());
     * System.out.println(getname() + "'s MP was not enough");
     * return 0;
     * } else {
     * 
     * setmagic(getmgic() - 10);
     * }
     * 
     * return 1;
     * }
     */
    /*
     * public int beAttack(warrior w) {
     * 
     * setLife(getLife() - 40);
     * // System.out.println(Life);
     * return getLife();
     * }
     * 
     * public int beAttack(mage m) {
     * 
     * setLife(getLife() - 25);
     * // System.out.println(Life);
     * return getLife();
     * }
     */
}