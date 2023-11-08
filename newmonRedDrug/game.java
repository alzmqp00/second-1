package javaa.RPG.newmonRedDrug;

import java.lang.Math;

public class game {
    public static void main(String[] agrs) {
        int num;
        int num2;
        int succ = 0;

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
                Drug D;
                int num1 = (int) (Math.random() * 10);

                if (r[(int) num2].getLife() <= 40) {

                    if (num1 == 0)
                        D = new RedDrug("大紅", 120);
                    else if (num1 <= 2)
                        D = new RedDrug("中紅", 80);
                    else if (num1 <= 6)
                        D = new RedDrug("小紅", 50);
                    else
                        D = new RedDrug("沒紅水喝", 0);

                    r[(int) num2].DrinkD(D);
                }
                num1 = (int) (Math.random() * 10);
                if (r[(int) num].getmgic() <= 30) {
                    if (num1 == 0)
                        D = new BlueDrug("大藍", 100);
                    else if (num1 <= 2)
                        D = new BlueDrug("中藍", 60);
                    else if (num1 <= 6)
                        D = new BlueDrug("小藍", 30);
                    else
                        D = new BlueDrug("沒藍水喝", 0);
                    r[(int) num].DrinkD(D);
                }

            }
        }
    }
}