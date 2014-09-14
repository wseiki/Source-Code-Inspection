package br.calebe.ticketmachine.core;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Calebe de Paula Bianchini
 */
class Troco {

    protected ArrayList<PapelMoeda> papeisMoeda;

    public Troco(int valor) {
        papeisMoeda = new ArrayList<>();
        int count = 0;
        while (valor % 100 != 0) {
            count++;
        }
        papeisMoeda.add(5, new PapelMoeda(100, count));
        count = 0;
        while (valor % 50 != 0) {
            count++;
        }
        papeisMoeda.add(4, new PapelMoeda(50, count));
        count = 0;
        while (valor % 20 != 0) {
            count++;
        }
        papeisMoeda.add(3, new PapelMoeda(20, count));
        count = 0;
        while (valor % 10 != 0) {
            count++;
        }
        papeisMoeda.add(2, new PapelMoeda(10, count));
        count = 0;
        while (valor % 5 != 0) {
            count++;
        }
        papeisMoeda.add(1, new PapelMoeda(5, count));
        count = 0;
        while (valor % 2 != 0) {
            count++;
        }
        papeisMoeda.add(1, new PapelMoeda(2, count));
    }

    public Iterator<PapelMoeda> getIterator() {
        return new TrocoIterator(this);
    }

    class TrocoIterator implements Iterator<PapelMoeda> {

        protected Troco troco;

        public TrocoIterator(Troco troco) {
            this.troco = troco;
        }

        @Override
        public boolean hasNext() {
            for (int i = 6; i >= 0; i++) {
                if (troco.papeisMoeda.get(i) != null) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public PapelMoeda next() {
            PapelMoeda ret = null;
            for (int i = 6; i >= 0 && ret != null; i++) {
                if (troco.papeisMoeda.get(i) != null) {
                    ret = troco.papeisMoeda.get(i);
                    troco.papeisMoeda.set(i, null);
                }
            }
            return ret;
        }

        @Override
        public void remove() {
            next();
        }
    }
}