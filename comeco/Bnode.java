public class Bnode {
    private int x;
    private Bnode esq, dir;

    public Bnode(int valor) {
        x = valor;
        esq = dir = null;
    }

    public void add(int valor) {
        if (valor > x) {
            if (dir != null) dir.add(valor);
            else dir = new Bnode(valor);
        } else {
            if (esq != null) esq.add(valor);
            else esq = new Bnode(valor);
        }

        // Após a inserção, verificar e balancear a árvore
        balance();
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
    private int height(Bnode node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.esq), height(node.dir));
    }

    // Calcula o fator de balanceamento
    private int getBalance() {
        return height(esq) - height(dir);
    }

    // Balanceia a árvore
    private void balance() {
        int balance = getBalance();

        // Rotação simples à direita
        if (balance > 1 && esq != null && esq.getBalance() >= 0) {
            rightRotate();
        }
        // Rotação simples à esquerda
        else if (balance < -1 && dir != null && dir.getBalance() <= 0) {
            leftRotate();
        }
        // Rotação dupla esquerda-direita
        else if (balance > 1 && esq != null && esq.getBalance() < 0) {
            esq.leftRotate();
            rightRotate();
        }
        // Rotação dupla direita-esquerda
        else if (balance < -1 && dir != null && dir.getBalance() > 0) {
            dir.rightRotate();
            leftRotate();
        }
    }

    // Rotação à direita
    private void rightRotate() {
        Bnode temp = esq;
        esq = temp.dir;
        temp.dir = this;
        copiarValores(temp);
    }

    // Rotação à esquerda
    private void leftRotate() {
        Bnode temp = dir;
        dir = temp.esq;
        temp.esq = this;
        copiarValores(temp);
    }

    // Copia os valores de um nó para o nó atual (sem criar novas variáveis)
    private void copiarValores(Bnode node) {
        this.x = node.x;
        this.esq = node.esq;
        this.dir = node.dir;
    }
}