package javaa.RPG.newmon;

import java.lang.Math;

public class game {
    public static void main(String[] agrs) {
        int num;
        int num2;
        int succ = 0;
        /*
         * 產生 ROLE 類型的異質陣列存放 6 個角色，隨機挑選兩個互打，唯兩位角色不能
         * 為同一人
         */
        // warrior w[] = new warrior[3];
        // mage m[] = new mage[3];
        /*
         * w[0] = new warrior("w1", 400, 100);
         * w[1] = new warrior("w2", 400, 100);
         * w[2] = new warrior("w3", 400, 100);
         * m[0] = new mage("m1", 280, 200);
         * m[1] = new mage("m2", 280, 200);
         * m[2] = new mage("m3", 280, 200);
         */
        Role r[] = new Role[6];

        r[0] = new warrior("w1", 400, 100);
        r[1] = new warrior("w2", 400, 100);
        r[2] = new warrior("w3", 400, 100);
        r[3] = new mage("m1", 280, 200);
        r[4] = new mage("m2", 280, 200);
        r[5] = new mage("m3", 280, 200);

        // int i = 10;
        while (true) {
            /*
             * 由于操作符优先级的原因，(int) 会首先应用于 Math.random()
             * ，然后再乘以 6。这会导致 num 和 num2 始终相等。
             */
            num = (int) (Math.random() * 6);
            num2 = (int) (Math.random() * 6);
            /*
             * 通过添加额外的括号，你确保 Math.random() * 6
             * 的结果首先被强制转换为整数
             */
            if (num == num2)
                continue;
            System.out.println(r[num].getname() + "攻擊" + r[num2].getname());

            if (r[num] instanceof warrior) {
                warrior w = (warrior) r[num];
                succ = w.NewMoon(r[(int) num2]);
            } else {
                mage m = (mage) r[num];
                succ = m.SmallFire(r[(int) num2]);
            }

            if (succ == 1) {
                if (r[(int) num2].getLife() <= 0) {
                    System.out.println(r[(int) num2].getname() + "die");

                    break;
                }
            }
        }
    }
}