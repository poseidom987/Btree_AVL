public class Bnode {
    private int x;
    private Bnode esq, dir;

    public Bnode(int valor) {
        x = valor;
        esq = dir = null;
    }

    public Bnode add(int valor) {
        if (valor > x) {
            if (dir != null) dir = dir.add(valor);
            else dir = new Bnode(valor);
        } else {
            if (esq != null) esq = esq.add(valor);
            else esq = new Bnode(valor);
        }

        // Após a inserção, balancear o nó atual
        return balance();
    }

    public void show() {
        if (dir != null) dir.show();    // DIR
        System.out.println(x);          // RAIZ
        if (esq != null) esq.show();    // ESQ
    }

    public int size() {
        int e = 0, d = 0;
        if (esq != null) e = esq.size();
        if (dir != null) d = dir.size();
        return 1 + e + d;
    }

    public int soma() {
        int e = 0, d = 0;
        if (esq != null) e = esq.soma();
        if (dir != null) d = dir.soma();
        return x + e + d;
    }

    // Calcula a altura da árvore
    private int altura(Bnode node) {
        if (node == null) return 0;
        return 1 + Math.max(altura(node.esq), altura(node.dir));
    }

    // Calcula o fator de balanceamento
    private int getBalance() {
        return altura(esq) - altura(dir);
    }

    // Balanceia o nó e retorna o novo nó
    private Bnode balance() {
        int balance = getBalance();

        // Rotação simples à direita
        if (balance > 1 && esq != null && esq.getBalance() >= 0) {
            return rightRotate();
        }
        // Rotação simples à esquerda
        else if (balance < -1 && dir != null && dir.getBalance() <= 0) {
            return leftRotate();
        }
        // Rotação dupla esquerda-direita
        else if (balance > 1 && esq != null && esq.getBalance() < 0) {
            esq = esq.leftRotate();
            return rightRotate();
        }
        // Rotação dupla direita-esquerda
        else if (balance < -1 && dir != null && dir.getBalance() > 0) {
            dir = dir.rightRotate();
            return leftRotate();
        }

        return this;  // Nenhuma rotação necessária, retorna o nó atual
    }

    // Rotação à direita
    private Bnode rightRotate() {
        Bnode novaRaiz = esq;
        esq = novaRaiz.dir;
        novaRaiz.dir = this;
        return novaRaiz;
    }

    // Rotação à esquerda
    private Bnode leftRotate() {
        Bnode novaRaiz = dir;
        dir = novaRaiz.esq;
        novaRaiz.esq = this;
        return novaRaiz;
    }
}