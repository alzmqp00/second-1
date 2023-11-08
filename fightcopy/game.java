package javaa.fightcopy;

import java.lang.Math;

public class game {
    public static void main(String[] agrs) {
        double num;
        double num2;

        warrior w[] = new warrior[3];
        mage m[] = new mage[3];
        w[0] = new warrior("w1", 400, 100);
        w[1] = new warrior("w2", 400, 100);
        w[2] = new warrior("w3", 400, 100);
        m[0] = new mage("m1", 280, 200);
        m[1] = new mage("m2", 280, 200);
        m[2] = new mage("m3", 280, 200);
        for (int i = 0; i < 3; i++) {
            System.out.println(w[i]);
            System.out.println(m[i]);
        }

        // int i = 10;
        while (true) {

            num = Math.random() * 3;
            num2 = Math.random() * 3;
            System.out.println(w[(int) num].getname() + "攻擊" + m[(int) num2].getname());
            int succ = w[(int) num].attack();

            if (succ == 1) {
                m[(int) num2].beAttack(w[(int) num2]);

                if (m[(int) num2].getLife() <= 0) {
                    System.out.println(m[(int) num2].getname() + "die");

                    break;
                }
            }

            num = Math.random() * 3;
            num2 = Math.random() * 3;
            System.out.println(m[(int) num].getname() + "攻擊" + w[(int) num2].getname());
            succ = m[(int) num].attack();
            // System.out.println(w[(int) num2].getLife());
            if (succ == 1) {
                num = Math.random() * 3;
                w[(int) num2].beAttack(m[(int) num]);

                if (w[(int) num2].getLife() <= 0) {

                    System.out.println(w[(int) num2].getname() + "die");

                    break;
                }
            }

        }
    }
}