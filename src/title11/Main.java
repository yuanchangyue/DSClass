package title11;

/**
 * @program: DSClass-master
 * @description:
 * @author: ChangYue
 * 10
 * 5 1 9 10 67 12 8 33 6 2
 * 3 10
 * @create: 2019-06-19 11:39
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        SeqList<Integer> list1 = new SeqList<>();
        for (int j = 0; j < i; j++)
            list1.insert(i, scanner.nextInt());

        int w = scanner.nextInt();
        int e = scanner.nextInt();
        list1.remove(w, e);
        System.out.println(list1.toString());
    }
}

class SeqList<T> {
    protected Object[] element;
    protected int n;

    public SeqList(int length) {
        this.element = new Object[length];
        this.n = 0;
    }

    public SeqList() {
        this(64);
    }

    public T get(int i) {
        if (i >= 0 && i < this.n) {
            return (T) this.element[i];
        }
        return null;
    }

    public SeqList(T[] values) {
        this(values.length);
        for (int i = 0; i < values.length; i++)
            this.element[i] = values[i];
        this.n = element.length;
    }

    public void set(int i, T x) {
        if (i >= 0 && i < this.n) {
            this.element[i] = x;
        } else {
            throw new java.lang.IndexOutOfBoundsException(i + "");
        }
    }

    public int insert(int i, T x) {
        if (x == null)
            throw new NullPointerException("x==null");
        if (i < 0) i = 0;
        if (i > this.n) i = this.n;
        Object[] source = this.element;
        if (this.n == element.length) {
            this.element = new Object[source.length * 2];
            for (int j = 0; j < i; j++)
                this.element[j] = source[j];
        }
        for (int j = this.n - 1; j >= i; j--)
            this.element[j + 1] = source[j];
        this.element[i] = x;
        this.n++;
        return i;
    }

    void remove(int i, int k) {
        if (this.n > 0) {
            for (int p = 0; p < this.n; p++) {
                int w = (int) this.element[p];
                if (w >= i && w <= k) {
                    remove(p);
                    p--;
                }
            }
        }
    }

    private void remove(int i) {
        if (this.n > 0 && i >= 0 && i <= this.n) {
            for (int j = i; j < this.n - 1; j++) {
                this.element[j] = this.element[j + 1];
            }
            this.element[this.n - 1] = null;
            this.n--;
        }
    }

    public String toString() {
        String str = "";
        for (int j = 0; j < this.n; j++) {
            str += this.element[j].toString() + " ";
        }
        return str;
    }

}