package com.company;

import com.company.Ask.Ask;
import com.company.Shower.Shower;
import com.company.Shower.ShowerVisitor;
import com.company.Tender.Tender;

import java.util.Random;

public class Main {

   public static void main(String[] args) throws InterruptedException {
   /*     ShowerVisitor showerVisitor = new ShowerVisitor(new Shower());

        while (true)
        {
            Thread.sleep(new Random().nextInt(2000) + 1000);
            new Thread(showerVisitor).start();
        }*/

   Tender tender = new Tender();

        for (int i = 0; i < tender.NUMBER_ASK; i++) {
            Ask thread = new Ask(i, tender.getBarrier());
            tender.addAsk(thread);
            thread.start();

            Thread.sleep(new Random().nextInt(1000) + 2000);
        }
    }
}
