package stack;

import java.util.Arrays;

public class Stack {
    private int[] items = new int[5];
    private int count;

    public void push(int item){
        if (count == items.length){
            throw new StackOverflowError();
        }
        items[count++] = item;
    }
    public int pop(){
        if (count ==0){
            throw new IllegalStateException();
        }
        return items[--count];
    }
    public boolean isEmpty(){
        return count ==0;
    }

    public int peek(){
        return items[count-1];
    }
    @Override
    public String toString(){
        int[] content = Arrays.copyOfRange(items, 0, count);
        return Arrays.toString(content);
    }
}
