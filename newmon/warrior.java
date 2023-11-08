package javaa.RPG.newmon;

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
    }/*
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