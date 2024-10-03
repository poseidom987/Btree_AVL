public class Btree {
    private Bnode raiz;

    public Btree() {
        raiz = null;
    }

    public void add(int valor) {
        if (raiz != null) {
            raiz.add(valor);
        } else {
            raiz = new Bnode(valor);
        }
    }

    public void show() {
        if (raiz != null) raiz.show();
    }

    public int size() {
        if (raiz != null) {
            return raiz.size();
        } else {
            return 0;
        }
    }

    public int soma() {
        if (raiz != null) {
            return raiz.soma();
        } else {
            return 0;
        }
    }
}